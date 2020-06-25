package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OneTimeActivity extends AppCompatActivity {
    private Button mGetStarted;
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_time);
        mGetStarted = findViewById(R.id.getStarted);
        mSharedPreferences = getSharedPreferences("FIRST", MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();
        mGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEditor.putBoolean(getString(R.string.first_time), true);
                mEditor.apply();
                startActivity(new Intent(OneTimeActivity.this, SelectingActivity.class));
                finish();
            }
        });
    }
}