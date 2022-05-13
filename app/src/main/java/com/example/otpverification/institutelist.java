package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class institutelist extends AppCompatActivity {
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.skyblue));

        setContentView(R.layout.activity_institutelist);

        myListView =(ListView) findViewById(R.id.listview);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("JAIPUR ENGINEERING COLLEGE AND RESEARCH CENTRE");
        arrayList.add("BIRLA INSTITUTE OF TECHNOLOGY");
        arrayList.add("SINHGAD INSTITUTE OF BUSINESS MANAGEMENT");
        arrayList.add("MANOHARBHAI PATEL INSTITUTE OF PHARMACY, GONDIA");
        arrayList.add("YASHWANTRAO CHAVAN SCHOOL OF RURAL DEVELOPMENT");
        arrayList.add("OMDAYAL GROUP OF INSTITUITIONS");
        arrayList.add("CENTRAL TOOL ROOM & TRAINING CENTRE");
        arrayList.add("AVANTHI’S SCIENTIFIC TECHNOLOGICAL & RESEARCH ACADEMY");
        arrayList.add("SAIGANAPATHI ENGINEERING COLLEGE");
        arrayList.add("370 PALLAVAN POLYTECHNIC COLLEGE");
        arrayList.add("SVKM'S DR. BHANUBEN NANAVATI COLLEGE OF PHARMACY");
        arrayList.add("G. H. RAISONI POLYTECHNIC");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, arrayList);
        myListView.setAdapter(arrayAdapter);

    }
}