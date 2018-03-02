package com.example.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

/**
 * Created on 2017/11/27.
 *
 * @author 00224524
 */
@Entity
public class BorrowModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String itemName;
    private String personName;
    @TypeConverters(DateConverter.class)
    private Date borrowDate;

    public BorrowModel(String itemName, String personName, Date borrowDate) {
        this.itemName = itemName;
        this.personName = personName;
        this.borrowDate = borrowDate;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPersonName() {
        return personName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }
}
