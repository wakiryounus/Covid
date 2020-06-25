package k.wakir.covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class IndiaDetailActivity extends AppCompatActivity {
    private TextView mStateName, mActive, mDeath, mRecovered, mTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_detail);
        mStateName = findViewById(R.id.tv_state_name);
        mActive = findViewById(R.id.tv_indian_active);
        mDeath = findViewById(R.id.tv_indian_death);
        mRecovered = findViewById(R.id.tv_indian_recovered);
        mTotal = findViewById(R.id.tv_indian_total);
        getData();
    }
    private void getData(){
        Intent intent = getIntent();
        mStateName.setText( intent.getStringExtra(getString(R.string.indian_state_name)));
        mActive.setText( intent.getStringExtra(getString(R.string.indian_active)));
        mDeath.setText( intent.getStringExtra(getString(R.string.indian_death)));
        mRecovered.setText( intent.getStringExtra(getString(R.string.indian_recovered)));
        mTotal.setText( intent.getStringExtra(getString(R.string.indian_total)));
    }
}