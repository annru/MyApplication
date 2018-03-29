package com.example.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        button.setOnClickListener { _ -> toast() }
        listview.adapter = MyAdapter(data(), this)
        listview.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(this, "点击了" + position, Toast.LENGTH_SHORT).show()
        }
    }


    private fun toast() {
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show()
    }


    private fun data(): ArrayList<String> {
        val list: ArrayList<String> = arrayListOf()
        list.add("a")
        list.add("b")
        list.add("c")
        list.add("d")
        list.add("e")
        return list
    }
}
