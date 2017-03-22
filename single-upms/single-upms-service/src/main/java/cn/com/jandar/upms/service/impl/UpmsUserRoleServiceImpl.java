package cn.com.jandar.upms.service.impl;

import cn.com.jandar.common.annotation.BaseService;
import cn.com.jandar.common.base.BaseServiceImpl;
import cn.com.jandar.upms.api.UpmsUserRoleService;
import cn.com.jandar.upms.dao.mapper.UpmsUserRoleMapper;
import cn.com.jandar.upms.dao.model.UpmsUserRole;
import cn.com.jandar.upms.dao.model.UpmsUserRoleExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户角色service实现
 * Created by shuzheng on 2017/2/26.
 */
@Service
@Transactional
@BaseService
public class UpmsUserRoleServiceImpl extends BaseServiceImpl<UpmsUserRoleMapper, UpmsUserRole, UpmsUserRoleExample> implements UpmsUserRoleService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserRoleServiceImpl.class);

    @Autowired
    UpmsUserRoleMapper upmsUserRoleMapper;

}