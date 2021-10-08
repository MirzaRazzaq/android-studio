package com.example.whowroteit;

import static com.example.whowroteit.NetworkUtils.getBookInfo;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class FetchBook extends AsyncTask<String, Void, String> {

    private EditText mBookInput;
    private TextView mTitleText, mAuthorText;

    public FetchBook(TextView mTitleText, TextView mAuthorText, EditText bookInput){
        this.mAuthorText = mAuthorText;
        this.mTitleText = mTitleText;
        this.mBookInput = bookInput;
    }

    @Override
    protected String doInBackground(String... params) {
        return NetworkUtils.getBookInfo(params[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            // Convert the response into a JSON object.
            JSONObject jsonObject = new JSONObject(s);
            // Get the JSONArray of book items.
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            // Initialize iterator and results fields.
            int i = 0;
            String title = null;
            String authors = null;

            // Look for results in the items array, exiting when both the title and author
            // are found or when all items have been checked.
            while (i < itemsArray.length() || (authors == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e){
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }

            // If both are found, display the result.
            if (title != null && authors != null){
                mTitleText.setText(title);
                mAuthorText.setText(authors);
                mBookInput.setText("");
            } else {
                // If none are found, update the UI to show failed results.
                mTitleText.setText(R.string.no_results);
                mAuthorText.setText("");
            }

        } catch (Exception e){
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mTitleText.setText(R.string.no_results);
            mAuthorText.setText("");
            e.printStackTrace();
        }
    }
}
