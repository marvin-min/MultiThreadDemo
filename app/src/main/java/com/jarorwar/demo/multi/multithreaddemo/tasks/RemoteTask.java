package com.jarorwar.demo.multi.multithreaddemo.tasks;

import android.os.AsyncTask;

/**
 * Created by marvinmin on 10/12/16.
 */

public class RemoteTask extends AsyncTask<Void,Integer,Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }
}
