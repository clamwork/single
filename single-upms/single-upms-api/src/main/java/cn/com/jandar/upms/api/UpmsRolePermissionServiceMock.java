package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsRolePermissionMapper;
import cn.com.jandar.upms.dao.model.UpmsRolePermission;
import cn.com.jandar.upms.dao.model.UpmsRolePermissionExample;

/**
 * 降级实现UpmsRolePermissionService接口
 * Created by shuzheng on 2017/2/26.
 */
public class UpmsRolePermissionServiceMock extends BaseServiceMock<UpmsRolePermissionMapper, UpmsRolePermission, UpmsRolePermissionExample> implements UpmsRolePermissionService {

}
