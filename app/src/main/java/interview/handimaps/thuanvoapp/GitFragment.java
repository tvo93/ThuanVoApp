package interview.handimaps.thuanvoapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple GitFragment subclass.
 */
@SuppressLint("SetJavaScriptEnabled")
public class GitFragment extends Fragment {


    public GitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_git, container, false);

        // Codes are learned from Android Tutorial (https://www.tutorialspoint.com)
        WebView webGitView = view.findViewById(R.id.webGitView);
        webGitView.setWebViewClient(new ViewSubUrl());
        webGitView.getSettings().setLoadsImagesAutomatically(true);
        webGitView.getSettings().setJavaScriptEnabled(true);
        webGitView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webGitView.loadUrl("https://github.com/tvo93"); //target url
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
