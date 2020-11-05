package com.example.a07json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.strictmode.CredentialProtectedWhileLockedViolation;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    String jsondata = "{\"coord\":{\"lon\":126.98,\"lat\":37.57},\"weather\":[{\"id\":721,\"main\":\"Haze\",\"description\":\"haze\",\"icon\":\"50d\"}],\"base\":\"stations\",\"main\":{\"temp\":299.78,\"pressure\":1023,\"humidity\":54,\"temp_min\":298.15,\"temp_max\":301.15},\"visibility\":10000,\"wind\":{\"speed\":2.1,\"deg\":330},\"clouds\":{\"all\":20},\"dt\":1569479121,\"sys\":{\"type\":1,\"id\":5509,\"message\":0.0062,\"country\":\"KR\",\"sunrise\":1569446551,\"sunset\":1569489888},\"timezone\":32400,\"id\":1835848,\"name\":\"Seoul\",\"cod\":200}";
    String jsonforecast="{\"cod\":\"200\",\"message\":0,\"cnt\":40,\"list\":[{\"dt\":1603940400,\"main\":{\"temp\":13.3,\"feels_like\":9.75,\"temp_min\":13.3,\"temp_max\":14.66,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1018,\"humidity\":31,\"temp_kf\":-1.36},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":31},\"wind\":{\"speed\":1.58,\"deg\":306},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-29 03:00:00\"},{\"dt\":1603951200,\"main\":{\"temp\":14.99,\"feels_like\":10.57,\"temp_min\":14.99,\"temp_max\":15.82,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1016,\"humidity\":28,\"temp_kf\":-0.83},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":42},\"wind\":{\"speed\":2.84,\"deg\":309},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-29 06:00:00\"},{\"dt\":1603962000,\"main\":{\"temp\":14.04,\"feels_like\":9.7,\"temp_min\":14.04,\"temp_max\":14.18,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1017,\"humidity\":33,\"temp_kf\":-0.14},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":2.98,\"deg\":324},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-29 09:00:00\"},{\"dt\":1603972800,\"main\":{\"temp\":12.57,\"feels_like\":9.16,\"temp_min\":12.57,\"temp_max\":12.57,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1017,\"humidity\":38,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":61},\"wind\":{\"speed\":1.76,\"deg\":314},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-29 12:00:00\"},{\"dt\":1603983600,\"main\":{\"temp\":12.17,\"feels_like\":9.38,\"temp_min\":12.17,\"temp_max\":12.17,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":1018,\"humidity\":39,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.87,\"deg\":2},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-29 15:00:00\"},{\"dt\":1603994400,\"main\":{\"temp\":11.44,\"feels_like\":8.67,\"temp_min\":11.44,\"temp_max\":11.44,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1018,\"humidity\":42,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":0.92,\"deg\":52},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-29 18:00:00\"},{\"dt\":1604005200,\"main\":{\"temp\":10.48,\"feels_like\":7.53,\"temp_min\":10.48,\"temp_max\":10.48,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":1019,\"humidity\":45,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":63},\"wind\":{\"speed\":1.19,\"deg\":55},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-29 21:00:00\"},{\"dt\":1604016000,\"main\":{\"temp\":11.9,\"feels_like\":8.87,\"temp_min\":11.9,\"temp_max\":11.9,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1020,\"humidity\":42,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":31},\"wind\":{\"speed\":1.37,\"deg\":58},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-30 00:00:00\"},{\"dt\":1604026800,\"main\":{\"temp\":16.24,\"feels_like\":13.33,\"temp_min\":16.24,\"temp_max\":16.24,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1020,\"humidity\":37,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.65,\"deg\":65},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-30 03:00:00\"},{\"dt\":1604037600,\"main\":{\"temp\":18.46,\"feels_like\":16.45,\"temp_min\":18.46,\"temp_max\":18.46,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1019,\"humidity\":34,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.56,\"deg\":42},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-30 06:00:00\"},{\"dt\":1604048400,\"main\":{\"temp\":16.85,\"feels_like\":14.59,\"temp_min\":16.85,\"temp_max\":16.85,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1021,\"humidity\":35,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.67,\"deg\":10},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-30 09:00:00\"},{\"dt\":1604059200,\"main\":{\"temp\":15.07,\"feels_like\":12.86,\"temp_min\":15.07,\"temp_max\":15.07,\"pressure\":1027,\"sea_level\":1027,\"grnd_level\":1022,\"humidity\":38,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":0.51,\"deg\":73},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-30 12:00:00\"},{\"dt\":1604070000,\"main\":{\"temp\":13.3,\"feels_like\":10.73,\"temp_min\":13.3,\"temp_max\":13.3,\"pressure\":1028,\"sea_level\":1028,\"grnd_level\":1022,\"humidity\":53,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":1},\"wind\":{\"speed\":1.76,\"deg\":151},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-30 15:00:00\"},{\"dt\":1604080800,\"main\":{\"temp\":12.08,\"feels_like\":9.72,\"temp_min\":12.08,\"temp_max\":12.08,\"pressure\":1027,\"sea_level\":1027,\"grnd_level\":1022,\"humidity\":58,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":1},\"wind\":{\"speed\":1.5,\"deg\":108},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-30 18:00:00\"},{\"dt\":1604091600,\"main\":{\"temp\":11.32,\"feels_like\":8.77,\"temp_min\":11.32,\"temp_max\":11.32,\"pressure\":1028,\"sea_level\":1028,\"grnd_level\":1022,\"humidity\":60,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":1.72,\"deg\":107},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-30 21:00:00\"},{\"dt\":1604102400,\"main\":{\"temp\":12.12,\"feels_like\":9.02,\"temp_min\":12.12,\"temp_max\":12.12,\"pressure\":1027,\"sea_level\":1027,\"grnd_level\":1021,\"humidity\":55,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":90},\"wind\":{\"speed\":2.38,\"deg\":123},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-31 00:00:00\"},{\"dt\":1604113200,\"main\":{\"temp\":15.3,\"feels_like\":11.92,\"temp_min\":15.3,\"temp_max\":15.3,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1019,\"humidity\":50,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.21,\"deg\":184},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-31 03:00:00\"},{\"dt\":1604124000,\"main\":{\"temp\":16.63,\"feels_like\":13.35,\"temp_min\":16.63,\"temp_max\":16.63,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1017,\"humidity\":53,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":95},\"wind\":{\"speed\":3.69,\"deg\":227},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-10-31 06:00:00\"},{\"dt\":1604134800,\"main\":{\"temp\":15.3,\"feels_like\":12.65,\"temp_min\":15.3,\"temp_max\":15.3,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1017,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.14,\"deg\":232},\"visibility\":10000,\"pop\":0.25,\"rain\":{\"3h\":0.12},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-31 09:00:00\"},{\"dt\":1604145600,\"main\":{\"temp\":15.07,\"feels_like\":11.99,\"temp_min\":15.07,\"temp_max\":15.07,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1017,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":93},\"wind\":{\"speed\":3.68,\"deg\":221},\"visibility\":10000,\"pop\":0.07,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-31 12:00:00\"},{\"dt\":1604156400,\"main\":{\"temp\":14.96,\"feels_like\":12.02,\"temp_min\":14.96,\"temp_max\":14.96,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1017,\"humidity\":63,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":95},\"wind\":{\"speed\":3.52,\"deg\":212},\"visibility\":10000,\"pop\":0.16,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-31 15:00:00\"},{\"dt\":1604167200,\"main\":{\"temp\":14.85,\"feels_like\":11.99,\"temp_min\":14.85,\"temp_max\":14.85,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1016,\"humidity\":66,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":95},\"wind\":{\"speed\":3.61,\"deg\":209},\"visibility\":10000,\"pop\":0.48,\"rain\":{\"3h\":0.24},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-31 18:00:00\"},{\"dt\":1604178000,\"main\":{\"temp\":14.78,\"feels_like\":12.28,\"temp_min\":14.78,\"temp_max\":14.78,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1015,\"humidity\":75,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.79,\"deg\":206},\"visibility\":10000,\"pop\":0.54,\"rain\":{\"3h\":1.02},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-10-31 21:00:00\"},{\"dt\":1604188800,\"main\":{\"temp\":14.71,\"feels_like\":11.49,\"temp_min\":14.71,\"temp_max\":14.71,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1016,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.24,\"deg\":197},\"visibility\":10000,\"pop\":0.65,\"rain\":{\"3h\":1.03},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-01 00:00:00\"},{\"dt\":1604199600,\"main\":{\"temp\":15.64,\"feels_like\":12.73,\"temp_min\":15.64,\"temp_max\":15.64,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1015,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.46,\"deg\":211},\"visibility\":10000,\"pop\":0.69,\"rain\":{\"3h\":0.97},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-01 03:00:00\"},{\"dt\":1604210400,\"main\":{\"temp\":16.7,\"feels_like\":13.26,\"temp_min\":16.7,\"temp_max\":16.7,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1013,\"humidity\":62,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.74,\"deg\":235},\"visibility\":10000,\"pop\":0.88,\"rain\":{\"3h\":0.47},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-01 06:00:00\"},{\"dt\":1604221200,\"main\":{\"temp\":15.87,\"feels_like\":13.63,\"temp_min\":15.87,\"temp_max\":15.87,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1013,\"humidity\":70,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.42,\"deg\":229},\"visibility\":10000,\"pop\":0.8,\"rain\":{\"3h\":0.16},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-01 09:00:00\"},{\"dt\":1604232000,\"main\":{\"temp\":15.44,\"feels_like\":13.5,\"temp_min\":15.44,\"temp_max\":15.44,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1014,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.08,\"deg\":236},\"visibility\":10000,\"pop\":0.82,\"rain\":{\"3h\":0.68},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-01 12:00:00\"},{\"dt\":1604242800,\"main\":{\"temp\":14.61,\"feels_like\":13.43,\"temp_min\":14.61,\"temp_max\":14.61,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1014,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":95},\"wind\":{\"speed\":2.08,\"deg\":258},\"visibility\":10000,\"pop\":0.39,\"rain\":{\"3h\":0.21},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-01 15:00:00\"},{\"dt\":1604253600,\"main\":{\"temp\":13.77,\"feels_like\":10.68,\"temp_min\":13.77,\"temp_max\":13.77,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1013,\"humidity\":57,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":97},\"wind\":{\"speed\":2.93,\"deg\":327},\"visibility\":10000,\"pop\":0.38,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-01 18:00:00\"},{\"dt\":1604264400,\"main\":{\"temp\":13.13,\"feels_like\":10.02,\"temp_min\":13.13,\"temp_max\":13.13,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1013,\"humidity\":44,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":1.86,\"deg\":333},\"visibility\":10000,\"pop\":0.09,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-01 21:00:00\"},{\"dt\":1604275200,\"main\":{\"temp\":13.13,\"feels_like\":9.17,\"temp_min\":13.13,\"temp_max\":13.13,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1015,\"humidity\":39,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":96},\"wind\":{\"speed\":2.72,\"deg\":311},\"visibility\":10000,\"pop\":0.15,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-02 00:00:00\"},{\"dt\":1604286000,\"main\":{\"temp\":15.36,\"feels_like\":10.48,\"temp_min\":15.36,\"temp_max\":15.36,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1014,\"humidity\":31,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":3.8,\"deg\":296},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-02 03:00:00\"},{\"dt\":1604296800,\"main\":{\"temp\":15.75,\"feels_like\":9.61,\"temp_min\":15.75,\"temp_max\":15.75,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1013,\"humidity\":33,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":4},\"wind\":{\"speed\":5.83,\"deg\":274},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-02 06:00:00\"},{\"dt\":1604307600,\"main\":{\"temp\":14.19,\"feels_like\":7.39,\"temp_min\":14.19,\"temp_max\":14.19,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1013,\"humidity\":34,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":39},\"wind\":{\"speed\":6.59,\"deg\":295},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-02 09:00:00\"},{\"dt\":1604318400,\"main\":{\"temp\":11.74,\"feels_like\":5.73,\"temp_min\":11.74,\"temp_max\":11.74,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1015,\"humidity\":42,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":19},\"wind\":{\"speed\":5.6,\"deg\":292},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-02 12:00:00\"},{\"dt\":1604329200,\"main\":{\"temp\":10.33,\"feels_like\":3.48,\"temp_min\":10.33,\"temp_max\":10.33,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1015,\"humidity\":47,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":22},\"wind\":{\"speed\":6.85,\"deg\":314},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-02 15:00:00\"},{\"dt\":1604340000,\"main\":{\"temp\":7.72,\"feels_like\":0.94,\"temp_min\":7.72,\"temp_max\":7.72,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1016,\"humidity\":49,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":11},\"wind\":{\"speed\":6.4,\"deg\":316},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-02 18:00:00\"},{\"dt\":1604350800,\"main\":{\"temp\":5.67,\"feels_like\":-0.82,\"temp_min\":5.67,\"temp_max\":5.67,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1018,\"humidity\":49,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.66,\"deg\":316},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2020-11-02 21:00:00\"},{\"dt\":1604361600,\"main\":{\"temp\":5.96,\"feels_like\":-0.26,\"temp_min\":5.96,\"temp_max\":5.96,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1019,\"humidity\":49,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.33,\"deg\":315},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2020-11-03 00:00:00\"}],\"city\":{\"id\":1835848,\"name\":\"Seoul\",\"coord\":{\"lat\":37.5683,\"lon\":126.9778},\"country\":\"KR\",\"population\":10349312,\"timezone\":32400,\"sunrise\":1603922031,\"sunset\":1603960654}}";
    EditText editText;
    TextView textView;
    TextView updates, country, location, temperature, humidity, pressure;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ediText);
        updates = findViewById(R.id.updates);
        country = findViewById(R.id.country);
        location = findViewById(R.id.location);
        temperature = findViewById(R.id.temperature);
        humidity = findViewById(R.id.humidity);
        pressure = findViewById(R.id.pressure);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        setTitle("양덕기 json");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseJSONdate(jsondata);
                parseJSONforecast(jsonforecast);
            }
        });

    }
    public void parseJSONdate(String odata){
        Integer ihumidity=0, ipressure=0;
        Double itemperature = 0.0d, dlong=0.0d, dlat=0.0d;
        String scounty = null;
        Long udate = 0L;
        SimpleDateFormat format1 = null;
        Date date = null;

        if(odata == null){
            textView.setText("데이터 없음");
            return;
        }

        try{
            JSONObject jsonObject = new JSONObject(odata);
            JSONObject jmain = jsonObject.getJSONObject("main");
            ihumidity = jmain.getInt("humidity");
            itemperature = jmain.getDouble("temp");
            ipressure = jmain.getInt("pressure");

            JSONObject jsys = jsonObject.getJSONObject("sys");
            scounty = jsys.getString("country");

            JSONObject jcoord = jsonObject.getJSONObject("coord");
            dlong = jcoord.getDouble("lon");
            dlat = jcoord.getDouble("lat");

            udate = jsonObject.getLong("dt");
            date = new Date(udate*1000);
            format1 = new SimpleDateFormat("yyyy년 MM월 dd일 EHH:mm:ss");


        }catch (Exception e){
            e.printStackTrace();
            Log.e("JSONParsing","Parsing Error");
        }
        temperature.setText(itemperature.toString());
        humidity.setText(ihumidity.toString());
        country.setText(scounty);
        pressure.setText(ipressure.toString());
        location.setText("경도 : "+ dlong + ", 위도 :" + dlat);
        updates.setText(format1.format(date));

    }

    public void parseJSONforecast(String odata){
        Integer humidity, pressure;
        Double temperature;
        String presult = null;

        if(odata == null){
            textView.setText("데이터 없음");
            return;
        }
        presult = "Forecast \n";
        try{
            JSONObject jsonObject = new JSONObject(odata);
            JSONArray jArray = jsonObject.getJSONArray("list");
            for(int i=0; i<jArray.length(); i++){
                JSONObject jlist = jArray.getJSONObject(i);
                Long udate = jlist.getLong("dt");
                Date date = new Date(udate * 1000);
                SimpleDateFormat dateformat =
                        new SimpleDateFormat("yyyy-MM-ddEHH:mm:ss");

                JSONObject jmain = jlist.getJSONObject("main");
                temperature = jmain.getDouble("temp");
                humidity = jmain.getInt("humidity");
                presult += dateformat.format(date) + " temperature =" + temperature
                        + ", "+ "humidity =" + humidity +"\n" ;
            }
        }catch (Exception e){
            e.printStackTrace();
            Log.e("JSONParsing","Parsing Error");
        }
        textView.setText(presult);
    }


}
