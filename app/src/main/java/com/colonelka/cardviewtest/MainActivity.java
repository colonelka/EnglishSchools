package com.colonelka.cardviewtest;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private RecyclerView recView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private ArrayList<Card> cards = new ArrayList<Card>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settingRecyclerView();
    }

    /**
     *This method is used to initialize the recyclerView for the main layout
     *
     * include getting data from JSON file
     * @author COLONELKA
     *
     * @see com.colonelka.cardviewtest.Card
     * @see com.colonelka.cardviewtest.MyAdapter
     *
     * @exception java.io.IOException
     * @exception org.json.simple.parser.ParseException
     *
     */
    private void settingRecyclerView() {
        recView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recView.setHasFixedSize(true);
        mManager = new LinearLayoutManager(this);
        recView.setLayoutManager(mManager);

        JSONParser parser = new JSONParser();
        String univName;
        String univCity;
        try {

            InputStream is = getResources().openRawResource(R.raw.universities);
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            Object obj = parser.parse(total.toString());
            JSONArray jsonArray = (JSONArray) obj;

            for(int i = 0 ; i<jsonArray.size();i++){
                JSONObject obj1 = (JSONObject) jsonArray.get(i);
                univName = (String) obj1.get("Institution_Name");
                univCity = (String) obj1.get("Institution_City");
                cards.add(new Card(univName,
                        univCity));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        mAdapter = new MyAdapter(cards);

        recView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
