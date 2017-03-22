package cn.com.jandar.upms.service.impl;
import cn.com.jandar.common.annotation.BaseService;
import cn.com.jandar.common.base.BaseServiceImpl;
import cn.com.jandar.upms.api.UpmsSystemService;
import cn.com.jandar.upms.dao.mapper.UpmsSystemMapper;
import cn.com.jandar.upms.dao.model.UpmsSystem;
import cn.com.jandar.upms.dao.model.UpmsSystemExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 系统service实现
 * Created by shuzheng on 2016/12/18.
 */
@Service
@Transactional
@BaseService
public class UpmsSystemServiceImpl extends BaseServiceImpl<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

    private static Logger _log = LoggerFactory.getLogger(UpmsSystemServiceImpl.class);

    @Autowired
    UpmsSystemMapper upmsSystemMapper;

}