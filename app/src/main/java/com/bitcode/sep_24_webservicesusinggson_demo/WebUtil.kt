package com.bitcode.sep_24_webservicesusinggson_demo

import android.util.Log
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class WebUtil {
    companion object{
        fun getAllBooks():ArrayList<Book>{

            val url = URL("https://api.itbook.store/1.0/new")
            var httpURLConnection = url.openConnection() as HttpURLConnection
            httpURLConnection.requestMethod = "GET"
            httpURLConnection.connect()
            var resReader = InputStreamReader(httpURLConnection.inputStream)
            val response = Gson().fromJson<APIResponse>(resReader, APIResponse::class.java)
            val books = response.books
            for(eachBook in books){
                Log.e("tag", "${eachBook.title} -- ${eachBook.url}")
            }
            return books
        }
    }
}