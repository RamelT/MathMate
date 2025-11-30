package com.example.mlmtest1_721.ui.conicsections

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mlmtest1_721.databinding.FragmentConicsectionsBinding

var explanation = SpannableStringBuilder()
var result = SpannableStringBuilder()

class ConicSectionsFragment : Fragment() {

    private var _binding: FragmentConicsectionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConicsectionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCalculate.setOnClickListener {
            val a = binding.etA.text.toString().toDoubleOrNull() ?: 0.0
            val b = binding.etB.text.toString().toDoubleOrNull() ?: 0.0
            val c = binding.etC.text.toString().toDoubleOrNull() ?: 0.0
            val d = binding.etD.text.toString().toDoubleOrNull() ?: 0.0
            val e = binding.etE.text.toString().toDoubleOrNull() ?: 0.0

            result.clear()
            explanation.clear()
            binding.tvExplanation.text = ""
            binding.tvExplanation.visibility = View.GONE

            if (a == 0.0 && c == 0.0) {
                appendBigBoldResult("Not a Conic Section!")
                binding.buttonExplain.visibility = View.GONE
                binding.tvExplanation.visibility = View.GONE
                binding.buttonClear.visibility= View.VISIBLE

                binding.buttonClear.setOnClickListener {
                    clearInputs(binding)
                }
            } else if (a == c) { // circle
                circle(a, b, c, d, e)
                buttonThings(binding)
            } else if (a == 0.0 || c == 0.0) { // parabola
                parabola(a, b, c, d, e)
                buttonThings(binding)
            } else if (a != c && (a / c > 0)) { // ellipse
                ellipse(a, b, c, d, e)
                buttonThings(binding)
            } else if (a != c && (a / c < 0)) { // hyperbola
                hyperbola(a, b, c, d, e)
                buttonThings(binding)
            }

            binding.tvResult.text = result
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
