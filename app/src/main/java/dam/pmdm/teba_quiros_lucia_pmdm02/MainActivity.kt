package dam.pmdm.teba_quiros_lucia_pmdm02

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                Thread.sleep(1500)
                false
            }
        }

        val savedThemeMode = PreferenceManager.getSavedThemeMode(this)
        AppCompatDelegate.setDefaultNightMode(savedThemeMode)

        val savedLocaleTag = PreferenceManager.getSavedLanguage(this)
        val appLocale = LocaleListCompat.forLanguageTags(savedLocaleTag)
        AppCompatDelegate.setApplicationLocales(appLocale)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Snackbar.make(findViewById(R.id.snackbar_text),
            getString(R.string.bienvenida),
            Snackbar.LENGTH_SHORT).show()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        setSupportActionBar(binding.mainToolbar)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.mainToolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.acerca_de -> {
                val mensajeAcercaDe: AlertDialog.Builder = AlertDialog.Builder(this)
                mensajeAcercaDe.setTitle(getString(R.string.acerca))
                    .setMessage(getString(R.string.acerca_de)).show()
                true
            }
            R.id.ajustes -> {
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()
                    ?.navigate(R.id.settingsFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}