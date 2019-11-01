package cat.udl.itproject.itsampleapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class LivecycleActivity extends AppCompatActivity {


    private static final String LIVECYCLE_STATE = "LivecycleState";
    TextView textView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_livecycle);

        textView = findViewById(R.id.textView);

        if (savedInstanceState == null && textView!=null){
            textView.append(getString(R.string.onCreateCallback));
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if (textView!=null){
            textView.append(getString(R.string.onPostCreateCallback));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (textView!=null){
            textView.append(getString(R.string.onStartCallback));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (textView!=null){
            outState.putCharSequence(LIVECYCLE_STATE, textView.getText());
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (textView!=null){
            textView.append(getString(R.string.onRestartCallback));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (textView!=null){
            textView.append(getString(R.string.onResumeCallback));
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (textView!=null){
            textView.append(getString(R.string.onPauseCallback));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (textView!=null){
            textView.append(getString(R.string.onStopCallback));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textView!=null){
            textView.append(getString(R.string.onDestroyCallback));
        }
    }
}
