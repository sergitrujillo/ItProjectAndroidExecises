package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SendMessageActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "cat.udl.itproject.itsampleapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }

    public void sendMessage(View view){

        EditText etMessage = findViewById(R.id.etMessage);
        String message = etMessage.getText().toString();
        Intent intent = new Intent(getApplicationContext(), MessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);

    }
}
