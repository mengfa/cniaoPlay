package com.cniao5.cniaoPlay.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cniao5.cniaoPlay.R;
import com.cniao5.cniaoPlay.pojo.TestGson;
import com.cniao5.cniaoPlay.ui.base.BaseFragment;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by mcdull.
 */
public class DiscoverFragment extends BaseFragment {

    private String jsonStr = "[\n" +
            "{ \"firstName\":\"Bill\" , \"lastName\":\"Gates\" },\n" +
            "{ \"firstName\":\"George\" , \"lastName\":\"Bush\" },\n" +
            "{ \"firstName\":\"Thomas\" , \"lastName\": \"Carter\" }\n" +
            "]";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.discover_main, container, false);

        final TextView result = (TextView) view.findViewById(R.id.result);
        Button testBtu = (Button) view.findViewById(R.id.test_btu);
        testBtu.setOnClickListener(view1 -> {
            Gson gson = new Gson();

            List<TestGson> list  = gson.fromJson(jsonStr, new TypeToken<List<TestGson>>() {}.getType());
            result.setText(list.get(0).getFirstName());
        });
        return view;
    }
}
