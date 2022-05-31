package com.example.clickup.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.lang.annotation.*;
import java.lang.reflect.Parameter;

@Documented
@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {
}
