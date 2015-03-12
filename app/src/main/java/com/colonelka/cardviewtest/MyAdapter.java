package com.colonelka.cardviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author COLONELKA
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private static ArrayList<Card> cards = new ArrayList<Card>();


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView schoolName;
        TextView schoolCity;

        public ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            schoolName = (TextView) v.findViewById(R.id.school_name_text);
            schoolCity = (TextView) v.findViewById(R.id.school_city_text);

        }

        @Override
        public void onClick(View v) {
            Intent schoolDescIntent = new Intent(v.getContext(),SchoolDetails.class);
            Bundle mBundle = new Bundle();

            mBundle.putSerializable("cards",cards.get(getPosition()));

            schoolDescIntent.putExtras(mBundle);

            v.getContext().startActivity(schoolDescIntent);


        }
    }



    public MyAdapter(ArrayList<Card> cards) {
        this.cards = cards;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_layout, parent, false);


        ViewHolder vh = new ViewHolder(v);

        return vh;
    }



    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Card c1 = cards.get(position);
        holder.schoolName.setText(c1.getName());
        holder.schoolCity.setText(c1.getCity());


    }


    @Override
    public int getItemCount() {
        return cards.size();
    }
}