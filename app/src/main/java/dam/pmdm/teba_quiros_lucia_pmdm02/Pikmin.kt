package dam.pmdm.teba_quiros_lucia_pmdm02

data class Pikmin (
    val id: Int,
    val type: String,
    val description: String,
    val ability: String
){
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