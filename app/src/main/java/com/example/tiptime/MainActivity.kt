package com.example.tiptime

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set click listener for the calculate button
        binding.calculateButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.costOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()

        if (cost == null || cost == 0.0) {
            binding.tipResult.text = getString(R.string.tip_amount, "0.00")
            return
        }

        // Get selected tip percentage
        val selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.option_twenty_percent -> 0.20
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15 // Default to 15% if no option is selected
        }

        var tip = tipPercentage * cost

        // Round up if switch is checked
        if (binding.roundUpSwitch.isChecked) {
            tip = ceil(tip)
        }

        // Format the tip amount
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}
