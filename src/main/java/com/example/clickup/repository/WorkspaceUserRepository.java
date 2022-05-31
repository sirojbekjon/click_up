package com.example.clickup.repository;

import com.example.clickup.entity.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkspaceUserRepository extends JpaRepository<WorkspaceUser, UUID> {
}
