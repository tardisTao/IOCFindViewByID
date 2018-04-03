package fanshe.ioc.com.baselibrary.findview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * FileName:CheckNet.java
 *
 * @author tardis_tao
 * @date 2018-03-25 02:37
 * Description:用于检测当前的网络状态
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckNet {

}
