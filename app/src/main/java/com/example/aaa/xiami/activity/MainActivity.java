package com.example.aaa.xiami.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.aaa.xiami.R;
import com.example.aaa.xiami.fragment.BbsFragment;
import com.example.aaa.xiami.fragment.HotFragment;
import com.example.aaa.xiami.fragment.MySpaceFragment;
import com.example.aaa.xiami.fragment.NewsetFragment;


public class MainActivity extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
        radioGroup.setOnCheckedChangeListener(this);

        ft = getSupportFragmentManager().beginTransaction();
        HotFragment hotFragment = new HotFragment();
        ft.add(R.id.fragment_container, hotFragment);
        ft.commit();

        getSupportActionBar().hide();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        switch (checkedId){
            case R.id.radio1:
                HotFragment hotFragment = new HotFragment();
                ft.replace(R.id.fragment_container, hotFragment);
                ft.commit();
                break;
            case R.id.radio2:
                NewsetFragment newsetFragment = new NewsetFragment();
                ft.replace(R.id.fragment_container, newsetFragment);
                ft.commit();
                break;
            case R.id.radio3:
                BbsFragment bbsFragment = new BbsFragment();
                ft.replace(R.id.fragment_container, bbsFragment);
                ft.commit();
                break;
            case R.id.radio4:
                MySpaceFragment mySpaceFragment = new MySpaceFragment();
                ft.replace(R.id.fragment_container, mySpaceFragment);
                ft.commit();
                break;
        }
    }
}
