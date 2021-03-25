package com.example.android.navigation.gameresult

import android.R
import android.content.Intent
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.navigation.masterViewModel

open class ResultFragment : Fragment() {

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var resultViewModel: ResultViewModel

    fun createFragment(): ArrayAdapter<String> {
        resultViewModel = ViewModelProvider(this).get(ResultViewModel::class.java)

        masterViewModel._activeQuiz.observe(viewLifecycleOwner, Observer {
            adapter = ArrayAdapter(
                    this.context!!,
                    R.layout.simple_dropdown_item_1line, resultViewModel.fillingViewList())
        })
        return adapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(com.example.android.navigation.R.menu.winner_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            com.example.android.navigation.R.id.share -> shareSucces()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra(Intent.EXTRA_TEXT, getString(com.example.android.navigation.R.string.share_success_text, masterViewModel.questionIndex.value, masterViewModel.numQuestions.value))
        return shareIntent

    }

    private fun shareSucces() {
        startActivity(getShareIntent())
    }

    fun setTitle() {
        (activity as AppCompatActivity).supportActionBar?.title = "This is your result"
    }
}

