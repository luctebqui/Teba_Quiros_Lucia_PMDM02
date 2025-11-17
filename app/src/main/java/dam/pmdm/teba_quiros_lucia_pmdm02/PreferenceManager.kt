package dam.pmdm.teba_quiros_lucia_pmdm02

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

object PreferenceManager {
    private const val PREF_FILE_NAME = "preferences"
    private const val PREF_LOCALE_KEY = "app_language"
    private const val DEFAULT_LOCALE = "es"
    private const val PREF_THEME_KEY = "app_theme_mode"
    private const val DEFAULT_THEME = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun saveLanguage(context: Context, localeTag: String) {
        getPreferences(context)
            .edit()
            .putString(PREF_LOCALE_KEY, localeTag)
            .apply()
    }

    fun getSavedLanguage(context: Context): String {
        return getPreferences(context)
            .getString(PREF_LOCALE_KEY, DEFAULT_LOCALE) ?: DEFAULT_LOCALE
    }

    fun saveThemeMode(context: Context, themeMode: Int) {
        getPreferences(context)
            .edit()
            .putInt(PREF_THEME_KEY, themeMode)
            .apply()
    }

    fun getSavedThemeMode(context: Context): Int {
        return getPreferences(context)
            .getInt(PREF_THEME_KEY, DEFAULT_THEME)
    }
}