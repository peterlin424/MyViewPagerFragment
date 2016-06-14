package project.peter.com.myviewpagerfragment.tabhost;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by linweijie on 6/14/16.
 */
public class FakeTabContent implements TabHost.TabContentFactory {

    private Context context;
    public FakeTabContent(Context context) {
        this.context = context;
    }

    @Override
    public View createTabContent(String tag) {

        View fakeView = new View(context);
        fakeView.setMinimumHeight(0);
        fakeView.setMinimumWidth(0);
        return fakeView;
    }
}
