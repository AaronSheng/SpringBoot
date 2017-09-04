package com.aaron.config;

import java.lang.annotation.*;

/**
 * Created by Aaron Sheng on 2017/8/27.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface TargetDataSource {
    String value();
}
