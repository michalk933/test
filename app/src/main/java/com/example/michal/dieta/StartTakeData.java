package com.example.michal.dieta;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class StartTakeData extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_start_take_data);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Configuration cnof = getResources().getConfiguration();
        if(cnof.orientation == Configuration.ORIENTATION_LANDSCAPE ){

            welcomescrean w = new welcomescrean();
            ft.replace(android.R.id.content,w);


        }else{



            TakeName n = new TakeName();
            ft.replace(android.R.id.content,n);
        }
        ft.commit();




    }


    public void pause() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),"metoda",Toast.LENGTH_SHORT).show();

            }
        }, 2000);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_take_data, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void golisner(View view) {

        if(view.getId() == R.id.buttonJeden) {
            EditText edJeden = (EditText)findViewById(R.id.edname);
            EditText edDwa = (EditText)findViewById(R.id.ednazwisko);
            String s = edJeden.getText().toString() +" / " + edDwa.getText().toString();

            Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();



            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();


            welcomescrean w = new welcomescrean();
            ft.replace(android.R.id.content, w);

            ft.commit();
        }else if(view.getId() == R.id.buttonDwa){

            Toast.makeText(getApplicationContext(),"hura!",Toast.LENGTH_SHORT).show();
        }

    }
}
