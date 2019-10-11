package com.example.fruits;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GrapeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grape);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("locals",MODE_PRIVATE);
        boolean  local=sharedPreferences.getBoolean("local",false);
        final TextView textView=findViewById(R.id.grape_name);
        final ImageView imageView=findViewById(R.id.grape_capital);

        if(local){
            textView.setText(getString(R.string.list_grape_name_local));
            imageView.setImageResource(R.drawable.g_ch);
        }else{
            textView.setText(getString(R.string.list_grape_name));
            imageView.setImageResource(R.drawable.g);
        }
    }
}
