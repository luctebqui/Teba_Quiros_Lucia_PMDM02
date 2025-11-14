package dam.pmdm.teba_quiros_lucia_pmdm02

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.PikminItemBinding

class MyAdapter (
    private val pikminList: List<Pikmin>,
    private val onClick:(Pikmin) -> Unit
): RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val binding = PikminItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        holder.bin(pikminList[position])
    }

    override fun getItemCount(): Int {
        return pikminList.size
    }

    inner class MyViewHolder(private val binding: PikminItemBinding) :
            RecyclerView.ViewHolder(binding.root){
        fun bin(pikmin: Pikmin){
            binding.pikminType.text = pikmin.type
            binding.pikminImage.setImageResource(pikmin.getImage())
            binding.root.setOnClickListener {
                onClick(pikmin)
            }
        }
    }
}