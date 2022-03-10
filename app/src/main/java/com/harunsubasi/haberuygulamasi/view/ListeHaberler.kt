package com.harunsubasi.haberuygulamasi.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout.VERTICAL
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.harunsubasi.haberuygulamasi.R
import com.harunsubasi.haberuygulamasi.adapter.AdapterRecyclerView
import com.harunsubasi.haberuygulamasi.model.News
import com.harunsubasi.haberuygulamasi.viewModel.ListeViewModel
import kotlinx.android.synthetic.main.fragment_liste_haberler.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ListeHaberler : Fragment() {


    private  var newsAdapter = AdapterRecyclerView(arrayListOf(), arrayListOf())
    private var newsModel : List<News>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste_haberler, container, false)




    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            loadData()



        recyclerView.layoutManager = GridLayoutManager(context,2, VERTICAL,false)
        recyclerView.adapter = newsAdapter






    }


    private fun loadData(){



         val BASE_URL = "https://newsapi.org/"


         val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service  = retrofit.create(com.harunsubasi.haberuygulamasi.Retrofit::class.java)
        val call = service.getNews()

        call.enqueue(object : Callback<News>{



            override fun onResponse(
                call: Call<News>,
                response: Response<News>
            ) {

                response.body()?.let {

                    it.articles?.let {articelList ->

                        newsAdapter.updateNewsList(articelList)


                    }






                    //newsAdapter.updateNewsList(arrayListOf(it))

                    //AdapterRecyclerView()
                    //newsAdapter.updateNewsList(newsModel as ArrayList<News>)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

                println(t)



            }



        })

    }





}