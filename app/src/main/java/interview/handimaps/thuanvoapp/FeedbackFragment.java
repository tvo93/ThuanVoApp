package interview.handimaps.thuanvoapp;


import android.app.ProgressDialog;
import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;


/**
 * A simple FeedbackFragment subclass.
 */
public class FeedbackFragment extends Fragment implements View.OnClickListener{

    private ProgressDialog progressDialog;
    private RequestQueue queue;

    private final String RATING = "entry.640208087";
    private final String INFO = "entry.190290850";
    private final String EXPECT = "entry.698406629";
    private final String IMPROVE = "entry.59418628";
    private final String LIKE = "entry.300695121";
    private final String OTHER = "entry.1769431798";


    private Button submit;
    private RadioButton num1, num2, num3, yes, no;
    private EditText edtQuestion3, edtQuestion4, edtQuestion5, edtQuestion6;
    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");

        submit = view.findViewById(R.id.button);
        submit.setOnClickListener(this);

        num1 = view.findViewById(R.id.num1);
        num2 = view.findViewById(R.id.num2);
        num3 = view.findViewById(R.id.num3);
        num1.setChecked(false);
        num2.setChecked(false);
        num3.setChecked(false);

        yes = view.findViewById(R.id.yes);
        no = view.findViewById(R.id.no);
        yes.setChecked(false);
        no.setChecked(false);

        edtQuestion3 = view.findViewById(R.id.edtQuestion3);
        edtQuestion4 = view.findViewById(R.id.edtQuestion4);
        edtQuestion5 = view.findViewById(R.id.edtQuestion5);
        edtQuestion6 = view.findViewById(R.id.edtQuestion6);

        // Initializing Queue for Volley
        queue = Volley.newRequestQueue(getActivity());
        return view;
    }

    @Override
    public void onClick(View v) {
        String myNum="";
        String myAnswer="";

        if (num1.isChecked()) {
            myNum = "1";
        } else if (num2.isChecked()) {
            myNum = "2";
        } else if (num3.isChecked()) {
            myNum = "3";
        }
        if (yes.isChecked()) {
            myAnswer = "YES";
        } else if (no.isChecked()) {
            myAnswer = "NO";
        }
             postData(myNum, myAnswer,
                     edtQuestion3.getText().toString().trim(),
                     edtQuestion4.getText().toString().trim(),
                     edtQuestion5.getText().toString().trim(),
                     edtQuestion6.getText().toString().trim());
        }


    /*
     * A class that will be used to collect user's input and then post to google form entries
     */
    private void postData(final String q1, final String q2, final String q3, final String q4,
                         final String q5, final String q6) {

       // The link that will get all user inputs
        final String myURL = "https://docs.google.com/forms/d/e/1FAIpQLSfoezxqEGH7bj42q4DJlTGpfO6n7kw4VVjv9ckbEQBjtDgXzw/formResponse";
        progressDialog.show();
        StringRequest request = new StringRequest(
                Request.Method.POST,
                myURL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("TAG", "Response: " + response);
                        if (response.length() > 0) {
                            Snackbar.make(submit, "Successfully Posted", Snackbar.LENGTH_LONG).show();

                            // Reset all values after user input values
                            num1.setChecked(false);
                            num2.setChecked(false);
                            num3.setChecked(false);
                            yes.setChecked(false);
                            no.setChecked(false);
                            edtQuestion3.setText(null);
                            edtQuestion4.setText(null);
                            edtQuestion5.setText(null);
                            edtQuestion6.setText(null);
                        } else {
                            Snackbar.make(submit, "Try Again", Snackbar.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Snackbar.make(submit, "Error while Posting Data", Snackbar.LENGTH_LONG).show();
            }
        }) {


            // Putting values into google form entries
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(RATING, q1);
                params.put(INFO, q2);
                params.put(EXPECT, q3);
                params.put(IMPROVE, q4);
                params.put(LIKE, q5);
                params.put(OTHER , q6);
                return params;
            }
        };

        //set up response time
        request.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(request);
    }
}
