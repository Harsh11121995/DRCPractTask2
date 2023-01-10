package com.example.drcpracttask2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.drcpracttask2.api.ApiClient
import com.example.drcpracttask2.api.ApiInterface
import com.example.drcpracttask2.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchData()
    }

    @SuppressLint("CheckResult")
    private fun fetchData() {
        try {
            val apiInterface = ApiClient.client?.create(ApiInterface::class.java)
            apiInterface?.getData(
                "funny cat",
                "K0Eydguo8EffPrJj2d4zzSOWgdvfYVeh",
            )!!
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ result ->
                    try {
                        if (result != null) {

                            binding.rcvImage.layoutManager = GridLayoutManager(this, 3)
                            val imageAdapter =
                                ImageAdapter(result.data,this)
                            binding.rcvImage.adapter = imageAdapter


                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }, { error ->
                    try {
                        error.printStackTrace()
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}