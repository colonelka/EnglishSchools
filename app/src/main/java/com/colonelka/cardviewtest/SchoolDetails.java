package com.colonelka.cardviewtest;

import android.app.Activity;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;




public class SchoolDetails extends Activity{

    private TextView tvSchName;
    private TextView tvSchDesc;
    private ImageView image;
    private Card cards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_desc_layout);
        initializeVars();

    }

    /**
     * This method initialize all the variable
     *
     * and get the data passes through the previous class
     *
     * @author COLONELKA
     * @see com.colonelka.cardviewtest.MyAdapter.ViewHolder
     */
    private void initializeVars() {

        cards = (Card) getIntent().getSerializableExtra("cards");
        tvSchName = (TextView) findViewById(R.id.tvSchName);
        tvSchDesc = (TextView) findViewById(R.id.tvSchDesc);
        image = (ImageView) findViewById(R.id.imageView);
        image.setImageResource(R.drawable.bug1);
        tvSchName.setText(cards.getName());
        StringBuilder k = new StringBuilder();
        for(int i = 0 ; i<=100 ; i++){
            k.append(cards.getName()+" description \n");
        }
        tvSchDesc.setText(k.toString());
    }
}
