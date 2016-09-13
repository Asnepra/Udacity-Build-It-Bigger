package com.example.ankit.builditbiggerp4;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.ankit.androidlibrary.JokeActivity;
import com.example.ankit.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

/**
 * Created by Ankit on 9/2/2016.
 */
public class JokeAsyncTask extends AsyncTask<Context, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;

    public JokeAsyncTask(Context context) {
        this.mContext = context;

    }

    /**
     * Override this method to perform a computation on a background thread. The
     * specified parameters are the parameters passed to {@link #execute}
     * by the caller of this task.
     * <p/>
     * This method can call {@link #publishProgress} to publish updates
     * on the UI thread.
     *
     * @param params The parameters of the task.
     * @return A result, defined by the subclass of this task.
     * @see #onPreExecute()
     * @see #onPostExecute
     * @see #publishProgress
     */
    @Override
    protected String doInBackground(Context... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("https://build-it-bigger-142309.appspot.com/_ah/api/");
            myApiService = builder.build();
        }
        try {
            return myApiService.sendJoke().execute().getData();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d("ONPostExec", result);
        Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(mContext, JokeActivity.class);
        intent.putExtra("Joke", result);
        mContext.startActivity(intent);
    }
}
