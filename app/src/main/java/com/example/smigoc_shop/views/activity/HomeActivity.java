package com.example.smigoc_shop.views.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.smigoc_shop.R;
import com.example.smigoc_shop.databinding.ActivityHomeBinding;
import com.example.smigoc_shop.utils.ICartListener;
import com.example.smigoc_shop.viewModel.HomeViewModel;
import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements ICartListener {

    @Override
    protected void onCreateDone(@Nullable Bundle savedInstanceState) {

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView drawer = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupWithNavController(drawer, navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.action_home)

                .setDrawerLayout(drawerLayout)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout);  //1
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);  //2
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(drawer, navController);
        drawer.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.categories:
                    startActivity(new Intent(getApplicationContext(), CategorySave.class));
                    break;
                case R.id.items:
                    startActivity(new Intent(getApplicationContext(), Itemsave.class));
                    break;
            }
            return true;
        });
    }

    @Override
    protected Class<HomeViewModel> setViewModel() {
        return HomeViewModel.class;
    }

    @Override
    protected ActivityHomeBinding setViewBinding() {
        return ActivityHomeBinding.inflate(getLayoutInflater());
    }


}
