package cn.com.jandar.upms.service.impl;

import cn.com.jandar.common.annotation.BaseService;
import cn.com.jandar.common.base.BaseServiceImpl;
import cn.com.jandar.upms.api.UpmsUserOrganizationService;
import cn.com.jandar.upms.dao.mapper.UpmsUserOrganizationMapper;
import cn.com.jandar.upms.dao.model.UpmsUserOrganization;
import cn.com.jandar.upms.dao.model.UpmsUserOrganizationExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户组织service实现
 * Created by shuzheng on 2017/2/6.
 */
@Service
@Transactional
@BaseService
public class UpmsUserOrganizationServiceImpl extends BaseServiceImpl<UpmsUserOrganizationMapper, UpmsUserOrganization, UpmsUserOrganizationExample> implements UpmsUserOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserOrganizationServiceImpl.class);

    @Autowired
    UpmsUserOrganizationMapper upmsUserOrganizationMapper;

}