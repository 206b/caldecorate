package com.first.tripakey.caldecorate;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

//หน้าคำนวนม้านจีบ
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Chagkanhong extends ActionBarActivity {
    /////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5;

    ///////จบ1 copy แอดส่วนลดตาม
    public Spinner spin_manmon;
    public boolean  checkbox_vat,checkbox_motor;
    static double   priceDoub,
            wFabDoub,
            weightDou,
            hand1Doub,hand2Doub,hand3Doub,hand4Doub,hand5Doub,priceHandDoub,handTotalDoub,
            wDoub,hDoub,
            motorDoub,
            totalBht,
            handtoDou,
            totalSquare,
            hlasqDou,
            numlotDou;

    static EditText WEdt, HEdt,
            weightEdt,
            wFabEdt,
            priceEdt,
            numlotEdt,
            hand1Edt, hand2Edt,hand3Edt,hand4Edt,hand5Edt,

    motorEdt;
    static String WStr;
    static String HStr;
    static String wFabStr;
    static String weightStr;
    static String showweightStr;
    static String priceStr;
    static String numlotStr;
    static String hand1Str;
    static String hand2Str;
    static String hand3Str;
    static String hand4Str;
    static String hand5Str,handtoStr;
    static String totalSqStr;
    static String totalBhtStr;
    static String totalhandStr;
    static String hlaStr;
    static char alarmTextStr;
    static String motorStr;
    static TextView mSquareTv,handTv,hlaSqTV,BhtTotalTv,weightTV,alarmTV,handtoTV;
    static Button   bt_cal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.chagkanhong);
        setContentView(R.layout.activity_chagkanhong);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //อ่านค่าเซตติงจากไฟล์ SharedPreferences
        // SharedPreferences sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);

////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
///////จบ2 copy แอดส่วนลดต
        addcom();

        //เทียบตัวเปนกับ xml

        WEdt = (EditText) findViewById(R.id.w);
        HEdt = (EditText) findViewById(R.id.h);
        wFabEdt = (EditText) findViewById(R.id.fabricW_edittxt);
        priceEdt = (EditText) findViewById(R.id.priceInt_edittxt);

        motorEdt = (EditText) findViewById(R.id.motorBht);
        numlotEdt = (EditText) findViewById(R.id.numLot);
        // weightEdt = (EditText) findViewById(R.id.weight);

        mSquareTv = (TextView) findViewById(R.id.Msquare);
        handTv = (TextView) findViewById(R.id.HandiBthPerM);
        BhtTotalTv = (TextView) findViewById(R.id.BthTotal);
        hlaSqTV  = (TextView) findViewById(R.id.HlaSquare);
        weightTV  = (TextView) findViewById(R.id.weightOut);
        alarmTV  = (TextView) findViewById(R.id.alarmOverW);
        handtoTV  = (TextView) findViewById(R.id.handtoShow);

///เริ่ม3 copy แอดส่วนลดตาม
        container = (LinearLayout)findViewById(R.id.container);
        container2= (LinearLayout)findViewById(R.id.container2);
        discountF = (LinearLayout)findViewById(R.id.discountReq);
        testhand = (EditText)findViewById(R.id.handi1_edittxt);

        testhand.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

                if (testhand.length() == 1) {
                    if (onstart == 0) {
                        onstart = 1;
                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                        field1 = (EditText) addView.findViewById(R.id.addDiscount);


                        discountF.addView(addView);
                        field1.addTextChangedListener(new TextWatcher() {
                            @Override
                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                            }

                            @Override
                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                            }

                            @Override
                            public void afterTextChanged(Editable s) {
                                if(field1.length()==1) {
                                    if (onstart == 1) {
                                        onstart = 2;
                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                        field2 = (EditText) addView.findViewById(R.id.addDiscount);
                                        discountF.addView(addView);
                                        field2.addTextChangedListener(new TextWatcher() {
                                            @Override
                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                            }

                                            @Override
                                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                                            }

                                            @Override
                                            public void afterTextChanged(Editable s) {
                                                if (field2.length() == 1) {
                                                    if (onstart == 2) {
                                                        onstart = 3;
                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                                        field3 = (EditText) addView.findViewById(R.id.addDiscount);
                                                        discountF.addView(addView);
                                                        field3.addTextChangedListener(new TextWatcher() {
                                                            @Override
                                                            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                                            }

                                                            @Override
                                                            public void onTextChanged(CharSequence s, int start, int before, int count) {

                                                            }

                                                            @Override
                                                            public void afterTextChanged(Editable s) {
                                                                if (field3.length() == 1) {
                                                                    if (onstart == 3) {
                                                                        onstart = 4;
                                                                        LayoutInflater layoutInflater2 = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                                                        final View addView = layoutInflater2.inflate(R.layout.discountfield, null);
                                                                        field4 = (EditText) addView.findViewById(R.id.addDiscount);

                                                                        discountF.addView(addView);
                                                                    }
                                                                }

                                                            }
                                                        });
                                                    }
                                                }

                                            }
                                        });

                                    }
                                }
                            }
                        });
                    }

                }

            }
        });



        ///////จบ3 copy แอดส่วนลดตาม

        bt_cal = (Button) findViewById(R.id.button_cal);


        final CheckBox c_vat = (CheckBox) findViewById(R.id.check_vat);
        //ชื่อหัวข้อเอามาจาตัวแปรที่เก็บใว้ก่อนเข้าหน้านี้แล้ว

        //เมื่อกดคำนวน
        bt_cal.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          if ((!WEdt.getText().toString().trim().isEmpty()) &&
                                                  // (!weightEdt.getText().toString().trim().isEmpty()) &&
                                                  (!HEdt.getText().toString().trim().isEmpty()) &&

                                                  (!priceEdt.getText().toString().trim().isEmpty()) ) {


                                              checkbox_vat = c_vat.isChecked();

                                              WStr = WEdt.getText().toString();
                                              HStr = HEdt.getText().toString();

                                              priceStr = priceEdt.getText().toString();
                                             // motorStr = motorEdt.getText().toString();
                                              //  numlotStr=numlotEdt.getText().toString();
                                              // weightStr=weightEdt.getText().toString();

                                              wDoub = Double.parseDouble(WStr);
                                              hDoub = Double.parseDouble(HStr);
                                              //  weightDou = Double.parseDouble(weightStr);

                                              priceDoub = Double.parseDouble(priceStr);
                                              //numlotDou = Double.parseDouble(numlotStr);
                                              // motorDoub = Double.parseDouble(motorStr);

                                              //หาพื้นที่
                                              totalSquare=(wDoub/100)*(hDoub/100);
                                              hlasqDou=(wDoub/100*1.09361)*(hDoub/100*1.09361);
                                           /*  weightDou=weightDou/1000*totalSquare;
                                              if (weightDou>2){
                                                  alarmTV.setText("***น้ำหนักเกิน 2 กก.ควรใส่สปริงผ่อนแรง");
                                              }else alarmTV.setText("      ");
*/
                                              if (!numlotEdt.getText().toString().trim().isEmpty()) {
                                                  numlotStr = numlotEdt.getText().toString();
                                                  numlotDou = Double.parseDouble(numlotStr);

                                              }else numlotDou=1;


                                              ////เริ่ม4 copy แอดส่วนลดตาม
                                              priceHandDoub=priceDoub;
                                              switch (onstart){
                                                  case 0:
                                                      if (!testhand.getText().toString().trim().isEmpty()){
                                                          hand1=Double.parseDouble(testhand.getText().toString());
                                                      }
                                                      break;
                                                  case 1:
                                                      if (!testhand.getText().toString().trim().isEmpty()){
                                                          hand1=Double.parseDouble(testhand.getText().toString());
                                                      }
                                                      if (!field1.getText().toString().trim().isEmpty()){
                                                          hand2=Double.parseDouble(field1.getText().toString());
                                                      }
                                                      break;
                                                  case 2:
                                                      if (!testhand.getText().toString().trim().isEmpty()){
                                                          hand1=Double.parseDouble(testhand.getText().toString());
                                                      }
                                                      if (!field1.getText().toString().trim().isEmpty()){
                                                          hand2=Double.parseDouble(field1.getText().toString());
                                                      }
                                                      if (!field2.getText().toString().trim().isEmpty()){
                                                          hand3=Double.parseDouble(field2.getText().toString());
                                                      }
                                                      break;
                                                  case 3:
                                                      if (!testhand.getText().toString().trim().isEmpty()){
                                                          hand1=Double.parseDouble(testhand.getText().toString());
                                                      }
                                                      if (!field1.getText().toString().trim().isEmpty()){
                                                          hand2=Double.parseDouble(field1.getText().toString());
                                                      }
                                                      if (!field2.getText().toString().trim().isEmpty()){
                                                          hand3=Double.parseDouble(field2.getText().toString());
                                                      }
                                                      if (!field3.getText().toString().trim().isEmpty()){
                                                          hand4=Double.parseDouble(field3.getText().toString());
                                                      }
                                                      break;
                                                  case 4:
                                                      if (!testhand.getText().toString().trim().isEmpty()){
                                                          hand1=Double.parseDouble(testhand.getText().toString());
                                                      }
                                                      if (!field1.getText().toString().trim().isEmpty()){
                                                          hand2=Double.parseDouble(field1.getText().toString());
                                                      }
                                                      if (!field2.getText().toString().trim().isEmpty()){
                                                          hand3=Double.parseDouble(field2.getText().toString());
                                                      }
                                                      if (!field3.getText().toString().trim().isEmpty()){
                                                          hand4=Double.parseDouble(field3.getText().toString());
                                                      }
                                                      if (!field4.getText().toString().trim().isEmpty()){
                                                          hand5=Double.parseDouble(field4.getText().toString());
                                                      }
                                                      break;
                                              }
                                              priceHandDoub = priceDoub*(100-hand1)/100;
                                              priceHandDoub = priceHandDoub*(100-hand2)/100;
                                              priceHandDoub = priceHandDoub*(100-hand3)/100;
                                              priceHandDoub = priceHandDoub*(100-hand4)/100;
                                              priceHandDoub = priceHandDoub*(100-hand5)/100;

                                              ///////จบ4 copy แอดส่วนลดต


                                              totalBht= (totalSquare*priceHandDoub)*numlotDou ;

                                              if (checkbox_vat == true) {
                                                  //คำนวน แยกภาษี
                                                  totalBht = totalBht + totalBht * 0.07;
                                                  priceHandDoub = priceHandDoub+priceHandDoub*0.07;
                                              }
                                              handtoDou= priceDoub-priceHandDoub;

                                          }else                 Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูลในช่องที่มีเครื่องหมายดอกจัน *", Toast.LENGTH_LONG).show();

                                          DecimalFormat d2 = new DecimalFormat("0.00");
                                          totalSqStr = d2.format(totalSquare);
                                          totalBhtStr = d2.format(totalBht);
                                          totalhandStr = d2.format(priceHandDoub);
                                          hlaStr = d2.format(hlasqDou);
                                          //   showweightStr=d2.format(weightDou);
                                          handtoStr=d2.format(handtoDou);

                                          mSquareTv.setText(totalSqStr);
                                          handTv.setText(totalhandStr);
                                          BhtTotalTv.setText(totalBhtStr);
                                          hlaSqTV.setText(hlaStr);
                                          // weightTV.setText(showweightStr);
                                          handtoTV.setText(handtoStr);

                                      }

                                      public void onBackPressed() {
                                          startActivity(new Intent(Chagkanhong.this, MainActivity.class));

                                          priceDoub=0;
                                          wFabDoub=0;
                                          weightDou=0;
                                          hand1Doub=0;
                                          hand2Doub=0;
                                          hand3Doub=0;
                                          hand4Doub=0;
                                          hand5Doub=0;
                                          priceHandDoub=0;
                                          handTotalDoub=0;
                                          wDoub=0;
                                          hDoub=0;
                                          motorDoub=0;
                                          totalBht=0;
                                          handtoDou=0;
                                          totalSquare=0;
                                          hlasqDou=0;
                                          numlotDou=0;



                                      }

                                  }
        );
    }
    public void addcom(){
        spin_manmon =(Spinner)findViewById(R.id.manmonSpin);
        List<String> list = new ArrayList<String>();
        list.add("ผ้าม่านเมืองทอง");
        list.add("ผ้าม่านเมืองเงิน");
        list.add("ผ้าม่านเมืองทองแดง");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_manmon.setAdapter(dataAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_chagkanhong, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.man:
                final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
                alertDialog.setTitle("Ezekiel 25:17");

                alertDialog.setMessage("\"The path of the righteous man is beset on all sides by the iniquities of the selfish and the tyranny of evil men.\n" +
                        "Blessed is he who, in the name of charity and good will, shepherds the weak through the valley of darkness, for he is truly his brother's keeper and the finder of lost children.\n" +
                        "And I will strike down upon thee with great vengeance and furious anger those who attempt to poison and destroy my brothers. And you will know my name is the Lord when I lay my vengeance upon thee.\"");
                alertDialog.show();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

