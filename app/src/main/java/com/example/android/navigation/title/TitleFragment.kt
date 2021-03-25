package com.example.android.navigation.title

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentTitleBinding
import com.example.android.navigation.masterViewModel
import timber.log.Timber


class TitleFragment : Fragment() {
    private lateinit var titleViewModel: TitleViewModel
    private var sharingText = "";
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        titleViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        binding.titleViewModel = titleViewModel
        binding.lifecycleOwner = this
        masterViewModel.multiQuizBundle.observe(viewLifecycleOwner, Observer {
            println("I observe the multi")
            titleViewModel.textMulti()
        })
        masterViewModel.singleQuizBundle.observe(viewLifecycleOwner, Observer {
            println("I observe the single")
            titleViewModel.textSingle()
        })
        binding.apply {
            sharingText = "Score Multiplechoice quiz: " + txtScoreMultipleChoice.text.toString() +
                    " Score Singlechoice quiz: " + txtScoreSingelAwnserQuiz.text.toString()
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.winner_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> shareSucces()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getShareIntent(): Intent {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain").putExtra("sharingIsCaring", sharingText)
        return shareIntent

    }

    private fun shareSucces() {
        Timber.i(getShareIntent().extras.toString())
        startActivity(Intent.createChooser(getShareIntent(),
                "share your quizresults: "))
    }
}
