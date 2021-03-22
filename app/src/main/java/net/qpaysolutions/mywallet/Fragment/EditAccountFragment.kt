package net.qpaysolutions.mywallet.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import net.qpaysolutions.mywallet.IOnBackPressed
import net.qpaysolutions.mywallet.R

class EditAccountFragment : Fragment(), IOnBackPressed{
    lateinit var btn_back : ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_edit_account, container, false)

        btn_back = view.findViewById(R.id.btn_back)

        btn_back.setOnClickListener(){
            onBackPressed()
        }

        return view
    }

    override fun onBackPressed(): Boolean {
        TODO("Not yet implemented")
    }

}