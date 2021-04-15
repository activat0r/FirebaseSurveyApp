package com.activator.survey.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.activator.survey.models.SurveyModel

class MainViewModel: ViewModel() {
    private val TAG:String = "MainViewModel"

    private val projects: MutableLiveData<ArrayList<String>> by lazy {
        MutableLiveData<ArrayList<String>>().also {
            loadProjects(it)
        }
    }

    private val teams: MutableLiveData<MutableList<String>> by lazy{
        MutableLiveData<MutableList<String>>().also {
            loadTeams(it)
        }
    }

    private val sprintSurvey:MutableLiveData<MutableList<SurveyModel>> by lazy{
        MutableLiveData<MutableList<SurveyModel>>().also {
            loadSurveyDataOfUser(it)
        }
    }

    private fun loadSurveyDataOfUser(survey: MutableLiveData<MutableList<SurveyModel>>) {
        val sprint1= SurveyModel("Sprint 1",2)
        val sprint2= SurveyModel("Sprint 2",3)
        val list = mutableListOf<SurveyModel>(sprint1,sprint2)
        survey.postValue(list)
    }

    private fun loadTeams(teams: MutableLiveData<MutableList<String>>) {
        val list = mutableListOf<String>("team 1", "team 2")
        teams.postValue(list)
    }

    fun getTeams():LiveData<MutableList<String>>{
        return  teams
    }

    fun getProjects(): LiveData<ArrayList<String>> {
        return projects
    }

    fun getSurveyDataForUser():LiveData<MutableList<SurveyModel>>{
        return sprintSurvey
    }

    private fun loadProjects(projects: MutableLiveData<ArrayList<String>>) {
        // Do an asynchronous operation to fetch users.
        val list = arrayListOf<String>("project 1","project 2")
        projects.postValue(list)
    }
}
