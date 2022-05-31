package com.example.clickup.service;

import com.example.clickup.entity.*;
import com.example.clickup.entity.enums.WorkspacePermissionName;
import com.example.clickup.entity.enums.WorkspaceRoleName;
import com.example.clickup.payload.ApiResponse;
import com.example.clickup.payload.MemberDto;
import com.example.clickup.payload.WorkspaceDto;
import com.example.clickup.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.file.ReadOnlyFileSystemException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class WorkspaceServiceImpl implements WorkspaceService{


    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    WorkspaceRepository workspaceRepository;

    @Autowired
    WorkspaceUserRepository workspaceUserRepository;

    @Autowired
    WorkspaceRoleRepository workspaceRoleRepository;

    @Autowired
    WorkspacePermissionRepository workspacePermissionRepository;
    @Override
    public ApiResponse addWorkspace(WorkspaceDto workspaceDto, User user) {
        User users  = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //workspace ochdik
        if (workspaceRepository.existsByOwnerIdAndName(user.getId(), workspaceDto.getName())){
            return new ApiResponse("Sizda bunday nomli ishxona mavjud",false);
        }
        Workspace workspace = new Workspace(
                workspaceDto.getName(),
                workspaceDto.getColor(),
                user,
                workspaceDto.getAvatarId()==null?null:attachmentRepository.findById(workspaceDto.getAvatarId()).orElseThrow(()->new ResourceNotFoundException("attachment"))

        );
        workspaceRepository.save(workspace);

        //WORKSPACE ROLE OCHDIK

        WorkspaceRole ownerRole = workspaceRoleRepository.save(
                new WorkspaceRole(
                        workspace,
                        WorkspaceRoleName.ROLE_OWNER.name(),
                        null
                )
        );

        //PERMISSION BERAMIZ YANI OWNERGA HUQUQLARINI BERMAIZ

        WorkspacePermissionName[] workspacePermissionNames = WorkspacePermissionName.values();
        List<WorkspacePermission> workspacePermissionList = new ArrayList<>();
        for (WorkspacePermissionName workspacePermissionName : workspacePermissionNames) {
                WorkspacePermission workspacePermission = new WorkspacePermission(
                        ownerRole,
                        workspacePermissionName
                );
                workspacePermissionList.add(workspacePermission);

        }workspacePermissionRepository.saveAll(workspacePermissionList);

        //WORKSPACE USER OCHDIK
        workspaceUserRepository.save(new WorkspaceUser(
                workspace,
                user,
                ownerRole,
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis())

        ));

        return new ApiResponse("ishxona saqlandi",true);
    }

    @Override
    public ApiResponse editWorkspace(WorkspaceDto workspaceDto) {


        return null;
    }

    @Override
    public ApiResponse changeOwnerWorkspace(Long id, UUID ownerId) {
        return null;
    }

    @Override
    public ApiResponse deleteWorkspace(Long id) {
        try {

        workspaceRepository.deleteById(id);
        return new ApiResponse("O'chirildi",true);
        }catch (Exception e){
            return new ApiResponse("Xatolik",false);
        }
    }

    @Override
    public ApiResponse addOrEditOrRemove(Long id, MemberDto memberDto) {
        return null;
    }
}
