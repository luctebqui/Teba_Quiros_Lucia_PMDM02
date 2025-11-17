package dam.pmdm.teba_quiros_lucia_pmdm02

/**
 * Clase que define la estructura de datos para cada pikmin.
 * @param id identificador interno del pikmin.
 * @param type tipo de pikmin (equivalente al nombre).
 * @param description descripción del pikmin.
 * @param ability habilidades asociadas al pikmin.
 */
data class Pikmin (
    val id: Int,
    val type: String,
    val description: String,
    val ability: String
){
    /**
     * Función por la que se asocia una imagen al pikmin en cuestión en función del identificador.
     * @return int que corresponde a la imagen.
     */
    fun getImage(): Int{
        return when(id){
            0 -> R.drawable.redpikmin
            1 -> R.drawable.yellowpikmin
            2 -> R.drawable.bluepikmin
            3 -> R.drawable.whitepikmin
            4 -> R.drawable.purplepikmin
            5 -> R.drawable.rockpikmin
            6 -> R.drawable.wingedpikmin
            7 -> R.drawable.icepikmin
            else -> R.drawable.glowpikmin
        }
    }
}