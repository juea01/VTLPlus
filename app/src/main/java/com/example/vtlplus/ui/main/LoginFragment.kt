package com.example.vtlplus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.vtlplus.R

class LoginFragment : Fragment() {

val showIndex: Int by lazy {
    arguments?.getInt("index",0)?:0
}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
        val loginButton: Button? = activity?.findViewById(com.example.vtlplus.R.id.loginButton)
        if (loginButton != null) {
            loginButton.setOnClickListener{

                val fragmentManager = activity!!.supportFragmentManager
                var mapFra = MapFragment.newInstance(0)

                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(com.example.vtlplus.R.id.container, mapFra)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }



    }

    companion object{
        fun newInstance(index: Int): LoginFragment{
            val f = LoginFragment()

            val args = Bundle()
            args.putInt("index", index)
            f.arguments = args
            return f
        }
    }

}

