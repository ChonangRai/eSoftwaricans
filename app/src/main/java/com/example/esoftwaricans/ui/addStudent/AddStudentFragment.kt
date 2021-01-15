package com.example.esoftwaricans.ui.addStudent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.esoftwaricans.MainActivity2
import com.example.esoftwaricans.R
import com.example.esoftwaricans.model.Student
import java.util.*
import java.util.regex.Pattern

class AddStudentFragment : Fragment() {
    private lateinit var etStName : EditText
    private lateinit var etStAge: EditText
    private lateinit var etStAddress: EditText
    private var gender =""
    private lateinit var etStPhoto: EditText
    private lateinit var rbStGender: RadioGroup
    private lateinit var btnAddStudent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        etStName = view.findViewById(R.id.ietName)
        etStAge = view.findViewById(R.id.ietAge)
        etStAddress = view.findViewById(R.id.ietAddress)
        etStPhoto = view.findViewById(R.id.ietPicture)
        rbStGender = view.findViewById(R.id.rgGender)

        btnAddStudent = view.findViewById(R.id.btnAddStudent)

        etStName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
             if (etStName.text.toString().length >= 6 && validName(etStName.text.toString())){
                 btnAddStudent.isEnabled = true
                 etStName.text.toString().toUpperCase()
             }else{
                 btnAddStudent.isEnabled= false
                 etStName.setError("Enter a valid person name.")
             }
            }
        })
        etStAge.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                if (!etStAge.text.toString().isNullOrEmpty() && etStAge.text.toString().toInt() < 150 && validAge(etStAge.text.toString().toInt())){
                    btnAddStudent.isEnabled = true
                }else{
                    btnAddStudent.isEnabled = false
                    etStAge.setError("Enter a valid age.")
                }
            }
        })

        btnAddStudent.setOnClickListener {
            val intSelectedGender: Int =rbStGender!!.checkedRadioButtonId
            if (intSelectedGender != -1){
                gender = view.findViewById<RadioButton>(intSelectedGender).text.toString()
                submitEvent()
            }
        }
        return view
    }

    private fun validAge(age: Int): Boolean {
        var p = Pattern.compile("[0-9]+")
        var m = p.matcher(age.toString())
        return m.matches()
    }

    private fun validName(text: String): Boolean {
        var p = Pattern.compile("[a-zA-Z\\s]+")
        var m = p.matcher(text)
        return m.matches()
    }

    private fun submitEvent() {
        if (!etStName.text.isNullOrEmpty() && !etStAge.text.isNullOrEmpty()){
            (activity as MainActivity2).stdList.add(Student(UUID.randomUUID().toString(),etStName.text.toString(), etStAge.text.toString(),gender, etStAddress.text.toString(),etStPhoto.text.toString()))
            Toast.makeText(context, "Student added succefully.", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }

    private fun clearFields() {
        etStName.text = null
        etStAge.text = null
        etStAddress.text = null
        etStPhoto.text=null
    }
}