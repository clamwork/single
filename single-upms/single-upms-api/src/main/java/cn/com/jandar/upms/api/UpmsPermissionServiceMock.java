package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsPermissionMapper;
import cn.com.jandar.upms.dao.model.UpmsPermission;
import cn.com.jandar.upms.dao.model.UpmsPermissionExample;

/**
 * 降级实现UpmsPermissionService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsPermissionServiceMock extends BaseServiceMock<UpmsPermissionMapper, UpmsPermission, UpmsPermissionExample> implements UpmsPermissionService {

}
