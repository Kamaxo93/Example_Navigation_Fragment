package com.camacho.examplenavigationfragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

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
        labelTextInfo.text = "$name $age"
    }

    companion object {
        private const val MY_NAME = "name"
        private const val MY_AGE = "age"

        fun newInstance(name: String, age: Int) = SecondFragment().apply {
            arguments = bundleOf(MY_NAME to name, MY_AGE to age)
        }
    }
}