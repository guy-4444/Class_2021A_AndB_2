package com.classy.class_2021a_andb_2;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MyJsonFile {

    public static  String readJsonFile(Context context, String fileNameWithExtension) {
        String FOLDER = context.getFilesDir() + File.separator + "AppJsons";

        String ret = "";

        try {
            InputStream inputStream = new FileInputStream(new File(FOLDER + File.separator + fileNameWithExtension));

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((receiveString = bufferedReader.readLine()) != null) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }

    public static  void removeJsonFile(Context context, String fileNameWithExtension) {
        String FOLDER = context.getFilesDir() + File.separator + "AppJsons";
        boolean success = true;
        File mainFolder = new File(FOLDER);// + File.separator + folderName);
        if (!mainFolder.exists()) {
            success = mainFolder.mkdirs();
        }

        try {
            File file = new File(FOLDER + File.separator + fileNameWithExtension);
            file.delete();
        } catch (Exception ex) { }
    }

    public static boolean createJsonFile(Context context, String fileNameWithExtension, String jsonString) {
        String FOLDER = context.getFilesDir() + File.separator + "AppJsons";
        boolean success = true;
        File mainFolder = new File(FOLDER);// + File.separator + folderName);
        if (!mainFolder.exists()) {
            success = mainFolder.mkdirs();
        }

        try {
            Writer output = null;
            File file = new File(FOLDER + File.separator + fileNameWithExtension);
            output = new BufferedWriter(new FileWriter(file));
            if (jsonString != null) {
                output.write(jsonString);
                output.close();
            }
            output.close();
            return true;
        } catch (FileNotFoundException fileNotFound) {
            return false;
        } catch (IOException ioException) {
            return false;
        }
    }
}
