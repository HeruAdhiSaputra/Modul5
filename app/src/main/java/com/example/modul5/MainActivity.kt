package com.example.modul5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.modul5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
        binding.button.setOnClickListener {
            val intent = Intent (Intent.ACTION_SEND)
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, binding.editTextText4.text.toString() )
            intent.type="text/plain"

            startActivity(Intent(Intent.createChooser(intent,"Share To")))


        }
        binding.button2.setOnClickListener {
            val uri = Uri.parse("tel:" + binding.editTextText2.text.toString())
            startActivity(Intent(Intent.ACTION_DIAL,uri))
        }
        binding.button3.setOnClickListener {
            val uri = Uri.parse("geo:0,0?q=" + binding.editTextText3.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
        binding.button4.setOnClickListener {
            val uri = Uri.parse(binding.editTextText.text.toString())
            startActivity(Intent(Intent.ACTION_VIEW,uri))
        }
        binding.button5.setOnClickListener {
            startActivity(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
        binding.button6.setOnClickListener {
            val intentgalery = Intent(Intent.ACTION_VIEW)
            intentgalery.data = Uri.parse("content://media/external/images/media/")
            startActivity(intentgalery)
        }
        binding.button8.setOnClickListener {
            startActivity(Intent(AlarmClock.ACTION_SHOW_ALARMS))
        }
    }

}