package echomachine.com.bloodbank_v1.pojo;

import echomachine.com.bloodbank_v1.R;

public class DemoModelList {
    public static DemoModel[] getAllPages() {
        return ALL_PAGES;
    }
    public static final DemoModel FIRST_FRAGMENT = new DemoModel(R.drawable.demo_fragment_first_item, "First Item");
    public static final DemoModel SECOND_FRAGMENT = new DemoModel(R.drawable.demo_fragment_second_item, "Second Item");
    public static final DemoModel THIRD_FRAGMENT = new DemoModel(R.drawable.demo_fragment_first_item, "Third Item");
    public static final DemoModel[] ALL_PAGES = {FIRST_FRAGMENT, SECOND_FRAGMENT, THIRD_FRAGMENT};
}
