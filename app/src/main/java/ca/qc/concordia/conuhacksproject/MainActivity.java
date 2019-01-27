package ca.qc.concordia.conuhacksproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    int radioButtonId;

    ListView myListView;
    String [] workshops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);


        /*
        Resources res = getResources();

        myListView = (ListView) findViewById(R.id.myListView);
        workshops = res.getStringArray(R.array.workshops);

        myListView.setAdapter(new ArrayAdapter<String>(this, R.layout.my_listview_detail, workshops));

        */





        TextView intputName = ((TextView)findViewById(R.id.inputTextName));
        RadioButton buttonManager = ((RadioButton)findViewById(R.id.buttonManager));
        RadioButton buttonAssistant = ((RadioButton)findViewById(R.id.buttonAssistant));
        RadioButton buttonTalker = ((RadioButton)findViewById(R.id.buttonTalker));

        ImageButton buttonSubmit = ((ImageButton)findViewById(R.id.btnSubmit));

        final RadioGroup rgMainScreen = ((RadioGroup)findViewById(R.id.btnGrpUser));

        rgMainScreen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                View radioButton = rgMainScreen.findViewById(checkedId);
                int index = rgMainScreen.indexOfChild(radioButton);

                // Add logic here

                switch (index) {
                    case 0: //first button

                        radioButtonId = 0;

                        Toast.makeText(getApplicationContext(), "Selected button number " + (index + 1), Toast.LENGTH_LONG).show();
                        break;
                    case 1: // second button

                        radioButtonId = 1;

                        Toast.makeText(getApplicationContext(), "Selected button number " + (index + 1), Toast.LENGTH_LONG).show();
                        break;

                    case 2: // third button

                        radioButtonId = 2;

                        Toast.makeText(getApplicationContext(), "Selected button number " + (index + 1), Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        //radioButtonId = rgMainScreen.getCheckedRadioButtonId();

        System.out.println(radioButtonId);

        RadioButton buttonChosen = ((RadioButton)findViewById(radioButtonId));

        String google = "https://www.google.ca/";
        Uri webaddress = Uri.parse(google);

        //intent = new Intent(MainActivity.this, ManagerMenu.class);

        final Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webaddress);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;

                outerloop:
                switch (radioButtonId){

                    case 0:



                        startActivity(goToGoogle);
                        break outerloop;

                    case 1:

                        intent = new Intent(MainActivity.this, AssistantMenu.class);

                        break;



                    case 2:

                        startActivity(goToGoogle);
                        break outerloop;

                        //intent = new Intent(MainActivity.this, TalkerMenu.class);

                        //break;

                }


                //myListView.removeView(v);
                    try {
                        startActivity(intent);
                    }catch (Exception e){

                    }

            }
        });




    }
}
