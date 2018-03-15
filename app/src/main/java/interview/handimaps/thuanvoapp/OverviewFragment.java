package interview.handimaps.thuanvoapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple OverviewFragment subclass.
 */
public class OverviewFragment extends Fragment {


    public OverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);

        // Use PDF Viewer library
        // From this link https://github.com/barteksc/AndroidPdfViewer
        PDFView projectView =  view.findViewById(R.id.projectView);
        projectView.fromAsset("TVProject.pdf").load();
        return view;
    }

}
