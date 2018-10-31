package com.example.xzl.accountbook;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity implements BlankFragment.OnFragmentInteractionListener,res.OnFragmentInteractionListener,FragmentPro.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton ImBtnRem=(ImageButton) findViewById(R.id.btnrem);
        ImageButton ImBtnRes=(ImageButton) findViewById(R.id.btnres);
        ImageButton ImBtnMypro=(ImageButton) findViewById(R.id.btnmyac);
        BlankFragment FragmentFir=new BlankFragment();
        getFragmentManager().beginTransaction().replace(R.id.accounthis,FragmentFir).commit();
        ImBtnRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlankFragment FragmentRem=new BlankFragment();
                getFragmentManager().beginTransaction().replace(R.id.accounthis,FragmentRem).commit();
            }
        });
        ImBtnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res FragmentRes=new res();
                getFragmentManager().beginTransaction().replace(R.id.accounthis,FragmentRes).commit();
            }
        });
        ImBtnMypro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               FragmentPro FragmentMyPro=new FragmentPro();
                getFragmentManager().beginTransaction().replace(R.id.accounthis,FragmentMyPro).commit();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}