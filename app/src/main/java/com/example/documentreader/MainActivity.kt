package com.example.documentreader

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import java.io.*

import java.lang.StringBuilder


class MainActivity : AppCompatActivity() {

    lateinit var documentView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        documentView = findViewById(R.id.docViewer)

    }

    fun viewPdfButton(view: View) {
        val browseStorage = Intent(Intent.ACTION_GET_CONTENT)
        browseStorage.setType("application/pdf")
        browseStorage.addCategory(Intent.CATEGORY_OPENABLE)
        startActivityForResult(Intent.createChooser(browseStorage, "Select pdf"), 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0 && resultCode == RESULT_OK && data != null)
        {
            val selectedPdf = data.data
            val intent = Intent(this@MainActivity, ViewActivity::class.java)
            intent.putExtra("FileUri", selectedPdf.toString())
            startActivity(intent)
        }
    }
}