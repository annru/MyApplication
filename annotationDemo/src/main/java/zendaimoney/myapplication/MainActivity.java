package zendaimoney.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = null;
        sayHello(name);
    }

    void sayHello(@NonNull String s) {
        Toast.makeText(this, "" + s, Toast.LENGTH_SHORT).show();
    }
}
