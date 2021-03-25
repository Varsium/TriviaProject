package com.example.android.navigation.DataSource

import com.example.android.navigation.Model.QuizQuestion


class QuizList {
    lateinit var quiztype: String

    fun QuizMultipleChoice(): ArrayList<QuizQuestion> {
        quiztype = "MultipleChoice"
        //Here you insert List for multiple choice -> number of awnsers can be several, Dont forget to put the Correct awnser among the awnsers.
        val list = ArrayList<QuizQuestion>()
        list.add(
                QuizQuestion("What is Android Jetpack?", "all of these",
                        listOf("all of these", "tools", "documentation", "libraries")))
        list.add(QuizQuestion("Base class for Layout?", "ViewGroup",
                listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")))
        list.add(QuizQuestion("Layout for complex Screens?", "ConstraintLayout",
                listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")))
        list.add(QuizQuestion("Pushing structured data into a Layout?", "Data Binding",
                listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")))
        list.add(QuizQuestion("Inflate layout in fragments?", "onCreateView",
                listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")))
        list.add(QuizQuestion("Build system for Android?", "Gradle",
                listOf("Gradle", "Graddle", "Grodle", "Groyle")))
        list.add(QuizQuestion("Android vector format?", "VectorDrawable",
                listOf("VectorDrawable", "AndroidVectorDrawable", "DrawableVector", "AndroidVector")))
        list.add(QuizQuestion("Android Navigation Component?", "NavController",
                listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")))
        list.add(QuizQuestion("Registers app with launcher?", "intent-filter",
                listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")))
        list.add(QuizQuestion("Mark a layout for Data Binding?", "<layout>",
                listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>"))
        )
        return list

    }

    fun QuizSingleAwnser(): ArrayList<QuizQuestion> {
        quiztype = "SingleAwnser"
        val list = ArrayList<QuizQuestion>()
        list.add(
                QuizQuestion(Question = "Who became Darth vader?", Correctawnser = "Annakin"
                ))
        list.add(QuizQuestion(Question = "Green it is, what is his name?", Correctawnser = "Yoda"
        ))
        list.add(QuizQuestion(Question = "what droid has been built by Annakin Skywalker", Correctawnser = "C-3PO"))
        list.add(QuizQuestion(Question = "Which weapon is used by the Jedi Knights?", Correctawnser = "Lightsaber"))
        list.add(QuizQuestion(Question = "What is the cause of Yoda’s death?", Correctawnser = "Age"))
        list.add(QuizQuestion(Question = "hows the astromech droid called that plays in every movie", Correctawnser = "R2-D2"))
        list.add(QuizQuestion(Question = "Jar Jar Binks belongs to what species??", Correctawnser = "Gungan"))
        list.add(QuizQuestion(Question = "What colour was Qui-Gon Jinn’s lightsaber?", Correctawnser = "Green"))
        list.add(QuizQuestion(Question = "Who kissed Leia first, Han or Luke?", Correctawnser = "Luke"))
        list.add(QuizQuestion(Question = "What is the other name for The Imperial Probe Droid?", Correctawnser = "Probot"
        )
        )
        return list
    }
}
