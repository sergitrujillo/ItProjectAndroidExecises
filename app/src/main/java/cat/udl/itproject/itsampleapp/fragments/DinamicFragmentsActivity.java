package cat.udl.itproject.itsampleapp.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import cat.udl.itproject.itsampleapp.R;

public class DinamicFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinamic_fragments);
    }

    public void selectFragment(View view) {
        Fragment fragment;
        switch (view.getId()) {
            case R.id.btn1:
                fragment = new Fragment1();
                break;
            case R.id.btn2:
                fragment = new Fragment2();
                break;
            case R.id.btn3:
            default:
                fragment = new Fragment3();
                break;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        ft.add(R.id.fragment,fragment);
        ft.addToBackStack(null);
        ft.commit();


    }
}
