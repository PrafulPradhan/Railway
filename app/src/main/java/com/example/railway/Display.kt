package com.example.railway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.railway.databinding.ActivityDisplayBinding

private lateinit var binding:ActivityDisplayBinding
class Display : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        var firstName :String=intent.getStringExtra("firstName").toString()
        var lastName=intent.getStringExtra("lastName").toString()
        var division=intent.getStringExtra("division").toString()
        var rollNo=intent.getStringExtra("rollNo").toString()
        var aadhar=intent.getStringExtra("aadhar").toString()
        var from=intent.getStringExtra("from").toString()
        var gender=intent.getStringExtra("gender").toString()
        var duration=intent.getStringExtra("duration").toString()

        var a = 8
        var b=69
        var c =420
        var d=43
        var e=69

        binding.tvDetails.text="Name: "+firstName+" "+lastName+
                                "\nDivision: "+division+"\nRoll number: "+rollNo+
                                "\nAadhar-Number: "+aadhar+" \nGender: "+gender+
                                "\nFrom: "+from+ "   To: Kurla"+
                                "\nDuration: "+duration


    }
}
