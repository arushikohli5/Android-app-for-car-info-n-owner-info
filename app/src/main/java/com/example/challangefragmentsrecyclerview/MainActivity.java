package com.example.challangefragmentsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CarAdapter.ItemClicked {
Button btnCar,btnOwner;
TextView tvtel,tvname,tvcarname;
ImageView ivlogo;

FragmentManager fragmentManager;
Fragment listFrag,btnFrag,carinfoFrag,ownerinfoFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCar=findViewById(R.id.btnCar);
        btnOwner=findViewById(R.id.btnOwner);
        tvcarname=findViewById(R.id.tvcarname);
        tvtel=findViewById(R.id.tvtel);
        tvname=findViewById(R.id.tvname);
        ivlogo=findViewById(R.id.ivlogo);

        fragmentManager=getSupportFragmentManager();

        listFrag=fragmentManager.findFragmentById(R.id.listFrag);
        btnFrag=fragmentManager.findFragmentById(R.id.btnFrag);
        carinfoFrag=fragmentManager.findFragmentById(R.id.carinfoFrag);
        ownerinfoFrag=fragmentManager.findFragmentById(R.id.ownerinfoFrag);

        fragmentManager.beginTransaction()
                .show(btnFrag)
                .show(listFrag)
                .show(carinfoFrag)
                .hide(ownerinfoFrag)
                .commit();
        btnOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .hide(carinfoFrag)
                        .show(ownerinfoFrag)
                        .commit();
            }
        });
        btnCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .show(carinfoFrag)
                        .hide(ownerinfoFrag)
                        .commit();
            }
        });
        OnItemClicked(0);
    }

    @Override
    public void OnItemClicked(int index) {
        tvname.setText(ApplicationClass.cars.get(index).getName());
        tvcarname.setText(ApplicationClass.cars.get(index).getCarname());
        tvtel.setText(ApplicationClass.cars.get(index).getTelno());

        if(ApplicationClass.cars.get(index).getLogo().equals("nissan")){
            ivlogo.setImageResource(R.drawable.nissan);
        }
        else if(ApplicationClass.cars.get(index).getLogo().equals("mercedes")){
            ivlogo.setImageResource(R.drawable.mercedes);
        }
        else
            ivlogo.setImageResource(R.drawable.volkswagen);
    }
}