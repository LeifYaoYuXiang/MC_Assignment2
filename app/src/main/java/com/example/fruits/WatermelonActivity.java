package com.example.fruits;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WatermelonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_watermelon);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("locals",MODE_PRIVATE);
        boolean  local=sharedPreferences.getBoolean("local",false);
        final TextView textView=findViewById(R.id.watermelon_name);
        final ImageView imageView=findViewById(R.id.watermelon_capital);

        if(local){
            textView.setText(getString(R.string.list_watermelon_name_local));
            imageView.setImageResource(R.drawable.wch);
        }else{
            textView.setText(getString(R.string.list_watermelon_name));
            imageView.setImageResource(R.drawable.w);
        }
    }
}
