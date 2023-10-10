package com.example.railway

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.railway.databinding.ActivityFormBinding

private lateinit var binding:ActivityFormBinding
class Form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getSupportActionBar()?.hide()
        binding.btnSubmitForm.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            //set title for alert dialog
            builder.setTitle("Confirm?")
            //set message for alert dialog
            builder.setMessage("Do you want to submit?")
            builder.setIcon(android.R.drawable.ic_dialog_alert)

            //performing positive action
            builder.setPositiveButton("Yes"){dialogInterface, which ->
                var firstName:String= binding.etFirstName.text.toString()
                var lastName:String= binding.etLastName.text.toString()
                var division:String = binding.etDiv.text.toString()
                var aadhar:String= binding.etAadhar.text.toString()
                var rollNo:String= binding.etRoll.text.toString()
                var from:String = binding.etFrom.text.toString()
                var gender= binding.radioGender.checkedRadioButtonId
                var genderRadioButton : RadioButton =findViewById(gender)
                var duration= binding.radioPass.checkedRadioButtonId
                var durationRadioButton: RadioButton=findViewById(duration)
                var bool= binding.switch1.isChecked
                if (firstName.isEmpty()||lastName.isEmpty()||division.isEmpty()||aadhar.isEmpty()||rollNo.isEmpty()||from.isEmpty()){
                    Toast.makeText(this,"Please Fill All Fields!",Toast.LENGTH_LONG).show()
                    Toast.makeText(this,"Please Fill All Fields!",Toast.LENGTH_LONG).show()

                }
                else if(gender==-1){
                    Toast.makeText(this,"Please Select Gender!",Toast.LENGTH_LONG).show()
                }
                else if(duration==-1){
                    Toast.makeText(this,"Please Select Duration!",Toast.LENGTH_LONG).show()
                }
                else{
                    intent = Intent(applicationContext, Display::class.java)
                    intent.putExtra("firstName",firstName)
                    intent.putExtra("lastName",lastName)
                    intent.putExtra("division",division)
                    intent.putExtra("aadhar",aadhar)
                    intent.putExtra("rollNo",rollNo)
                    intent.putExtra("from",from)
                    intent.putExtra("gender",genderRadioButton.getText())
                    intent.putExtra("duration",durationRadioButton.getText())
                    intent.putExtra("handicapped",bool)
                    var student= Student(firstName, lastName, division, rollNo, aadhar)
                    var db=DBManager(context = this)
                    db.insertData(student)
                    startActivity(intent)
                }

            }
            builder.setNeutralButton("Cancel") { dialogInterface, which ->

            }
            builder.setNegativeButton("No"){dialogInterface, which ->

            }
            // Create the AlertDialog
            val alertDialog: AlertDialog = builder.create()
            // Set other dialog properties
            alertDialog.setCancelable(false)
            alertDialog.show()
        }
    }
}