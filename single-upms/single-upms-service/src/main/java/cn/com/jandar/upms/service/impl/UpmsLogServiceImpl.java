package cn.com.jandar.upms.service.impl;

import cn.com.jandar.common.annotation.BaseService;
import cn.com.jandar.common.base.BaseServiceImpl;
import cn.com.jandar.upms.api.UpmsLogService;
import cn.com.jandar.upms.dao.mapper.UpmsLogMapper;
import cn.com.jandar.upms.dao.model.UpmsLog;
import cn.com.jandar.upms.dao.model.UpmsLogExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志service实现
 * Created by shuzheng on 2017/3/14.
 */
@Service
@Transactional
@BaseService
public class UpmsLogServiceImpl extends BaseServiceImpl<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

    private static Logger _log = LoggerFactory.getLogger(UpmsLogServiceImpl.class);

    @Autowired
    UpmsLogMapper upmsLogMapper;

}