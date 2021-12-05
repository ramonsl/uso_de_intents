package com.example.intents_hotel

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.intents_hotel.databinding.ActivityContatoBinding

class ContatoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityContatoBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnFone.setOnClickListener(View.OnClickListener {
            Log.d("Clique", "Email")
           dialPhoneNumber(bind.btnFone.text.toString())
        })

        bind.btnSite.setOnClickListener(View.OnClickListener {
            Log.d("Clique", "Discar")
            openWebPage(bind.btnSite.text.toString())
        })

        bind.btnEmail.setOnClickListener(View.OnClickListener {
            Log.d("Clique", "Enviar")
            //Todo: implementar essa intent
        })
    }

    private fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
            startActivity(intent)
    }

    private fun openWebPage(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
}