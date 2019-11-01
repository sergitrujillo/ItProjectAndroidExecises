package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainIntentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intents);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), SendMessageActivity.class);
        startActivity(intent);
    }
}
