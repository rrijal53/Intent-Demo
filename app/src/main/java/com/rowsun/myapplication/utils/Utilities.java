package com.rowsun.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {




    public static String readStringFromAssets(Context context, String fileName){

        String i = "";
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            i = new String(buffer, "UTF-8");
        }catch (IOException e){
            e.printStackTrace();
        }
        return i;
    }

    public static String readStringFromAssetUsinBuffer(Context context, String fileName){

        String i = "";
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            BufferedReader b = new BufferedReader(new InputStreamReader(inputStream));
            String result = "";
            StringBuilder sb = new StringBuilder();

            while ((result = b.readLine()) !=null){
                //  sb.append(result);
                i+=result;
            }
         //   i = sb.toString();
          //  Toast.makeText(context, i, Toast.LENGTH_LONG).show();

        }catch (IOException e){
            e.printStackTrace();
        }
        return i;
    }


}
