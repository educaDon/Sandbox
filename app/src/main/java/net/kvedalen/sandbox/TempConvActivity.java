package net.kvedalen.sandbox;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DecimalFormat;

public class TempConvActivity extends Activity {

    private Button c2fButton;
    private Button f2cButton;
    private EditText tempInput;
    private TextView tempOutput;
    DecimalFormat round = new DecimalFormat("0.0");
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_conv);

        tempInput = (EditText) findViewById(R.id.editTextId);
        c2fButton = (Button) findViewById(R.id.button_c2fId);
        f2cButton = (Button) findViewById(R.id.button_f2cId);
        tempOutput = (TextView) findViewById(R.id.output_textId);

        c2fButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String tempIn_string = tempInput.getText().toString();
                if (tempIn_string.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_LONG).show();
                } else {
                    double tempIn_double = Double.parseDouble(tempIn_string);
                    double converted_double = c2f(tempIn_double);
                    String stringResult = String.valueOf(round.format(converted_double));
                    tempOutput.setText(stringResult + " \u00B0F");
                }
            }
        });

        f2cButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String tempIn_string = tempInput.getText().toString();
                if (tempIn_string.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_LONG).show();
                } else {
                    double tempIn_double = Double.parseDouble(tempIn_string);

                    String stringResult = String.valueOf(round.format(f2c(tempIn_double)));

                    tempOutput.setText(stringResult + " \u00B0C");
                }
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public double c2f(double c) {
        double result = c * 9 / 5 + 32;
        return result;
    }

    public double f2c(double f) {
        double result = (f - 32) * 5 / 9;
        return result;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TempConv Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.kvedalen.sandbox/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "TempConv Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://net.kvedalen.sandbox/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
