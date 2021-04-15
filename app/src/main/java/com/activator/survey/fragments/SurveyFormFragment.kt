package com.activator.survey.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.get
import androidx.fragment.app.viewModels
import com.activator.survey.R
import com.activator.survey.adapters.SurveyListAdapter
import com.activator.survey.models.SurveyModel
import com.activator.survey.viewmodels.MainViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SurveyFormFragment : Fragment() {

    val TAG:String = "SurveyFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        var root = inflater.inflate(R.layout.fragment_survey_form,container,false)

        val mainViewModel: MainViewModel by viewModels()

        var listView = root.findViewById(R.id.survey_form_listview) as ListView
        var  list : ArrayList<SurveyModel> = ArrayList()
        var text : TextView = root.findViewById(R.id.survey_form_textView)


        var adapter= activity?.let { SurveyListAdapter(it,list) }

        list.add(SurveyModel("Sprint 1", 5))
        list.add(SurveyModel("Sprint 2",8))

        listView.adapter = adapter
        adapter?.notifyDataSetChanged()

        Log.d(TAG,"OnCreate")


        return root

    }



}