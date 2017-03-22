package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsOrganizationMapper;
import cn.com.jandar.upms.dao.model.UpmsOrganization;
import cn.com.jandar.upms.dao.model.UpmsOrganizationExample;

/**
 * 降级实现UpmsOrganizationService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsOrganizationServiceMock extends BaseServiceMock<UpmsOrganizationMapper, UpmsOrganization, UpmsOrganizationExample> implements UpmsOrganizationService {

}
