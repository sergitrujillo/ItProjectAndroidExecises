package cat.udl.itproject.itsampleapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import cat.udl.itproject.itsampleapp.R;


public class Fragment3 extends Fragment {


    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment3, container, false);
        textView = view.findViewById(R.id.textView);
        return view;
    }


    public void doSomething(String s) {
        textView.setText(s);
    }
}
