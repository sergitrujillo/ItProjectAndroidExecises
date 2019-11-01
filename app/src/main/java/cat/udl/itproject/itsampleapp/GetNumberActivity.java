package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_number);
    }

    public void sendNumber(View view) {
        EditText etNumber = findViewById(R.id.etNumber);
        int number = Integer.parseInt(etNumber.getText().toString());
        Intent resultIntent = new Intent();
        resultIntent.putExtra(MainIntentsActivity.EXTRA_NUMBER, number);
        setResult(RESULT_OK, resultIntent);
        finish();
    }

    public void cancelNumber(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
