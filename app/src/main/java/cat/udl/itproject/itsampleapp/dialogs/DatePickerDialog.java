package cat.udl.itproject.itsampleapp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerDialog extends DialogFragment implements android.app.DatePickerDialog.OnDateSetListener {

    android.app.DatePickerDialog.OnDateSetListener mCallback;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        return new android.app.DatePickerDialog(getActivity(), this,
                c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (android.app.DatePickerDialog.OnDateSetListener) context;

        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement OnDateSetListener");
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        mCallback.onDateSet(view, year, month, dayOfMonth);
    }
}
