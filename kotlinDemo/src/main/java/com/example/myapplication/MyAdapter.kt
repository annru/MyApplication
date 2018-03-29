package com.example.myapplication

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

/**
 * Created on 2018/3/28.
 * @author 00224524
 */
class MyAdapter : BaseAdapter {
    private var mData: ArrayList<String>
    private var mContext: Context

    constructor(list: ArrayList<String>, context: Context) {
        this.mData = list
        this.mContext = context
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: MyViewHolder
        val v: View
        if (convertView == null) {
            v = View.inflate(mContext, R.layout.item, null)
            holder = MyViewHolder(v)
            v.tag = holder
        } else {
            v = convertView
            holder = v.tag as MyViewHolder
        }
        holder.str.text = mData[position]
        return v
    }

    override fun getItem(position: Int): Any {
        return mData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return mData.size
    }


    private class MyViewHolder(viewItem: View) {
        var str: TextView = viewItem.findViewById(R.id.textView) as TextView
    }
}