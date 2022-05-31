package com.example.clickup.repository;

import com.example.clickup.entity.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspacePermissionRepository extends JpaRepository<WorkspacePermission, UUID> {
}
