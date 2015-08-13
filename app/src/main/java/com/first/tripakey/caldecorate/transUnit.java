package com.first.tripakey.caldecorate;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class transUnit extends ActionBarActivity {
    EditText ydEdt,mtrEdt;
    String ydStr,mtrStr;
    Double ydInt,mtrInt;
    Button transBt;
    public  TextWatcher textWatcherM,textWatcherY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans_unit);

        ydEdt =(EditText)findViewById(R.id.yd_edt);
        mtrEdt =(EditText)findViewById(R.id.mtr_edt);

          textWatcherM=new TextWatcher() {
             DecimalFormat d2 = new DecimalFormat("0.00");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!mtrEdt.getText().toString().trim().isEmpty()) ){
                    mtrStr =   mtrEdt.getText().toString();
                    mtrInt = Double.parseDouble(mtrStr);
                    mtrInt=mtrInt*1.093613298;
                    String m =d2.format(mtrInt);
                    ydEdt.removeTextChangedListener(textWatcherY);
                    ydEdt.setText(m);
                    ydEdt.addTextChangedListener(textWatcherY);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
          textWatcherY=new TextWatcher() {
              DecimalFormat d2 = new DecimalFormat("0.00");
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // TODO Auto-generated method stub
                if ((!ydEdt.getText().toString().trim().isEmpty()) ){
                    ydStr =   ydEdt.getText().toString();
                    ydInt = Double.parseDouble(ydStr);
                    ydInt=ydInt*0.9144;
                    String y =d2.format(ydInt);
                    mtrEdt.removeTextChangedListener(textWatcherM);
                    mtrEdt.setText(y);
                    mtrEdt.addTextChangedListener(textWatcherM);
                    // mtrEdt.setText(mtrStr);
                }

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        };
        ydEdt.addTextChangedListener(textWatcherY);
        mtrEdt.addTextChangedListener(textWatcherM);
      /*  transBt.setOnClickListener(new View.OnClickListener() {
            DecimalFormat d2 = new DecimalFormat("0.00");
            @Override
            public void onClick(View view) {

                if ((!ydEdt.getText().toString().trim().isEmpty()) ){
                    if ((mtrEdt.getText().toString().trim().isEmpty())){
                        Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show();
                    }else{
                     mtrStr =   mtrEdt.getText().toString();
                        mtrInt = Double.parseDouble(mtrStr);
                        mtrInt=mtrInt*1.093613298;
                        String m =d2.format(mtrInt);
                        ydEdt.setText(m);
                        mtrEdt.setText(mtrStr);
                    }

                }
                ///
                if ((!mtrEdt.getText().toString().trim().isEmpty()) ){
                    if ((ydEdt.getText().toString().trim().isEmpty())){
                        Toast.makeText(getApplicationContext(), "กรุณากรอกข้อมูล", Toast.LENGTH_LONG).show();
                    }else{
                        ydStr =   ydEdt.getText().toString();
                        ydInt = Double.parseDouble(ydStr);
                        ydInt=ydInt*0.9144;
                        String y =d2.format(ydInt);
                        mtrEdt.setText(y);
                        ydEdt.setText(ydStr);
                    }

                }

            }
        });*/
    }

}