package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsLogMapper;
import cn.com.jandar.upms.dao.model.UpmsLog;
import cn.com.jandar.upms.dao.model.UpmsLogExample;

/**
 * 降级实现UpmsLogService接口
 * Created by shuzheng on 2017/3/14.
 */
public class UpmsLogServiceMock extends BaseServiceMock<UpmsLogMapper, UpmsLog, UpmsLogExample> implements UpmsLogService {

}
