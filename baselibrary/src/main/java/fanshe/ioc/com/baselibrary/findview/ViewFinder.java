package fanshe.ioc.com.baselibrary.findview;

import android.app.Activity;
import android.view.View;

/**
 * FileName:ViewFinder.java
 *
 * @author tardis_tao
 * @date 2018-03-25 01:29
 * Description:为了兼容所有的传入参数，
 */

public class ViewFinder {
    private Activity mActivity;
    private View mView;

    ViewFinder(Activity activity) {
        this.mActivity = activity;
    }

     ViewFinder(View view) {
        this.mView = view;
    }

    //反射注入id（根据viewId设置MainActivity的findviewbyid）
     View findViewById(int viewId) {
        return mActivity != null ? mActivity.findViewById(viewId) : mView.findViewById(viewId);
    }
}
