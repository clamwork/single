package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsUserPermissionMapper;
import cn.com.jandar.upms.dao.model.UpmsUserPermission;
import cn.com.jandar.upms.dao.model.UpmsUserPermissionExample;

/**
 * 降级实现UpmsUserPermissionService接口
 * Created by shuzheng on 2017/2/26.
 */
public class UpmsUserPermissionServiceMock extends BaseServiceMock<UpmsUserPermissionMapper, UpmsUserPermission, UpmsUserPermissionExample> implements UpmsUserPermissionService {

}
