package com.example.fruits;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList=new ArrayList<>();
    private boolean local=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences=getSharedPreferences("locals",MODE_PRIVATE);
        local=sharedPreferences.getBoolean("local",false);

        final FloatingActionButton floatingActionButton=this.findViewById(R.id.change_language);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                local=!local;
                SharedPreferences.Editor editor=getSharedPreferences("locals",MODE_PRIVATE).edit();
                editor.putBoolean("local",local);
                editor.apply();
                final AlertDialog.Builder normalDialog = new AlertDialog.Builder(MainActivity.this);
                if(local){
                    normalDialog.setTitle("警告！");
                    normalDialog.setMessage("语言转化已经完成");
                }else{
                    normalDialog.setTitle("Warning!");
                    normalDialog.setMessage("Language Transformation has been done");
                }
                normalDialog.show();
                onResume();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        fruitList=new ArrayList<>();
        init(local);
        final ListView listView=findViewById(R.id.fruit_list);
        FruitAdapter fruitAdapter=new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(fruitAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent=new Intent(MainActivity.this,AppleActivity.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent=new Intent(MainActivity.this,LemonActivity.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent=new Intent(MainActivity.this,WatermelonActivity.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent=new Intent(MainActivity.this,BananaActivity.class);
                    startActivity(intent);
                }
                if(i==4){
                    Intent intent=new Intent(MainActivity.this,CherryActivity.class);
                    startActivity(intent);
                }
                if(i==5){
                    Intent intent=new Intent(MainActivity.this,GrapeActivity.class);
                    startActivity(intent);
                }else{
                    Log.i("INFO","LIST_CLICK_WRONG");
                }
            }
        });
    }

    private void init(boolean local){
        if(local){
            Fruit apple=new Fruit(getString(R.string.list_apple_name_local),R.drawable.apple);
            fruitList.add(apple);
            Fruit lemon=new Fruit(getString(R.string.list_lemon_name_local),R.drawable.lemon);
            fruitList.add(lemon);
            Fruit watermelon=new Fruit(getString(R.string.list_watermelon_name_local),R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit banana=new Fruit(getString(R.string.list_banana_name_local),R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry=new Fruit(getString(R.string.list_cherry_name_local),R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grapes=new Fruit(getString(R.string.list_grape_name_local),R.drawable.grapes);
            fruitList.add(grapes);
        }else{
            Fruit apple=new Fruit(getString(R.string.list_apple_name),R.drawable.apple);
            fruitList.add(apple);
            Fruit lemon=new Fruit(getString(R.string.list_lemon_name),R.drawable.lemon);
            fruitList.add(lemon);
            Fruit watermelon=new Fruit(getString(R.string.list_watermelon_name),R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit banana=new Fruit(getString(R.string.list_banana_name),R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry=new Fruit(getString(R.string.list_cherry_name),R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grapes=new Fruit(getString(R.string.list_grape_name),R.drawable.grapes);
            fruitList.add(grapes);
        }
    }


}
