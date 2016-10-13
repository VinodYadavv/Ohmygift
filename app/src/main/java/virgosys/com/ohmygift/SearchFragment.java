package virgosys.com.ohmygift;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by vinod on 12/10/16.
 */
public class SearchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        System.out.println("kkkkkkkkkkkkkk");
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        return view;

    }
}
