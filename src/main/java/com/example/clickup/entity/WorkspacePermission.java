package com.example.clickup.entity;

import com.example.clickup.entity.enums.WorkspacePermissionName;
import com.example.clickup.entity.template.AbstractUUIDEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspacePermission extends AbstractUUIDEntity {

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    private WorkspaceRole workspaceRole;//o'rinbosar

    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName permission;//add member,remove member



}
