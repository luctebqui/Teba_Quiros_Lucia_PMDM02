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

/**
 * Esta clase contiene la actividad principal que contendrá la toolbar y el FragmentContentView
 * donde se mostrará la información de los pikmin.
 */
class MainActivity : AppCompatActivity() {
    /**
     * Objeto binding que proporciona acceso al layout activity_main.xml.
     */
    private lateinit var binding: ActivityMainBinding

    /**
     * Esta función primero instala una SplashScreen con 1,5 segundos de duración y recuperan las
     * preferencias guardadas (tema e idioma). Después se infla e inicializa la actividad,
     * que contendrá un snackbar de bienvenida,un menú de navegación definido en el fichero
     * nav_graph.xml y la toolbar.
     * @param savedInstanceState Si no es nulo, se está reconstruyendo a partir de un estado previo guardado.
     */
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

    /**
     * Función que genera el menú de la toolbar (menu.xml).
     * @param menu corresponde con el menu que se va a inflar.
     * @return true una vez inflado el layout del menu correctamente.
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    /**
     * Función por la que se le da funcionalidad a cada uno de los elementos que constituyen el menú
     * de la toolbar.
     * @param item corresponde con el elemento al que se le va a dar funcionalidad del menú.
     * @return true cuando se selecciona uno de los elementos del menu con una funcionalidad.
     */
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