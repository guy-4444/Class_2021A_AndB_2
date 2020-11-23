package com.classy.class_2021a_andb_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.krishna.debug_tools.activity.ActivityDebugTools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Activity_Files extends AppCompatActivity {

    private static final String TAG = "pttt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);


        (findViewById(R.id.filesBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Files.this, ActivityDebugTools.class));
            }
        });

        Car car = new Car()
                .setMode("Mitsubishi")
                .setWheels(4);
        String json = new Gson().toJson(car);
        writeStringAsFile(json, car.getMode() + "1.txt");
        String encryptedJson = MyCipher.encrypt(json);
        writeStringAsFile(encryptedJson, car.getMode() + "2.txt");
    }


    public void writeStringAsFile(final String fileContents, String fileName) {
        try {
            File directory = new File(getCacheDir() + File.separator + "Cars" + File.separator);
            directory.mkdirs();

            FileWriter out = new FileWriter(new File(directory, fileName));
            out.write(fileContents);
            out.close();
            Log.d(TAG, "writeStringAsFile success");
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

    public String readFileAsString(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        BufferedReader in = null;

        try {
            in = new BufferedReader(new FileReader(new File(getFilesDir(), fileName)));
            while ((line = in.readLine()) != null) stringBuilder.append(line);

        } catch (FileNotFoundException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }

        return stringBuilder.toString();
    }
}