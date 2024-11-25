package com.bitcode.sep_24_webservicesusinggson_demo

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.sep_24_webservicesusinggson_demo.databinding.BookViewBinding
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class BooksAdapter(private var books : ArrayList<Book>):RecyclerView.Adapter<BooksAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var bookViewBinding : BookViewBinding
        init {
            bookViewBinding = BookViewBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       val bookView = LayoutInflater.from(parent.context).inflate(R.layout.book_view,null)
        return BookViewHolder(bookView)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookViewBinding.txtTitle.text = books[position].title
        holder.bookViewBinding.txtISBN.text = books[position].isbn
        holder.bookViewBinding.txtPrice.text = books[position].price + ""

        Glide.with(holder.itemView)
            .load(books[position].image)
            .error(R.drawable.ic_launcher_background)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.bookViewBinding.imgBookView)
    }

    override fun getItemCount(): Int {
        return books.size
    }
}