package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.model.gitmodel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Retrofit网络请求示例
 */

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
        gitapi service = restAdapter.create(gitapi.class);

        service.getFeed("basil2style", new Callback<gitmodel>() {
            @Override
            public void success(gitmodel gitmodel, Response response) {
                Log.i(TAG, "success");
                Log.i(TAG, gitmodel.getCompany());
                Log.i(TAG, gitmodel.getName());
                Log.i(TAG, gitmodel.getBlog());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.i(TAG,error.getMessage());
            }
        });
    }


    public interface gitapi {
        @GET("/users/{user}")
        void getFeed(@Path("user") String user, Callback<gitmodel> response);
    }
}
