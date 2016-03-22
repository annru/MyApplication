package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.model.APIService;
import com.example.myapplication.model.Repo;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

//import retrofit.Callback;
//import retrofit.http.GET;
//import retrofit.http.Path;

/**
 * Retrofit网络请求示例
 */

public class RetrofitActivity extends AppCompatActivity {
    private static final String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);


        /**
         *1.9版本请求方式
         */

//        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint("https://api.github.com").build();
//        gitapi service = restAdapter.create(gitapi.class);
//
//        service.getFeed("basil2style", new Callback<gitmodel>() {
//            @Override
//            public void success(gitmodel gitmodel, Response response) {
//                Log.i(TAG, "success");
//                Log.i(TAG, gitmodel.getCompany());
//                Log.i(TAG, gitmodel.getName());
//                Log.i(TAG, gitmodel.getBlog());
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.i(TAG,error.getMessage());
//            }
//        });


        /**
         * 2.0版本请求方式
         */
        //异步请求

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Call<Repo> call = service.loadRepo();
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Response<Repo> response) {
                // Get result Repo from response.body()
                Log.d("onResponse", response.body().getWeatherinfo().getCity());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("onFailure", t.getMessage());

            }
        });



    }


//    public interface gitapi {
//        @GET("/users/{user}")
//        void getFeed(@Path("user") String user, Callback<gitmodel> response);
//    }
}
