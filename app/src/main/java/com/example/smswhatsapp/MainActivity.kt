package com.example.smswhatsapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.net.URLEncoder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setContentView(R.layout.numberlayout)
       // read()

        val btnSend : Button = findViewById(R.id.btnsend)
        val txtNumber : EditText = findViewById(R.id.edtnum)
        val txtMsg : EditText = findViewById(R.id.edtsms)
        val btncontact: Button = findViewById(R.id.btnContact)
        btncontact.setOnClickListener {

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
//            val ma1 = Intent(this, ma2::class.java)
//startActivity(ma1)
        }
        btnSend.setOnClickListener {
            if(txtNumber.text.isNotEmpty() && txtMsg.text.isNotEmpty()){
                val packageManager : PackageManager = packageManager
                val i = Intent(Intent.ACTION_VIEW)
                val url = "https://api.whatsapp.com/send?phone=" + txtNumber.text.toString() + "&text="+ URLEncoder.encode(
                    txtMsg.text.toString(),
                    "UTF-8"
                )
                i.setPackage("com.whatsapp")
                i.data = Uri.parse(url)
                if(i.resolveActivity(packageManager) != null){
                    startActivity(i)
                }
            }else{
                Toast.makeText(this, "Проверь данные", Toast.LENGTH_LONG).show()
            } }
    }

//     fun read() {
//        var cursor: Cursor? = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null, null)
//         startManagingCursor(cursor)
//         var from = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,
//         ContactsContract.CommonDataKinds.Phone._ID)
//         var to = intArrayOf(android.R.id.text1,android.R.id.text2)
//         var simple: SimpleCursorAdapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,to)
//   listView.adapter
//    }


}