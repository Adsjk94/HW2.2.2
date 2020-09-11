package com.example.hw222;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_open_notes) {
            Toast.makeText(MainActivity.this, R.string.toastNotebook, Toast.LENGTH_LONG).show();
            Intent intentNotes = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intentNotes);
            return true;
        }
        else if (id == R.id.action_task_time) {
            Toast.makeText(MainActivity.this, R.string.toastTaskTime, Toast.LENGTH_LONG).show();
            Intent intentTaskTame = new Intent(MainActivity.this, TaskTimeActivity.class);
            startActivity(intentTaskTame);
            return true;
        }
        else if (id == R.id.action_deliver) {
            Toast.makeText(MainActivity.this, R.string.toastDeliver, Toast.LENGTH_LONG).show();
            Intent intentDeliver = new Intent(MainActivity.this, DeliveryActivity.class);
            startActivity(intentDeliver);
            return true;
        }
        else if (id == R.id.action_payment) {
            Toast.makeText(MainActivity.this, R.string.toastPayment, Toast.LENGTH_LONG).show();
            Intent intentPayment = new Intent(MainActivity.this, PaymentActivity.class);
            startActivity(intentPayment);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}