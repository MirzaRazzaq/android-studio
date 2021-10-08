package com.example.whowroteit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mBookInput;
    private TextView mAuthor, mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBookInput = findViewById(R.id.bookInput);
        mAuthor = findViewById(R.id.authorText);
        mTitle = findViewById(R.id.titleText);
    }

    public void seachBooks(View view) {
        String mQueryString = mBookInput.getText().toString();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        // Check the status of the network connection.
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If the network is active and the search field is not empty, start a FetchBook AsyncTask.
        if (networkInfo != null && networkInfo.isConnected() && mQueryString.length()!=0) {
            new FetchBook(mTitle, mAuthor, mBookInput).execute(mQueryString);
        }
        // Otherwise update the TextView to tell the user there is no connection or no search term.
        else {
            if (mQueryString.length() == 0) {
                mAuthor.setText("");
                mTitle.setText(R.string.no_search_term);
            } else {
                mAuthor.setText("");
                mTitle.setText(R.string.no_network);
            }
        }
    }
}