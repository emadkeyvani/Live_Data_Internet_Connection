package com.keyvani.livedatainternetconnection

import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.keyvani.livedatainternetconection.R
import com.keyvani.livedatainternetconection.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val checkConnection by lazy { CheckConnection(application) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            checkConnection.observe(this@MainActivity,){
                if (it) {
                    ivStatus.setImageResource(R.drawable.ic_baseline_wifi_24)
                    ivStatus.setColorFilter(ContextCompat.getColor(this@MainActivity,R.color.green),PorterDuff.Mode.MULTIPLY)

                    tvStatus.text= "CONNECTED :)"
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.green))

                }else{
                    ivStatus.setImageResource(R.drawable.ic_baseline_wifi_off_24)
                    ivStatus.setColorFilter(ContextCompat.getColor(this@MainActivity,R.color.red),PorterDuff.Mode.MULTIPLY)

                    tvStatus.text= "DISCONNECTED :("
                    tvStatus.setTextColor(ContextCompat.getColor(this@MainActivity,R.color.red))

                }
            }
        }



    }
}