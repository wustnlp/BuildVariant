package com.chinaums.variant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView requestUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestUrl = (TextView)findViewById(R.id.requestUrl);
        requestUrl.setText(BuildConfig.API_URL);
    }
}
