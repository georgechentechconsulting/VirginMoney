package com.example.virginmoney.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.virginmoney.R

class FavoriteColorDialogFragment(private val favoriteColor: String) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        val view = LayoutInflater.from(context).inflate(R.layout.favorite_color_popup, null)

        val colorTextView: TextView = view.findViewById(R.id.favoriteColorText)
        colorTextView.text = "Favorite Color: $favoriteColor"

        dialog.setContentView(view)
        return dialog
    }
}
