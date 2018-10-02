package synabro.kafuuchino;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ResultFragment extends Fragment {


    Toolbar m;
    TextView t;

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
        View v = inflater.inflate(R.layout.fragment_main3_result, null);

        t = v.findViewById(R.id.m3r_text);

        m = v.findViewById(R.id.m3r_toolbar);
        m.inflateMenu(R.menu.home3_result);
        m.setPadding(0,getStatusBarHeight(),0,0);
        m.setTitle("첨성대");

        m.setOnMenuItemClickListener((MenuItem item) -> {
            switch (item.getItemId()){
                case R.id.m3_recap : {
                    Toast.makeText(getContext(),"다시 캡쳐 메뉴",Toast.LENGTH_SHORT).show();
                    return true;
                }
                case R.id.m3_reimage : {

                    Toast.makeText(getContext(),"다시 선택 메뉴",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(Intent.ACTION_PICK);
                    i.setType("image/*");
                    startActivityForResult(i, 1);
                    return true;
                }
            }
            return false;
        });

        t.setText("첨성대는 신라의 왕궁이 있었던 월성 북쪽에 위치하고 있다. 362개의 화강암 벽돌을 사용하여 원통형으로 축조하였다. 높이는 9.4미터, 밑면 지름 5.17m, 지대석 한 변 길이는 5.35m이다. 돌로 27층을 쌓았으며, 꼭대기에는 다시 우물 정(井) 모양의 2층의 천장돌이 있다. 13층에서 15층에 이르기까지 정남향의 네모난 문이 있고, 이 문의 아래로 12층이 있고 위로 13층이 있으므로 첨성대 위아래의 중간에 문이 위치한다. 이 문에 사다리를 걸쳐 사람이 오르내렸다. 내부에는 12단까지 흙이 채워져 있고 여기에 사용된 돌의 수는 362개이다. 내부에 19단과 20단, 25단과 26단이 장대석을 이루고 있다");

        return v;
    }

}
