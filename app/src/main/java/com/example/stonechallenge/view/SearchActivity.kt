package com.example.stonechallenge.view

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.stonechallenge.R
import com.example.stonechallenge.entity.ChuckFact
import com.example.stonechallenge.interactor.Interactor
import com.example.stonechallenge.router.Router
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_search.*
import java.io.Serializable


class SearchActivity : AppCompatActivity(),
    ActivityPadrao {
    lateinit var etBusca: EditText
    override lateinit var interactor: Interactor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        Router.INSTANCE.setCleanArchitecture(this)
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
                    interactor.fetchSearchText(etBusca.text.toString().trim())
                    return true
                }
                return false
            }
        })

        val recyclerView = rv_categorias_activity_search
        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.COLUMN
        layoutManager.justifyContent = JustifyContent.FLEX_END
        recyclerView.layoutManager = layoutManager
    }

    override fun exibirErro(resposta: String?) {
        Toast.makeText(
            baseContext,
            "Chuck has nothing to say about it",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun exibirResultado(resposta: ChuckFact) {
        val lista: ArrayList<ChuckFact> = ArrayList()
        lista.add(resposta)
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("FACTS", lista as Serializable)
        startActivity(intent)
    }

    override fun listarRespostas(resposta: List<ChuckFact>) {
        val lista: ArrayList<ChuckFact> = ArrayList()
        if (resposta.size > 100)
            lista.addAll(resposta.subList(0, 100))
        else lista.addAll(resposta)
        val intent: Intent = Intent(this, MainActivity::class.java)
        intent.putExtra("FACTS", lista as Serializable)
        startActivity(intent)
    }

    override fun listarCategorias(resposta: List<String>) {
        Toast.makeText(
            baseContext,
            resposta.get(0),
            Toast.LENGTH_SHORT
        ).show()
    }
}