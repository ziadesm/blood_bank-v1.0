package echomachine.com.bloodbank_v1.ui.demo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import echomachine.com.bloodbank_v1.R;
import echomachine.com.bloodbank_v1.pojo.DemoModel;

public class ViewPagerItemFragment extends Fragment {
    private ImageView imageView;
    private TextView textView;

    private DemoModel mPage;
    public static final String DEMO_KEY = "demo";

    public static ViewPagerItemFragment getInstance(DemoModel demoModel) {
        ViewPagerItemFragment fragment = new ViewPagerItemFragment();
        if (demoModel != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEMO_KEY, demoModel);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getParcelable(DEMO_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater
            , @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_item_pager
                        , container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageView = view.findViewById(R.id.fragment_demo_item_pager_iv);
        textView = view.findViewById(R.id.fragment_demo_item_pager_tv);
        init();
    }

    private void init() {
        if (mPage != null) {
            textView.setText(mPage.getText());
            RequestOptions options = new RequestOptions();
            Glide.with(getActivity())
                    .setDefaultRequestOptions(options)
                    .load(mPage.getImage())
                    .into(imageView);
        }
    }
}
