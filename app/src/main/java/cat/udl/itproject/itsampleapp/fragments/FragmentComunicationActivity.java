package cat.udl.itproject.itsampleapp.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;

import cat.udl.itproject.itsampleapp.R;

public class FragmentComunicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_comunication);
    }

    public void doSomething(View view) {
        Fragment3 fragment = (Fragment3) getSupportFragmentManager().findFragmentById(R.id.fragment3);
        fragment.doSomething("DO SOMETHING!!!");
    }
}
