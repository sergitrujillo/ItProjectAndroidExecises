package cat.udl.itproject.itsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        TextView tvMessage = findViewById(R.id.message);
        if (intent.hasExtra(SendMessageActivity.EXTRA_MESSAGE)) {

            String message = intent.getStringExtra(SendMessageActivity.EXTRA_MESSAGE);
            tvMessage.setText(message);
        }
    }
}
