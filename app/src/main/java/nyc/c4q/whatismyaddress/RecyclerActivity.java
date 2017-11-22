package nyc.c4q.whatismyaddress;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

import nyc.c4q.whatismyaddress.controller.DisplayAdapter;

public class RecyclerActivity extends AppCompatActivity {
    private ArrayList prefEntries;
    private String sharedPrefExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        if (getIntent().hasExtra("sharedprefs")) {
            sharedPrefExtra = getIntent().getExtras().getString("sharedprefs");

        }
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefExtra, MODE_PRIVATE);
        //googled from stack overflow
        Map<String, ?> allEntries = sharedPreferences.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            prefEntries.add(entry.getValue());
        }
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_activity_recyclerview);
        DisplayAdapter displayAdapter = new DisplayAdapter(prefEntries);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());


        recyclerView.setAdapter(displayAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);


    }
}
