package cat.udl.itproject.itsampleapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TemperatureConverterActivity extends AppCompatActivity {

    private EditText etTemperature;
    private RadioButton rbCelsius;
    private RadioButton rbFahrenheit;
    private Button btCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        bindWidgets();
        bindListeners();
    }

    private void bindListeners() {
        etTemperature.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() == KeyEvent.ACTION_UP &&
                    keyCode == KeyEvent.KEYCODE_ENTER) {
                calculate();
                return true;
            }
            return false;
        });
        btCalculate.setOnClickListener(v -> calculate());
    }

    private void bindWidgets() {
        etTemperature = findViewById(R.id.etTemperature);
        rbCelsius = findViewById(R.id.rbCelsius);
        rbFahrenheit = findViewById(R.id.rbFahrenheit);
        btCalculate = findViewById(R.id.btCalculate);
    }


    public void calculate() {
        try {
            float source = getSourceTemp();
            float destination;
            RadioButton nextDestination;
            if (rbCelsius.isChecked()) {
                destination = convertFahrenheitToCelsius(source);
                nextDestination = rbFahrenheit;
            } else if (rbFahrenheit.isChecked()) {
                destination = convertCelsiusToFahrenheit(source);
                nextDestination = rbCelsius;
            } else {
                Toast.makeText(this, "Error: UnKnown target", Toast.LENGTH_SHORT).show();
                return;
            }
            setDestinationTemp(destination);
            selectNextDestination(nextDestination);
        } catch (NotValidTemperatureException ex) {
            Toast.makeText(this, "Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void selectNextDestination(RadioButton destination) {
        rbFahrenheit.setChecked(false);
        rbCelsius.setChecked(false);
        destination.setChecked(true);
    }

    private void setDestinationTemp(float destination) {
        etTemperature.setText(String.valueOf(destination));
    }

    private float getSourceTemp() {
        String text = etTemperature.getText().toString();
        if (text.isEmpty()) {
            throw new NotValidTemperatureException("Empty value");
        }
        try {
            return Float.parseFloat(text);
        } catch (NumberFormatException ex) {
            throw new NotValidTemperatureException("Invalid value");
        }
    }

    private float convertFahrenheitToCelsius(float temp) {
        return (temp - 32) * 5 / 9;
    }

    private float convertCelsiusToFahrenheit(float temp) {
        return ((temp * 9) / 5) + 32;
    }
}
