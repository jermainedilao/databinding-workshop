package jermaine.databindingworkshop

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    val nameError = MutableLiveData<String>("")

    val emailError = MutableLiveData<String>("")

    val bioError = MutableLiveData<String>("")

    val nameText = MutableLiveData<String>("")

    val emailText = MutableLiveData<String>("")

    val bioText = MutableLiveData<String>("")

    val genderSelectedPosition = MutableLiveData(0)

    val successText = MutableLiveData("")

    fun register() {
        Log.d(TAG, "register: ")
        if (validateInputs()) {
            Log.d(TAG, "register: name ${nameText.value}")
            Log.d(TAG, "register: email ${emailText.value}")
            Log.d(TAG, "register: gender ${genderSelectedPosition.value}")
            Log.d(TAG, "register: bio ${bioText.value}")


            Handler()
                .postDelayed(
                    {
                        nameText.value = ""
                        emailText.value = ""
                        genderSelectedPosition.value = 0
                        bioText.value = ""
                        setSuccessText()
                    },
                    2000
                )
        }
    }

    private fun setSuccessText() {
        successText.value = "Registration successful"

        Handler()
            .postDelayed(
                {
                    successText.value = ""
                },
                2000
            )
    }

    fun validateInputs(): Boolean {
        var validated = true
        if (nameText.value!!.isEmpty()) {
            Log.d(TAG, "validateInputs: name is empty")
            nameError.value = "name is empty"
            validated = false
        }
        if (emailText.value!!.isEmpty()) {
            Log.d(TAG, "validateInputs: email is empty")
            emailError.value = "email is empty"
            validated = false
        }
        if (bioText.value!!.isEmpty()) {
            Log.d(TAG, "validateInputs: bio is empty")
            bioError.value = "bio is empty"
            validated = false
        }

        return validated
    }
}