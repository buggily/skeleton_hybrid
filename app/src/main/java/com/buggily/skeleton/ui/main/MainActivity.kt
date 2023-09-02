package com.buggily.skeleton.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.buggily.skeleton.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        WindowCompat.setDecorFitsSystemWindows(
            window,
            false
        )

        val insetsController = WindowInsetsControllerCompat(
            window,
            window.decorView
        )

        val isDark: Boolean = resources.getBoolean(R.bool.is_dark)
        val isLight: Boolean = !isDark

        with(insetsController) {
            isAppearanceLightStatusBars = isLight
            isAppearanceLightNavigationBars = isLight
        }

        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_main_nav_host_fragment
        ) as NavHostFragment

        navController = navHostFragment.navController
    }
}
