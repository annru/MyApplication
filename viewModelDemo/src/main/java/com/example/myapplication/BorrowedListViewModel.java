package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created on 2017/11/27.
 *
 * @author 00224524
 */

public class BorrowedListViewModel extends AndroidViewModel {
    private final LiveData<List<BorrowModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    public BorrowedListViewModel(Application application) {
        super(application);
        appDatabase = AppDatabase.getDatabase(this.getApplication());
        itemAndPersonList = appDatabase.itemAndPersonModel().getAllBorrowedItems();
    }


    LiveData<List<BorrowModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    void deleteItem(BorrowModel borrowModel) {
        new DeleteAsyncTask(appDatabase).execute(borrowModel);
    }

    private static class DeleteAsyncTask extends AsyncTask<BorrowModel, Void, Void> {

        private AppDatabase db;

        DeleteAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final BorrowModel... params) {
            db.itemAndPersonModel().deleteBorrow(params[0]);
            return null;
        }

    }

}
