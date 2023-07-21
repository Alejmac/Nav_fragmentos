package com.example.navegacioin_entre_fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initcomponent()
        navigation = findViewById(R.id.MenuNav)
        navigation.setOnNavigationItemReselectedListener {
            (navigationFragment())

            supportFragmentManager.commit {
                //se instancia el fragment
                replace<PrimerFragment>(R.id.fragmentContainer)
                setReorderingAllowed(true)
                addToBackStack("replacement")
            }
        }
    }

    private fun initcomponent(){
        navigation = findViewById(R.id.MenuNav)

    }
    private fun navigationFragment(){
        var NavMenu = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.fragmento1 -> {
                    supportFragmentManager.commit {
                        //se instancia el fragment
                        replace<PrimerFragment>(R.id.fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragmento2 -> {
                    supportFragmentManager.commit {
                        //se instancia el fragment
                        replace<SegundoFragment>(R.id.fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }
                R.id.fragmento3 -> {
                    supportFragmentManager.commit {
                        //se instancia el fragment
                        replace<TercerFragment>(R.id.fragmentContainer)
                        setReorderingAllowed(true)
                        addToBackStack("replacement")
                    }
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }


    }
}