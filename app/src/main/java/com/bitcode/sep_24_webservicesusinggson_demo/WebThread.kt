package com.bitcode.sep_24_webservicesusinggson_demo

import android.os.AsyncTask
import android.os.Handler
import android.os.Message

class WebThread(private var handler : Handler) : AsyncTask<Any, Any, ArrayList<Book>>() {
    override fun doInBackground(vararg params: Any?): ArrayList<Book> {
        return WebUtil.getAllBooks()
    }
    override fun onPostExecute(result: ArrayList<Book>?) {
        super.onPostExecute(result)
        var messageObject = Message()
        messageObject.obj = result
        handler.sendMessage(messageObject)
    }
}