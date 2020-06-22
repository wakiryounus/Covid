package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CountryDetailActivity extends AppCompatActivity {
    private TextView mCountryName, mUpdatedTime, mPopulation, mContinent,
            mCases, mTodayCases, mDeaths, mTodayDeaths, mRecovered, mTodayRecovered, mActive,
            mCritical, mCasesPerOneMillion, mDeathsPerOneMillion, mTests, mTestPerOneMillion, mOneCasePerPeople,
            mOneDeathsPerPeople, mOneTestPerPeople, mActivePerOneMillion, mRecoveredPerOneMillion, mCriticalPerOneMillion;
    private ImageView mFlagImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        mCountryName = findViewById(R.id.tv_country_name);
        mUpdatedTime = findViewById(R.id.tv_updated_time);
        mPopulation = findViewById(R.id.tv_population);
        mContinent = findViewById(R.id.tv_continent);
        mCases = findViewById(R.id.tv_cases);
        mTodayCases = findViewById(R.id.tv_today_cases);
        mDeaths = findViewById(R.id.tv_deaths);
        mFlagImage = findViewById(R.id.flag_image);
        mTodayDeaths = findViewById(R.id.tv_today_deaths);
        mRecovered = findViewById(R.id.tv_recovered);
        mTodayRecovered = findViewById(R.id.tv_today_recovered);
        mActive = findViewById(R.id.tv_active);
        mCritical = findViewById(R.id.tv_critical);
        mCasesPerOneMillion = findViewById(R.id.tv_cases_per_one_million);
        mDeathsPerOneMillion = findViewById(R.id.tv_deaths_per_one_million);
        mTests = findViewById(R.id.tv_tests);
        mTestPerOneMillion = findViewById(R.id.tv_test_per_one_million);
        mOneCasePerPeople = findViewById(R.id.tv_one_case_per_people);
        mOneDeathsPerPeople = findViewById(R.id.tv_one_death_per_people);
        mOneTestPerPeople = findViewById(R.id.tv_one_test_per_people);
        mActivePerOneMillion = findViewById(R.id.tv_active_per_one_million);
        mRecoveredPerOneMillion = findViewById(R.id.tv_recovered_per_one_million);
        mCriticalPerOneMillion = findViewById(R.id.tv_critical_per_one_million);
        setUpWidgets();
    }
    private void setUpWidgets(){
        Intent intent = getIntent();
        Picasso.get().load(intent.getStringExtra(getString(R.string.flagUrl))).into(mFlagImage);
        mCountryName.setText(intent.getStringExtra(getString(R.string.countryname)));
        mUpdatedTime.setText(intent.getStringExtra(getString(R.string.updated_time)));
        mPopulation.setText(intent.getStringExtra(getString(R.string.population)));
        mContinent.setText(intent.getStringExtra(getString(R.string.continent)));
        mCases.setText(intent.getStringExtra(getString(R.string.cases)));
        mTodayCases.setText(intent.getStringExtra(getString(R.string.today_cases)));
        mDeaths.setText(intent.getStringExtra(getString(R.string.deaths)));
        mTodayDeaths.setText(intent.getStringExtra(getString(R.string.today_deaths)));
        mRecovered.setText(intent.getStringExtra(getString(R.string.recovered)));
        mTodayRecovered.setText(intent.getStringExtra(getString(R.string.today_recovered)));
        mActive.setText(intent.getStringExtra(getString(R.string.active)));
        mCritical.setText(intent.getStringExtra(getString(R.string.critical)));
        mCasesPerOneMillion.setText(intent.getStringExtra(getString(R.string.cases_per_one_million)));
        mDeathsPerOneMillion.setText(intent.getStringExtra(getString(R.string.deaths_per_one_million)));
        mTests.setText(intent.getStringExtra(getString(R.string.tests)));
        mTestPerOneMillion.setText(intent.getStringExtra(getString(R.string.test_per_one_million)));
        mOneCasePerPeople.setText(intent.getStringExtra(getString(R.string.one_case_per_people)));
        mOneDeathsPerPeople.setText(intent.getStringExtra(getString(R.string.one_death_per_people)));
        mOneTestPerPeople.setText(intent.getStringExtra(getString(R.string.one_test_per_people)));
        mActivePerOneMillion.setText(intent.getStringExtra(getString(R.string.active_per_one_million)));
        mRecoveredPerOneMillion.setText(intent.getStringExtra(getString(R.string.recovered_per_one_million)));
        mCriticalPerOneMillion.setText(intent.getStringExtra(getString(R.string.critical_per_one_million)));
    }
}