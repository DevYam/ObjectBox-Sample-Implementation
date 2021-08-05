package com.ncertguruji.objectboxnote;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ncertguruji.objectboxnote.entity.User;

import java.util.List;

import io.objectbox.Box;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button b = this.findViewById(R.id.getData);
        b.setOnClickListener(view -> {
            Box<User> userBox = ObjectBox.get().boxFor(User.class);
            List<User> all = userBox.getAll();
            StringBuilder names = new StringBuilder();
            for (User u: all
            ) {
                names.append(u.getName()).append("\n");
            }
            Toast.makeText(MainActivity2.this, names, Toast.LENGTH_SHORT).show();


        });

    }
}