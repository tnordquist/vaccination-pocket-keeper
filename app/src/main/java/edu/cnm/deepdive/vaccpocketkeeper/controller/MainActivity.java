package edu.cnm.deepdive.vaccpocketkeeper.controller;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import edu.cnm.deepdive.vaccpocketkeeper.R;
import edu.cnm.deepdive.vaccpocketkeeper.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

  private AppBarConfiguration appBarConfiguration;
  private ActivityMainBinding binding;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    setSupportActionBar(binding.appBarMain.toolbar);
    DrawerLayout drawer = binding.drawerLayout;
    NavigationView navigationView = binding.navView;
    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    appBarConfiguration = new AppBarConfiguration.Builder(
        R.id.nav_home)//,R.id.nav_gallery, R.id.nav_slideshow//TODO: come back to this and add in other fragments
        .setDrawerLayout(drawer)
        .build();
    NavController navController = Navigation.findNavController(this,
        R.id.nav_host_fragment_content_main);
    NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    NavigationUI.setupWithNavController(navigationView, navController);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onSupportNavigateUp() {
    NavController navController = Navigation.findNavController(this,
        R.id.nav_host_fragment_content_main);
    return NavigationUI.navigateUp(navController, appBarConfiguration)
        || super.onSupportNavigateUp();
  }
}