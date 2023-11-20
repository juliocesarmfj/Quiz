package com.example.quizzapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizzapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val questions = arrayOf(
        "Qual é a capital do Brasil?",
        "Quem foi o primeiro presidente dos Estados Unidos?",
        "Qual é o maior oceano do mundo?",
        "Quem escreveu 'Romeu e Julieta'?",
        "Em que ano ocorreu a Revolução Francesa?",
        "Qual é o símbolo químico para o ouro?",
        "Quem foi o líder sul-africano que lutou contra o apartheid?",
        "Quem pintou a Mona Lisa?",
        "Qual é o maior planeta do nosso sistema solar?",
        "Quem foi o fundador do Facebook?",
        "Qual é o segundo maior país do mundo em área territorial?",
        "Em que continente está localizado o Deserto do Saara?",
        "Quem foi o famoso físico britânico que desenvolveu a teoria da relatividade?",
        "Qual é a moeda oficial do Japão?",
        "Quem foi o primeiro ser humano a pisar na Lua?",
        "Qual é o país mais populoso do mundo?",
        "Quem escreveu 'Dom Quixote'?",
        "Em que ano a Segunda Guerra Mundial começou?",
        "Qual é o nome da empresa de tecnologia fundada por Bill Gates?",
        "Quem foi o famoso cientista que formulou as leis do movimento e a lei da gravidade?"
    )

    private val options = arrayOf(
        arrayOf("Brasília", "Rio de Janeiro", "São Paulo"),
        arrayOf("George Washington", "Thomas Jefferson", "John Adams"),
        arrayOf("Oceano Atlântico", "Oceano Pacífico", "Oceano Índico"),
        arrayOf("William Shakespeare", "Charles Dickens", "Jane Austen"),
        arrayOf("1789", "1799", "1809"),
        arrayOf("O", "Au", "Ag"),
        arrayOf("Nelson Mandela", "Desmond Tutu", "Steve Biko"),
        arrayOf("Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso"),
        arrayOf("Júpiter", "Saturno", "Netuno"),
        arrayOf("Mark Zuckerberg", "Bill Gates", "Elon Musk"),
        arrayOf("Canadá", "China", "Rússia"),
        arrayOf("África", "Ásia", "América do Sul"),
        arrayOf("Albert Einstein", "Isaac Newton", "Niels Bohr"),
        arrayOf("Yen", "Yuan", "Won"),
        arrayOf("Neil Armstrong", "Buzz Aldrin", "Yuri Gagarin"),
        arrayOf("China", "Índia", "Estados Unidos"),
        arrayOf("Miguel de Cervantes", "Gustave Flaubert", "Fyodor Dostoevsky"),
        arrayOf("1939", "1940", "1941"),
        arrayOf("Microsoft", "Apple", "Google"),
        arrayOf("Isaac Newton", "Galileu Galilei", "Stephen Hawking")
    )

    private val correctAnswers = arrayOf(0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 2, 1, 0, 0, 0, 2, 0, 0, 0, 1, 1)

    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayQuestion()

        binding.optionButton.setOnClickListener {
            checkAnswers(0)
        }
        binding.option2Button.setOnClickListener {
            checkAnswers(1)
        }
        binding.option3Button.setOnClickListener {
            checkAnswers(2)
        }
    }
    private fun correctButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.optionButton.setBackgroundColor(Color.GREEN)
            1 -> binding.option2Button.setBackgroundColor(Color.GREEN)
            2 -> binding.option3Button.setBackgroundColor(Color.GREEN)

        }

    }

    private fun wrongButtonColors(buttonIndex: Int){
        when(buttonIndex){
            0 -> binding.optionButton.setBackgroundColor(Color.RED)
            1 -> binding.option2Button.setBackgroundColor(Color.RED)
            2 -> binding.option3Button.setBackgroundColor(Color.RED)
        }
    }

    private fun resetButtonColors(){
        binding.optionButton.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option2Button.setBackgroundColor(Color.rgb(50, 59, 96))
        binding.option3Button.setBackgroundColor(Color.rgb(50, 59, 96))
    }



    private fun displayQuestion(){
        binding.questionText.text = questions[currentQuestionIndex]
        binding.optionButton.text = options[currentQuestionIndex][0]
        binding.option2Button.text = options[currentQuestionIndex][1]
        binding.option3Button.text = options[currentQuestionIndex][2]
        resetButtonColors()
    }

    private fun showResultToast() {
        val resultMessage = "Você acertou $score perguntas!"
        val toast = Toast.makeText(this, resultMessage, Toast.LENGTH_LONG)
        toast.show()
    }

    private fun checkAnswers(selectedAnswersIndex: Int) {
        val correctAnswerIndex = correctAnswers[currentQuestionIndex]

        if (selectedAnswersIndex == correctAnswerIndex) {
            score++
            correctButtonColors(selectedAnswersIndex)
        } else {
            wrongButtonColors(selectedAnswersIndex)
            correctButtonColors(correctAnswerIndex)
        }

        if (currentQuestionIndex < questions.size - 1) {
            currentQuestionIndex++
            binding.questionText.postDelayed({ displayQuestion() }, 1000)
        } else {
            showResultToast()
        }
    }






}