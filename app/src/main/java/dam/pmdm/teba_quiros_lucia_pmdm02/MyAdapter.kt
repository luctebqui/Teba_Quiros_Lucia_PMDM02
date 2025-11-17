package dam.pmdm.teba_quiros_lucia_pmdm02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.PikminItemBinding

/**
 * Adaptador para el RecyclerView que puestra los distintos pikmin.Crea las vistas de los y los vincula
 * con los datos del pikmin correspondiente.
 * @param pikminList lista de pikmin.
 * @param onClick función lambda que se invoca cuando se selecciona un pikmin.
 */
class MyAdapter (
    private val pikminList: List<Pikmin>,
    private val onClick:(Pikmin) -> Unit
): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    /**
     * Esta función devuelve el ViewHolder que es utilizado por el RecyclerView para generar una nueva vista.
     * @param parent
     * @param viewType vista del pikmin.
     * @return instancia de MyViewHolder
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = PikminItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    /**
     * Reemplaza la información que contiene la vista del item del RecyclerView en función de su posición.
     * @param holder MyViewHolder cuya información debe actualizarse de acuerdo con los datos del item que corresponda.
     * @param position posición del item dentro del RecyclerView.
     */
    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bin(pikminList[position])
    }

    /**
     *Función que informa del número de items.
     * @return int que en este caso equivale al número de pikmin contenidos en la lista pikminList.
     */
    override fun getItemCount(): Int {
        return pikminList.size
    }

    /**
     * Clase interna que myestra la vista de un item de la lista. Vincula los datos y configura el listener.
     * @param binding que proporciona acceso al layout fragment_grid.xml.
     */
    inner class MyViewHolder(private val binding: PikminItemBinding) :
            RecyclerView.ViewHolder(binding.root){

        /**
         * Esta función bin (nombre acordado) vincula los datos del pikmin a la vista del item.
         * @param pikmin
         */
        fun bin(pikmin: Pikmin){
            binding.pikminType.text = pikmin.type
            binding.pikminImage.setImageResource(pikmin.getImage())
            binding.root.setOnClickListener {
                onClick(pikmin)
            }
        }
    }
}