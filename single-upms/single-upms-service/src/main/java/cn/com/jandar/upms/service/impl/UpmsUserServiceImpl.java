package cn.com.jandar.upms.service.impl;

import cn.com.jandar.common.annotation.BaseService;
import cn.com.jandar.common.base.BaseServiceImpl;
import cn.com.jandar.upms.api.UpmsUserService;
import cn.com.jandar.upms.dao.mapper.UpmsUserMapper;
import cn.com.jandar.upms.dao.model.UpmsUser;
import cn.com.jandar.upms.dao.model.UpmsUserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户service实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
@BaseService
public class UpmsUserServiceImpl extends BaseServiceImpl<UpmsUserMapper, UpmsUser, UpmsUserExample> implements UpmsUserService {

    private static Logger _log = LoggerFactory.getLogger(UpmsUserServiceImpl.class);

    @Autowired
    UpmsUserMapper upmsUserMapper;

}