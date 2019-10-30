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

class MapFragment : Fragment() {

    val showIndex: Int by lazy {
        arguments?.getInt("index",0)?:0
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

                val textMes: TextView? = activity?.findViewById(com.example.vtlplus.R.id.rego)
                if (textMes != null) {
                    // Create the observer which updates the UI.
                    val regoObserver = Observer<User> { user ->
                        // Update the UI, in this case, a TextView.
                        textMes.text = "Your Registration Plate: "+user.rego
                    }

                    // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
                    viewModel.user.observe(this, regoObserver)
                }


    }

    companion object{
        fun newInstance(index: Int): MapFragment{
            val f = MapFragment()

            val args = Bundle()
            args.putInt("index", index)
            f.arguments = args
            return f
        }
    }


}

