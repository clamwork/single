package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsUserRoleMapper;
import cn.com.jandar.upms.dao.model.UpmsUserRole;
import cn.com.jandar.upms.dao.model.UpmsUserRoleExample;

/**
 * 降级实现UpmsUserRoleService接口
 * Created by shuzheng on 2017/2/26.
 */
public class UpmsUserRoleServiceMock extends BaseServiceMock<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

}
