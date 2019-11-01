package cat.udl.itproject.itsampleapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.security.Permissions;

public class MainIntentsActivity extends AppCompatActivity {

    public static final String EXTRA_NUMBER = "cat.udl.itproject.itsampleapp.NUMBER";
    public static final int REQUEST_CODE_1 = 1;
    public static final int REQUEST_CODE_2 = 2;
    public static final int REQUEST_PERMISSIONCALL = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_intents);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(getApplicationContext(), SendMessageActivity.class);
        startActivity(intent);
    }

    public void sendMessageObj(View view) {
        Intent intent = new Intent(getApplicationContext(), SendMessageObjActivity.class);
        startActivity(intent);
    }

    public void sendOutput1(View view) {
        Intent intent = new Intent(getApplicationContext(), GetNumberActivity.class);
        startActivityForResult(intent, REQUEST_CODE_1);
    }

    public void sendOutput2(View view) {
        Intent intent = new Intent(getApplicationContext(), GetNumberActivity.class);
        startActivityForResult(intent, REQUEST_CODE_2);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            int number = data.getIntExtra(EXTRA_NUMBER, 0);
            String message;
            switch (requestCode) {
                case REQUEST_CODE_1:
                    message = getString(R.string.send) + " RQ1:" + number;
                    break;
                case REQUEST_CODE_2:
                    message = getString(R.string.send) + " RQ1:" + number;
                    break;
                default:
                    message = "ERROR";
                    break;
            }
            Toast.makeText(getBaseContext(), message, Toast.LENGTH_SHORT).show();
        } else { // CANCEL
            Toast.makeText(getBaseContext(), getString(R.string.cancel), Toast.LENGTH_SHORT).show();
        }

    }

    public void makePhoneDial(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getString(R.string.dialNumber)));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void makePhoneCall(View view) {

        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (result != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PERMISSIONCALL);
        } else {
            callPhone();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_PERMISSIONCALL:
                if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
                    callPhone();
                }
                break;
        }
    }

    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + getString(R.string.dialNumber)));
        int result = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if (result != PackageManager.PERMISSION_GRANTED) {
            startActivity(intent);
        }
    }

    public void openUrlWeb(View view) {
        Uri webPage = Uri.parse(getString(R.string.androidWeb));
        Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openMap(View view) {
        Uri geo = Uri.parse("geo:41.608945,0.6224863");
        Intent intent = new Intent(Intent.ACTION_VIEW, geo);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
