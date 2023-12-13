import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText hoursWorkedEditText;
    private EditText hourlyRateEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoursWorkedEditText = findViewById(R.id.editTextHoursWorked);
        hourlyRateEditText = findViewById(R.id.editTextHourlyRate);
        calculateButton = findViewById(R.id.buttonCalculate);
        resultTextView = findViewById(R.id.textViewResult);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatePayment();
            }
        });
    }

    private void calculatePayment() {
        double hoursWorked = Double.parseDouble(hoursWorkedEditText.getText().toString());
        double hourlyRate = Double.parseDouble(hourlyRateEditText.getText().toString());

        double dailyPayment = hoursWorked * hourlyRate;
        double weeklyPayment = dailyPayment * 7;
        double monthlyPayment = dailyPayment * 30;

        String resultText = String.form
            
