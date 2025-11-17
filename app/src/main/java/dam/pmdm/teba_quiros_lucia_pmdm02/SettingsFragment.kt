package dam.pmdm.teba_quiros_lucia_pmdm02

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {
    private lateinit var binding: FragmentSettingsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        initializeSwitchState()

        binding.switchLanguage.setOnCheckedChangeListener { _, isChecked ->
            val localeTag = if (isChecked) "en" else "es"
            LanguagePreferenceManager.saveLocale(requireContext(), localeTag)
            val newLocales = LocaleListCompat.forLanguageTags(localeTag)
            AppCompatDelegate.setApplicationLocales(newLocales)
            binding.root.post {
                val intent = Intent(requireActivity(), MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                requireActivity().finish()
            }
        }

        return binding.root
    }

    private fun initializeSwitchState() {
        val currentTag = LanguagePreferenceManager.getSavedLocale(requireContext())
        binding.switchLanguage.isChecked = currentTag == "en"
    }
}