package interview.handimaps.thuanvoapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.barteksc.pdfviewer.PDFView;


/**
 * A CoverLetterFragment subclass.
 */
public class CoverLetterFragment extends Fragment {


    public CoverLetterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cover_letter, container, false);

        // Use PDF Viewer library
        // From this link https://github.com/barteksc/AndroidPdfViewer
        PDFView pdfCoverLetter = view.findViewById(R.id.pdfCoverLetter);
        pdfCoverLetter.fromAsset("CoverLetter.pdf").load();
        return view;
    }

}
