package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsUserOrganizationMapper;
import cn.com.jandar.upms.dao.model.UpmsUserOrganization;
import cn.com.jandar.upms.dao.model.UpmsUserOrganizationExample;

/**
 * 降级实现UpmsUserOrganizationService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsUserOrganizationServiceMock extends BaseServiceMock<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

}
