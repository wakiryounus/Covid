package k.wakir.covid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;


public class SelectingActivity extends AppCompatActivity {
    private RelativeLayout mRelativeLayoutLive, mRelativeLayoutPrevention;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecting);
        mRelativeLayoutLive = findViewById(R.id.relLayoutLive);
        mRelativeLayoutPrevention = findViewById(R.id.relLayoutPrevention);
        mRelativeLayoutLive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectingActivity.this, MainActivity.class));
            }
        });
        mRelativeLayoutPrevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectingActivity.this, PrecautionActivity.class));
            }
        });
    }
}