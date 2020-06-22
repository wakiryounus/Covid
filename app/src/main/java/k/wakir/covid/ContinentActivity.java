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
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import k.wakir.covid.adapters.ContinentListAdapter;
import k.wakir.covid.adapters.CountryListAdapter;
import k.wakir.covid.models.ContinentList;
import k.wakir.covid.models.CountryList;

public class ContinentActivity extends AppCompatActivity implements ContinentListAdapter.OnContinentClickListener {
    private ProgressBar mProgressBar;
    private RecyclerView mRecyclerView;
    private Context mContext = ContinentActivity.this;

    private ArrayList<ContinentList> mContinentLists;
    private RequestQueue mRequestQueue;

    private String mContinentName,  mUpdatedTime, mPopulation,
            mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mTodayRecovered, mActive,
            mCritical, mCasesPerOneMillion, mDeathsPerOneMillion, mTests, mTestPerOneMillion,
            mActivePerOneMillion, mRecoveredPerOneMillion, mCriticalPerOneMillion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_continent);
        mProgressBar = findViewById(R.id.progressbar);
        mRecyclerView = findViewById(R.id.recyclerView);
        mContinentLists = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setHasFixedSize(true);
        mRequestQueue = Volley.newRequestQueue(mContext);
        parseJSON();
    }
    private void parseJSON(){
        String url = "https://corona.lmao.ninja/v2/continents?yesterday=true&sort";
        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject jsonObject = response.getJSONObject(i);
                        mUpdatedTime = jsonObject.getString("updated");
                        mPopulation = jsonObject.getString("population");
                        mContinentName = jsonObject.getString("continent");
                        mCases = jsonObject.getString("cases");
                        mTodayCases = jsonObject.getString("todayCases");
                        mDeaths = jsonObject.getString("deaths");
                        mTodayDeaths = jsonObject.getString("todayDeaths");
                        mRecovered = jsonObject.getString("recovered");
                        mTodayRecovered = jsonObject.getString("todayRecovered");
                        mActive = jsonObject.getString("active");
                        mCritical = jsonObject.getString("critical");
                        mCasesPerOneMillion = jsonObject.getString("casesPerOneMillion");
                        mDeathsPerOneMillion = jsonObject.getString("deathsPerOneMillion");
                        mTests = jsonObject.getString("tests");
                        mTestPerOneMillion = jsonObject.getString("testsPerOneMillion");
                        mActivePerOneMillion = jsonObject.getString("activePerOneMillion");
                        mRecoveredPerOneMillion = jsonObject.getString("recoveredPerOneMillion");
                        mCriticalPerOneMillion = jsonObject.getString("criticalPerOneMillion");
                        ContinentList continentList = new ContinentList();
                        continentList.setActive(mActive);
                        continentList.setActivePerOneMillion(mActivePerOneMillion);
                        continentList.setCases(mCases);
                        continentList.setCasesPerOneMillion(mCasesPerOneMillion);
                        continentList.setContinentName(mContinentName);
                        continentList.setCritical(mCritical);
                        continentList.setCriticalPerOneMillion(mCriticalPerOneMillion);
                        continentList.setDeaths(mDeaths);
                        continentList.setDeathsPerOneMillion(mDeathsPerOneMillion);
                        continentList.setPopulation(mPopulation);
                        continentList.setRecovered(mRecovered);
                        continentList.setRecoveredPerOneMillion(mRecoveredPerOneMillion);
                        continentList.setTestPerOneMillion(mTestPerOneMillion);
                        continentList.setTests(mTests);
                        continentList.setTodayCases(mTodayCases);
                        continentList.setTodayDeaths(mTodayDeaths);
                        continentList.setTodayRecovered(mTodayRecovered);
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String dateString = formatter.format(new Date(Long.parseLong(mUpdatedTime)));
                        continentList.setUpdatedTime(dateString);
                        mContinentLists.add(continentList);
                    }
                    ContinentListAdapter adapter = new ContinentListAdapter(mContext, mContinentLists, ContinentActivity.this);
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
                Toast.makeText(mContext, "Something went wrong try again later", Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mRequestQueue.add(jsonObjectRequest);
    }

    @Override
    public void onContinentClick(int position) {
        ContinentList countryList = mContinentLists.get(position);
        Intent intent = new Intent(mContext, ContinentDetailActivity.class);
        intent.putExtra(getString(R.string.population),"Population : "+ countryList.getPopulation());
        intent.putExtra(getString(R.string.continent),countryList.getContinentName());
        intent.putExtra(getString(R.string.updated_time),"Updated Time : "+ countryList.getUpdatedTime());
        intent.putExtra(getString(R.string.cases),"Cases : "+ countryList.getCases());
        intent.putExtra(getString(R.string.today_cases),"Today Cases : "+ countryList.getTodayCases());
        intent.putExtra(getString(R.string.deaths),"Deaths : "+ countryList.getDeaths());
        intent.putExtra(getString(R.string.today_deaths),"Today Deaths : "+ countryList.getTodayDeaths());
        intent.putExtra(getString(R.string.recovered),"Recovered : "+ countryList.getRecovered());
        intent.putExtra(getString(R.string.today_recovered),"Today Recovered : "+ countryList.getTodayRecovered());
        intent.putExtra(getString(R.string.active),"Active : "+ countryList.getActive());
        intent.putExtra(getString(R.string.critical),"Critical : "+ countryList.getCritical());
        intent.putExtra(getString(R.string.tests),"Tests : "+ countryList.getTests());
        intent.putExtra(getString(R.string.cases_per_one_million),"Cases Per One Million : "+ countryList.getCasesPerOneMillion());
        intent.putExtra(getString(R.string.deaths_per_one_million),"Deaths Per One Million: "+ countryList.getDeathsPerOneMillion());
        intent.putExtra(getString(R.string.recovered_per_one_million),"Recovered Per One Million : "+ countryList.getRecoveredPerOneMillion());
        intent.putExtra(getString(R.string.active_per_one_million),"Active Per One Million : "+ countryList.getActivePerOneMillion());
        intent.putExtra(getString(R.string.critical_per_one_million),"Critical Per One Million : "+ countryList.getCriticalPerOneMillion());
        intent.putExtra(getString(R.string.test_per_one_million),"Test Per One Million : "+ countryList.getTestPerOneMillion());
        startActivity(intent);
    }
}