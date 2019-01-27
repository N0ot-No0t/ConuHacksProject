package ca.qc.concordia.conuhacksproject;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AssistantMenu extends Activity {

    ListView myListView;
    String [] workshops;
    String [] dates;
    String [] descriptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //getSupportActionBar().hide();
        setContentView(R.layout.assistant_layout);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        workshops = res.getStringArray(R.array.workshops);
        dates = res.getStringArray(R.array.dates);
        descriptions = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(AssistantMenu.this, workshops, dates, descriptions);
        myListView.setAdapter(itemAdapter);

        //Demo of the basic list working
        //myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, workshops));



    }
}
