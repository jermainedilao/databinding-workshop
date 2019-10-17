package jermaine.databindingworkshop

import android.util.Log
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("errorText")
fun EditText.setInputError(errorText: String) {
    Log.d("EditText", "setInputError: $errorText")
    if (errorText.isEmpty()) return
    this.error = errorText
}