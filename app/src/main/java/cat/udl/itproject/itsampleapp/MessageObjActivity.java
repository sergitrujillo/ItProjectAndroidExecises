package cat.udl.itproject.itsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MessageObjActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        TextView tvMessage = findViewById(R.id.message);
        if (intent.hasExtra(SendMessageObjActivity.EXTRA_MESSAGE_OBJECT)) {

            Message message = (Message) intent.getSerializableExtra(SendMessageObjActivity.EXTRA_MESSAGE_OBJECT);
            tvMessage.setText(message.getmTitle() + " - " + message.getmContent());
        }
    }
}
