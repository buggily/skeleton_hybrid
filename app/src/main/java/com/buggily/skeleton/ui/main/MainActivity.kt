package com.buggily.skeleton.ui.main

import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
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

        setupWindow(Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
        setupNavigationController()
    }

    private fun setupWindow(decorFitsSystemWindows: Boolean) {
        WindowCompat.setDecorFitsSystemWindows(
            window,
            decorFitsSystemWindows
        )

        val systemBarsColor: Int = if (decorFitsSystemWindows) {
            R.color.system_bars_translucent
        } else {
            R.color.system_bars_transparent
        }.let { ContextCompat.getColor(this, it) }

        window.statusBarColor = systemBarsColor
        window.navigationBarColor = systemBarsColor

        if (decorFitsSystemWindows) {
            return
        }

        val isDark: Boolean = resources.getBoolean(R.bool.is_dark)
        val isLight: Boolean = !isDark

        val insetsController = WindowInsetsControllerCompat(
            window,
            window.decorView
        )

        with(insetsController) {
            isAppearanceLightStatusBars = isLight
            isAppearanceLightNavigationBars = isLight
        }
    }

    private fun setupNavigationController() {
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(
            R.id.activity_main_nav_host_fragment
        ) as NavHostFragment

        navController = navHostFragment.navController
    }
}
