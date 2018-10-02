package synabro.kafuuchino;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.wonderkiln.camerakit.CameraView;

public class Main3Fragment extends Fragment {

    Toolbar m;
    Button b_cap;
    CameraView cv;

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

    @Override
    public void onResume() {
        super.onResume();
        cv.start();
    }

    @Override
    public void onPause() {
        cv.stop();
        super.onPause();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //just change the fragment_dashboard
        //with the fragment you want to inflate
        //like if the class is HomeFragment it should have R.layout.home_fragment
        //if it is DashboardFragment it should have R.layout.fragment_dashboard
        View v = inflater.inflate(R.layout.fragment_main3_camera, null);

        int resourceId = getResources().getIdentifier("design_bottom_navigation_height", "dimen", getActivity().getPackageName());
        int height = 0;
        if (resourceId > 0) {
            height = getResources().getDimensionPixelSize(resourceId);
        }
        /*
        //height in pixels
        Toast.makeText(this, height + "", Toast.LENGTH_SHORT).show();
        // if you want the height in dp
        float density = getResources().getDisplayMetrics().density;
        float dp = height / density;
        Toast.makeText(this, dp + "", Toast.LENGTH_SHORT).show();
        */
        m = v.findViewById(R.id.m3_toolbar);
        m.inflateMenu(R.menu.home3);

        m.setOnMenuItemClickListener((MenuItem item) -> {
                switch (item.getItemId()){
                    case R.id.m3_search : {

                        Toast.makeText(getContext(),"메뉴",Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Intent.ACTION_PICK);
                        i.setType("image/*");
                        startActivityForResult(i, 1);
                        return true;
                    }
                }
                return false;
        });

        m.setPadding(0,getStatusBarHeight(),0,0);
        m.setTitle("촬영해서 검색하기");

        cv = v.findViewById(R.id.camera);

        b_cap = v.findViewById(R.id.m3_camera_capture);
        ConstraintLayout.LayoutParams h = (ConstraintLayout.LayoutParams) b_cap.getLayoutParams();
        h.bottomMargin = getNavBarHeight()+height;
        b_cap.setLayoutParams(b_cap.getLayoutParams());

        return v;
    }

}
