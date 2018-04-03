package fanshe.ioc.com.baselibrary.findview;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * FileName:ViewUtils.java
 *
 * @author tardis_tao
 * @date 2018-03-25 01:25
 * Description:
 */

public class ViewUtils {
    //兼容Activity
    public static void inject(Activity activity) {
        inject(new ViewFinder(activity), activity);
    }

    //兼容View
    public static void inject(View view) {
        inject(new ViewFinder(view), view);
    }

    //兼容Fragment
    public static void inject(View view, Object object) {
        inject(new ViewFinder(view), object);
    }

    //兼容以上三个方法
    public static void inject(ViewFinder finder, Object object) {
        //开始注入属性
        injectFiled(finder, object);
        //开始注入方法
        injectEvent(finder, object);
    }

    /**
     * 注入方法
     * @param viewFinder
     * @param object
     */
    private static void injectEvent(ViewFinder viewFinder,Object object){
        Class<?> clazz = object.getClass();
        //1. 获取所有方法
        Method[] methods = clazz.getDeclaredMethods();
        // 2.获取方法上面的所有id
        for (Method method : methods) {
            OnClick onClick = method.getAnnotation(OnClick.class);
            if (onClick !=null){
                int[] viewIds = onClick.value();
                if (viewIds.length > 0){
                    // 3.遍历所有的id 先findViewById然后 setOnClickListener
                    for (int viewId : viewIds) {
                        View view = viewFinder.findViewById(viewId);
                        if (view !=null){
                            view.setOnClickListener(new DeclaredOnClickListener(method,object));
                        }
                    }
                }
            }
        }

    }
    /**
     * 注入属性
     *
     * @param viewFinder
     * @param object
     */
    private static void injectFiled(ViewFinder viewFinder, Object object) {
        //1.获取类里面的所有属性
        Class<?> clazz = object.getClass();
        // 获取所有属性包括私有和公有
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //2.获取viewById的里面的value值
            ViewById viewById = field.getAnnotation(ViewById.class);
            if (viewById != null) {
                // 获取ViewById属性上的viewId值
                int viewId = viewById.value();
                //3.findviewById找到view
                View view = viewFinder.findViewById(viewId);
                if (view != null) {
                    // 4. 反射注入View属性
                    // 设置所有属性都能注入包括私有和公有(暴力反射)
                    field.setAccessible(true);
                    try {
                        field.set(object, view);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new RuntimeException("Invalid @ViewInject for "
                            + clazz.getSimpleName() + "." + field.getName());
                }
            }
        }

    }


    private static class DeclaredOnClickListener implements View.OnClickListener{
        private Method mMethod;
        private Object mHandlerType;
        DeclaredOnClickListener(Method method,Object handlerType){
            this.mHandlerType=handlerType;
            this.mMethod=method;
        }
        @Override
        public void onClick(View view) {
            // 4.反射执行方法
            mMethod.setAccessible(true);
            try {
                mMethod.invoke(mHandlerType,view);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    mMethod.invoke(mHandlerType, null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
