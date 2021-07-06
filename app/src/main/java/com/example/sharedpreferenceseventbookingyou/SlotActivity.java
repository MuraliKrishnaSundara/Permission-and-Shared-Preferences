package com.example.sharedpreferenceseventbookingyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SlotActivity extends AppCompatActivity {

    private static final String PREF_INT_KEY = "PREF_INT_KEY";
    private static final String PREF_INT_KEY2 = "PREF_INT_KEY2";
    private static final String PREF_STRING_KEY = "PREF_STRING_KEY";
    private static final String PREF_STRING_KEY2 = "PREF_STRING_KEY2";
    private static final String PREF_STRING_KEY3 = "PREF_STRING_KEY3";
    private static final String PREF_STRING_KEY4 = "PREF_STRING_KEY4";
    private EditText mEtSeats;
    private EditText mEtDates;
    private Button mBtnPreviews;
    private TextView mTvFirstNames;
    private TextView mTvLastNames;
    private TextView mTvEmails;
    private TextView mTvPhones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot);
        initViewsAndListeners();
        String stringFromPref1 = PreferenceHelper.getStringFromPreference(SlotActivity.this, PREF_STRING_KEY);
        mTvFirstNames.setText(stringFromPref1);
        String stringFromPref2 = PreferenceHelper.getStringFromPreference(SlotActivity.this, PREF_STRING_KEY2);
        mTvLastNames.setText(stringFromPref2);
        String stringFromPref3 = PreferenceHelper.getStringFromPreference(SlotActivity.this, PREF_STRING_KEY3);
        mTvEmails.setText(stringFromPref3);
        long numberFromPref = PreferenceHelper.getIntFromPreference(SlotActivity.this, PREF_INT_KEY);
        mTvPhones.setText(numberFromPref + " ");
        mBtnPreviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                switch (id) {
                    case R.id.btnPreview:
                        PreferenceHelper.writeStringToPreference(SlotActivity.this, PREF_STRING_KEY4, mEtDates.getText().toString());
                        if (isNumber())
                            PreferenceHelper.writeIntToPreference(SlotActivity.this, PREF_INT_KEY2, Long.parseLong(mEtSeats.getText().toString()));
                        break;
                }
                Intent intent = new Intent(SlotActivity.this, FinalActivity.class);
                if (isNumber())
                    startActivity(intent);
            }
        });
    }

    private void initViewsAndListeners() {
        mEtSeats = findViewById(R.id.etSeat);
        mEtDates = findViewById(R.id.etDate);
        mBtnPreviews = findViewById(R.id.btnPreview);
        mTvFirstNames = findViewById(R.id.etFirstNames);
        mTvLastNames = findViewById(R.id.etLastNames);
        mTvEmails = findViewById(R.id.etEmails);
        mTvPhones = findViewById(R.id.etPhone);
    }

    private boolean isNumber() {
        boolean isNumber = false;

        if (!mEtSeats.getText().toString().isEmpty()) {
            try {
                Long.parseLong(mEtSeats.getText().toString());
                isNumber = true;
            } catch (Exception e) {
                isNumber = false;
                mEtSeats.setError("Enter a valid number");
            }
        } else {
            mEtSeats.setError("Field cannot be empty");
        }
        return isNumber;
    }
}