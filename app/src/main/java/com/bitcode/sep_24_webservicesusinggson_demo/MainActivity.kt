package com.bitcode.sep_24_webservicesusinggson_demo

import android.os.Bundle
import android.os.Handler
import android.os.Message
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bitcode.sep_24_webservicesusinggson_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var booksAdapter: BooksAdapter
    var books : ArrayList<Book> = ArrayList<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(activityMainBinding.root)
        initRecyclerView()
        WebThread(MessageHandler()).execute()
    }

    private fun initRecyclerView(){
        booksAdapter = BooksAdapter(books)
        activityMainBinding.booksRecyclerView.adapter = booksAdapter
        activityMainBinding.booksRecyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,
            false)
    }

    private inner class MessageHandler : Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)

            if (msg.obj != null) {
                val booksResponse = msg.obj as ArrayList<Book>
                this@MainActivity.books.addAll(booksResponse)
                booksAdapter.notifyDataSetChanged()         //important
            }
        }
    }
}