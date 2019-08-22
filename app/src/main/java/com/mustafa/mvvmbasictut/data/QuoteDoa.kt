package com.mustafa.mvvmbasictut.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class QuoteDoa {
    private val quotesList = mutableListOf<Quote>()

    // Once we have repository we are going to observe the quotes from it
    // and then in ViewModel will observe them from repository through mediator
    private val quotes = MutableLiveData<List<Quote>> ()

    init {
        quotes.value = quotesList
    }

    fun addQuote (quote : Quote) {
        quotesList.add(quote)
        quotes.value = quotesList
    }

//    fun getQuotes() : LiveData<List<Quote>> {
//        return quotes
//    }

    // we cast MutableLiveData to LiveData cuz outside the Doa we dint want to be able to change or modify it
    // Outside the Doa we just want to observe it
    fun getQuotes () = quotes as LiveData<List<Quote>>

    //Sometimes we need two or three Doa each one keeps tracking of something
    // and to put all the Doa s in one place you really want to put them in one class called Database in case Room
    // So we need only one instance of that class
    // kotlin has an awesome keyword syntax "object" but we can't use in this case because we will need to pass the application
    // and case of "Object" we cant do so "we cant have a constructor", so we have to do it in the java way


}