package com.denicks21.switchlanguage

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class LanguageSpinner : AppCompatActivity() {
    var spinner: Spinner? = null
    var myLocale: Locale? = null
    private var currentLanguage = "it"
    private var currentLang: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_spinner)

        currentLanguage = intent.getStringExtra(currentLang).toString()
        spinner = findViewById<View>(R.id.spinner) as Spinner
        val list = ArrayList<String>()
        list.add("Italian")
        list.add("English")
        list.add("Espanol")
        list.add("Francais")
        list.add("Deutsch")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.adapter = adapter
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long,
            ) {
                when (position) {
                    0 -> {}
                    1 -> setLocale("it")
                    2 -> setLocale("us")
                    3 -> setLocale("es")
                    4 -> setLocale("fr")
                    5 -> setLocale("de")
                }
            }
            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    fun setLocale(localeName: String) {
        if (localeName != currentLanguage) {
            myLocale = Locale(localeName)
            val res = resources
            val dm = res.displayMetrics
            val conf = res.configuration
            conf.locale = myLocale
            res.updateConfiguration(conf, dm)
            val refresh = Intent(this, MainActivity::class.java)
            refresh.putExtra(currentLang, localeName)
            startActivity(refresh)
        } else {
            Toast.makeText(this@LanguageSpinner, "Language already selected", Toast.LENGTH_SHORT)
                .show()
        }
    }
}