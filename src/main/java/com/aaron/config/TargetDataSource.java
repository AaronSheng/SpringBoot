package com.aaron.config;

import java.lang.annotation.*;

/**
 * Created by Aaron Sheng on 2017/8/27.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
