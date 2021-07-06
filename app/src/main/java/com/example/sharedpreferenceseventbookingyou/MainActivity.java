package com.example.sharedpreferenceseventbookingyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private static final String PREF_INT_KEY = "PREF_INT_KEY";
    private static final String PREF_STRING_KEY = "PREF_STRING_KEY";
    private static final String PREF_STRING_KEY2 = "PREF_STRING_KEY2";
    private static final String PREF_STRING_KEY3 = "PREF_STRING_KEY3";
    private EditText mEtFirstName;
    private EditText mEtLastName;
    private EditText mEtEmailAddress;
    private EditText mEtPhoneNumber;
    private Button mBtnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewsAndListeners();
        mBtnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = v.getId();
                switch (id) {
                    case R.id.btnBook:
                        PreferenceHelper.writeStringToPreference(MainActivity.this, PREF_STRING_KEY, mEtFirstName.getText().toString());
                        PreferenceHelper.writeStringToPreference(MainActivity.this, PREF_STRING_KEY2, mEtLastName.getText().toString());
                        PreferenceHelper.writeStringToPreference(MainActivity.this, PREF_STRING_KEY3, mEtEmailAddress.getText().toString());
                        if (isNumber())
                            PreferenceHelper.writeIntToPreference(MainActivity.this, PREF_INT_KEY, Long.parseLong(mEtPhoneNumber.getText().toString()));
                        break;
                }
                Intent intent = new Intent(MainActivity.this, SlotActivity.class);
                if (isNumber())
                    startActivity(intent);
            }
        });
    }

    private void initViewsAndListeners() {
        mEtFirstName = findViewById(R.id.etFirstName);
        mEtLastName = findViewById(R.id.etLastName);
        mEtEmailAddress = findViewById(R.id.etEmailAddress);
        mEtPhoneNumber = findViewById(R.id.etPhoneNumber);
        mBtnBook = findViewById(R.id.btnBook);
    }

    private boolean isNumber() {
        boolean isNumber = false;

        if (!mEtPhoneNumber.getText().toString().isEmpty()) {
            try {
                Long.parseLong(mEtPhoneNumber.getText().toString());
                isNumber = true;
            } catch (Exception e) {
                isNumber = false;
                mEtPhoneNumber.setError("Enter a valid number");
            }
        } else {
            mEtPhoneNumber.setError("Field cannot be empty");
        }
        return isNumber;
    }
}