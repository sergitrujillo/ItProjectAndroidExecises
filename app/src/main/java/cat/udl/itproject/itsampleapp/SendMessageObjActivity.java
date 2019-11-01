package cat.udl.itproject.itsampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SendMessageObjActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_OBJECT = "cat.udl.itproject.itsampleapp.MESSAGEOBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_messageobj);
    }

    public void sendMessage(View view){
        EditText etTitle = findViewById(R.id.etTitle);
        EditText etMessage = findViewById(R.id.etMessage);
        String title = etTitle.getText().toString();
        String content = etMessage.getText().toString();
        Message message = new Message(title,content);
        Intent intent = new Intent(getApplicationContext(), MessageObjActivity.class);
        intent.putExtra(EXTRA_MESSAGE_OBJECT, message);
        startActivity(intent);

    }
}
