package com.cniao5.cniaoPlay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cniao5.cniaoPlay.R;
import com.cniao5.cniaoPlay.data.ActivityComponent;
import com.cniao5.cniaoPlay.data.ActivityModule;
import com.cniao5.cniaoPlay.data.DaggerActivityComponent;
import com.cniao5.cniaoPlay.network.OkHttpUtil;
import com.cniao5.cniaoPlay.pojo.UserInfo;
import com.cniao5.cniaoPlay.ui.base.BaseFragment;
import com.google.gson.Gson;

import java.io.IOException;

import javax.inject.Inject;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by mcdull.
 */
public class GameFragment extends BaseFragment {

    @Inject
    UserInfo userInfo;
    private ActivityComponent activityComponent;

    private String url = "http://112.124.22.238:8081/course_api/auth/login?phone=15677975034&password=cniaowo12345678";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_main, container, false);

        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        activityComponent.inject(this);

        final TextView result = (TextView) view.findViewById(R.id.result);
        Button getBtu = (Button) view.findViewById(R.id.get_btu);
        getBtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormBody formBody = new FormBody.Builder()
                        .add("Content-Type", "application/json")
                        .build();

                Request request = new Request.Builder()
                        .url(url)
                        .post(formBody)
                        .build();

                Callback callback = new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, final Response response) throws IOException {

                        userInfo.setMessage("测试依赖注入");
                        Gson gson = new Gson();
//                        userInfo = gson.fromJson(response.body().string(),UserInfo.class);
                        if(response.isSuccessful()){
                           getActivity().runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   result.setText(userInfo.getMessage());
                               }
                           });
                        }
                    }
                };
                OkHttpUtil.enqueue(request, callback);
            }
        });





        return view;
    }


}
