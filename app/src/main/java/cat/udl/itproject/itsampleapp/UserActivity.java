package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    public static final String EXTRA_USER= "cat.udl.itproject.itsampleapp.USER";
    public static final String EXTRA_NAME = "cat.udl.itproject.itsampleapp.NAME";
    public static final String EXTRA_LOGIN = "cat.udl.itproject.itsampleapp.LOGIN";
    public static final String EXTRA_IMAGE = "cat.udl.itproject.itsampleapp.IMAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        User user;
        if (getIntent().hasExtra(EXTRA_USER)){
            user = (User) getIntent().getSerializableExtra(EXTRA_USER);
        }else{
            user = new User(getIntent().getStringExtra(EXTRA_LOGIN),
                    getIntent().getStringExtra(EXTRA_NAME),
                    getIntent().getIntExtra(EXTRA_IMAGE,R.drawable.logo));
        }

        TextView login = findViewById(R.id.login);
        TextView name = findViewById(R.id.name);
        ImageView image = findViewById(R.id.image);

        login.setText(user.getmUserLogin());
        name.setText(user.getmUserName());
        image.setImageResource(user.getmImageResourceId());
    }
}
