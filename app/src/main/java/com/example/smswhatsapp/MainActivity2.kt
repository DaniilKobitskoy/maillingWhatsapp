package com.example.smswhatsapp

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        read()
    }
    fun read() {
        var cursor: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null, null)
        startManagingCursor(cursor)
        var from = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone._ID)
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)
        var simple: SimpleCursorAdapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to)
        var lv = findViewById(R.id.listView) as ListView
        lv.adapter = simple

    }
}