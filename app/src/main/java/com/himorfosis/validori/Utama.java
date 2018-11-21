package com.himorfosis.validori;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Utama extends AppCompatActivity {

    // toolbar
    TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.utama);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbarvalidori);

        toolbarText = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.toolbartext);
        toolbarText.setText("Validori");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        if (navigation != null) {

            Menu menu = navigation.getMenu();
            pilihFragment(menu.getItem(1));

            navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    pilihFragment(item);

                    return false;
                }
            });

        }

    }

    private void pilihFragment(MenuItem item) {

        item.setChecked(true);

        switch (item.getItemId()) {

            case R.id.riwayat:
                tampilFragment(new Riwayat());
                toolbarText.setText("Riwayat");

                break;
            case R.id.validasi:
                tampilFragment(new UtamaTabValidasi());
                toolbarText.setText("Validasi");

                break;
            case R.id.tentang:
                tampilFragment(new Pengaturan());
                toolbarText.setText("Tentang");
                break;

        }

    }

    private void tampilFragment (Fragment fragment) {

        if (fragment == null)
            return;


        FragmentManager fragmentManager = getFragmentManager();

        if (fragmentManager != null) {

            FragmentTransaction ft = fragmentManager.beginTransaction();

            if(ft != null) {

                ft.replace(R.id.frame, fragment);
                ft.commit();
            }

        }

    }
}
