package com.example.clickup.service;

import com.example.clickup.entity.User;
import com.example.clickup.entity.enums.SystemRoleName;
import com.example.clickup.payload.ApiResponse;
import com.example.clickup.payload.RegisterDto;
import com.example.clickup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JavaMailSender javaMailSender;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    public ApiResponse registerUser(RegisterDto registerDto) {
        if (userRepository.existsByEmail(registerDto.getEmail()))
            return new ApiResponse("Bunday user mavjud",false);
        User user = new User(
                registerDto.getFullName(),
                registerDto.getEmail(),
                passwordEncoder.encode(
                registerDto.getPassword()),
                SystemRoleName.SYSTEM_USER
        );

        int code = new Random().nextInt(999999);
        user.setEmailCode(String.valueOf(code).substring(0,4));
        userRepository.save(user);
        sendEmail(user.getEmail(), user.getEmailCode());
        return new ApiResponse("User saqlandi",true) ;
    }

    public Boolean sendEmail(String sendingEmail,String emailCode){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("sirojiddin1712@gmail.com");
            mailMessage.setTo(sendingEmail);
            mailMessage.setSubject("Akkountni tasdiqlash");
            mailMessage.setText(emailCode);
            javaMailSender.send(mailMessage);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public ApiResponse verifyEmail(String email, String emailCode) {

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()){
            User user = optionalUser.get();
            if (emailCode.equals(user.getEmailCode())){
                user.setEnabled(true);
                userRepository.save(user);
                return new ApiResponse("Acount aktivlashtirildi",true);
            }
            return new ApiResponse("code xato",false);
        }
        return new ApiResponse("bunday user mavjud emas",false);
    }
}
