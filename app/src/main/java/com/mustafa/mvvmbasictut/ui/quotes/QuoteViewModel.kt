package com.mustafa.mvvmbasictut.ui.quotes

import androidx.lifecycle.ViewModel
import com.mustafa.mvvmbasictut.data.Quote
import com.mustafa.mvvmbasictut.data.QuoteRepository

class QuoteViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {

    fun getQuotes () =  quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) {
        quoteRepository.addQuote(quote)
    }


}