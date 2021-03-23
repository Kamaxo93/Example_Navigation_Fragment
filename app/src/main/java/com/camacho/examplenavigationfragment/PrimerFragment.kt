package com.camacho.examplenavigationfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener


class PrimerFragment : Fragment(R.layout.fragment_primer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnNavigation = view.findViewById<Button>(R.id.primer_fragment__btn__btn_navigation)
        val labelTextTile = view.findViewById<TextView>(R.id.primer_fragment__label__text_title)
        setFragmentResultListener("requestKey") { _, bundle ->
            val result = bundle.getString("bundleKey")
            labelTextTile.text = result
        }

        btnNavigation.setOnClickListener {
            requireActivity().supportFragmentManager.commit {
                replace(R.id.activity_main__container__fragment_container_view, SecondFragment.newInstance("camacho", 27))
                addToBackStack("primerFragment")
            }
        }
    }

}