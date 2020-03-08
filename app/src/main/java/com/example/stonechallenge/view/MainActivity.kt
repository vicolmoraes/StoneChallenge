package com.example.stonechallenge.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.stonechallenge.R
import com.example.stonechallenge.interactor.Interactor
import com.example.stonechallenge.router.Router
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
    ActivityPadrao {
    lateinit var rvResultados: RecyclerView
    override lateinit var interactor: Interactor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Router.INSTANCE.setCleanArchitecture(this)

        findViews()
        iniciarToolbar("Bem Vindo")
    }

    fun iniciarToolbar(titulo: String?) {
        val toolbar: Toolbar = in_toolbar as Toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setTitle(titulo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.title.equals("pesquisar")) {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
            finish()
        }

        return true
    }
    private fun findViews() {
        rvResultados = rv_resultados_activity_main
    }

}




