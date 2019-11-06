package cat.udl.itproject.itsampleapp.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import cat.udl.itproject.itsampleapp.R;

public class FragmentListenerActivity extends AppCompatActivity implements FragmentListener.OnButtonClickedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_listener);

        Fragment fr = new FragmentListener();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_place,fr);
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public void onButtonClicked(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
