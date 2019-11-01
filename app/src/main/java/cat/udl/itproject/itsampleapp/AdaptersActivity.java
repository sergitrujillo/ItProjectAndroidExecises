package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AdaptersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapters);

        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.arrayNumber)));
        ArrayAdapter<String> numbersAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,numbers);


        manageSpinner(numbersAdapter);
        manageListView(numbersAdapter);
        manageGridView(numbersAdapter);

    }

    private void manageGridView(ArrayAdapter<String> numbersAdapter) {
        GridView gridView = findViewById(R.id.numbersGrid);
        gridView.setAdapter(numbersAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelected((TextView) view);
            }
        });
    }

    private void manageListView(ArrayAdapter<String> numbersAdapter) {
        ListView listView = findViewById(R.id.numbersList);
        listView.setAdapter(numbersAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showSelected((TextView) view);

            }
        });
    }

    private void manageSpinner(ArrayAdapter<String> numbersAdapter) {
        Spinner spinner = findViewById(R.id.numbersSpinner);
        numbersAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(numbersAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                showSelected((TextView) view);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    private void showSelected(TextView view) {
        Toast.makeText(getApplicationContext(), view.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
