package com.activator.survey.Utilities.Components

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE as ViewGone
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.activator.survey.R
import com.activator.survey.databinding.ActivityMainBinding
import com.activator.survey.databinding.FragmentDialogErrorBinding

class DialogBox(val errorMessage: String,val errorTitle: String) : DialogFragment() {
    private lateinit var binding: FragmentDialogErrorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDialogErrorBinding.inflate(inflater)



        var rootView : View = binding.root
        val positiveButton : Button = binding.fragmentDialogErrorButtonPositive
        val negativeButton : Button = binding.fragmentDialogErrorButtonNegative

        binding.fragmentDialogErrorTitle.text = errorTitle
        binding.fragmentDialogErrorMessage.text = errorMessage
        negativeButton.setOnClickListener(View.OnClickListener {
            dismiss()
        })
        negativeButton.text = "Okay"
        positiveButton.visibility = ViewGone
        return rootView
    }


}