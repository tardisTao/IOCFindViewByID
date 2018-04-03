package fanshe.ioc.com.baselibrary.findview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:OnClick.java
 *
 * @author tardis_tao
 * @date 2018-03-25 02:21
 * Description:点击事件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OnClick {
    int [] value();
}
