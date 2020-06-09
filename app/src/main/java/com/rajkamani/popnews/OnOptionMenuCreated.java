package com.rajkamani.popnews;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class OnOptionMenuCreated extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.ShareApp) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TITLE, "Url of APP");
            intent.putExtra(Intent.EXTRA_TEXT,"Url Of application");
            startActivity(Intent.createChooser(intent, "Share App Via"));
        } else if (item.getItemId() == R.id.AboutUs) {
            Intent intent = new Intent(this, AboutUs.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
