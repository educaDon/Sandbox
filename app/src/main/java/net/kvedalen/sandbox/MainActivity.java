package net.kvedalen.sandbox;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {

    private ListView listview;
    private CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] titles = new String[]{
                "Temperature Converter",
                "RadioButtons",
                "Checkboxes",
                "Switches",
                "Login Screen",
                "Grid layout",
        };

        final String[] descriptions = new String[]{
                "Convert between Celcius and Fahrenheit",
                "... for one option only",
                "... for multiple options",
                "... for turning things on/off",
                "... testing Textfields",
                "... with animations!!"
        };

        ArrayList<HashMap<String, String>> datalist = new ArrayList<>();

        for (int i=0 ; i < titles.length ; i++) {

            HashMap<String,String> data = new HashMap<>();
            data.put("title",titles[i]);
            data.put("desc",descriptions[i]);

            datalist.add(data);

        }

        listview = (ListView) findViewById(R.id.listId);
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(), datalist);
        listview.setAdapter(customListViewAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPos = position;
                String itemClicked = listview.getItemAtPosition(myPos).toString();

                Intent intent;

                switch (myPos) {
                    case 0:
                        intent = new Intent(MainActivity.this, TempConvActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, LoginScreenActivity.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this, GridAnimationActivity.class);
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Item clicked: " + itemClicked, Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });


    }
}
