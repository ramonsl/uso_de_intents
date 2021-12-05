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
           dialPhoneNumber(bind.btnFone.text.toString())
        })

        bind.btnSite.setOnClickListener(View.OnClickListener {
            Log.d("Clique", "Discar")
            openWebPage(bind.btnSite.text.toString())
        })

        bind.btnEmail.setOnClickListener(View.OnClickListener {
            //Em alguns emuladores esse método pode não funcionar.
            // Por isso realize o teste se possivel em um dispositivo que tenha uma conta de email configurada.
            composeEmail(bind.btnEmail.text.toString(), "Reserva")
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

   private fun composeEmail(addresses: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, addresses)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}