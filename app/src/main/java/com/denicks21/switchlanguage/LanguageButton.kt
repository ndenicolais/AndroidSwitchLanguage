package com.denicks21.switchlanguage

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class LanguageButton : AppCompatActivity() {
    lateinit var mBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocate()
        setContentView(R.layout.activity_language_button)
        mBtn = findViewById(R.id.mChangeLang)
        mBtn.setOnClickListener {
            showChangeLang()
        }
    }

    private fun showChangeLang() {
        val listItmes = arrayOf("Italian", "English", "Espanol", "Francais", "Deutsch")
        val mBuilder = AlertDialog.Builder(this@LanguageButton)
        mBuilder.setTitle(R.string.changeLangTitle)
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("it")
                recreate()
            } else if (which == 1) {
                setLocate("us")
                recreate()
            } else if (which == 2) {
                setLocate("es")
                recreate()
            } else if (which == 3) {
                setLocate("fr")
                recreate()
            } else if (which == 4) {
                setLocate("de")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }

    private fun setLocate(Lang: String) {
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }
}