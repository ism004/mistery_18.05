package kholmurodov.ismoil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AnswersActivity : AppCompatActivity() {

    private lateinit var answersList: ListView
    private val answers = listOf("Клубок", "Валенки", "Достоевский", "Дыхание", "Зонтик", "Ложка", "Шапка", "Сапоги", "Одеяло", "Рюкзак")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answers)
        answersList = findViewById(R.id.answers_list)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, answers)
        answersList.adapter = adapter

        // Обработчик нажатия кнопки "Проверить"
        answersList.setOnItemClickListener { _, _, position, _ ->
            checkAnswer(position)
        }
    }

    private fun checkAnswer(answerPosition: Int) {
        val resultIntent = Intent()
        resultIntent.putExtra("ANSWER_POSITION", answerPosition)
        Toast.makeText(this, "Выбран ответ $answerPosition", Toast.LENGTH_SHORT).show()
        finish() // Закрытие текущего экрана и возврат на предыдущий
    }
}