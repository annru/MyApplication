package com.example.myapplication.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.myapplication.R;
import com.jungly.gridpasswordview.GridPasswordView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.view_pager_btn)
    Button viewPagerBtn;

    @Bind(R.id.retrofit_btn)
    Button retrofitBtn;

    @Bind(R.id.recycler_view_btn)
    Button recyclerViewBtn;
    @Bind(R.id.address_book_btn)
    Button addressBookBtn;

    @Bind(R.id.grid_password_btn)
    Button gridPasswordBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPagerBtn.setOnClickListener(this);
        retrofitBtn.setOnClickListener(this);

        recyclerViewBtn.setOnClickListener(this);

        addressBookBtn.setOnClickListener(this);
        gridPasswordBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.view_pager_btn:
                intent = new Intent(this, GuideActivity.class);
                startActivity(intent);
                break;
            case R.id.retrofit_btn:
                intent = new Intent(this, RetrofitActivity.class);
                startActivity(intent);
                break;

            case R.id.recycler_view_btn:
                intent = new Intent(this, RecyclerViewActivity.class);
                startActivity(intent);
                break;

            case R.id.address_book_btn:
                intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, 1);
                break;
            case R.id.grid_password_btn:
                inputPwdDialog();
//                intent = new Intent(this, GridPasswordActivity.class);
//                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(uri, null, null, null, null);
//            while (cursor.moveToNext()) {
//                int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
//                String contact = cursor.getString(nameFieldColumnIndex);
//                String phone = cursor.get
//                Log.i("name", "name:" + contact);
//            }
//            cursor.close();
            cursor.moveToFirst();
            String phoneNumber = getContactPhone(cursor);
            Log.i("name", "手机号:" + phoneNumber);
        }
    }

    /**
     * 获取联系人手机号码
     *
     * @param cursor
     * @return
     */
    private String getContactPhone(Cursor cursor) {
        int phoneColumn = cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER);
        int phoneNum = cursor.getInt(phoneColumn);
        String result = "";
        if (phoneNum > 0) {
            // 获得联系人的ID号
            int idColumn = cursor.getColumnIndex(ContactsContract.Contacts._ID);
            String contactId = cursor.getString(idColumn);
            // 获得联系人电话的cursor
            Cursor phone = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "="
                            + contactId, null, null);
            if (phone.moveToFirst()) {
                for (; !phone.isAfterLast(); phone.moveToNext()) {
                    int index = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    int typeindex = phone
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.TYPE);
                    int phone_type = phone.getInt(typeindex);
                    String phoneNumber = phone.getString(index);
                    result = phoneNumber;
//                  switch (phone_type) {//此处请看下方注释
//                  case 2:
//                      result = phoneNumber;
//                      break;
//
//                  default:
//                      break;
//                  }
                }
                if (!phone.isClosed()) {
                    phone.close();
                }
            }

        }
        return result;
    }


    /**
     * 密码输入框
     */
    private void inputPwdDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.show();
        alertDialog.setContentView(R.layout.dialog_input_password);
        GridPasswordView pwdView = (GridPasswordView)alertDialog.findViewById(R.id.gpv_normal);
        pwdView.setOnPasswordChangedListener(new GridPasswordView.OnPasswordChangedListener() {
            @Override
            public void onTextChanged(String psw) {
                Log.i("onTextChanged",psw);
            }

            @Override
            public void onInputFinish(String psw) {
               Log.i("onInputFinish",psw);
            }
        });
        alertDialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

}
