package alpha.smartdripirrigation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class deleteRover extends AppCompatActivity {

    private EditText ip;
    private Button clearAllBtn,deleteRoverBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_rover);

        clearAllBtn = (Button)findViewById(R.id.clearAllBtn);
        deleteRoverBtn = (Button)findViewById(R.id.deleteRoverBtn);
        ip = (EditText)findViewById(R.id.deleteIP);

        //Enable Back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        clearAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rovers.deleteFile(getApplicationContext());
            }
        });

        deleteRoverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rovers.deleteRover(ip.getText().toString(),getApplicationContext());
            }
        });

    }

    //Back button function
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
