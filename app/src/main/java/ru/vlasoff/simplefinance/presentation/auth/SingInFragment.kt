package ru.vlasoff.simplefinance.presentation.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.vlasoff.simplefinance.R
import ru.vlasoff.simplefinance.databinding.FragmentSigninBinding

@AndroidEntryPoint
class SingInFragment : Fragment() {

    private val binding: FragmentSigninBinding by lazy {
        FragmentSigninBinding.inflate(layoutInflater)
    }

    private var email = ""
    private var password = ""

    private val authViewModel: AuthViewModel by hiltNavGraphViewModels(R.id.nav_auth)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.email.editText?.doAfterTextChanged { text ->
            binding.email.error = if (text?.length == 0)getString(R.string.cannot_be_empty_warning) else null
            email = text.toString()
        }

        binding.password.editText?.doAfterTextChanged { text ->
            binding.password.error = if (text?.length == 0)getString(R.string.cannot_be_empty_warning) else null
            password = text.toString()
        }

        binding.buttonSignIn.setOnClickListener {
            if (email.isNotBlank() and password.isNotBlank()) {
                authViewModel.signIn(email, password)
            } else {
                binding.email.error = getString(R.string.cannot_be_empty_warning)
                binding.password.error = getString(R.string.cannot_be_empty_warning)
            }
        }

        binding.tvFromLoginToSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_singInFragment_to_signUpFragment)
        }

        authViewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                AuthState.Authorized -> {
                    findNavController().navigate(R.id.action_singInFragment_to_mainActivity)
                }
                AuthState.Failed -> {
                    Toast.makeText(requireContext(), getString(R.string.login_or_email_error_text), Toast.LENGTH_SHORT)
                        .show()
                    " ".apply {
                        binding.email.error = this
                        binding.password.error = this
                    }
                }
            }
        }

    }

}