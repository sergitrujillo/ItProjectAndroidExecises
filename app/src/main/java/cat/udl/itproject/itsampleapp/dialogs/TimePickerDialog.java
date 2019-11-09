package cat.udl.itproject.itsampleapp.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerDialog extends DialogFragment implements android.app.TimePickerDialog.OnTimeSetListener {

    android.app.TimePickerDialog.OnTimeSetListener mCallback;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        return new android.app.TimePickerDialog(getActivity(), this,
                c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (android.app.TimePickerDialog.OnTimeSetListener) context;

        } catch (ClassCastException ex) {
            throw new ClassCastException(context.toString() + "must implement OnTimeSetListener");
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mCallback.onTimeSet(view,hourOfDay,minute);
    }
}
