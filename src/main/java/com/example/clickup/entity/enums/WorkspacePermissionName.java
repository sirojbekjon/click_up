package com.example.clickup.entity.enums;

import java.util.Arrays;
import java.util.List;

public enum WorkspacePermissionName {
    CAN_ADD_MEMBER("Add/remove Members",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
                   ),
    CAN_REMOVE_MEMBER("can remove Members",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
                   ),

    CAN_EDIT_WORKSPACE("CAN_EDIT_WORKSPACE ",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),

    CAN_ADD_GUEST("CAN_ADD_GUEST",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),

    CAN_SEE_TIME_ESTIMATED("CAN_SEE_TIME_ESTIMATED",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_SEE_TIME_SPENT("CAN_SEE_TIME_SPENT",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),

    CAN_CREATE_SPACES("CAN_CREATE_SPACES",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_CREATE_FOLDER("CAN_CREATE_FOLDER",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_CREATE_LISTS("CAN_CREATE_LIST",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_DELETE_COMMENTS("CAN_DELETE_COMMENTS",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_DELETE_ITEMS("CAN_DELETE_ITEMS",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_EDIT_DESCRIPTION("CAN_EDIT_DESCRIPTION",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_ADD_LIST_STATUSES("CAN_EDIT_STATUSES",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),
    CAN_EDIT_TEAM("CAN_EDIT_TEAM",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),


    CAN_EXPORT_TASKS("CAN_EXPORT_TASKS",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),


    CAN_EDIT_TEAM_OWNER("CAN_EDIT_TEAM_OWNER",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),

    CAN_MANAGE_TAGS("CAN_MANAGE_TAGS",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN,WorkspaceRoleName.ROLE_MEMBER)
    ),


    CAN_SHARE("CAN_SHARE",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN,WorkspaceRoleName.ROLE_MEMBER)
    ),

    CAN_MANAGE_STATUSES("CAN_MANAGE_STATUSES",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),

    CAN_SEE_TEAM_MEMBERS("CAN_SEE_TEAM_MEMBERS",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),


    CAN_ADD_ROLE("CAN_ADD_ROLE",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    ),


    CAN_CHANGE_PERMISSION("CAN_CHANGE_PERMISSION",
            "gives user permission to add or remove members to the workspace",
            Arrays.asList(WorkspaceRoleName.ROLE_OWNER,WorkspaceRoleName.ROLE_MEMBER.ROLE_ADMIN)
    );


    public String name;
    public String description;
    public List<WorkspaceRoleName>workspaceRoleNames;

    WorkspacePermissionName(String name, String description,List<WorkspaceRoleName> workspaceRoleNames) {
        this.name = name;
        this.description = description;
        this.workspaceRoleNames=workspaceRoleNames;
    }
}
