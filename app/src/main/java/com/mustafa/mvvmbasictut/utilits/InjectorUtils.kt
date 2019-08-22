package com.mustafa.mvvmbasictut.utilits

import com.mustafa.mvvmbasictut.data.QuoteDatabase
import com.mustafa.mvvmbasictut.data.QuoteRepository
import com.mustafa.mvvmbasictut.ui.quotes.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val repository = QuoteRepository.getInstance(QuoteDatabase.getInstance().quoteDoa)
        return QuotesViewModelFactory(repository)
    }
}