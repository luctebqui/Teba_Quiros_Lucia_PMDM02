package dam.pmdm.teba_quiros_lucia_pmdm02

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate

/**
 * Objeto no instanciable que permitirá la gestión de preferencias persistentes de la aplicación.
 */
object PreferenceManager {
    /**
     * Nombre del archivo que almacena las preferencias.
     */
    private const val PREF_FILE_NAME = "preferences"

    /**
     * Clave del idioma.
     */
    private const val PREF_LOCALE_KEY = "app_language"

    /**
     * Valor por defecto del idioma si no se ha guardado nada previamente.
     */
    private const val DEFAULT_LOCALE = "es"

    /**
     * Clave del tema de la aplicación.
     */
    private const val PREF_THEME_KEY = "app_theme_mode"

    /**
     * Valor por defecto del tema si no se ha guardado nada anteriormente.
     */
    private const val DEFAULT_THEME = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

    /**
     * Recupera la instancia del fichero de preferencias.
     * @param context contexto de la aplicación necesario para acceder a las preferencias.
     * @return instancia de las preferencias.
     */
    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Guarda el idioma seleccionado por el usuario.
     * @param context
     * @param localeTag tag del idioma. Es decir, el idioma seleccionado.
     */
    fun saveLanguage(context: Context, localeTag: String) {
        getPreferences(context)
            .edit()
            .putString(PREF_LOCALE_KEY, localeTag)
            .apply()
    }

    /**
     * Recupera el idioma guardado previamente o devuelve el valor por defecto (es).
     * @param context
     * @return tag del idioma.
     */
    fun getSavedLanguage(context: Context): String {
        return getPreferences(context)
            .getString(PREF_LOCALE_KEY, DEFAULT_LOCALE) ?: DEFAULT_LOCALE
    }

    /**
     * Guarda el tema seleccionado por el usuario.
     * @param context
     * @param themeMode tag del tema. Es decir, el tema seleccionado.
     */
    fun saveThemeMode(context: Context, themeMode: Int) {
        getPreferences(context)
            .edit()
            .putInt(PREF_THEME_KEY, themeMode)
            .apply()
    }

    /**
     * Recupera el tema guardado previamente o devuelve el valor por defecto (tema claro).
     * @param context
     * @return modo del tema.
     */
    fun getSavedThemeMode(context: Context): Int {
        return getPreferences(context)
            .getInt(PREF_THEME_KEY, DEFAULT_THEME)
    }
}