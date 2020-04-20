package com.mirio.skincare;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.mirio.skincare.Info.InfoFragment;
import com.mirio.skincare.Log.LogFragment;
import com.mirio.skincare.Products.ProductSearchFragment;
import com.mirio.skincare.Products.WishlistFragment;
import com.mirio.skincare.ProfileQuiz.ProfileFragment;
import com.mirio.skincare.SkinCareRoutine.RoutineFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawer;
    protected FragmentManager fragmentManager;
    private NavigationView navView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);

    //adds menu icon to the task bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    // Sets the profile as the first fragment when the app is opened
        if(savedInstanceState == null){
            fragmentManager.beginTransaction().replace(R.id.frag_container, new ProfileFragment()).commit();
            navView.setCheckedItem(R.id.nav_profile);
        }


    }

    @Override
    public void onBackPressed() {
    //Closes the drawer menu if its open
        if(drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
    // Goes back to the last accessed fragment
        else if (fragmentManager.getBackStackEntryCount() > 1)
            fragmentManager.popBackStack();
        else super.onBackPressed();
    }

    /**
     * Binds each menu item to its corresponding fragment.
     * @param menuItem The menu item that has been pressed.
     * @return
     */
    @Override
    public boolean onNavigationItemSelected( MenuItem menuItem) {
        switch(menuItem.getItemId()){
            case R.id.nav_profile:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new ProfileFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_products_skin:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new ProductSearchFragment(true)).addToBackStack(null).commit();
                break;
            case R.id.nav_products_makeup:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new ProductSearchFragment(false)).addToBackStack(null).commit();
                break;
            case R.id.nav_log:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new LogFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_info:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new InfoFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_wishlist:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new WishlistFragment()).addToBackStack(null).commit();
                break;
            case R.id.nav_routine:
                fragmentManager.beginTransaction().replace(R.id.frag_container, new RoutineFragment()).addToBackStack(null).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public FragmentManager getFragManager(){return fragmentManager;}

}
