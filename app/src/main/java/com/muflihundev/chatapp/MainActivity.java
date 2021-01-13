package com.muflihundev.chatapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.muflihundev.chatapp.databinding.ActivityMainBinding;
import com.muflihundev.chatapp.menu.ChatsFragment;
import com.muflihundev.chatapp.menu.ContactFragment;
import com.muflihundev.chatapp.menu.StatusFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setUpViewPager(binding.viewPager);
        binding.tabLayout.setupWithViewPager(binding.viewPager);
        setSupportActionBar(binding.toolbar);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeFabIcon(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changeFabIcon(final int index) {
        binding.fabAction.hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (index)
                {
                    case 0:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_chat_24));
                        break;
                    case 1:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_camera_alt_24));
                        break;
                    case 2:
                        binding.fabAction.setImageDrawable(getDrawable(R.drawable.ic_baseline_call_24));
                        break;
                }
                binding.fabAction.show();
            }
        },400);
    }

    private void setUpViewPager (ViewPager viewPager){
        MainActivity.SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ChatsFragment(),"Chats");
        adapter.addFragment(new StatusFragment(),"Status");
        adapter.addFragment(new ContactFragment(),"Contacts");

        viewPager.setAdapter(adapter);
    }
    private static class SectionsPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            fragmentTitleList.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.menu_search:
                Toast.makeText(this,"Search",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_options:
                Toast.makeText(this,"Options",Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}