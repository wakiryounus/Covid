package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

import k.wakir.covid.adapters.IndiaListAdapter;
import k.wakir.covid.models.ContinentList;
import k.wakir.covid.models.IndiaList;

public class IndiaActivity extends AppCompatActivity implements IndiaListAdapter.OnStateClickListener {
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private Context mContext = IndiaActivity.this;

    private ArrayList<IndiaList> mIndiaLists;
    private RequestQueue mRequestQueue;

    private String mStateName, mTotal, mActive, mDeath, mCured;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india);
        mProgressBar = findViewById(R.id.progressbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mIndiaLists = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        mRequestQueue = Volley.newRequestQueue(mContext);
        parseJSON();
    }
    private void parseJSON(){
        String url = "https://covid-19india-api.herokuapp.com/v2.0/state_data";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                   JSONObject stateArray = response.getJSONObject(1);
                   JSONArray stateData = stateArray.getJSONArray("state_data");
                    for (int i = 0; i < stateData.length(); i++){
                        JSONObject jsonObject = stateData.getJSONObject(i);
                        mStateName = jsonObject.getString("state");
                        mTotal =  jsonObject.getString("confirmed");
                        mCured =  jsonObject.getString("recovered");
                        mActive =  jsonObject.getString("active");
                        mDeath =  jsonObject.getString("deaths");
                        IndiaList indiaList = new IndiaList();
                        indiaList.setName(mStateName);
                        indiaList.setActive(mActive);
                        indiaList.setCured(mCured);
                        indiaList.setDeath(mDeath);
                        indiaList.setTotal(mTotal);
                        mIndiaLists.add(indiaList);
                    }
//                    HashSet<IndiaList> removed = new HashSet<>(mIndiaLists);
//                    ArrayList<IndiaList> lastList = new ArrayList<>(removed);
                    IndiaListAdapter adapter = new IndiaListAdapter(mContext, mIndiaLists, IndiaActivity.this);
                    mRecyclerView.setAdapter(adapter);
                    mProgressBar.setVisibility(View.GONE);
                } catch (Exception e) {
                    e.printStackTrace();
                    mProgressBar.setVisibility(View.GONE);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }




    @Override
    public void onStateClick(int position) {
        IndiaList indiaList = mIndiaLists.get(position);
        Intent intent = new Intent(mContext, IndiaDetailActivity.class);
        intent.putExtra(getString(R.string.indian_state_name),"State Name : "+ indiaList.getName());
        intent.putExtra(getString(R.string.indian_active),"Active : "+ indiaList.getActive());
        intent.putExtra(getString(R.string.indian_death),"Deaths : "+ indiaList.getDeath());
        intent.putExtra(getString(R.string.indian_recovered),"Recovered : "+ indiaList.getCured());
        intent.putExtra(getString(R.string.indian_total),"Confirmed : "+ indiaList.getTotal());
        startActivity(intent);
    }
}