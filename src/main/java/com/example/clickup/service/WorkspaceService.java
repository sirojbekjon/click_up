package com.example.clickup.service;

import com.example.clickup.entity.User;
import com.example.clickup.payload.ApiResponse;
import com.example.clickup.payload.MemberDto;
import com.example.clickup.payload.WorkspaceDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface WorkspaceService {


  ApiResponse addWorkspace(WorkspaceDto workspaceDto, User user);
  ApiResponse editWorkspace(WorkspaceDto workspaceDto);

  ApiResponse changeOwnerWorkspace(Long id, UUID ownerId);

  ApiResponse deleteWorkspace(Long id);

  ApiResponse addOrEditOrRemove(Long id, MemberDto memberDto);

}
