package com.example.intents_hotel

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.intents_hotel.databinding.ActivityContatoBinding
import java.net.URI

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

        bind.btnMap.setOnClickListener(View.OnClickListener {
            showMap()
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

    fun showMap() {

        val geoLocation = Uri.parse("https://www.google.com/maps/place/Portal+Torres+Hotel/@-29.3272249,-49.7538337,17z/data=!3m1!4b1!4m8!3m7!1s0x9522695e3db7e1b9:0xc37a2a9ea8b35c91!5m2!4m1!1i2!8m2!3d-29.3272174!4d-49.7516394")
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocation
        }
            startActivity(intent)

    }

}