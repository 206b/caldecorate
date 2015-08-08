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

public class manbupsang extends ActionBarActivity {
    //////เริ่ม1 copy แอดส่วนลดตาม

    LinearLayout container,container2,discountF;
    static EditText            testhand,  field1,field2,field3,field4;
    public  Integer onstart;
    static Double   hand1,hand2,hand3,hand4,hand5;

    ///////จบ1 copy แอดส่วนลดตาม
    public Spinner spin_LTD;//spinner บริษัทขายผ้า
    public boolean  checkbox_vat4,checkbox_motor;
    static double   priceDoub4,
            wFabDoub4,
            hand1Doub4,hand2Doub4,hand3Doub4,hand4Doub4,hand5Doub4,priceHandDoub4,handTotalDoub4,
            wDoub4,hDoub4,
            motorDoub4,
            totalBht4,
            totalSquare4;

    static EditText WEdt4, HEdt4,
            wFabEdt4,
            priceEdt4,
            hand1Edt4, hand2Edt4,hand3Edt4,hand4Edt4,hand5Edt4,
            motorEdt4;
    static String WStr4, HStr4,
            wFabStr4,
            priceStr4,
            hand1Str4, hand2Str4,hand3Str4,hand4Str4,hand5Str4,
    totalSqStr4,
            totalBht4Str4,
            totalhandStr4,
            motorStr4;
    static TextView mSquareTv4,handTv4,BhtTotalTv4;
    static Button   bt_cal4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.manbupsang);
        setContentView(R.layout.activity_manbupsang);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //อ่านค่าเซตติงจากไฟล์ SharedPreferences
        // SharedPreferences sp = getSharedPreferences("PREF_NAME", Context.MODE_PRIVATE);

/////เริ่ม2 copy แอดส่วนลดตาม
        onstart=0;
        hand1 = 0.0;
        hand2 = 0.0;
        hand3 = 0.0;
        hand4 = 0.0;
        hand5 = 0.0;
///////จบ2 copy แอดส่วนลดตาม

        //เทียบตัวเปนกับ xml
        WEdt4 = (EditText) findViewById(R.id.w4);
        HEdt4 = (EditText) findViewById(R.id.h4);
        wFabEdt4 = (EditText) findViewById(R.id.fabricW_edittxt4);
        priceEdt4 = (EditText) findViewById(R.id.priceInt_edittxt4);



        mSquareTv4 = (TextView) findViewById(R.id.Msquare4);
        handTv4 = (TextView) findViewById(R.id.HandiBthPerM4);
        BhtTotalTv4 = (TextView) findViewById(R.id.BthTotal4);


        bt_cal4 = (Button) findViewById(R.id.button_cal4);


        final CheckBox c_vat4 = (CheckBox) findViewById(R.id.check_vat4);
        //ชื่อหัวข้อเอามาจาตัวแปรที่เก็บใว้ก่อนเข้าหน้านี้แล้ว

        //////เริ่ม3 copy แอดส่วนลดตาม
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


        //เมื่อกดคำนวน
        bt_cal4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                           if ((!WEdt4.getText().toString().trim().isEmpty()) &&
                           (!HEdt4.getText().toString().trim().isEmpty()) &&
                             (!wFabEdt4.getText().toString().trim().isEmpty())&&
                           (!priceEdt4.getText().toString().trim().isEmpty()) ) {


                            checkbox_vat4 = c_vat4.isChecked();

                              WStr4 = WEdt4.getText().toString();
                             HStr4 = HEdt4.getText().toString();
                              wFabStr4 = wFabEdt4.getText().toString();
                              priceStr4 = priceEdt4.getText().toString();


                               wDoub4 = Double.parseDouble(WStr4);
                                  hDoub4 = Double.parseDouble(HStr4);
                             wFabDoub4 = Double.parseDouble(wFabStr4);
                                  priceDoub4 = Double.parseDouble(priceStr4);


                                              //หาพื้นที่
                             totalSquare4=wDoub4*hDoub4;


                               //////เริ่ม4 copy แอดส่วนลดตาม
                               priceHandDoub4 = priceDoub4;

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
                               priceHandDoub4 = priceDoub4*(100-hand1)/100;
                               priceHandDoub4 = priceHandDoub4*(100-hand2)/100;
                               priceHandDoub4 = priceHandDoub4*(100-hand3)/100;
                               priceHandDoub4 = priceHandDoub4*(100-hand4)/100;
                               priceHandDoub4 = priceHandDoub4*(100-hand5)/100;

                               ///////จบ4 copy แอดส่วนลดตาม



                               totalBht4=totalSquare4*priceHandDoub4;
                                              handTotalDoub4=priceDoub4-priceHandDoub4;
                                              if (checkbox_vat4 == true) {
                                                  //คำนวน แยกภาษี
                                                  totalBht4 = totalBht4 + totalBht4 * 0.07;
                                              }

                                          }else   Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูลในช่องที่มีเครื่องหมายดอกจัน *", Toast.LENGTH_LONG).show();

                                          DecimalFormat d24 = new DecimalFormat("0.00");
                                          totalSqStr4 = d24.format(totalSquare4);
                                          totalBht4Str4 = d24.format(totalBht4);
                                          totalhandStr4 = d24.format(handTotalDoub4);

                                          mSquareTv4.setText(totalSqStr4);
                                          handTv4.setText(totalhandStr4);
                                          BhtTotalTv4.setText(totalBht4Str4);



                                      }







                                      //เมื่อกดกลับจะรีเซตค่าตัวแปรเพื่อให้ไม่มีค่าผลลัพค่างอยุ

                                      public void onBackPressed() {
                                          startActivity(new Intent(manbupsang.this, MainActivity.class));


                                      }

                                  }
        ); }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_manbupsang, menu);
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

