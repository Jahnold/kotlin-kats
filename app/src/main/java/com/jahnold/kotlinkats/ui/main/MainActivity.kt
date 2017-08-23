package com.jahnold.kotlinkats.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jahnold.kotlinkats.App
import com.jahnold.kotlinkats.R
import com.jahnold.kotlinkats.data.entities.Cat
import com.jahnold.kotlinkats.data.network.CatsHttp
import com.jahnold.kotlinkats.data.repositories.CatsRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var adapter : CatsAdapter
    private lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initPresenter()

    }

    override fun onDestroy() {

        presenter.unbindView(this)
        super.onDestroy()
    }

    private fun initRecycler() {

        adapter = CatsAdapter(mutableListOf<Cat>())
        cats_recycler.layoutManager = LinearLayoutManager(this)
        cats_recycler.adapter = adapter
    }

    private fun initPresenter() {

        val retrofit = App.instance.getRetrofit()
        val catsHttp = CatsHttp(retrofit)
        val catsRepository = CatsRepository(catsHttp)

        presenter = MainPresenter(catsRepository)
        presenter.bindView(this)
        presenter.init()
    }

    override fun setContentView(cats : List<Cat>) {

        val descriptions = cats.map { cat -> cat.description }

        cats_recycler.visibility = View.VISIBLE
        cats_error.visibility = View.GONE
        cats_loading.visibility = View.GONE

        adapter.setCats(cats)
    }

    override fun setLoadingView() {

        cats_recycler.visibility = View.GONE
        cats_error.visibility = View.GONE
        cats_loading.visibility = View.VISIBLE
    }

    override fun setErrorView() {

        cats_recycler.visibility = View.GONE
        cats_error.visibility = View.VISIBLE
        cats_loading.visibility = View.GONE
    }
}
