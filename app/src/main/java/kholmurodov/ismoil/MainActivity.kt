package kholmurodov.ismoil
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import android.content.Intent



class MainActivity : AppCompatActivity() {

    private lateinit var buttonStat: Button
    private lateinit var buttonRiddle: Button
    private lateinit var buttonAnswer: Button
    private lateinit var riddleTextView: TextView

    // Список загадок
    private val riddles = arrayOf(
        "На одном месте мотков двести",
        "Палят и варят, а не едят",
        "Кто написал «Преступление и наказание»?",
        "Идёт сегодня дождик,\n" +
                "\n" +
                "\n" +
                "Бери с собою …!",
        "За спиной у нас висит,\n" +
                "\n" +
                "\n" +
                "Много сможет он вместить!",
        "На пол снова убежало\n" +
                "\n" +
                "С моей кровати …",
                "В них прошли мы по дороге, \n" +
                "\n" +
                "\n" +
                "Не промокли наши ноги!",
        " Она сидит на голове,\n" +
                "\n" +
                "\n" +
                "Чтоб тепло было тебе!",
        "Суп в тарелку мы нальём,\n" +
                "\n" +
                "\n" +
                "Рукой затем её возьмём!",
        "Оно лёгкое, как пёрышко, но даже самый тренированный человек долго его не удержит. Что это?"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStat = findViewById(R.id.button_stat)
        buttonRiddle = findViewById(R.id.button_riddle)
        buttonAnswer = findViewById(R.id.button_answer)
        riddleTextView = findViewById(R.id.riddle_text_view)

        buttonRiddle.setOnClickListener {
            showRandomRiddle()
        }

        val buttonAnswer = findViewById<Button>(R.id.button_answer)
        buttonAnswer.setOnClickListener {
            val intent = Intent(this, AnswersActivity::class.java)
            startActivity(intent)
        }
    }
    private fun showRandomRiddle() {
        // Генерируем случайный индекс
        val randomIndex = Random().nextInt(riddles.size)
        // Отображаем случайную загадку
        riddleTextView.text = riddles[randomIndex]
    }

}