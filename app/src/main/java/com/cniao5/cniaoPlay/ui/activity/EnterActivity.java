package com.cniao5.cniaoPlay.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.cniao5.cniaoPlay.common.AppApplication;
import com.cniao5.cniaoPlay.common.AppConstant;
import com.cniao5.cniaoPlay.ui.base.BaseAppCompatActivity;
import com.cniao5.cniaoPlay.utils.SharedPrenfenceUtil;

/**
 * Created by mcdull.
 */
public class EnterActivity extends BaseAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (isFinishing()){
            return;
        }

        String versionShared = SharedPrenfenceUtil.getString(this, AppConstant.GUIDE_SHOW,"");
        String versionName = AppApplication.getAppContext().getVersion();

        if (TextUtils.isEmpty(versionShared)|| !versionShared.equalsIgnoreCase(versionName)){
            //显示引导页
            openActivity(GuideActivity.class);

        }else {
            //显示主界面
            openActivity(MainActivity.class);
        }
        finish();
    }
}
