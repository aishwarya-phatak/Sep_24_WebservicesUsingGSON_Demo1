package com.bitcode.sep_24_webservicesusinggson_demo

import android.os.AsyncTask

class WebThread : AsyncTask<Any, Any, APIResponse>() {
    override fun doInBackground(vararg params: Any?): APIResponse {
        return WebUtil.getAllBooks()
    }
}