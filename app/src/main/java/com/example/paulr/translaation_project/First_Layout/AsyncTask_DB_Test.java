package com.example.paulr.translaation_project.First_Layout;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class AsyncTask_DB_Test extends AsyncTask<String, String, String[]> {


    protected String wordEnglishText = "Sorry, this word hasn't translated yet";
    protected String defenitionEnglishText= "Sorry, this word hasn't translated yet";
    protected String wordRussianText = "Sorry, this word hasn't translated yet";
    protected String defenitionRussianText = "Sorry, this word hasn't translated yet";
    protected String wordChinaText = "Sorry, this word hasn't translated yet";
    protected String defenitionChinaText = "Sorry, this word hasn't translated yet";
    protected String wordJapanText = "Sorry, this word hasn't translated yet";
    protected String defenition_JapanText = "Sorry, this word hasn't translated yet";


    InputStream is = null;
    String result = null;
    String line = null;

    String word;


    private  Context context;

    public AsyncTask_DB_Test(Context context){
        this.context = context;
    }

    public interface AsyncResponse {
        void processFinish(String[] output);
    }

    public AsyncResponse delegate = null;

    public AsyncTask_DB_Test(AsyncResponse delegate){
        this.delegate = delegate;
    }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }



        @Override
        protected String[] doInBackground(String... strings) {


            ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
            nameValuePairs.add(new BasicNameValuePair("wordEnglish", strings[0]));

            try {
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost("https://siteforproject.000webhostapp.com/get_products_details.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
                HttpResponse response = httpClient.execute(httppost);
                HttpEntity enity = response.getEntity();
                is = enity.getContent();
                Log.e("pass 1", "connection success");

            } catch (Exception e) {
                Log.e("Fail 1", e.toString());
            }


            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 100);
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
                is.close();
                result = sb.toString();
                reader.close();
                Log.e("pass 2", "connection" + result);
            } catch (Exception e) {
                Log.e("Fail 2", e.toString());
            }

            try {
                JSONObject json_data = new JSONObject(result);
                 wordEnglishText = (json_data.getString("wordEnglish"));
                defenitionEnglishText = (json_data.getString("defenitionEnglish"));
                wordRussianText = (json_data.getString("wordRussian"));
                defenitionRussianText = (json_data.getString("defenitionRussian"));
                wordChinaText = (json_data.getString("wordChina"));
                defenitionChinaText = (json_data.getString("defenitionChina"));
                wordJapanText = (json_data.getString("wordJapan"));
                defenition_JapanText = (json_data.getString("defenition_Japan"));
                Log.e("pass 3", defenitionEnglishText);

            } catch (Exception e) {
                Log.e("Fail 3", e.toString());
            }


            String words[] = new String[8];
            words[0] = defenitionEnglishText;
            words[1] = wordRussianText;
            words[2] = defenitionRussianText;
            words[3] = wordChinaText;
            words[4] = defenitionChinaText;
            words[5] = wordJapanText;
            words[6] = defenition_JapanText;
            words[7] = wordEnglishText;


            return words;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);



        }

        @Override
        protected void onPostExecute(String[] result) {
            super.onPostExecute(result);
            delegate.processFinish(result);


        }

    }

