package com.example.camerapermission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private Button mBtnCameraPermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCameraPermission = findViewById(R.id.btnCameraPermission);

        mBtnCameraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permissions, REQUEST_CODE);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            showToast("Camera Permission Granted");
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            showToast("Camera Permission Denied");
            String[] permissions1 = {Manifest.permission.CAMERA};
            ActivityCompat.requestPermissions(MainActivity.this, permissions1, REQUEST_CODE);
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                showToast("Camera Permission Granted");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}