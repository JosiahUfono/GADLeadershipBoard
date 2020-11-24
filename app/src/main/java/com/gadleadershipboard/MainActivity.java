package com.gadleadershipboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.gadleadershipboard.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding activityMainBinding;
    String LearningLeadersbaseUrl = "https://gadsapi.herokuapp.com/api/hours",
            IqLeadersBaseUrl = "https://gadsapi.herokuapp.com/api/skilliq",
            skillsTabString = "Skill IQ Leaders", hoursTabString = "Leaning Leaders";

   // URL BaseQuery = NetworkUtils.buildUrl(BaseUrl);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        TabAdapter tabAdapter = new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new SkillsFragment(), skillsTabString);
        tabAdapter.addFragment(new HoursFragment(), hoursTabString);

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int selectedMenuItem = item.getItemId();
        if (selectedMenuItem == R.id.menu_submit_button){
            Intent intent = new Intent(this, FormActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    /*private void skillFragment() {
        SkillsFragment skillsFragment = new SkillsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, skillsFragment, "SkillFragment");
        fragmentTransaction.commit();
    }

    private void hoursFragment() {
        HoursFragment skillsFragment = new HoursFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout, skillsFragment, "hoursFragment");
        fragmentTransaction.commit();
    }*/
}