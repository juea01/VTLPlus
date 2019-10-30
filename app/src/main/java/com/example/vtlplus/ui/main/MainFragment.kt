package com.example.vtlplus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.example.vtlplus.R




class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(com.example.vtlplus.R.layout.main_fragment, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        val trackButton: Button? = activity?.findViewById(com.example.vtlplus.R.id.trackingButton)
        if (trackButton != null) {
            trackButton.setOnClickListener{

                val fragmentManager = activity!!.supportFragmentManager
                var loginFr = LoginFragment.newInstance(0)


                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.vtlplus.R.id.container, loginFr)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

    }

}
