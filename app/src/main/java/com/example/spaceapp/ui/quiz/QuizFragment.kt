package com.example.spaceapp.ui.quiz

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.spaceapp.databinding.FragmentQuizBinding
import com.example.spaceapp.R

class QuizFragment : Fragment() {

  private lateinit var notificationsViewModel: QuizViewModel
private var _binding: FragmentQuizBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  private var shortAnimationDuration: Int = 0
//check
 // private val buttonStartQuiz = binding.buttonStartQuiz
//end
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    notificationsViewModel =
            ViewModelProvider(this).get(QuizViewModel::class.java)

    _binding = FragmentQuizBinding.inflate(inflater, container, false)
    val root: View = binding.root
    val startButton: View = root.findViewById(R.id.start)
    val quizCard : View = root.findViewById(R.id.include)
    val nextQuestion : View = root.findViewById(R.id.next_question)
    val quizQuestion : TextView = root.findViewById(R.id.quiz_question)
    var cpt : Int = 1
    quizQuestion.text="This is the question number " + cpt.toString()
    quizCard.visibility=View.GONE
    nextQuestion.visibility=View.GONE
    //animation of the card
    shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)

    //start of the quiz with the apparition of the quiz card
    startButton.setOnClickListener(){
      quizCard.visibility=View.VISIBLE
      nextQuestion.visibility=View.VISIBLE
      startButton.visibility=View.GONE
    }

    //loop for 10 questions quiz
    nextQuestion.setOnClickListener(){
      cpt += 1
      if (cpt>10) { //the card disappears after 10 questions
        cpt = 1
        quizQuestion.text = "This is the question number " + cpt.toString()
        startButton.visibility = View.VISIBLE
        quizCard.visibility = View.GONE
        nextQuestion.visibility=View.GONE
      }
      else //question
        quizQuestion.text ="This is the question number " + cpt.toString()

    }
  (activity as? AppCompatActivity)?.supportActionBar?.title = "Quiz"
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
}
}