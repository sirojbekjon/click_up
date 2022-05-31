package com.example.clickup.payload;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
public class WorkspaceDto {

    @NotNull
    private String name;

    @NotNull
    private String color;

    private UUID avatarId;
}
