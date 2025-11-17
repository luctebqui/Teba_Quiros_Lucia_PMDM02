package dam.pmdm.teba_quiros_lucia_pmdm02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.FragmentDetailsBinding

/**
 *Fragmento que da lugar a la pantalla de detalle del pikmin que se haya seleccionado previamente.
 */
class DetailsFragment : Fragment() {
    /**
     * Objeto binding que proporciona acceso al layout fragment_details.xml.
     */
    private lateinit var binding : FragmentDetailsBinding

    /**
     *  Esta funcion infla  el layout fragment_details.xml.
     * @param inflater puede usarse para inflar vistas en el fragmento.
     * @param container Si no es nulo, este es el padre al que la vista del fragmento debe ser adjuntada.
     * @param savedInstanceState Si no es nulo, se está reconstruyendo a partir de un estado previo guardado.
     * @return vista raiz del fragmento.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Función a la que se llama una vez ejecutada la función anterior (onCreateView). Aquí se recuperan
     * los datos del pikmin que se ha seleccionado para poder mostrarlos por pantalla.
     * @param view vista devuelta en onCreateView.
     * @param savedInstanceState Si no es nulo, se está reconstruyendo a partir de un estado previo guardado.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.type.text = arguments?.getString("type")
        binding.description.text = arguments?.getString("description")
        binding.ability.text = arguments?.getString("ability")
        binding.image.setImageResource(arguments?.getInt("image")!!)
    }
}