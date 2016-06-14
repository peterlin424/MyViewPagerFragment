package project.peter.com.myviewpagerfragment.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by linweijie on 6/14/16.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> listFrags;

    public MyViewPagerAdapter(FragmentManager supportFragmentManager, List<Fragment> listFrags) {
        super(supportFragmentManager);

        this.listFrags = listFrags;
    }

    @Override
    public Fragment getItem(int position) {

        return listFrags.get(position);
    }

    @Override
    public int getCount() {
        return listFrags.size();
    }
}
