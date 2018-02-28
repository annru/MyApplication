package zendaimoney.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = new View(this);
        view.post(new Runnable() {
            @Override
            public void run() {
                Log.i("view", "post方法1");
            }
        });

        UI.HANDLER.post(new Runnable() {
            @Override
            public void run() {
                Log.i("handler", "post方法2");
            }
        });

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("主线程", "post方法3");
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("子线程", "post方法4");
            }
        }).start();


    }


    public static class UI {
        public static final Handler HANDLER = new Handler(Looper.getMainLooper());

        private UI() {
        }
    }


}
