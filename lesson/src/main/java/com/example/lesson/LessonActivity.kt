package com.example.lesson

import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.core.BaseView
import com.example.lesson.entity.Lesson
import kotlinx.android.synthetic.main.activity_lesson.*

class LessonActivity : AppCompatActivity(), BaseView<LessonPresenter>, Toolbar.OnMenuItemClickListener {
    private val lessonPresenter = LessonPresenter(this)

    private val lessonAdapter = LessonAdapter()

    private lateinit var refreshLayout: SwipeRefreshLayout

    override fun getPresenter() = lessonPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson)
        val toolbar = this.toolbar
        toolbar.inflateMenu(R.menu.menu_lesson)
        toolbar.setOnMenuItemClickListener(this)
        val recyclerView = this.list
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = lessonAdapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        refreshLayout = findViewById(R.id.swipe_refresh_layout)
        refreshLayout.setOnRefreshListener(OnRefreshListener { getPresenter().fetchData() })
        refreshLayout.isRefreshing = true
        lessonPresenter.fetchData()
    }

    fun showResult(lessons: List<Lesson>) {
        lessonAdapter.updateAndNotify(lessons)
        refreshLayout.isRefreshing = false
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        getPresenter().showPlayback()
        return false
    }
}