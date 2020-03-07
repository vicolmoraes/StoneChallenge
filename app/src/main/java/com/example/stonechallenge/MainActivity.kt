package com.example.stonechallenge

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var bt: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViews()
    }

    private fun findViews() {
        bt = bt_activity_main
        bt.setOnClickListener {

            val call = RetrofitConfig().buildingService().list("random")
            call.enqueue(object : Callback<ChuckResponse> {
                override fun onResponse(
                    call: Call<ChuckResponse>?,
                    response: Response<ChuckResponse>?
                ) {
                    response?.body()?.let {
                        val resposta: ChuckResponse = it
                        Toast.makeText(
                            baseContext,
                            resposta.value,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(
                    call: Call<ChuckResponse>?,
                    t: Throwable?
                ) {
                }
            })

        }
    }
}



