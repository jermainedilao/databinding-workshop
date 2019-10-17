package jermaine.databindingworkshop

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun register(
        name: String,
        email: String,
        gender: String,
        bio: String
    ) {
        Log.d(TAG, "register: name $name")
        Log.d(TAG, "register: email $email")
        Log.d(TAG, "register: gender $gender")
        Log.d(TAG, "register: bio $bio")
    }
}