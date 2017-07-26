package com.zendaimoney.laocaibao.base;

import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.zendaimoney.laocaibao.http.CommonCallBack;
import com.zendaimoney.laocaibao.http.LaocaibaoTask;
import com.zendaimoney.laocaibao.utils.NetUtils;

import org.json.JSONObject;

/**
 * Created by 00224524 on 2017/6/13.
 * description:
 */

public class BaseFragment extends Fragment {

    public void sendRequest(Class<?> T, JSONObject params, String methodCode, CommonCallBack fragment) {
        if (NetUtils.isConnected(getActivity())) {
            LaocaibaoTask laocaibaoTask = new LaocaibaoTask(getActivity(), params, methodCode, fragment);
            laocaibaoTask.send(T);
        } else {
            Toast.makeText(getActivity(), "当前没有网络", Toast.LENGTH_SHORT).show();
        }
    }

}
