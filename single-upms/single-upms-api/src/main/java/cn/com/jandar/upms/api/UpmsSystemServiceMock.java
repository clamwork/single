package cn.com.jandar.upms.api;


import cn.com.jandar.common.base.BaseServiceMock;
import cn.com.jandar.upms.dao.mapper.UpmsSystemMapper;
import cn.com.jandar.upms.dao.model.UpmsSystem;
import cn.com.jandar.upms.dao.model.UpmsSystemExample;

/**
 * 降级实现UpmsSystemService接口
 * Created by shuzheng on 2017/2/14.
 */
public class UpmsSystemServiceMock extends BaseServiceMock<UpmsSystemMapper, UpmsSystem, UpmsSystemExample> implements UpmsSystemService {

}
