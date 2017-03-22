package cn.com.jandar.common.annotation;

import java.lang.annotation.*;

/**
 *  初始化继承BaseService的service
 * Created by superman on 2017/3/20.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BaseService {
}
