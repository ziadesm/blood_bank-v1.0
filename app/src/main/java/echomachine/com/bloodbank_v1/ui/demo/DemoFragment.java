package echomachine.com.bloodbank_v1.ui.demo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.adapter.ViewPagerAdapter;
import echomachine.com.bloodbank_v1.pojo.DemoModel;
import echomachine.com.bloodbank_v1.pojo.DemoModelList;
import echomachine.com.bloodbank_v1.ui.login.LoginActivity;
import echomachine.com.bloodbank_v1.utils.HelperMethod;
import echomachine.com.bloodbank_v1.utils.NavigationUtils;

public class DemoFragment extends Fragment {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button finishButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        viewPager = view.findViewById(R.id.demo_fragment_vp);
        tabLayout = view.findViewById(R.id.tab_layout);
        finishButton = view.findViewById(R.id.demo_fragment_ll_finish_btn);

        finishButton.setOnClickListener(v -> NavigationUtils
                .navigateToDestinationActivity(getActivity(), LoginActivity.class));
        init();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HelperMethod.hideAllBars(getActivity());
    }

    private void init() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        DemoModel[] pages = DemoModelList.getAllPages();

        for (DemoModel model: pages){
            ViewPagerItemFragment fragment = ViewPagerItemFragment.getInstance(model);
            fragments.add(fragment);
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);
    }
}