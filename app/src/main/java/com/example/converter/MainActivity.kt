package com.example.converter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var decimalInput:EditText
    lateinit var binaryInput:EditText
    lateinit var octalInput:EditText
    lateinit var hexadecimalInput:EditText
    lateinit var convertButton:Button
    lateinit var clearButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intiView()
        convertButton.setOnClickListener {
           if(decimalInput.text.isNotBlank()) convertNumbersFromDecimal()
            else if(binaryInput.text.isNotBlank())convertNumbersFromBinary()
            else if(octalInput.text.isNotBlank())convertNumbersFromOctal()
            else convertNumbersFromHexadecimal()
        }
        clearButton.setOnClickListener { clearTextEdit() }
    }
    private fun intiView(){

        decimalInput=findViewById(R.id.decimal_input)
        binaryInput=findViewById(R.id.binary_input)
        octalInput=findViewById(R.id.octal_input)
        hexadecimalInput=findViewById(R.id.hexadecimal_input)
        convertButton=findViewById(R.id.convert_button)
        clearButton=findViewById(R.id.clear_button)
    }
    private fun convertNumbersFromDecimal() {
        val decimal = decimalInput.text.toString().toIntOrNull() ?: return
        binaryInput.setText(decimal.toString(2))
        octalInput.setText(decimal.toString(8))
        hexadecimalInput.setText(decimal.toString(16).uppercase())
    }
    private fun convertNumbersFromBinary() {
        val  binary = binaryInput.text.toString().toIntOrNull(2) ?: return
        decimalInput.setText(binary.toString(10))
        octalInput.setText(binary.toString(8))
        hexadecimalInput.setText(binary.toString(16).uppercase())
    }
    private fun convertNumbersFromOctal() {
        val  octal = octalInput.text.toString().toIntOrNull(8) ?: return
        decimalInput.setText(octal.toString(10))
        binaryInput.setText(octal.toString(2))
        hexadecimalInput.setText(octal.toString(16).uppercase())
    }
    private fun convertNumbersFromHexadecimal() {
        val  hexadecimal = hexadecimalInput.text.toString().toIntOrNull(16) ?: return
        decimalInput.setText(hexadecimal.toString(10))
        binaryInput.setText(hexadecimal.toString(2))
        octalInput.setText(hexadecimal.toString(8))
    }

    private fun clearTextEdit() {
        decimalInput.setText("")
        binaryInput.setText("")
        octalInput.setText("")
        hexadecimalInput.setText("")
    }


}