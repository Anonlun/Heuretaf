
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var hoursWorkedEditText: EditText
    private lateinit var hourlyRateEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hoursWorkedEditText = findViewById(R.id.editTextHoursWorked)
        hourlyRateEditText = findViewById(R.id.editTextHourlyRate)
        calculateButton = findViewById(R.id.buttonCalculate)
        resultTextView = findViewById(R.id.textViewResult)

        calculateButton.setOnClickListener { calculatePayment() }
    }

    private fun calculatePayment() {
        val hoursWorked = hoursWorkedEditText.text.toString().toDoubleOrNull() ?: 0.0
        val hourlyRate = hourlyRateEditText.text.toString().toDoubleOrNull() ?: 0.0

        val dailyPayment = hoursWorked * hourlyRate
        val weeklyPayment = dailyPayment * 7
        val monthlyPayment = dailyPayment * 30

        val resultText =
            "Journalier: $dailyPayment €\nHebdomadaire: $weeklyPayment €\nMensuel: $monthlyPayment €"

        resultTextView.text = resultText
        resultTextView.visibility = View.VISIBLE
    }
}
```
