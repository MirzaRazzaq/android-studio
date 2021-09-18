package com.example.twoactivitiesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.twoactivitiesapp.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    private EditText mMessageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.Text_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
    }

    public void laucnhSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked");
        Intent intent = new Intent(this, MainActivity2.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent Data){
        super.onActivityResult(RequestCode,ResultCode,Data);

        if (RequestCode == TEXT_REQUEST){
            if (ResultCode == RESULT_OK){
                String reply = Data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}