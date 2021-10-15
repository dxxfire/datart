package datart.server.service;

import datart.core.entity.Role;
import datart.core.entity.ext.UserBaseInfo;
import datart.core.mappers.ext.RoleMapperExt;
import datart.security.base.ResourceType;
import datart.security.base.SubjectType;
import datart.security.base.PermissionInfo;
import datart.server.base.dto.ResourcePermissions;
import datart.server.base.dto.SubjectPermissions;
import datart.server.base.dto.ViewPermission;
import datart.server.base.params.GrantPermissionParam;
import datart.server.base.params.ViewPermissionParam;

import java.util.List;
import java.util.Set;

public interface RoleService extends BaseCRUDService<Role, RoleMapperExt> {

    boolean updateUsersForRole(String roleId, Set<String> userIds);

    boolean updateRolesForUser(String userId, String orgId, Set<String> roleIds);

    Role createPerUserRole(String orgId, String userId);

    List<UserBaseInfo> listRoleUsers(String roleId);

    boolean grantPermission(List<PermissionInfo> permissionInfo);

    boolean grantOrgOwner(String orgId, String userId);

    boolean revokeOrgOwner(String orgId, String userId);

    List<PermissionInfo> grantPermission(GrantPermissionParam grantPermissionParam);

    SubjectPermissions getSubjectPermissions(String orgId, SubjectType subjectType, String subjectId);

    ResourcePermissions getResourcePermission(String orgId, ResourceType resourceType, String resourceId);

    List<ViewPermission> listRoleViewPermission(String orgId, SubjectType subjectType, String subjectId);

    List<ViewPermission> listViewPermission(String viewId);

    boolean grantViewPermission(ViewPermissionParam viewPermissionParam);

}