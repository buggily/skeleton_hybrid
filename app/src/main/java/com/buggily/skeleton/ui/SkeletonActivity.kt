package com.buggily.skeleton.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.buggily.skeleton.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SkeletonActivity : AppCompatActivity() {

    private val viewModel: SkeletonViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        enableEdgeToEdge()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skeleton)
        setNavigationController()
    }

    private fun setNavigationController() {
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_skeleton_nav_host_fragment
        ) as NavHostFragment

        navController = navHostFragment.navController
    }
}
