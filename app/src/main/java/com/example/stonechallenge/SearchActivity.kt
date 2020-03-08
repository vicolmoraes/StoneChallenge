package com.example.stonechallenge

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity(), ActivityPadrao {
    lateinit var etBusca: EditText
    override lateinit var interactor: Interactor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Configurator.INSTANCE.setCleanArchitecture(this)
        findViews()
    }

    private fun findViews() {
        etBusca = et_activity_search

        etBusca.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(
                v: View?,
                keyCode: Int,
                event: KeyEvent
            ): Boolean {
                if (event.getAction() === KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER
                ) {
                    interactor.fetchSearchCategorie(etBusca.text.toString().trim())
                    return true
                }
                return false
            }
        })
    }

    override fun exibirErro(resposta: String?) {
        Toast.makeText(
            baseContext,
            "Chuck has nothing to say about it",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun exibirResultado(resposta: ChuckFact) {
        Toast.makeText(
            baseContext,
            resposta.value,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun listarRespostas(resposta: List<ChuckFact>) {
        Toast.makeText(
            baseContext,
            resposta.get(0).value,
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun listarCategorias(resposta: List<String>) {
        Toast.makeText(
            baseContext,
            resposta.get(0),
            Toast.LENGTH_SHORT
        ).show()
    }
}