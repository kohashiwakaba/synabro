package synabro.kafuuchino;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class HomeActivity2 extends AppCompatActivity {

    BottomNavigationView navigation;
    ConstraintLayout container;



    public int getStatusBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            result = getResources().getDimensionPixelSize(resourceId);

        return result;
    }

    public int getNavBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0)
            result = getResources().getDimensionPixelSize(resourceId);

        return result;
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container_frag, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        // AppCompact Toolbar 인스턴스 얻기
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        // Status Bar 높이만큼 Padding 부여
        //toolbar.setPadding(0, getStatusBarHeight(), 0, 0);

        setContentView(R.layout.activity_home2);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        container = findViewById(R.id.container);

        navigation.setPadding(0,0,0,getNavBarHeight());

        loadFragment(new Main2Fragment());

        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment f = null;
                switch (item.getItemId()) {
                    case R.id.home_1:
                        navigation.setItemBackgroundResource(R.color.navSearch);
                        f = new Main1Fragment();
                        break;
                    case R.id.home_3:
                        navigation.setItemBackgroundResource(R.color.navHome);
                        // TODO: 2018-09-28 replace this to Main2Fragment
                        //f = new Main2Fragment();
                        f = new ResultFragment();
                        break;
                    case R.id.home_5:
                        navigation.setItemBackgroundResource(R.color.navPic);
                        f = new Main3Fragment();
                        break;
                }
                return loadFragment(f);
            }
        });
        navigation.setSelectedItemId(R.id.home_3);
    }
}
