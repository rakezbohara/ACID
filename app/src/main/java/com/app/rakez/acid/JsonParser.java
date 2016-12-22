package com.app.rakez.acid;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JsonParser extends AppCompatActivity {

    TextView t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_parser);
        b1 = (Button) findViewById(R.id.fetch);
        t1 = (TextView) findViewById(R.id.resultfield);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeJsonArrayRequest();
            }
        });

    }

    private void makeJsonObjectRequest(){
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET, "http://api.androidhive.info/volley/person_object.json", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    String name = response.getString("name");
                    String email = response.getString("email");
                    JSONObject phone = response.getJSONObject("phone");
                    String home = phone.getString("home");
                    String mobile = phone.getString("mobile");

                    t1.setText(name+"\n"+email+"\n"+home+"\n"+mobile);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjReq);
    }
    private void makeJsonArrayRequest(){
        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading");
        pDialog.show();

        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, "http://api.androidhive.info/volley/person_array.json", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                String result=null;

                for(int i = 0;i<response.length();i++){
                    try {
                        JSONObject person = (JSONObject) response.get(i);
                        String name = person.getString("name");
                        String email = person.getString("email");
                        JSONObject phone = person.getJSONObject("phone");
                        String home = phone.getString("home");
                        String mobile = phone.getString("mobile");
                        result = result + name +"\n"+ email +"\n"+ home +"\n"+ mobile +"\n";

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                t1.setText(result);
                pDialog.hide();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                pDialog.hide();

            }
        });
        AppController.getInstance().addToRequestQueue(req);

    }
}
