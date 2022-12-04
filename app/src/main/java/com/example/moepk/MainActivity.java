package com.example.moepk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    public FragmentManager fm = getSupportFragmentManager();
    public FragmentTransaction ft = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // when search button clicked, open the pop up menu

    public void onSearch(View v) {

        PopupMenu SOP = new PopupMenu(this, v);
        SOP.setOnMenuItemClickListener(this);
        SOP.inflate(R.menu.searchpopup);
        SOP.show();
    }

    // Does things depending on what option was selected

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int searchPopup = item.getItemId();

        switch (searchPopup) {
            case R.id.optionLink:
                linkSearch lsf = new linkSearch();
                ft.add(R.id.linkFrame, lsf, "enterlink");
                ft.commit();
                break;
            case R.id.optionFile:
                Log.d("File", "pressed");
                break;
            default:
                return false;
        }
        return true;
    }

}
