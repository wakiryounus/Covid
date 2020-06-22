package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mGlobal, mCountries, mIndia, mContinent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGlobal = findViewById(R.id.relLayoutGlobal);
        mCountries = findViewById(R.id.relLayoutCountry);
        mIndia = findViewById(R.id.relLayoutIndia);
        mContinent = findViewById(R.id.relLayoutContinent);
        mGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GlobalActivity.class));
            }
        });
        mCountries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CountriesActivity.class));
            }
        });
        mIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IndiaActivity.class));
            }
        });
        mContinent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ContinentActivity.class));
            }
        });
    }
}