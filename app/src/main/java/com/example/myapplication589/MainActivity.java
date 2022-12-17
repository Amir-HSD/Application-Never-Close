package com.example.myapplication589;
// امیرحسین موسویان
import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
// امیرحسین موسویان
public class MainActivity extends AppCompatActivity {
    // امیرحسین موسویان
    private Button mButton;
    private EditText mText, mText2;
    private TextView mTextView;
    // امیرحسین موسویان
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if(Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

        Intent service = new Intent(getApplicationContext(), MyService.class);
        startService(service);

        mButton = findViewById(R.id.button2);
        mText = findViewById(R.id.editTextTextPersonName2);
        mText2 = findViewById(R.id.editTextTextPersonName);
        mTextView = findViewById(R.id.textView3);

        mText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String Get_Text = mText2.getText().toString();
                if (Get_Text != "") {
                    mTextView.setText(Get_Text);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            // امیرحسین موسویان
            @Override
            public void onClick(View view)
            {
                String Get_Text = mText.getText().toString();
                if (Get_Text != "") {
                    mTextView.setText(Get_Text);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Lotfan Yek Text Vared Konid!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    // امیرحسین موسویان
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
        return;
    }
    // امیرحسین موسویان
    @Override
    protected void onPause() {

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication589");
        if (launchIntent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            super.onPause();

        }else{
            Toast.makeText(getApplicationContext(),"ریدم :) تو برنده شدی و برنامه بسته شد",Toast.LENGTH_SHORT).show();
            super.onPause();
        }

    }
    // امیرحسین موسویان
    @Override
    protected void onDestroy() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication589");
        if (launchIntent != null) {
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            super.onDestroy();

        }else{
            Toast.makeText(getApplicationContext(),"ریدم :) تو برنده شدی و برنامه بسته شد",Toast.LENGTH_SHORT).show();
            super.onDestroy();
        }
    }
    // امیرحسین موسویان
    @Override
    protected void onUserLeaveHint() {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.myapplication589");
        if (launchIntent != null) {
            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"برنامه بسته نمیشه عزیزم",Toast.LENGTH_SHORT).show();
            super.onUserLeaveHint();

        }else{
            Toast.makeText(getApplicationContext(),"ریدم :) تو برنده شدی و برنامه بسته شد",Toast.LENGTH_SHORT).show();
            super.onUserLeaveHint();
        }
    }



}