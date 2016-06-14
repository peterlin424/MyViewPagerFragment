package project.peter.com.myviewpagerfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.peter.com.myviewpagerfragment.tabhost.FakeTabContent;
import project.peter.com.myviewpagerfragment.tabhost.TabContentFragment;
import project.peter.com.myviewpagerfragment.tabhost.TabContentOneFragment;
import project.peter.com.myviewpagerfragment.tabhost.TabContentThreeFragment;
import project.peter.com.myviewpagerfragment.tabhost.TabContentTwoFragment;
import project.peter.com.myviewpagerfragment.viewpager.BannerFragment;
import project.peter.com.myviewpagerfragment.viewpager.MyViewPagerAdapter;
import project.peter.com.myviewpagerfragment.viewpager.CirclePageIndicator;

public class MainActivity extends AppCompatActivity {


    private TabHost tabHost2;
    private ViewPager viewPagerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * ViewPager
         * */

        ViewPager mViewPager = (ViewPager) findViewById(R.id.main_viewpPager);

        BannerFragment banner1 = new BannerFragment();
        banner1.setParams(this, R.drawable.banner1);
        BannerFragment banner2 = new BannerFragment();
        banner2.setParams(this, R.drawable.banner2);

        List<Fragment> listFrags = new ArrayList<>();
        listFrags.add(banner1);
        listFrags.add(banner2);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager(), listFrags);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(mPageChangeListener);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.main_viewPager_indicator);
        indicator.setViewPager(mViewPager);
        indicator.setOnPageChangeListener(mPageChangeListener);

        /**
         * FragmentTabHost
         * */
        FragmentTabHost tabHost = (FragmentTabHost)findViewById(R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        tabHost.addTab(tabHost.newTabSpec("Tab1")
                        .setIndicator("Tab1"),
                TabContentOneFragment.class,
                null);
        tabHost.addTab(tabHost.newTabSpec("Tab2")
                        .setIndicator("Tab2"),
                TabContentTwoFragment.class,
                null);
        tabHost.addTab(tabHost.newTabSpec("Tab3")
                        .setIndicator("Tab3"),
                TabContentThreeFragment.class,
                null);

        /**
         * TabHost with ViewPager
         * */
        // init TabHost
        tabHost2 = (TabHost)findViewById(R.id.tabhost2);
        tabHost2.setup();
        setupTab(tabHost2, "tab1", new FakeTabContent(this));
        setupTab(tabHost2, "tab2", new FakeTabContent(this));
        setupTab(tabHost2, "tab3", new FakeTabContent(this));
        setupTab(tabHost2, "tab4", new FakeTabContent(this));
        setupTab(tabHost2, "tab5", new FakeTabContent(this));
        setupTab(tabHost2, "tab6", new FakeTabContent(this));
        setupTab(tabHost2, "tab7", new FakeTabContent(this));
        setupTab(tabHost2, "tab8", new FakeTabContent(this));
        setupTab(tabHost2, "tab9", new FakeTabContent(this));
        setupTab(tabHost2, "tab10", new FakeTabContent(this));
        tabHost2.setOnTabChangedListener(mTabChangeListener);

        // init ViewPager
        viewPagerContent = (ViewPager) findViewById(R.id.view_pager_content);

        TabContentFragment tabContent1 = new TabContentFragment();
        tabContent1.setParams(this, "tab1");
        TabContentFragment tabContent2 = new TabContentFragment();
        tabContent2.setParams(this, "tab2");
        TabContentFragment tabContent3 = new TabContentFragment();
        tabContent3.setParams(this, "tab3");
        TabContentFragment tabContent4 = new TabContentFragment();
        tabContent4.setParams(this, "tab4");
        TabContentFragment tabContent5 = new TabContentFragment();
        tabContent5.setParams(this, "tab5");
        TabContentFragment tabContent6 = new TabContentFragment();
        tabContent6.setParams(this, "tab6");
        TabContentFragment tabContent7 = new TabContentFragment();
        tabContent7.setParams(this, "tab7");
        TabContentFragment tabContent8 = new TabContentFragment();
        tabContent8.setParams(this, "tab8");
        TabContentFragment tabContent9 = new TabContentFragment();
        tabContent9.setParams(this, "tab9");
        TabContentFragment tabContent10 = new TabContentFragment();
        tabContent10.setParams(this, "tab10");

        List<Fragment> listFrags2 = new ArrayList<>();
        listFrags2.add(tabContent1);
        listFrags2.add(tabContent2);
        listFrags2.add(tabContent3);
        listFrags2.add(tabContent4);
        listFrags2.add(tabContent5);
        listFrags2.add(tabContent6);
        listFrags2.add(tabContent7);
        listFrags2.add(tabContent8);
        listFrags2.add(tabContent9);
        listFrags2.add(tabContent10);

        MyViewPagerAdapter adapter2 = new MyViewPagerAdapter(getSupportFragmentManager(), listFrags2);
        viewPagerContent.setAdapter(adapter2);
        viewPagerContent.setOnPageChangeListener(mPageChangeListener2);
    }

    private void setupTab(TabHost tabHost, String name, TabHost.TabContentFactory tf){
        View tab = LayoutInflater.from(this).inflate(R.layout.tabitem_title, null);
        TextView tv_title = (TextView) tab.findViewById(R.id.tv_tab_title);
        tv_title.setText(name);

        TabHost.TabSpec tabSpec;
        tabSpec = tabHost.newTabSpec(name);
        tabSpec.setIndicator(tab);
        tabSpec.setContent(tf);

        tabHost.addTab(tabSpec);
    }

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) { }

        @Override
        public void onPageScrollStateChanged(int state) { }
    };

    private TabHost.OnTabChangeListener mTabChangeListener = new TabHost.OnTabChangeListener() {
        @Override
        public void onTabChanged(String tabId) {
            int item = tabHost2.getCurrentTab();
            viewPagerContent.setCurrentItem(item);

            HorizontalScrollView hsv = (HorizontalScrollView) findViewById(R.id.hsv_scroll);
            View tabView = tabHost2.getCurrentTabView();
            int scrollPos = tabView.getLeft() - (hsv.getWidth() - tabView.getWidth())/2;
            hsv.smoothScrollTo(scrollPos, 0);
        }
    };

    private ViewPager.OnPageChangeListener mPageChangeListener2 = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

        @Override
        public void onPageSelected(int position) {
            tabHost2.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) { }
    };
}
