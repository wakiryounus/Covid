package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mSharedPreferences = getSharedPreferences("FIRST", MODE_PRIVATE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mSharedPreferences.getBoolean(getString(R.string.first_time), false)){
                    startActivity(new Intent(SplashScreenActivity.this, SelectingActivity.class));
                }else {
                    startActivity(new Intent(SplashScreenActivity.this, OneTimeActivity.class));
                }

                finish();
            }
        }, 1300);
    }
}