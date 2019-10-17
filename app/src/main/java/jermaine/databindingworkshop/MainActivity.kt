package jermaine.databindingworkshop

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainViewModel
    private lateinit var inputName: EditText
    private lateinit var inputEmail: EditText
    private lateinit var inputBio: EditText
    private lateinit var spnGender: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        inputName = findViewById(R.id.inputName)
        inputEmail = findViewById(R.id.inputEmail)
        inputBio = findViewById(R.id.inputBio)
        spnGender = findViewById(R.id.spnGender)
    }

    fun onSubmitClick(view: View) {
        if (!validateInputs()) return

        viewModel
            .register(
                inputName.text.toString(),
                inputEmail.text.toString(),
                spnGender.selectedItem as String,
                inputBio.text.toString()
            )

        Handler()
            .postDelayed({
                clearFields()
                Toast
                    .makeText(
                        this,
                        "Registration Successful",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }, 2000)
    }

    private fun clearFields() {
        inputName.setText("")
        inputEmail.setText("")
        inputBio.setText("")
    }

    private fun validateInputs(): Boolean {
        var validated = true
        if (inputName.text.isEmpty()) {
            inputName.error = "name is empty"
            validated = false
        }
        if (inputEmail.text.isEmpty()) {
            inputEmail.error = "email is empty"
            validated = false
        }
        if (inputBio.text.isEmpty()) {
            inputBio.error = "bio is empty"
            validated = false
        }

        return validated
    }
}
