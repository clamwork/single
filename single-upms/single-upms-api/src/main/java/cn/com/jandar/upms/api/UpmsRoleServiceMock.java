package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsRoleMapper;
import cn.com.jandar.upms.dao.model.UpmsRole;
import cn.com.jandar.upms.dao.model.UpmsRoleExample;

/**
 * 降级实现UpmsRoleService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsRoleServiceMock extends BaseServiceMock<UpmsRoleMapper, UpmsRole, UpmsRoleExample> implements UpmsRoleService {

}
