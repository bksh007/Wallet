package net.qpaysolutions.mywallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import net.qpaysolutions.mywallet.Fragment.AllCardsFragment
import net.qpaysolutions.mywallet.Fragment.BankCardFragment
import net.qpaysolutions.mywallet.Fragment.LoyaltyFragment
import net.qpaysolutions.mywallet.Fragment.ProfileFragment

class DashBoardActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView
    private val profileFragment =
        ProfileFragment()
    private val allCardsFragment =
        AllCardsFragment()
    private val bankCardFragment =
        BankCardFragment()
    private val loyaltyFragment =
        LoyaltyFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavigationView.background = null

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.menu_profile-> {
                    val fragment =
                        ProfileFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menu_bank_cards-> {
                    val fragment =
                        BankCardFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menu_loyalty_card-> {
                    val fragment =
                        LoyaltyFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menu_all_cards-> {
                    val fragment =
                        AllCardsFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false

        }
    }


}