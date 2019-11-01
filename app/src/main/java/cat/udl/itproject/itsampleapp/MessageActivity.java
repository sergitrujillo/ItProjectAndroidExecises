package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        TextView tvMessage = findViewById(R.id.message);
        if (intent.hasExtra(SendMessageActivity.EXTRA_MESSAGE)){
            tvMessage.setText(intent.getStringExtra(SendMessageActivity.EXTRA_MESSAGE));
        }
    }
}
