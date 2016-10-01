package com.example.user.viewpager;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.viewpagerindicator.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager; //Создаем экземпляр типа viewpager
    CustomAdapter  customAdapter; //Создаем экземпляр типа CustomAdapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //Вызываем базовый метод onCreate, чтобы задать начальную установку парметров
        setContentView(R.layout.activity_main); //устанавливает содержимое Activity из layout-файла

        viewPager=(ViewPager)findViewById(R.id.pager); //метод findViewById,  чтобы по ID получить объект соответствующий какому-либо View-элементу
        customAdapter=new CustomAdapter(this); // создаем объект типа CustomAdapter
        viewPager.setAdapter(customAdapter); //связывает подготовленный список с адаптером

        CirclePageIndicator circleIndicator = (CirclePageIndicator)findViewById(R.id.indicator); //получаем вью-элемент индикатор
        circleIndicator.setSnap(true); // маркировка текста
        circleIndicator.setViewPager(viewPager); // привязываем индикатор к определенному вьюпейджеру


    }
}

