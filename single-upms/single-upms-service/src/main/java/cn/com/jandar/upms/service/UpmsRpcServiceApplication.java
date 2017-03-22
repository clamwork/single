package cn.com.jandar.upms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by ZhangShuzheng on 2017/2/3.
 */
public class UpmsRpcServiceApplication {

	private static Logger _log = LoggerFactory.getLogger(UpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		_log.info(">>>>> jandar-upms-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
		_log.info(">>>>> jandar-upms-rpc-service 启动完成 <<<<<");
	}

}
