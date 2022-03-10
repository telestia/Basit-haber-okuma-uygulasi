package com.harunsubasi.haberuygulamasi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harunsubasi.haberuygulamasi.RetrofitService
import com.harunsubasi.haberuygulamasi.model.News
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListeViewModel : ViewModel() {
    private val ApiService = RetrofitService()
    private val disposable = CompositeDisposable()






    }
