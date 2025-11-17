package dam.pmdm.teba_quiros_lucia_pmdm02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.FragmentSettingsBinding

/**
 * Fragmento que permite configurar las preferencias de idioma y estilo.
 */
class SettingsFragment : Fragment() {
    /**
     * Objeto binding que proporciona acceso al layout fragment_settings.xml.
     */
    private lateinit var binding: FragmentSettingsBinding

    /**
     * Esta función infla  el layout fragment_settings.xml después de comprobar las preferencias
     * previamente seleccionadas y de darle funcionalidad a cada uno de los switch presentes en
     * dicho layout.
     * @param inflater puede usarse para inflar vistas en el fragmento.
     * @param container Si no es nulo, este es el padre al que la vista del fragmento debe ser adjuntada.
     * @param savedInstanceState Si no es nulo, se está reconstruyendo a partir de un estado previo guardado.
     * @return vista raiz del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        initializeSwitchState()

        binding.switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            val language = if (isChecked) "en" else "es"
            PreferenceManager.saveLanguage(requireContext(), language)
            binding.root.post {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                binding.switchLanguage.isEnabled = false
                startActivity(intent)
                requireActivity().finish()
            }
        }

        binding.switchTheme.setOnCheckedChangeListener { _, isChecked ->
            val themeMode = if (isChecked) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            PreferenceManager.saveThemeMode(requireContext(), themeMode)
            binding.root.post {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                binding.switchTheme.isEnabled = false
                startActivity(intent)
                requireActivity().finish()
            }
        }

        return binding.root
    }

    /**
     * Mediante esta función se modifica el estado de los switch en función de las preferencias
     * guardadas en usos anteriores de la aplicación.
     */
    private fun initializeSwitchState() {
        val currentTag = PreferenceManager.getSavedLanguage(requireContext())
        binding.switchLanguage.isChecked = currentTag == "en"

        val currentThemeMode = PreferenceManager.getSavedThemeMode(requireContext())
        binding.switchTheme.isChecked = currentThemeMode == AppCompatDelegate.MODE_NIGHT_YES
    }
}