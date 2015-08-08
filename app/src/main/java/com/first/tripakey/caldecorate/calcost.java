package com.first.tripakey.caldecorate;
//หลักการตั้งตัวเปรใน java = ชนิดตัวแปร(ย่อ)_ชื่อตัวแปลนั้น
//หลักการตั้งตัวเปรใน xml  = ชื่อตัวแปลนั้น_ชนิดตัวแปร(ย่อ

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class calcost extends ActionBarActivity {



    String[] costArray = { "ค่าใช้จ่ายผ้าม่าน","ค่าใช้จ่ายผ้าบุเฟอร์นิเจอร์", "ค่าใช้จ่ายม่านม้วน","ค่าใช้จ่ายมู่ลี่ไม้/มู่ลี่โฟมวู๊ด",
            "ค่าใช้จ่ายมู่ลี่อลูมิเนียม","ค่าใช้จ่ายฉากกั้นห้อง","ค่าใช้จ่ายวอลเปเปอร์","ค่าใช้จ่ายม่านปรับแสง "};

    private ListView costListView;

    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcost);

        setTitle(R.string.titlecalcost);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        costListView  =  (ListView) findViewById(R.id.lv_cost);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, costArray);
        costListView.setAdapter(arrayAdapter);
        costListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position+1){
                    case 1:
                       startActivity(new Intent(calcost.this, cost1.class));

                        break;

                    case 2:
                        startActivity(new Intent(calcost.this, cost1_2.class));

                        break;
                    case 3:
                        startActivity(new Intent(calcost.this, cost2.class));

                        break;
                    case 4:
                        startActivity(new Intent(calcost.this, cost2_2.class));

                        break;
                    case 5:
                        startActivity(new Intent(calcost.this, cost2_3.class));

                        break;
                    case 6:
                        startActivity(new Intent(calcost.this, cost2_4.class));

                        break;
                    case 7:
                        startActivity(new Intent(calcost.this, costWallpaper.class));

                        break;
                    case 8:
                        startActivity(new Intent(calcost.this, costManbapsang.class));

                        break;


                }

            }
        });






    }





    
    @Override
    public void onBackPressed() {
        startActivity(new Intent(calcost.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_calcost, menu);
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