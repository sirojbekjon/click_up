package com.example.clickup.entity;

import com.example.clickup.entity.enums.WorkspaceRoleName;
import com.example.clickup.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspaceUser extends AbstractUUIDEntity {

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private Workspace workspace;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkspaceRole workspaceRole;

    @Column(nullable = false)
    private Timestamp dateInvited;

    private Timestamp dateJoined;
}
