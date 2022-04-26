package ru.mirea.utts.mireaproject.ui.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

import ru.mirea.utts.mireaproject.R;


public class WebFragment extends Fragment {
    private WebView webView;
    private EditText searchInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web, container, false);
        view.findViewById(R.id.search_button).setOnClickListener(this::onSearchButtonClick);

        searchInput = (EditText) view.findViewById(R.id.url_input);
        webView = (WebView) view.findViewById(R.id.web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.com/");
        return view;
    }

    private void onSearchButtonClick(View view){
        String searchText = "https://"+ searchInput.getText().toString();
        webView.loadUrl(searchText);
    }
}