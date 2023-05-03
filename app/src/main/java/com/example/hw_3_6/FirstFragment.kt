package com.example.hw_3_6

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.hw_3_6.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        click()
    }

    private fun click() {
        binding.button.setOnClickListener {
            dataSend()
        }
    }

    private fun initView() {
        Glide.with(binding.imageView)
            .load("https://di-uploads-pod12.dealerinspire.com/friendlycdjr/uploads/2020/06/2020-Dodge-Challenger-SRT-Hellcat-Redeye-50th-Anniversary.jpg")
            .into(binding.imageView)
        binding.editTextOne.text
        binding.editTextTwo.text
    }

    private fun dataSend() {
        var bundle = Bundle()
        val fragment = SecondFragment()
        bundle.putString("first", binding.editTextOne.text.toString())
        bundle.putString("second", binding.editTextTwo.text.toString())
        bundle.putParcelable("image", (binding.imageView.drawable as BitmapDrawable).bitmap)
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null).commit()
    }
}