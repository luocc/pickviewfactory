package com.example.administrator.pickviewfactory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> food = new ArrayList<>();
    private ArrayList<String> clothes = new ArrayList<>();
    private ArrayList<String> computer = new ArrayList<>();

    private ArrayList<String> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<String>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> options3Items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

    }

    public void initData(){
        //无联动的数据
        food.add("KFC");
        food.add("MacDonald");
        food.add("Pizza hut");
        clothes.add("Nike");
        clothes.add("Adidas");
        clothes.add("Armani");
        computer.add("ASUS");
        computer.add("Lenovo");
        computer.add("Apple");
        computer.add("HP");

        //有联动的数据
        options1Items.add("广东");
        options1Items.add("湖南");
        options1Items.add("广西");

        ArrayList<String> options2Items_01 = new ArrayList<>();
        options2Items_01.add("广州");
        options2Items_01.add("东莞");
        options2Items_01.add("珠海");
        ArrayList<String> options2Items_02 = new ArrayList<>();
        options2Items_02.add("长沙");
        options2Items_02.add("株洲");
        ArrayList<String> options2Items_03 = new ArrayList<>();
        options2Items_03.add("玉林");
        options2Items.add(options2Items_01);
        options2Items.add(options2Items_02);
        options2Items.add(options2Items_03);


        for (int i = 0; i < options2Items.size(); i++) {
            ArrayList<ArrayList<String>> options222Items = new ArrayList<>();
            for (int j = 0; j < options2Items.get(i).size(); j++) {
                ArrayList<String> str = new ArrayList<>();
                for (int k = 0; k <=2; k++) {
                    str.add(k+"");
                }
                options222Items.add(str);
            }
            options3Items.add(options222Items);
        }

    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_1:
                new PickViewFactory().showTimePickView(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(MainActivity.this, date2String(date), Toast.LENGTH_SHORT).show();
                        Log.i("pvTime", "onTimeSelect");
                    }
                });
            break;
            case R.id.btn_2:
                new PickViewFactory().showDatePickView(this, false, true, true, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(MainActivity.this, date2String(date), Toast.LENGTH_SHORT).show();
                        Log.i("pvTime", "onTimeSelect");
                    }
                });
                break;
            case R.id.btn_3:
                new PickViewFactory().showDateTimePickView(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(MainActivity.this, date2String(date), Toast.LENGTH_SHORT).show();
                        Log.i("pvTime", "onTimeSelect");
                    }
                });
                break;
            case R.id.btn_4:
                new PickViewFactory().showLunarCalendarPickView(this, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        Toast.makeText(MainActivity.this, date2String(date), Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_5:
                new PickViewFactory().showCityPickView(this, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_6:
                new PickViewFactory().showSpecialTimePickView(this, 2880, new PickViewFactory.OnSpecialTimeSelectListener() {

                    @Override
                    public void onOptionsSelect(String options1, String option1des, String options2, String options3) {
                        String tx = options1 +  option1des + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_7:
                new PickViewFactory().showOneOptionsPickView(this, food, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_8:
                new PickViewFactory().showTwoOptionsPickView(this, options1Items, options2Items, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_9:
                new PickViewFactory().showThreeOptionsPickView(this, options1Items, options2Items, options3Items, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_10:
                new PickViewFactory().showTwoOptionsNoLinkPickView(this, food, clothes, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;
            case R.id.btn_11:
                new PickViewFactory().showThreeOptionsNoLinkPickView(this, food, clothes, computer, new PickViewFactory.OnOptionsStringSelectListener() {
                    @Override
                    public void onOptionsSelect(String options1, String options2, String options3) {
                        String tx = options1 + options2 + options3;
                        Toast.makeText(MainActivity.this, tx, Toast.LENGTH_SHORT).show();
                    }
                });
                break;

        }
    }


    //可根据需要自行截取数据显示
    private String date2String(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
