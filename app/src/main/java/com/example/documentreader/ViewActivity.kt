package com.example.documentreader

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class ViewActivity : AppCompatActivity() {

    lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        pdfView = findViewById(R.id.viewPage)

        val pdfFile = Uri.parse(intent.getStringExtra("FileUri"))
        pdfView.fromUri(pdfFile)
            .password(null)
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .load()
    }
}
