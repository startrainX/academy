package com.project.servicebase.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: zsp
 * @Description: mybatis_plus 练习自动填充
 * @Date: Create in 22:04 2020/4/11
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 使用mp实现添加操作时，这个方法执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 第一个参数为属性名，第二个为填充值，第三个都是一样的，那也就是只有时间比较可能会用到啊
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    /**
     * 使用mp实现修改操作时，这个方法执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
