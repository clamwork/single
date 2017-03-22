package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsUserMapper;
import cn.com.jandar.upms.dao.model.UpmsUser;
import cn.com.jandar.upms.dao.model.UpmsUserExample;

/**
 * 降级实现UpmsUserService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsUserServiceMock extends BaseServiceMock<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

}
