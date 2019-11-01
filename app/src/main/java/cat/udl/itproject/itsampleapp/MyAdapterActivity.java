package cat.udl.itproject.itsampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MyAdapterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_adapter);


        ArrayList<User> users  = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            users.add(new User("user"+ i, "User " +i, R.drawable.ic_launcher_foreground));
        }
        UserAdapter userAdapter = new UserAdapter(this,0,users);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(userAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = (User) parent.getItemAtPosition(position);

                Intent intent = new Intent(getApplicationContext(), UserActivity.class);
                if (position%2 ==0){
                    intent.putExtra(UserActivity.EXTRA_NAME, user.getmUserName());
                    intent.putExtra(UserActivity.EXTRA_LOGIN, user.getmUserLogin());
                    intent.putExtra(UserActivity.EXTRA_IMAGE, user.getmImageResourceId());
                }else{
                    intent.putExtra(UserActivity.EXTRA_USER, user);
                }
                startActivity(intent);
            }
        });

    }
}
