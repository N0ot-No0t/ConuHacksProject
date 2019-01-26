package ca.qc.concordia.conuhacksproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        TextView intputName = ((TextView)findViewById(R.id.inputTextName));
        RadioButton buttonManager = ((RadioButton)findViewById(R.id.buttonManager));
        RadioButton buttonAssistant = ((RadioButton)findViewById(R.id.buttonAssistant));
        RadioButton buttonTalker = ((RadioButton)findViewById(R.id.buttonTalker));

        ImageButton buttonSubmit = ((ImageButton)findViewById(R.id.btnSubmit));

        RadioGroup rgMainScreen = ((RadioGroup)findViewById(R.id.btnGrpUser));

        final int radioButtonId = rgMainScreen.getCheckedRadioButtonId();

        System.out.println(radioButtonId);

        RadioButton buttonChosen = ((RadioButton)findViewById(radioButtonId));

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                switch (radioButtonId){

                    case R.id.buttonManager:



                        break;

                    case R.id.buttonAssistant:



                        break;

                    case R.id.buttonTalker:

                        Intent intent = new Intent(MainActivity.this, TalkerMenu.class);
                        startActivity(intent);

                        break;

                }
            }
        });




    }
}
