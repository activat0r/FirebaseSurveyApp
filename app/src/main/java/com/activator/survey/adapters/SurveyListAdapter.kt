package com.activator.survey.adapters

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.widget.doAfterTextChanged
import com.activator.survey.R
import com.activator.survey.models.SurveyModel

class SurveyListAdapter(var context: Context, var listitems: ArrayList<SurveyModel>) :
    BaseAdapter(){

    override fun getCount(): Int {
        return listitems.size
    }

    override fun getItem(position: Int): Any {
        return listitems[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    override fun getView(position: Int,convertView: View?, parent: ViewGroup): View? {
        var itemView:View? = convertView
        var viewHolder :SurveyViewHolder
        if (itemView==null){
            viewHolder = SurveyViewHolder()
            val inflater : LayoutInflater = LayoutInflater.from(context)
            itemView = inflater.inflate(R.layout.item_survey, parent,false)
            viewHolder.surveyNameTextView = itemView.findViewById(R.id.survey_item_name)
            viewHolder.surveyScoreTextView = itemView.findViewById(R.id.survey_item_score)
            viewHolder.surveyCheckImageButton = itemView.findViewById(R.id.survey_item_check)
            viewHolder.surveyClearImageButton = itemView.findViewById(R.id.survey_item_clear)

            viewHolder.surveyLinearLayout = itemView.findViewById(R.id.survey_item)
            itemView.tag = viewHolder
        }

        else{
            viewHolder = itemView.tag as SurveyViewHolder
        }

        viewHolder.surveyNameTextView!!.text = listitems[position].sprintName
        viewHolder.surveyScoreTextView!!.setText(listitems[position].score.toString())
        viewHolder.surveyScoreTextView!!.id = position
        Log.d("Adapter","getView")

        viewHolder.surveyCheckImageButton!!.setOnClickListener(View.OnClickListener {
            Log.d("adapter", "checked")
            listitems[position].score = viewHolder.surveyScoreTextView!!.text.toString().toInt()
            viewHolder.surveyScoreTextView!!.imeOptions = EditorInfo.IME_ACTION_NEXT
        })

        viewHolder.surveyClearImageButton!!.setOnClickListener(View.OnClickListener {
            Log.d("adapter", "cleared")
            viewHolder.surveyScoreTextView!!.setText("0")
            listitems[position].score = 0
        })

        viewHolder.surveyScoreTextView!!.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->

            if(actionId == EditorInfo.IME_ACTION_NEXT){
                viewHolder.surveyCheckImageButton!!.performClick()
                true
            }

            false
        })


        return itemView

        }


    private inner class SurveyViewHolder{
        var surveyNameTextView: TextView? = null
        var surveyScoreTextView: EditText? =null
        var surveyCheckImageButton:ImageButton? = null
        var surveyClearImageButton: ImageButton? = null
        var surveyLinearLayout: LinearLayout? = null
    }



}