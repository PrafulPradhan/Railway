package com.example.railway

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.railway.databinding.ActivityHomeBinding

private lateinit var binding:ActivityHomeBinding

class Home : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        binding.button.setOnClickListener {
            var id:String= binding.etId.text.toString()
            var password:String =binding.etPassword.text.toString()
            if (id.equals("123")&&password.equals("123")){
            intent = Intent(applicationContext, Form::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Invalid College-Id or Password",Toast.LENGTH_SHORT).show()
            }
        }
    }
}