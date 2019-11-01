package cat.udl.itproject.itsampleapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainIntentsActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "cat.udl.itproject.itsampleapp.NUMBER";
    public static final int REQUETST_CODE_1 = 1;
    public static final int REQUETST_CODE_2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intents);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), SendMessageActivity.class);
        startActivity(intent);
    }

    public void sendMessageObj(View view) {
        Intent intent = new Intent(getApplicationContext(), SendMessageObjActivity.class);
        startActivity(intent);
    }

    public void sendOutput1(View view) {
        Intent intent = new Intent(getApplicationContext(), GetNumberActivity.class);
        startActivityForResult(intent, REQUETST_CODE_1);
    }

    public void sendOutput2(View view) {
        Intent intent = new Intent(getApplicationContext(), GetNumberActivity.class);
        startActivityForResult(intent, REQUETST_CODE_2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            int number = data.getIntExtra(EXTRA_NUMBER, 0);
            String message;
            switch (requestCode) {
                case REQUETST_CODE_1:
                    message = getString(R.string.send) + " RQ1:" + number;
                    break;
                case REQUETST_CODE_2:
                    message = getString(R.string.send) + " RQ1:" + number;
                    break;
                default:
                    message = "ERROR";
                    break;
            }
            Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        }else{ // CANCEL
            Toast.makeText(getBaseContext(), getString(R.string.cancel), Toast.LENGTH_SHORT).show();
        }

    }
}
