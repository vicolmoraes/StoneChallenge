package com.example.stonechallenge.view

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.stonechallenge.BancoController
import com.example.stonechallenge.R
import com.example.stonechallenge.entity.ChuckFact
import com.example.stonechallenge.interactor.Interactor
import com.example.stonechallenge.router.Router
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.activity_search.*
import java.io.Serializable


class SearchActivity : AppCompatActivity(),
    ActivityPadrao {
    lateinit var etBusca: EditText
    lateinit var rvCategorias: RecyclerView
    lateinit var listaCategorias: ArrayList<String>
    lateinit var crud: BancoController
    override lateinit var interactor: Interactor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        listaCategorias = ArrayList()
        Router.INSTANCE.setCleanArchitecture(this)
        findViews()
        setRecycler()
    }

    private fun findViews() {
        crud = BancoController(this)
        crud.iniciar()

        etBusca = et_activity_search
        rvCategorias = rv_categorias_activity_search

        interactor.fetchSearchListCategories()

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

        val layoutManager = FlexboxLayoutManager(this)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.CENTER
        layoutManager.alignItems = AlignItems.CENTER
        rvCategorias.layoutManager = layoutManager
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
        listaCategorias.clear()
        listaCategorias.addAll(resposta.subList(0, 8))
        var listaBanco: ArrayList<String>
        listaBanco = crud.carregaListaCategorias()

        if (listaBanco.isEmpty())
            crud.insereListaCategoria(listaCategorias)

        setRecycler()
    }

    private fun setRecycler() {
        rvCategorias.adapter =
            CategoryAdapter(
                crud.carregaListaCategorias(),
                this,
                { partItem: String -> partItemClicked(partItem) })
    }

    private fun partItemClicked(categoria: String) {
        interactor.fetchSearchCategorie(categoria.trim())
    }
}