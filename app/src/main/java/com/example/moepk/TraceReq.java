package com.example.moepk;
import android.util.Log;

import com.google.gson.Gson;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class TraceReq {

    String resp;
    OkHttpClient client = new OkHttpClient();
    Request getRequest = new Request.Builder()
            .url("https://api.trace.moe/search?url=")
            .build();

    public void getInfo() {
        try {
            Response response = client.newCall(getRequest).execute();
            resp = response.body().string();
            Log.d("response", resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
