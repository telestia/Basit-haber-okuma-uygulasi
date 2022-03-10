package com.harunsubasi.haberuygulamasi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.harunsubasi.haberuygulamasi.R
import com.harunsubasi.haberuygulamasi.model.News
import com.harunsubasi.haberuygulamasi.view.DetayHaber
import com.harunsubasi.haberuygulamasi.view.ListeHaberler
import com.harunsubasi.haberuygulamasi.view.ListeHaberlerDirections
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detay_haber.view.*
import kotlinx.android.synthetic.main.recycler_row.view.*

class AdapterRecyclerView(val News: ArrayList<News>,val  article : ArrayList<News.Article>) : RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>() {


    private var websayfasi = DetayHaber()
    class ViewHolder(var view : View) : RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recycler_row,parent,false)
        return ViewHolder(view)
    }



    override fun getItemCount(): Int {
        //println(article.size)
        return  article.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.view.haberBasligi.text = article[position].title
        holder.view.haberKaynagi.text = article[position].source?.name
        Picasso.get().load(article[position].urlToImage).into(holder.view.haberResmi)


        holder.view.setOnClickListener {


            article[position].url?.let { url ->


            }
            val action = ListeHaberlerDirections.actionListeHaberlerToDetayHaber( article[position].url)
            Navigation.findNavController(it).navigate(action)



        }

    }

    fun updateNewsList (newNewsList : List<News.Article>){
        News.clear()
        article.addAll(newNewsList)
        notifyDataSetChanged()
    }

}