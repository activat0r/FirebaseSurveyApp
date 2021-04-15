package com.activator.survey.Utilities.Listeners

import android.content.Context
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.activator.survey.Utilities.Components.DialogBox

class AutoCompleteEditTextValidator(val list: ArrayList<String>, val type:String, val context: Context) : AutoCompleteTextView.Validator{
    override fun isValid(text: CharSequence?): Boolean {
        return list.contains(text.toString())
    }

    override fun fixText(invalidText: CharSequence?): CharSequence {
        Toast.makeText(context,"$invalidText is not a valid $type name",Toast.LENGTH_SHORT).show()

        return ""
    }
}