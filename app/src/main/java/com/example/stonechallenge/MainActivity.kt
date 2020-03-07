package com.example.stonechallenge

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var bt: Button
    lateinit var interactor: Interactor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Configurator.INSTANCE.setCleanArchitecture(this)

        findViews()
    }

    private fun findViews() {
        bt = bt_activity_main
        bt.setOnClickListener {
            interactor.fetchSearchRandom()
        }
    }

    fun exibirErro(erro: String?) {
        Toast.makeText(
            baseContext,
            erro,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun exibirResultado(resposta: ChuckResponse) {
        Toast.makeText(
            baseContext,
            resposta.value,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun listarRespostas(resposta: List<ChuckResponse>) {
        Toast.makeText(
            baseContext,
            resposta.get(0).value,
            Toast.LENGTH_SHORT
        ).show()
    }

    fun listarCategorias(resposta: List<String>) {
        Toast.makeText(
            baseContext,
            resposta.get(0),
            Toast.LENGTH_SHORT
        ).show()
    }
}




