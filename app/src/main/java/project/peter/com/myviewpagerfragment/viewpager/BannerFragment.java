package project.peter.com.myviewpagerfragment.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import project.peter.com.myviewpagerfragment.R;

/**
 * Created by linweijie on 6/14/16.
 */
public class BannerFragment extends Fragment {

    private Context context;
    private int picId;

    public BannerFragment() {}

    public void setParams(Context context, int picId){
        this.context = context;
        this.picId = picId;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_banner, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ImageView binner = (ImageView) getView().findViewById(R.id.banner);
        binner.setImageResource(picId);
    }
}
