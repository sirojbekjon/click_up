package com.example.clickup.payload;

import com.example.clickup.entity.enums.WorkspaceRoleName;
import lombok.Data;

import java.util.UUID;

@Data
public class MemberDto {

    private UUID id;

    private UUID roleId;

    private String addType;

}
