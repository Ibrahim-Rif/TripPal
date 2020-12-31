package com.example.trippal.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.trippal.HelperClasses.HomeAdapter.CategoriesAdapter;
import com.example.trippal.HelperClasses.HomeAdapter.CategoriesHelperClass;
import com.example.trippal.HelperClasses.HomeAdapter.FeaturedAdpater;
import com.example.trippal.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.trippal.HelperClasses.HomeAdapter.MostAdapter;
import com.example.trippal.HelperClasses.HomeAdapter.MostHelperClass;
import com.example.trippal.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    //Variable
    static final float END_SCALE = 0.7f;
    RecyclerView featuredRecycler, mostViewRecycler, categoriesViewRecycler;
    RecyclerView.Adapter adapter;
    private GradientDrawable gradient1, gradient2, gradient3, gradient4;
    ImageView menuIcon;
    LinearLayout contentView;
    Button mapBtn;

    //Drawer Menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView( R.layout.activity_user_dashboard );
        //Hooks
        featuredRecycler = findViewById( R.id.featured_recycler );
        mostViewRecycler = findViewById( R.id.most_recycler );
        categoriesViewRecycler = findViewById( R.id.categories_recycler );
        menuIcon = findViewById( R.id.menu_icon );
        contentView = findViewById( R.id.content );


       // mapBtn = findViewById( R.id.map_id );

        //Menu Hooks
        drawerLayout = findViewById( R.id.drawer_layout );
        navigationView = findViewById( R.id.navigation_view );


        navigationDrawer();


        //Recycler Views Function Calls
        featuredRecycler();
        mostViewRecycler();
        categoriesViewRecycler();
    }


    //Nnavigation Drawer Function
    private void navigationDrawer() {
        //Naviagtion Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener( this );
        navigationView.setCheckedItem( R.id.nav_home );

        menuIcon.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawerLayout.isDrawerVisible( GravityCompat.START ))
                    drawerLayout.closeDrawer( GravityCompat.START );
                else drawerLayout.openDrawer( GravityCompat.START );

            }
        } );
        animateNaviagtionDrawer();
    }

    private void animateNaviagtionDrawer() {

       // drawerLayout.setScrimColor( getResources().getColor( R.color.colorAccent ) );
        drawerLayout.addDrawerListener( new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

                //Scale the View based on current slide offset
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;

                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                //Translate the View, accounting for the scaled width

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2 ;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }


        }
        );
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible( GravityCompat.START )){
            drawerLayout.closeDrawer( GravityCompat.START );
        }else
        super.onBackPressed();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav_all_cities:
                startActivity( new Intent(getApplicationContext(),AllCities.class));
                break;
            case R.id.nav_all_pois:
                startActivity( new Intent(getApplicationContext(),AllPOIs.class));
                break;
            case R.id.nav_all_categories:
                startActivity( new Intent(getApplicationContext(),AllCategories.class));
                break;
            case R.id.nav_map:startActivity( new Intent( this, MapsActivity2.class ) );
                break;
            case R.id.nav_track:
                startActivity( new Intent( this, MapActivity.class ) );
                break;
            case R.id.nav_add_tourplan:
                startActivity( new Intent( this, TourplanActivity.class ) );
                break;
            case R.id.nav_reminder:
                startActivity( new Intent( this, ReminderActivity.class ) );
                break;
            case R.id.nav_mylocation:
                startActivity( new Intent( this, MylocationActivity.class ) );
                break;






        }
        return true;

    }



    private void mostViewRecycler() {
        mostViewRecycler.setHasFixedSize( true );
        mostViewRecycler.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false ) );
        ArrayList<MostHelperClass> mostView = new ArrayList<>();
        mostView.add( new MostHelperClass( R.drawable.add_missing_place, "Hebron", "I like this food vert much ,but its not healthy its so i dont like it sorry!!!" ) );
        mostView.add( new MostHelperClass( R.drawable.sit_back_and_relax, "Nablus", "I like this food vert much ,but its not healthy its so i dont like it sorry!!!" ) );
        mostView.add( new MostHelperClass( R.drawable.search_place, "Jerusalem", "I like this food vert much ,but its not healthy its so i dont like it sorry!!!" ) );
        mostView.add( new MostHelperClass( R.drawable.add_missing_place, "Acr", "I like this food vert much ,but its not healthy its so i dont like it sorry!!!" ) );

        adapter = new MostAdapter( mostView );
        mostViewRecycler.setAdapter( adapter );
        GradientDrawable gradient3 = new GradientDrawable( GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600} );
    }

    private void categoriesViewRecycler() {
        categoriesViewRecycler.setHasFixedSize( true );
        categoriesViewRecycler.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false ) );
        ArrayList<CategoriesHelperClass> categoriesView = new ArrayList<>();
        categoriesView.add( new CategoriesHelperClass( R.drawable.add_missing_place, "Hotales" ) );
        categoriesView.add( new CategoriesHelperClass( R.drawable.sit_back_and_relax, "Car Rntal" ) );
        categoriesView.add( new CategoriesHelperClass( R.drawable.search_place, "Jerusalem" ) );
        categoriesView.add( new CategoriesHelperClass( R.drawable.add_missing_place, "Acr" ) );
        categoriesView.add( new CategoriesHelperClass( R.drawable.add_missing_place, "Sondos" ) );

        adapter = new CategoriesAdapter( categoriesView );
        categoriesViewRecycler.setAdapter( adapter );
        GradientDrawable gradient2 = new GradientDrawable( GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600} );
    }

    private void featuredRecycler() {

        featuredRecycler.setHasFixedSize( true );
        featuredRecycler.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.HORIZONTAL, false ) );

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();

        featuredLocations.add( new FeaturedHelperClass( R.drawable.jeruslem, "Jerusalem" ) );
        featuredLocations.add( new FeaturedHelperClass( R.drawable.ramallah, "Ramallah") );
        featuredLocations.add( new FeaturedHelperClass( R.drawable.nablus, "Nablus") );
        featuredLocations.add( new FeaturedHelperClass( R.drawable.bethlehem, "Bethlehem") );
        featuredLocations.add( new FeaturedHelperClass( R.drawable.jericho, "Jericho") );
        adapter = new FeaturedAdpater( featuredLocations );
        featuredRecycler.setAdapter( adapter );
        GradientDrawable gradient1 = new GradientDrawable( GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffeff400, 0xffaff600} );
    }






    public void mappage(View view) {
        startActivity( new Intent( this, MapActivity.class ) );
        finish();
    }

    public void reminder(View view) {
        startActivity( new Intent( this, ReminderActivity.class ) );
        finish();
    }

    public void mylocation(View view) {
        startActivity( new Intent( this, MylocationActivity.class ) );
        finish();
    }

    public void tourplan(View view) {
        startActivity( new Intent( this, TourplanActivity.class ) );
        finish();
    }


}