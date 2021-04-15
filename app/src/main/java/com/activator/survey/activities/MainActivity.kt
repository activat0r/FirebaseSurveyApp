package com.activator.survey.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.activator.survey.R
import com.activator.survey.databinding.ActivityMainBinding
import com.activator.survey.viewmodels.MainViewModel
import com.activator.survey.Utilities.Listeners.AutoCompleteEditTextValidator
import com.activator.survey.fragments.SurveyFormFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val projectAdapter: ArrayAdapter<String>
        val teamAdapter:ArrayAdapter<String>
        val mainViewModel: MainViewModel by viewModels()

        var projectList = arrayListOf<String>()
        val projectObserver = Observer<List<String>> { projects ->
            projectList.clear()
            projectList.addAll(projects)}

        var teamList = arrayListOf<String>()
        val teamObserver = Observer<List<String>> { teams ->
            teamList.clear()
            teamList.addAll(teams)
        }

        mainViewModel.getProjects().observe(this,projectObserver)
        mainViewModel.getTeams().observe(this,teamObserver)

        projectAdapter = ArrayAdapter(this, R.layout.dropdown_item,projectList)
        projectAdapter.clear()
        projectAdapter.addAll()
        binding.projectsSpinner.setAdapter(projectAdapter);
        binding.projectsSpinner.validator = AutoCompleteEditTextValidator(projectList,"project", this)
        binding.projectsSpinner.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            val view = v as? AutoCompleteTextView
            if(!hasFocus){
                view?.performValidation()
            }
        }

        teamAdapter = ArrayAdapter(this, R.layout.dropdown_item,teamList)
        teamAdapter.clear()
        teamAdapter.addAll()
        binding.teamSpinner.setAdapter(teamAdapter);
        binding.teamSpinner.validator = AutoCompleteEditTextValidator(teamList,"team",this)
        binding.teamSpinner.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            val view = v as? AutoCompleteTextView
            if(!hasFocus){
                view?.performValidation()
            }
        }



//        var errorDialog =  DialogBox("Failed to connect to the network. Do you want to try again?","Network Error")
//        errorDialog.isCancelable = false
//        errorDialog.show(supportFragmentManager,"networkErrorDialog")

        val fragment = SurveyFormFragment()
        supportFragmentManager.beginTransaction().add(R.id.framelayout,fragment,"surveyFragment").commitAllowingStateLoss()

    }
}

