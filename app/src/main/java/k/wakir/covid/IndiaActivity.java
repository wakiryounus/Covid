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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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
        String url = "https://covid19-india-adhikansh.herokuapp.com/states";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                   JSONArray stateArray = response.getJSONArray("state");
                    for (int i = 1; i < stateArray.length(); i++){
                        JSONObject jsonObject = stateArray.getJSONObject(i);
                        mStateName = jsonObject.getString("name");
                        mTotal =  jsonObject.getString("total");
                        mCured =  jsonObject.getString("cured");
                        mActive =  jsonObject.getString("active");
                        mDeath =  jsonObject.getString("death");
                        IndiaList indiaList = new IndiaList();
                        indiaList.setName(mStateName);
                        indiaList.setActive(mActive);
                        indiaList.setCured(mCured);
                        indiaList.setDeath(mDeath);
                        indiaList.setTotal(mTotal);
                        mIndiaLists.add(indiaList);
                    }
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
        intent.putExtra(getString(R.string.indian_total),"Total : "+ indiaList.getTotal());
        startActivity(intent);
    }
}