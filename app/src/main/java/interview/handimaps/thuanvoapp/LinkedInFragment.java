package interview.handimaps.thuanvoapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple LinkedInFragment subclass.
 */
@SuppressLint("SetJavaScriptEnabled")
public class LinkedInFragment extends Fragment {


    public LinkedInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_linkedin, container, false);

        // Codes are learned from Android Tutorial (https://www.tutorialspoint.com)
        WebView webView = view.findViewById(R.id.webView);
        webView.setWebViewClient(new ViewSubUrl());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl("https://www.linkedin.com/in/thuan-vo-314333b3/"); //target url


        return view;
    }

    // Navigate to all sub urls
    private class ViewSubUrl extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
