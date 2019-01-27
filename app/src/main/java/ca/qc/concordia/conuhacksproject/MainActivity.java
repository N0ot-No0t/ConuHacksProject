package ca.qc.concordia.conuhacksproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    int radioButtonId;
    String serverURL = "http://172.30.17.249/update_info.php";
    //String serverURL = "http://localhost/update_info.php";
    AlertDialog.Builder builder;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        builder = new AlertDialog.Builder(MainActivity.this);

        final TextView inputName = ((TextView)findViewById(R.id.inputTextName));
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

                        Toast.makeText(getApplicationContext(), "Selected button number " + index + 1, Toast.LENGTH_LONG).show();
                        break;
                    case 1: // second button

                        radioButtonId = 1;

                        Toast.makeText(getApplicationContext(), "Selected button number " + index + 1, Toast.LENGTH_LONG).show();
                        break;

                    case 2: // third button

                        radioButtonId = 2;

                        Toast.makeText(getApplicationContext(), "Selected button number " + index + 1, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

        //radioButtonId = rgMainScreen.getCheckedRadioButtonId();

        System.out.println(radioButtonId);

        RadioButton buttonChosen = ((RadioButton)findViewById(radioButtonId));

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = null;

                try{
                    userName = inputName.getText().toString();

                    //System.out.println(userName);
                }catch (Exception ex){

                    userName = "Invalid Name";

                }


                switch (radioButtonId){

                    case 0:

                        intent = new Intent(MainActivity.this, ManagerMenu.class);

                        break;

                    case 1:

                        intent = new Intent(MainActivity.this, AssistantMenu.class);


                        break;

                    case 2:

                        intent = new Intent(MainActivity.this, TalkerMenu.class);

                        break;

                }

                StringRequest stringRequest = new StringRequest(Request.Method.POST, serverURL,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                builder.setTitle("Server Response");
                                builder.setMessage("Response: "+response);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        inputName.setText("");

                                    }
                                });

                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();

                            }
                        }
                        , new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(MainActivity.this, "Error on response",Toast.LENGTH_SHORT).show();
                        error.printStackTrace();

                    }
                }){

                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("userName",userName);
                        return params;
                    }
                };

                int socketTimeout = 30000; // 30 seconds. You can change it
                RetryPolicy policy = new DefaultRetryPolicy(socketTimeout,
                        DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);

                stringRequest.setRetryPolicy(policy);

                MySingleton.getInstance(MainActivity.this).addToRequestQueue(stringRequest);




                startActivity(intent);
            }
        });




    }
}
