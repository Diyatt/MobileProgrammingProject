package com.example.catchok_apps.fragments

import android.content.Context
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.R
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentSignUpBinding
import com.example.catchok_apps.utilities.BottomNavigationViewListener
import javax.inject.Inject


@AndroidEntryPoint

class SignUpFragment:BaseFragment<FragmentSignUpBinding>(FragmentSignUpBinding::inflate) {
    @Inject lateinit var firebaseAuth:FirebaseAuth

    override var showBottomNavigation: Boolean = false

    override fun onBindView() {
        super.onBindView()
        binding.signUpBtn.setOnClickListener {
            val email = binding.emailInput.text.toString()
            val password = binding.passwordInput.text.toString()
            val confirmPassword = binding.passwordConfInput.text.toString()



            if(email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(password == confirmPassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                        if(it.isSuccessful){
                            binding.emailLayout.isErrorEnabled = false
                            findNavController().navigate(
                                SignUpFragmentDirections.actionSignUpToGenderFragment()
                            )
                        }
                        else{
                            binding.emailLayout.isErrorEnabled = true
                            binding.passwordConfLayout.isErrorEnabled = true
                            binding.passwordLayout.isErrorEnabled = true
                            binding.passwordConfLayout.error = "Something is wrong"
                            binding.passwordLayout.error = "Something is wrong"
                            binding.emailLayout.error = "Something is wrong"
                        }
                    }

                }
                else{
                    Toast.makeText(requireContext(), "Passwords are not matching", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(requireContext(), "Enter something", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onResume() {
        super.onResume()

    }
}