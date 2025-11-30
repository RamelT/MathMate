package com.example.mlmtest1_721.ui.conicsections

import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.StyleSpan
import android.view.View
import com.example.mlmtest1_721.R
import com.example.mlmtest1_721.databinding.FragmentConicsectionsBinding
import kotlin.math.abs

fun doubleToFraction(value: Double, tolerance: Double = 1.0E-6): String {
    if (value % 1.0 == 0.0) {
        return value.toString() // Return whole number as is (e.g., -2.0 stays -2.0)
    }

    val sign = if (value < 0) -1 else 1
    var h1 = 1
    var h2 = 0
    var k1 = 0
    var k2 = 1
    var b = abs(value)

    do {
        val a = b.toInt()
        val temp = h1
        h1 = a * h1 + h2
        h2 = temp
        val tempK = k1
        k1 = a * k1 + k2
        k2 = tempK
        b = 1.0 / (b - a)
    } while (abs(value - sign * h1.toDouble() / k1) > abs(value * tolerance))

    val numerator = sign * h1
    val denominator = k1

    return "$numerator/$denominator"
}

fun doubleToPositiveFraction(value: Double, tolerance: Double = 1.0E-6): String {
    val absValue = abs(value)

    if (absValue % 1.0 == 0.0) {
        return absValue.toString() // Return whole number as is (e.g., 2.0 stays 2.0)
    }

    var h1 = 1
    var h2 = 0
    var k1 = 0
    var k2 = 1
    var b = absValue

    do {
        val a = b.toInt()
        val temp = h1
        h1 = a * h1 + h2
        h2 = temp
        val tempK = k1
        k1 = a * k1 + k2
        k2 = tempK
        b = 1.0 / (b - a)
    } while (abs(absValue - h1.toDouble() / k1) > absValue * tolerance)

    return "$h1/$k1"
}

fun appendNormalExplanation(text: String) {
    explanation.append(text)
}

fun appendNormalResult(text: String) {
    result.append(text)
}

fun appendBigBoldExplanation(text: String) {
    val start = explanation.length
    explanation.append(text)
    explanation.setSpan(StyleSpan(Typeface.BOLD), start, explanation.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    explanation.setSpan(RelativeSizeSpan(1.2f), start, explanation.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

fun appendBigBoldResult(text: String) {
    val start = result.length
    result.append(text)
    result.setSpan(StyleSpan(Typeface.BOLD), start, result.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    result.setSpan(RelativeSizeSpan(1.2f), start, result.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

fun appendBigBlueBoldExplanation(text: String) {
    val start = explanation.length
    explanation.append(text)
    explanation.setSpan(StyleSpan(Typeface.BOLD), start, explanation.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    explanation.setSpan(ForegroundColorSpan(Color.BLUE), start, explanation.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    explanation.setSpan(RelativeSizeSpan(1.4f), start, explanation.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

fun appendBigBlueBoldResult(text: String) {
    val start = result.length
    result.append(text)
    result.setSpan(StyleSpan(Typeface.BOLD), start, result.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    result.setSpan(ForegroundColorSpan(Color.BLUE), start, result.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    result.setSpan(RelativeSizeSpan(1.4f), start, result.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
}

fun clearInputs(binding: FragmentConicsectionsBinding) {
    binding.etA.text.clear()
    binding.etB.text.clear()
    binding.etC.text.clear()
    binding.etD.text.clear()
    binding.etE.text.clear()
    binding.tvResult.text = binding.root.context.getString(R.string.Results)
    binding.tvExplanation.text = ""
    binding.tvExplanation.visibility = View.GONE
    binding.buttonExplain.visibility = View.GONE
    binding.buttonClear.visibility = View.GONE
    result.clear()
    explanation.clear()
}

fun buttonThings(binding: FragmentConicsectionsBinding) {
    binding.buttonExplain.visibility = View.VISIBLE
    binding.buttonClear.visibility= View.VISIBLE

    binding.buttonExplain.setOnClickListener {
        binding.tvExplanation.text = explanation
        binding.tvExplanation.visibility = View.VISIBLE
    }

    binding.buttonClear.setOnClickListener {
        clearInputs(binding)
    }
}