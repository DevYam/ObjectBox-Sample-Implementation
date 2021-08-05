package com.ncertguruji.objectboxnote;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.ncertguruji.objectboxnote.entity.User;

import java.util.List;

import io.objectbox.Box;

public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting box for user object

        ObjectBox.init(this);
        Box<User> userBox = ObjectBox.get().boxFor(User.class);
        EditText editText = this.findViewById(R.id.inp);

        Button save = this.findViewById(R.id.saveBtn);
        save.setOnClickListener(view -> {
            String data = editText.getText().toString();
            userBox.put(new User(data));
        });

        Button find = this.findViewById(R.id.get);
        find.setOnClickListener(view -> {
//            List<User> all = userBox.getAll();
//            StringBuilder names = new StringBuilder();
//            for (User u: all
//                 ) {
//                names.append(u.getName()).append("\n");
//            }
//            Toast.makeText(MainActivity.this, names, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });



    }
}