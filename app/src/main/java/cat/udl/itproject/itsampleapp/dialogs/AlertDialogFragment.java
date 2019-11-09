package cat.udl.itproject.itsampleapp.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.style.BulletSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import cat.udl.itproject.itsampleapp.R;

public class AlertDialogFragment extends DialogFragment {

    public static final String TITLE_ARGUMENT = "title";

    public static AlertDialogFragment getInstance(int title){
        AlertDialogFragment frag = new AlertDialogFragment();
        Bundle  args = new Bundle();
        args.putInt(TITLE_ARGUMENT, title);
        frag.setArguments(args);
        return frag;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        int title = getArguments().getInt(TITLE_ARGUMENT);

        return new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setPositiveButton(R.string.alert_dialog_yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((DialogsActivity) getActivity()).doPositiveClick();
                    }
                })
                .setNegativeButton(R.string.alert_dialog_no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ((DialogsActivity) getActivity()).doNegativeClick();
                    }
                })
                .create();


    }
}

