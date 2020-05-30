package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Set;

public class BaroqueActivity extends AppCompatActivity implements ListView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_list);


        // Create an array of opuses.
        ArrayList<Opus> opuses = new ArrayList<Opus>();

        // Adding opuses to an array.
        opuses.add(new Opus("Jasleen Royal",
                            "Kho gaye hum kahan"));
        opuses.add(new Opus("Zaeden",
                            "Kya karoon"));
        opuses.add(new Opus("Prateek Kuhad",
                            "Saansein"));
        opuses.add(new Opus("Ed Sheeran",
                            "Dive"));
        opuses.add(new Opus("Ed Sheeran",
                            "Photograph"));
        opuses.add(new Opus("Jason Mraz",
                            "Lets see what the night can do"));
        opuses.add(new Opus("Vilen",
                            "Chidiya"));
        opuses.add(new Opus("Lord Huron",
                            "The night we met"));
        opuses.add(new Opus("Dino James",
                            "Whishlist"));
        opuses.add(new Opus("Powfu",
                            "Death bed"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        OpusAdapter adapter = new OpusAdapter(this, opuses);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // play_list file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

        // Set OnClickListener on ListView to identify the item on ListView clicked by user
        // Text on the ListView item clicked is passed on to PlayerActivity
        listView.setOnItemClickListener(this);
    }

    /**
     * Method to identify ListView item clicked and launch PlayerActivity
     */
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Get the selected opus.
        Opus currentOpus = (Opus) adapterView.getItemAtPosition(position);

        // Extract strings from Opus object.
        String opusForPlaying = currentOpus.getOpus();
        String composerForPlaying = currentOpus.getNameOfComposer();

        // Sending the name of composer and his opus to PlayerActivity.
        Intent opusIntent = new Intent(this, PlayerActivity.class);
        opusIntent.putExtra("opus", opusForPlaying);
        opusIntent.putExtra("composer", composerForPlaying);
        startActivity(opusIntent);
    }
}
