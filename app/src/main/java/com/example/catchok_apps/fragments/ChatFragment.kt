package com.example.catchok_apps.fragments



import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import com.example.catchok_apps.adapter.ItemMessageAdapter
import com.example.catchok_apps.base.BaseFragment
import com.example.catchok_apps.databinding.FragmentChatBinding
import com.example.catchok_apps.repository.gpt.GptViewModel
import com.example.catchok_apps.repository.gpt.model.Choice
import com.example.catchok_apps.repository.gpt.model.Message


@AndroidEntryPoint
class ChatFragment:BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {

    private val viewModel: GptViewModel by viewModels()
    private var messageList = mutableListOf<Choice>()
    var index:Int = 0


    override fun onBindView() {
        super.onBindView()
        val adapter = ItemMessageAdapter()
        binding.messageList.adapter = adapter
        binding.messageList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL, true)
        binding.backBtn.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.til.setEndIconOnClickListener {
            binding.hello.isVisible = false
            binding.messageList.isVisible = true
            if(binding.editText.text.toString().isNotEmpty()){
                val userMessage = Message("user", "${binding.editText.text.toString()}")
                val choice = Choice(index++, userMessage)
                messageList.add(choice)
                viewModel.getPrompt(binding.editText.text.toString())
                adapter.submitList(messageList.reversed().toMutableList())
                binding.messageList.scrollToPosition(messageList.size-1)
                binding.editText.text?.clear()
            }
            else{
                Toast.makeText(requireContext(), "Please enter something", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.chatResponseLiveData.observe(viewLifecycleOwner){ response->
            if(response !=null){
                messageList.add(response.choices[0])
                adapter.submitList(messageList.reversed().toMutableList())
                binding.messageList.scrollToPosition(messageList.size-1)
            }
            else{
                Toast.makeText(requireContext(), "Response is empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.messageList.setOnClickListener {
            binding.root.hideKeyboard()
        }

    }
    private fun setUpLoader() {
        viewModel.loadingLiveData.observe(this) {
//            binding.loadingView.isVisible = it
        }
    }

}