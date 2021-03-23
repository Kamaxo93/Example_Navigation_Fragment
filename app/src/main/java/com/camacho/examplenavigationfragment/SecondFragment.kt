package com.camacho.examplenavigationfragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var name: String? = ""
    private var age: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       name = requireArguments().getString(MY_NAME)
       age = requireArguments().getInt(MY_AGE)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val labelTextInfo = view.findViewById<TextView>(R.id.second_fragment__label__text_info)
        val btnSetData = view.findViewById<Button>(R.id.second_fragment__btn__btn_navigation)
        labelTextInfo.text = "$name $age"
        btnSetData.setOnClickListener {
            val result = "Resultado"
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
    }

    companion object {
        private const val MY_NAME = "name"
        private const val MY_AGE = "age"

        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            arguments = bundleOf(MY_NAME to name, MY_AGE to age)
        }
    }
}