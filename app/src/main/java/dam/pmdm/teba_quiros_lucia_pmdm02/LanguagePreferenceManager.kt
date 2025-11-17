package dam.pmdm.teba_quiros_lucia_pmdm02

import android.content.Context
import android.content.SharedPreferences

object LanguagePreferenceManager {
    private const val PREF_FILE_NAME = "language_prefs"
    private const val PREF_LOCALE_KEY = "app_locale"
    private const val DEFAULT_LOCALE = "es"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun saveLocale(context: Context, localeTag: String) {
        getPreferences(context)
            .edit()
            .putString(PREF_LOCALE_KEY, localeTag)
            .apply()
    }

    fun getSavedLocale(context: Context): String {
        return getPreferences(context)
            .getString(PREF_LOCALE_KEY, DEFAULT_LOCALE) ?: DEFAULT_LOCALE
    }
}