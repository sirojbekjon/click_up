package com.example.clickup.controller;

import com.example.clickup.entity.User;
import com.example.clickup.entity.Workspace;
import com.example.clickup.payload.ApiResponse;
import com.example.clickup.payload.MemberDto;
import com.example.clickup.payload.WorkspaceDto;
import com.example.clickup.security.CurrentUser;
import com.example.clickup.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Member;
import java.util.UUID;

@RestController
@RequestMapping("/api/workspace")
public class WorkspaceController {
    @Autowired
    WorkspaceService workspaceService;


    @PostMapping
    public HttpEntity<?> addWorkspace(@Valid @RequestBody WorkspaceDto workspaceDto, @CurrentUser User user){
        ApiResponse apiResponse = workspaceService.addWorkspace(workspaceDto,user);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> editWorkspace(@PathVariable Long id,@RequestBody WorkspaceDto workspaceDto){
        ApiResponse apiResponse = workspaceService.editWorkspace(workspaceDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }


    @PutMapping("/changeOwner/{id}")
    public HttpEntity<?> changeOwnerWorkspace(@PathVariable Long id,
                                              @RequestParam UUID ownerId){
        ApiResponse apiResponse = workspaceService.changeOwnerWorkspace(id,ownerId);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteWorkspace(@PathVariable Long id){
        ApiResponse apiResponse = workspaceService.deleteWorkspace(id);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }

    @PostMapping("/addOrEditOrRemove/{id}")
    public HttpEntity<?> addOrEditOrRemove(@PathVariable Long id, @RequestBody MemberDto memberDto){
        ApiResponse apiResponse = workspaceService.addOrEditOrRemove(id,memberDto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
}
