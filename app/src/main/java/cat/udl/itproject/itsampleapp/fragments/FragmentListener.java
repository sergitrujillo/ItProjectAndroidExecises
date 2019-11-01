package cat.udl.itproject.itsampleapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cat.udl.itproject.itsampleapp.R;


public class FragmentListener extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_listener, container, false);

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonClicked("Fragment is Here!!!");
            }
        });


        return view;
    }
    public OnButtonClickedListener listener;
    public interface OnButtonClickedListener{
        void onButtonClicked(String msg);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnButtonClickedListener){
            listener = (OnButtonClickedListener) context;
        }else{
            throw new ClassCastException("must implement OnButtonClickedListener");
        }
    }
}
