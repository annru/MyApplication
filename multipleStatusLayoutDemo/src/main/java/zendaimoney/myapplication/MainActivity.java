package zendaimoney.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.classic.common.MultipleStatusView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.multiple_status_view)
    MultipleStatusView multipleStatusView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        multipleStatusView.showError();

        multipleStatusView.showNoNetwork(R.layout.custom_no_network_view, new LinearLayoutCompat.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        multipleStatusView.showEmpty();
        multipleStatusView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (multipleStatusView.getViewStatus()) {
                    case MultipleStatusView.STATUS_NO_NETWORK:
                        Toast.makeText(MainActivity.this, "重试", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        Button retryBtn = (Button)multipleStatusView.findViewById(R.id.retry_btn);
        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "嘿哈", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
