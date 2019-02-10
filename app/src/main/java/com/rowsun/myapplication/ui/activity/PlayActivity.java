package com.rowsun.myapplication.ui.activity;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.util.Log;
import android.widget.TextView;

import com.rowsun.myapplication.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayActivity extends AppCompatActivity {
    TextView tvOne, tvTwo, tvThree, tvFour, tvFive, tvSix, tvSeven;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        tvOne = findViewById(R.id.tv_one);
        tvTwo = findViewById(R.id.tv_two);
        tvThree = findViewById(R.id.tv_three);
        tvFour = findViewById(R.id.tv_four);
        tvFive = findViewById(R.id.tv_five);
        tvSix = findViewById(R.id.tv_six);
        tvSeven = findViewById(R.id.tv_seven);
        tvOne.setText("http://www.rijalroshan.com.np/");
        Linkify.addLinks(tvOne, Linkify.WEB_URLS);

        tvTwo.setText("9849316389");
        Linkify.addLinks(tvTwo, Linkify.PHONE_NUMBERS);

        tvThree.setText("rijalroshan94@gmail.com");
        Linkify.addLinks(tvThree, Linkify.EMAIL_ADDRESSES);

        tvFour.setText("Email : rijalroshan94@gmail.com Number :  9849316389 Website : http://abc.com");
        Linkify.addLinks(tvFour, Linkify.EMAIL_ADDRESSES | Linkify.WEB_URLS);

        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+le");
        tvFive.setText("press Roshan& or on Rijal& to search it on google 111&");
        Linkify.addLinks(tvFive, pattern, "http://www.google.ie/search?q=");

        Linkify.MatchFilter filter = new Linkify.MatchFilter() {
            @Override
            public boolean acceptMatch(CharSequence charSequence, int start, int end) {
                return start > 100;
            }
        };

        Pattern pattern2 = Pattern.compile("[a-zA-Z0-9]+");
        tvSix.setText("Phone number : 98323");
        Linkify.addLinks(tvSix, pattern2, "http://www.google.ie/search?q=", filter, null);

        Linkify.TransformFilter myTransformFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return url.substring(1);
            }
        };

        Pattern pattern3 = Pattern.compile("A[a-zA-Z]+");

        tvSeven.setText("press ALinkify or on AAndroid to search it on google");
        Linkify.addLinks(tvSeven, pattern3, "http://www.google.ie/search?q=", null, myTransformFilter);


        Date d = new Date();
        Date d2 = new Date();
        d.before(d2);
        d.after(d2);
        d.equals(d2);

        Calendar c = Calendar.getInstance();
        c.set(2012, 12 , 12, 23, 12);
        c.setTimeZone(TimeZone.getTimeZone("Asia/Kathmandu"));
        c.add(Calendar.MONTH , -3);

        String date = "2019-12-13";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.format(c.getTime());
        try {
            Date ddd = format.parse(date);
            c.setTime(ddd);

            Date dt = format.parse(date);
            SimpleDateFormat df = new SimpleDateFormat("EEEE");
            tvOne.setText(df.format(dt));
//            "13 december 2019, friday 12pm"
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
