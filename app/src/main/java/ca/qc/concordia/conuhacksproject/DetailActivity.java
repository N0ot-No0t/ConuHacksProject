package ca.qc.concordia.conuhacksproject;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    String[] workshops;
    String[] dates;
    String[] descriptions;
    String[] extraDescriptions;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent in = getIntent();
        int index = in.getIntExtra("ca.qc.concordia.ITEM_INDEX", -1);

        Resources res = getResources();
        workshops = res.getStringArray(R.array.workshops);
        dates = res.getStringArray(R.array.dates);
        descriptions = res.getStringArray(R.array.descriptions);
        extraDescriptions = res.getStringArray(R.array.extraDetails);

        if(index > -1){
            String text = getTheText(index);
            TextView textView = (TextView) findViewById((R.id.workshopDescriptionTextView));



            setContentView(textView);
        }


    }


    public String getTheText(int index) {

        switch (index) {

            case 0:
                return extraDescriptions[index];


            case 1:
                return extraDescriptions[index];

            case 2:
                return extraDescriptions[index];

            default: return "";
        }


    }

}
