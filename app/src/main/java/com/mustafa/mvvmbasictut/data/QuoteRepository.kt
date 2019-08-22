package com.mustafa.mvvmbasictut.data

/**
 * The repository is the one who makes the decision regarding to app data either is fetched from eb or Room database
 */
class QuoteRepository private constructor(private val quoteDoa: QuoteDoa){

    //Static
    companion object {

        //@Volatile meaning that writes to this field are immediately made visible to other threads.
        @Volatile private var instance: QuoteRepository? = null
        // In case instance is null then execute synchronized "only one thread can execute it"
        fun getInstance(quoteDoa: QuoteDoa) = instance ?: synchronized(this) {

            instance ?: QuoteRepository(quoteDoa).also { instance = it }
        }

    }

    fun addQuote (quote : Quote) {
        quoteDoa.addQuote(quote)
    }

    fun getQuotes () = quoteDoa.getQuotes()
}