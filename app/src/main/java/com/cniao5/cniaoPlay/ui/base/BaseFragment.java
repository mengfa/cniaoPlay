package com.cniao5.cniaoPlay.ui.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.cniao5.cniaoPlay.R;


/**
 * Created by mcdull on 15/8/25.
 * Des:Fragment基类
 */
public class BaseFragment extends Fragment {

    /** 记录日志的标记. */
    private String TAG = BaseFragment.class.getSimpleName();

    protected void openActivity(Class<?> pClass) {
        openActivity(pClass, null);
    }

    protected void openActivity(Class<?> pClass, Bundle pBundle) {
        Intent intent = new Intent(getActivity(), pClass);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

    protected void openActivity(String pAction) {
        openActivity(pAction, null);
    }

    protected void openActivity(String pAction, Bundle pBundle) {
        Intent intent = new Intent(pAction);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }

}
