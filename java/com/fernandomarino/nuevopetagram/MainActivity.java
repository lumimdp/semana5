package com.fernandomarino.nuevopetagram;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.fernandomarino.nuevopetagram.adapter.PageAdapter;
import com.fernandomarino.nuevopetagram.fragment.Perfil;
import com.fernandomarino.nuevopetagram.fragment.ReciclerWiev;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tabLayout = (TabLayout) findViewById(R.id.tabMascotas);
        viewPager = (ViewPager) findViewById(R.id.vpMainActivity);
        setUpViewPager();


        ActionBar ab = getSupportActionBar();

        ab.setIcon(R.mipmap.pataperro);
        ab.setDisplayShowHomeEnabled(true);


    }



private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReciclerWiev());
        fragments.add(new Perfil());

        return fragments;

}


    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mRanking:
                Intent e = new Intent(this, Ranking.class);
                startActivity(e);
                break;

            case R.id.mMenuContacto:
                Intent intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.mAcercaDe:
                Intent i = new Intent(this, AcercaDe.class);
                startActivity(i);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
