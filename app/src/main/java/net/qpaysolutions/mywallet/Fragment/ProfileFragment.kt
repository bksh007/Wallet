package net.qpaysolutions.mywallet.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import net.qpaysolutions.mywallet.R

@Suppress("UNREACHABLE_CODE")
class ProfileFragment : Fragment() {
    lateinit var edit_account : TextView
    lateinit var language : TextView
    lateinit var selected_language : TextView
    lateinit var security : TextView
    lateinit var help_center : TextView
    lateinit var sign_out : TextView


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
        val view =  inflater.inflate(R.layout.fragment_profile, container, false)

        edit_account = view.findViewById(R.id.fragment_profile_tv_edit_account)
        language = view.findViewById(R.id.fragment_profile_tv_language)
        selected_language = view.findViewById(R.id.fragment_profile_tv_selected_language)
        security = view!!.findViewById(R.id.fragment_profile_tv_security)
        help_center = view.findViewById(R.id.fragment_profile_tv_help_center)
        sign_out = view.findViewById(R.id.fragment_profile_tv_sign_out)


        edit_account.setOnClickListener(){
            val fragment = EditAccountFragment()
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.container, fragment)?.addToBackStack("my_fragment")
                ?.commit()
        }

        return view
    }

}

