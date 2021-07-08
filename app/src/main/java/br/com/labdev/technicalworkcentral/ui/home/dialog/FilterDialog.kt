package br.com.labdev.technicalworkcentral.ui.home.dialog

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import br.com.labdev.technicalworkcentral.R
import com.google.android.material.slider.RangeSlider
import kotlinx.android.synthetic.main.dialog_filter.view.*
import java.util.*

class FilterDialog(
    var informedFilters: (a: String, m: String, s: String,
                          c: String, k: String, y:RangeSlider) -> Unit = { _,_,_,_,_,_ -> }
): DialogFragment() {

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if(dialog!=null){
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.window!!.setGravity(Gravity.CENTER_VERTICAL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val rootView: View = inflater.inflate(R.layout.dialog_filter, container)

        val authorName = rootView.dialog_author_name_edtxt.editableText.toString()
        val mentorName = rootView.dialog_mentor_name_edtxt.editableText.toString()
        val studyArea = rootView.dialog_study_area_edtxt.editableText.toString()
        val course = rootView.dialog_course_edtxt.editableText.toString()
        val keyWord = rootView.dialog_keyword_edtxt.editableText.toString()
        val year: RangeSlider = rootView.findViewById(R.id.dialog_year_slider)
        year.valueFrom = 1995f
        year.valueTo = Calendar.YEAR.toFloat()
        year.stepSize = 1f
        year.values = listOf(1995f,2021f)

        rootView.dialog_confirm_btn.setOnClickListener {
            informedFilters(authorName, mentorName, studyArea, course, keyWord, year)
            dialog?.dismiss()
        }

        rootView.dialog_cancel_btn.setOnClickListener {
            dialog?.dismiss()
        }

        return rootView
    }
}