package k.wakir.covid;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Context;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ProgressBar;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.android.volley.Request;
    import com.android.volley.RequestQueue;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.JsonObjectRequest;
    import com.android.volley.toolbox.Volley;

    import org.json.JSONObject;

public class GlobalActivity extends AppCompatActivity {
    private TextView mNewConfirmed, mTotalConfirmed, mNewDeath, mTotalDeath, mNewRecovered, mTotalRecovered, mDate;

    private RequestQueue mRequestQueue;
    private Context mContext = GlobalActivity.this;

    private ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        mNewConfirmed = findViewById(R.id.tv_new_confirmed);
        mTotalConfirmed = findViewById(R.id.tv_total_confirmed);
        mNewDeath = findViewById(R.id.tv_new_death);
        mTotalDeath = findViewById(R.id.tv_total_death);
        mDate = findViewById(R.id.tv_date);
        mNewRecovered = findViewById(R.id.tv_new_recovered);
        mProgressBar = findViewById(R.id.progressbar);
        mTotalRecovered = findViewById(R.id.tv_total_recovered);
        mRequestQueue = Volley.newRequestQueue(mContext);
        parseJSON();
    }
    private void parseJSON(){
        String url = "https://api.covid19api.com/summary";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject jsonObject = response.getJSONObject("Global");
                    String newConfirmed = jsonObject.getString("NewConfirmed");
                    String totalConfirmed = jsonObject.getString("TotalConfirmed");
                    String newDeath = jsonObject.getString("NewDeaths");
                    String totalDeath = jsonObject.getString("TotalDeaths");
                    String newRecovered = jsonObject.getString("NewRecovered");
                    String totalRecovered = jsonObject.getString("TotalRecovered");
                    String date = response.getString("Date");
                    String shortDate = date.substring(0, Math.min(date.length(), 10));
                    mNewConfirmed.setText("New Confirmed : "+newConfirmed);
                    mTotalConfirmed.setText("Total Confirmed : "+totalConfirmed);
                    mNewDeath.setText("New Death : "+newDeath);
                    mTotalDeath.setText("Total Death : "+totalDeath);
                    mNewRecovered.setText("New Recovered : "+newRecovered);
                    mTotalRecovered.setText("Total Recovered : "+totalRecovered);
                    mDate.setText("Updated : "+shortDate);
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
}