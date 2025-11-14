package dam.pmdm.teba_quiros_lucia_pmdm02

data class Pikmin (
    val type: String,
    val description: String,
    val ability: String
){
    fun getImage(): Int{
        return when(type){
            (R.string.pikmin_rojo).toString() -> R.drawable.redpikmin
            (R.string.pikmin_amarillo).toString() -> R.drawable.yellowpikmin
            (R.string.pikmin_azul).toString() -> R.drawable.bluepikmin
            (R.string.pikmin_blanco).toString() -> R.drawable.whitepikmin
            (R.string.pikmin_morado).toString() -> R.drawable.purplepikmin
            (R.string.pikmin_petreo).toString() -> R.drawable.rockpikmin
            (R.string.pikmin_alado).toString() -> R.drawable.wingedpikmin
            (R.string.pikmin_gelido).toString() -> R.drawable.redpikmin
            else -> R.drawable.glowpikmin
        }
    }
}