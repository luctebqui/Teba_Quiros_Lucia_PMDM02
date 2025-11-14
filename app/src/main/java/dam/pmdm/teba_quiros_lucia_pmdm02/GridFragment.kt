package dam.pmdm.teba_quiros_lucia_pmdm02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.FragmentGridBinding

class GridFragment : Fragment() {
    private lateinit var binding: FragmentGridBinding
    private lateinit var pikminList: List<Pikmin>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pikminList = listOf(
            Pikmin(getString(R.string.pikmin_rojo), getString(R.string.detalle_rojo), getString(R.string.habilidad_rojo)),
            Pikmin(getString(R.string.pikmin_amarillo), getString(R.string.detalle_amarillo), getString(R.string.habilidad_amarillo)),
            Pikmin(getString(R.string.pikmin_azul), getString(R.string.detalle_azul), getString(R.string.habilidad_azul)),
            Pikmin(getString(R.string.pikmin_blanco), getString(R.string.detalle_blanco), getString(R.string.habilidad_blanco)),
            Pikmin(getString(R.string.pikmin_morado), getString(R.string.detalle_morado), getString(R.string.habilidad_morado)),
            Pikmin(getString(R.string.pikmin_petreo), getString(R.string.detalle_petreo), getString(R.string.habilidad_petreo)),
            Pikmin(getString(R.string.pikmin_alado), getString(R.string.detalle_alado), getString(R.string.habilidad_alado)),
            Pikmin(getString(R.string.pikmin_gelido), getString(R.string.detalle_gelido), getString(R.string.habilidad_gelido)),
            Pikmin(getString(R.string.pikmin_luminoso), getString(R.string.detalle_luminoso), getString(R.string.habilidad_luminoso))
        )

        binding.pikminRecyclerview.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.pikminRecyclerview.adapter =
            MyAdapter(pikminList) { selectedType ->
                Toast.makeText(
                    requireContext(),
                    "Se ha seleccionado el ${selectedType.type}",
                    Toast.LENGTH_SHORT
                ).show()
                val bundle = Bundle()
                bundle.putString("type", selectedType.type)
                bundle.putString("description", selectedType.description)
                bundle.putString("ability", selectedType.ability)
                bundle.putInt("image", selectedType.getImage())
                findNavController().navigate(R.id.detailsFragment, bundle)
            }
    }
}