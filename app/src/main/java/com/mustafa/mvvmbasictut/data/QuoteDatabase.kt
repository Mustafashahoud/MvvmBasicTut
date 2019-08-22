package com.mustafa.mvvmbasictut.data



//Sometimes we need two or three Doa each one keeps tracking of something
// and to put all the Doa s in one place you really want to put them in one class called Database in case Room
// So we need only one instance of that class
// kotlin has an awesome keyword syntax "object" but we can't use in this case because we will need to pass the application
// and case of "Object" we cant do so "we cant have a constructor", so we have to do it in the java way

/*
* This is the way you create Singleton in ase we wanna something to be passed in the constructor
*
* */
class QuoteDatabase private constructor(){

    var quoteDoa = QuoteDoa()
        private set // it's like the setter in Java

    //Static
    companion object {
        //@Volatile meaning that writes to this field are immediately made visible to other threads.
        @Volatile private var instance: QuoteDatabase? = null
        // In case instance is null then execute synchronized "only one thread can execute it"
        fun getInstance() = instance ?: synchronized(this) {

            instance ?: QuoteDatabase().also { instance = it }
        }

    }

}