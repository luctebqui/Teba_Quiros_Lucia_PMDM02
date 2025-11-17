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

/**
 * Fragmento que contiene la cuadrícula de pikmin disponibles. Cuando
 * se selecciona uno de los pikmin, navegará a la pantalla de detalle (DetailFragment).
 */
class GridFragment : Fragment() {
    /**
     * Objeto binding que proporciona acceso al layout fragment_grid.xml.
     */
    private lateinit var binding: FragmentGridBinding

    /**
     * Lista de pikmin disponibles.
     */
    private lateinit var pikminList: List<Pikmin>

    /**
     * Esta funcion infla  el layout fragment_grid.xml.
     * @param inflater puede usarse para inflar vistas en el fragmento.
     * @param container Si no es nulo, este es el padre al que la vista del fragmento debe ser adjuntada.
     * @param savedInstanceState Si no es nulo, se está reconstruyendo a partir de un estado previo guardado.
     * @return vista raiz del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGridBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Función a la que se llama una vez ejecutada la función anterior (onCreateView). Aquí se inicializa
     * la lista de pikmin, se configura el RecycledView con un GridLayoutManager y se establece
     * el adaptador definido en la clase MyAdapter.kt
     * @param view vista devuelta en onCreateView.
     * @param savedInstanceState estado guardado de la instancia del fragmento.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pikminList = listOf(
            Pikmin(0,getString(R.string.pikmin_rojo), getString(R.string.detalle_rojo), getString(R.string.habilidad_rojo)),
            Pikmin(1,getString(R.string.pikmin_amarillo), getString(R.string.detalle_amarillo), getString(R.string.habilidad_amarillo)),
            Pikmin(2,getString(R.string.pikmin_azul), getString(R.string.detalle_azul), getString(R.string.habilidad_azul)),
            Pikmin(3,getString(R.string.pikmin_blanco), getString(R.string.detalle_blanco), getString(R.string.habilidad_blanco)),
            Pikmin(4,getString(R.string.pikmin_morado), getString(R.string.detalle_morado), getString(R.string.habilidad_morado)),
            Pikmin(5,getString(R.string.pikmin_petreo), getString(R.string.detalle_petreo), getString(R.string.habilidad_petreo)),
            Pikmin(6,getString(R.string.pikmin_alado), getString(R.string.detalle_alado), getString(R.string.habilidad_alado)),
            Pikmin(7,getString(R.string.pikmin_gelido), getString(R.string.detalle_gelido), getString(R.string.habilidad_gelido)),
            Pikmin(8,getString(R.string.pikmin_luminoso), getString(R.string.detalle_luminoso), getString(R.string.habilidad_luminoso))
        )

        binding.pikminRecyclerview.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.pikminRecyclerview.adapter =
            MyAdapter(pikminList) { selectedType ->
                Toast.makeText(
                    requireContext(),
                    getString(R.string.seleccion)+ selectedType.type,
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