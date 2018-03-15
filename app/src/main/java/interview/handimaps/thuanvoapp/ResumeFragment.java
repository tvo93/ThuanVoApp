package interview.handimaps.thuanvoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;


/**
 * A simple ResumeFragment subclass.
 */
public class ResumeFragment extends Fragment {

    public ResumeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        // Use PDF Viewer library
        // From this link https://github.com/barteksc/AndroidPdfViewer
        PDFView myPdfView =  view.findViewById(R.id.pdfView);
        myPdfView.fromAsset("Resume_App.pdf").load();

        return view;
    }

}
