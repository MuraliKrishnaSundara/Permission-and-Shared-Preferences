package com.example.sharedpreferenceseventbookingyou;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    private static final String PREF_INT_KEY = "PREF_INT_KEY";
    private static final String PREF_INT_KEY2 = "PREF_INT_KEY2";
    private static final String PREF_STRING_KEY = "PREF_STRING_KEY";
    private static final String PREF_STRING_KEY2 = "PREF_STRING_KEY2";
    private static final String PREF_STRING_KEY3 = "PREF_STRING_KEY3";
    private static final String PREF_STRING_KEY4 = "PREF_STRING_KEY4";
    private EditText mEtSeatf;
    private EditText mEtDatef;
    private Button mBtnConfirm;
    private TextView mTvFirstNamef;
    private TextView mTvLastNamef;
    private TextView mTvEmailf;
    private TextView mTvPhonef;
    private TextView mTvSeatf;
    private TextView mTvDatef;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        initViewsAndListeners();
        String stringFromPref1 = PreferenceHelper.getStringFromPreference(FinalActivity.this, PREF_STRING_KEY);
        mTvFirstNamef.setText(stringFromPref1);
        String stringFromPref2 = PreferenceHelper.getStringFromPreference(FinalActivity.this, PREF_STRING_KEY2);
        mTvLastNamef.setText(stringFromPref2);
        String stringFromPref3 = PreferenceHelper.getStringFromPreference(FinalActivity.this, PREF_STRING_KEY3);
        mTvEmailf.setText(stringFromPref3);
        long numberFromPref = PreferenceHelper.getIntFromPreference(FinalActivity.this, PREF_INT_KEY);
        mTvPhonef.setText(numberFromPref + " ");
        long numberFromPref1 = PreferenceHelper.getIntFromPreference(FinalActivity.this, PREF_INT_KEY2);
        mTvSeatf.setText(numberFromPref1 + " ");
        String stringFromPref4 = PreferenceHelper.getStringFromPreference(FinalActivity.this, PREF_STRING_KEY4);
        mTvDatef.setText(stringFromPref4);
        mBtnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder
                        .setTitle("Confirmed")
                        .setMessage("The event is confirmed on " + stringFromPref4)
                        .show();
            }
        });
    }

    private void initViewsAndListeners() {
        mTvSeatf = findViewById(R.id.etSeatf);
        mTvDatef = findViewById(R.id.etDatef);
        mBtnConfirm = findViewById(R.id.btnConfirm);
        mTvFirstNamef = findViewById(R.id.etFirstNamef);
        mTvLastNamef = findViewById(R.id.etLastNamef);
        mTvEmailf = findViewById(R.id.etEmailf);
        mTvPhonef = findViewById(R.id.etPhonef);
    }
}