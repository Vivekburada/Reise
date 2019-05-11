package io.rewardnxt.vivekburada.reise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.widget.Toast.LENGTH_SHORT;

public class LaunchActivity extends AppCompatActivity {

    @BindView(R.id.student) Button student;
    @BindView(R.id.parent) Button parent;
    @BindView(R.id.school) Button school;

    private Intent I;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);

    }
    @OnClick({ R.id.student, R.id.parent, R.id.school})
    public void onItemClicked(View view) {

        switch (view.getId()) {
            case R.id.student:
                // do something here
                Toast.makeText(this, "Student", LENGTH_SHORT).show();
                I = new Intent(LaunchActivity.this, LoginActivity.class);
                I.putExtra("user", "student"); //Optional parameters
                LaunchActivity.this.startActivity(I);
                break;
            case R.id.parent:
                // do something here
                Toast.makeText(this, "Parent", LENGTH_SHORT).show();
                I = new Intent(LaunchActivity.this, LoginActivity.class);
                I.putExtra("user", "parent"); //Optional parameters
                LaunchActivity.this.startActivity(I);
                break;
            case R.id.school:
                // do something here
                Toast.makeText(this, "School", LENGTH_SHORT).show();
                I = new Intent(LaunchActivity.this, LoginActivity.class);
                I.putExtra("user", "school"); //Optional parameters
                LaunchActivity.this.startActivity(I);
                break;
        }
    }

}
