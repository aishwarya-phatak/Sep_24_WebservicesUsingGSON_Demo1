package com.bitcode.sep_24_webservicesusinggson_demo

data class APIResponse(
    var error : String,
    var total : String,
    var books : ArrayList<Book>
){
    override fun toString(): String {
        return super.toString()
    }
}