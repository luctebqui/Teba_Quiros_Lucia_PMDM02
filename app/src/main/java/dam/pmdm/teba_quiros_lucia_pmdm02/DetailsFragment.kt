package dam.pmdm.teba_quiros_lucia_pmdm02

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dam.pmdm.teba_quiros_lucia_pmdm02.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding : FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.type.text = arguments?.getString("type")
        binding.description.text = arguments?.getString("description")
        binding.ability.text = arguments?.getString("ability")
        binding.image.setImageResource(arguments?.getInt("image")!!)
    }
}