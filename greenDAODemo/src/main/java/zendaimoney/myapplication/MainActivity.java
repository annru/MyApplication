package zendaimoney.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zendaimoney.myapplication.gen.UserDao;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.add)
    Button add;

    @BindView(R.id.del)
    Button del;

    @BindView(R.id.search)
    Button search;

    @BindView(R.id.content)
    TextView content;

    private UserDao mUserDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //git commit 2
        //git commit 5
        //git commit 6
        //git commit 7
    }


    @OnClick({R.id.add, R.id.del, R.id.search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
            case R.id.del:
                del();
                break;
            case R.id.search:
                search();
                break;
        }
    }

    public void add() {
        mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
        User user = new User((long) new Random().nextInt(100), "安志翔");
        mUserDao.insert(user);
    }

    public void del() {
        mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
        mUserDao.deleteByKey((long) 2);
    }

    public void search() {
        mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
        List<User> list = mUserDao.loadAll();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).getId()).append("---->").append(list.get(i).getName()).append("\n");
        }
        content.setText(stringBuilder.toString());
    }
}
