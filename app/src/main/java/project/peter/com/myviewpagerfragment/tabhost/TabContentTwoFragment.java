package project.peter.com.myviewpagerfragment.tabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import project.peter.com.myviewpagerfragment.R;

/**
 * Created by linweijie on 6/14/16.
 */
public class TabContentTwoFragment extends Fragment {

    public TabContentTwoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_tab_content, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TextView tv_content = (TextView) getView().findViewById(R.id.tv_content);
        tv_content.setText("Content Two");
    }
}
