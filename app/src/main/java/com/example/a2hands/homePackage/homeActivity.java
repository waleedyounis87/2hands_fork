package com.example.a2hands.homePackage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.example.a2hands.R;
import com.example.a2hands.SearchFragment;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homeActivity extends AppCompatActivity implements SearchFragment.OnFragmentInteractionListener, PostFragment.OnListFragmentInteractionListener,  HomeFragment.OnFragmentInteractionListener,  BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView nav;
    private int navItemId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        nav = findViewById(R.id.bottom_navigation);
        nav.setOnNavigationItemSelectedListener(this);
        BadgeDrawable badge = nav.getOrCreateBadge(nav.getMenu().getItem(3).getItemId());
        badge.setVisible(true);
        navigateHome();
    }
    public void navigateHome(){
                final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.homeFragment,new HomeFragment()).addToBackStack(null);
                ft.commit();
    }
    public void navigateSearch(){
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.homeFragment,new SearchFragment()).addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int pos =0;
        navItemId = item.getItemId();
        for (int i = 0; i < nav.getMenu().size(); i++) {
            if(navItemId == nav.getMenu().getItem(i).getItemId()){
                pos = i;
                break;
            }
        }

        switch (pos) {
            case 0: navigateHome();
                break;
            case 1:navigateSearch() ;
                break;
            case 2: ;
                break;
            case 3: ;
                break;
            case 4: ;
                break;
        }
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Post item) {

    }
}
