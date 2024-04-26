package com.muindi.stephen.radiogrouplibrary

/**
 * Stephen Muindi (c) 2024
 * Radio Group Library
 */


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.muindi.stephen.radiogrouplibrary.R.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // This will get the radiogroup
        val rGroup = findViewById<View>(id.radioGroup1) as RadioGroup
        val tv = findViewById<TextView>(id.textView2)

        // This will get the radiobutton in the radiogroup that is checked
        val checkedRadioButton =
            rGroup.findViewById<View>(rGroup.checkedRadioButtonId) as RadioButton

        // This overrides the radiogroup onCheckListener
        rGroup.setOnCheckedChangeListener { group, checkedId ->
            // This will get the radiobutton that has changed in its check state
                val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton
            // This puts the value (true/false) into the variable
            val isChecked = checkedRadioButton.isChecked
            // If the radiobutton that has changed in check state is now checked...
            if (isChecked) {
                // Changes the textview's text to "Checked: example radiobutton text"
                tv.text = checkedRadioButton.getText()
                checkedRadioButton.setBackgroundResource(drawable.frame_51)
                checkedRadioButton.setTextColor(ContextCompat.getColor(this,color.white))

                for (i in 0 until group.childCount) {
                    val radioButton = group.getChildAt(i) as RadioButton
                    if (radioButton.id != checkedId) {
                        radioButton.setBackgroundResource(drawable.frame_52)
                        radioButton.setTextColor(ContextCompat.getColor(this,color.black))
                    }
                }
            }
        }
    }
}