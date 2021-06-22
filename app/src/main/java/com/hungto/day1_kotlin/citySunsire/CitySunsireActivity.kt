package com.hungto.day1_kotlin.citySunsire

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hungto.day1_kotlin.R
import kotlinx.android.synthetic.main.activity_city_sunsire.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class CitySunsireActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city_sunsire)
        btn_get.setOnClickListener {
        var code =edt_entercode.text
        var url =
            "https://freeapi.code4func.com/api/v1/food/detail/f754f617-92b1-" + code + "-b516-67f40659cd82"
        AsyncTask().execute(url)
        }
    }


    inner class AsyncTask : android.os.AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            //before start
        }

        override fun doInBackground(vararg params: String?): String {
            //call
            try {
                var url = URL(params[0])
                val urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.connectTimeout = 7000
                var inString = ConverStreamToString(urlConnection.inputStream)
                //connnot access to ui
                publishProgress(inString)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return " "
        }

        override fun onProgressUpdate(vararg values: String?) {
            super.onProgressUpdate(*values)
            try {
                var jsonObject=JSONObject(values[0])
                val code=jsonObject.getJSONObject("data")
                var description=code.getString("description")
                tv_showfoodName.text=description.toString()
            }catch (e:java.lang.Exception){
                e.printStackTrace()
            }
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            //after task done
        }

    }

    private fun ConverStreamToString(inputStream: InputStream): String {
        val bufferedReader = BufferedReader(InputStreamReader(inputStream))
        var line: String
        var AllString: String = ""
        try {
            do {
                line = bufferedReader.readLine()
                if (line != null) {
                    AllString += line
                }
            } while (line != null)
            inputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    return AllString
    }
}