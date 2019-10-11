package com.example.fruits;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BananaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences=getSharedPreferences("locals",MODE_PRIVATE);
        boolean  local=sharedPreferences.getBoolean("local",false);

        final TextView textView=findViewById(R.id.banana_name);
        final ImageView imageView=findViewById(R.id.banana_capital);

        if(local){
            textView.setText(getString(R.string.list_banana_name_local));
            imageView.setImageResource(R.drawable.b_ch);
        }else{
            textView.setText(getString(R.string.list_banana_name));
            imageView.setImageResource(R.drawable.b);
        }
    }
}
