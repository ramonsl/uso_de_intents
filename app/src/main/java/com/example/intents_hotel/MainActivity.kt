package com.example.intents_hotel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intents_hotel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.btnContato.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ContatoActivity::class.java)
            startActivity(intent)
        })

        bind.btnFotos.setOnClickListener(View.OnClickListener {
            //Todo: implementar essa intent
        })

    }
}
