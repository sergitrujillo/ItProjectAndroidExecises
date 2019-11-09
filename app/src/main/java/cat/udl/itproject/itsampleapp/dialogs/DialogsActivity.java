package cat.udl.itproject.itsampleapp.dialogs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import cat.udl.itproject.itsampleapp.R;

public class DialogsActivity extends AppCompatActivity
        implements android.app.DatePickerDialog.OnDateSetListener,
        android.app.TimePickerDialog.OnTimeSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
    }

    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerDialog();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerDialog();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showAlertDialog(View view) {
        DialogFragment newFragment = AlertDialogFragment.getInstance(R.string.exit_query);
        newFragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this,
                String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this,
                String.format("%02d:%02d", hourOfDay, minute),
                Toast.LENGTH_SHORT).show();
    }

    public void doPositiveClick() {
        Toast.makeText(this,
                "Positive Click",
                Toast.LENGTH_SHORT).show();
    }

    public void doNegativeClick() {
        Toast.makeText(this,
                "Negative Click",
                Toast.LENGTH_SHORT).show();
    }
}
