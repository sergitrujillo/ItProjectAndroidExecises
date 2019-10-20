package cat.udl.itproject.itsampleapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class WidgetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgets);

        final EditText editText = findViewById(R.id.edittext);

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                    keyCode == KeyEvent.KEYCODE_ENTER){
                    Toast.makeText(WidgetActivity.this,editText.getText(),Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });



        final CheckBox checkBox = findViewById(R.id.checkbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox c = (CheckBox) v;
                if (c.isChecked()){
                    Toast.makeText(WidgetActivity.this,"Selected",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(WidgetActivity.this,"Not Selected",Toast.LENGTH_SHORT).show();
                }
            }
        });

        final View.OnClickListener radio_listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rb = (RadioButton) v;
                Toast.makeText(WidgetActivity.this,rb.getText(),Toast.LENGTH_SHORT).show();
            }
        };

        final RadioButton radio_red = findViewById(R.id.radio_red);
        final RadioButton radio_blue = findViewById(R.id.radio_blue);
        radio_red.setOnClickListener(radio_listener);
        radio_blue.setOnClickListener(radio_listener);


        final ToggleButton toggleButton = findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToggleButton tb = (ToggleButton) v;
                if (tb.isChecked()){
                    Toast.makeText(WidgetActivity.this,"Checked",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(WidgetActivity.this, "Not checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
