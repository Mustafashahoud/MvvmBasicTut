package com.mustafa.mvvmbasictut.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.mustafa.mvvmbasictut.R
import com.mustafa.mvvmbasictut.data.Quote
import com.mustafa.mvvmbasictut.utilits.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuoteViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuffer = StringBuffer()
            quotes.forEach { quote -> stringBuffer.append("$quote\n\n ") }

            textView_quotes.text = stringBuffer.toString()


        })

        button_add_quote.setOnClickListener {

            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuotes(quote)
            editText_author.setText("")
            editText_quote.setText("")

        }
    }
}
