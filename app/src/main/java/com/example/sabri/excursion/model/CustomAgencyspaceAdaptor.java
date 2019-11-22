package com.example.sabri.excursion.model;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sabri.excursion.R;

public class CustomAgencyspaceAdaptor extends ArrayAdapter {
    private final Activity context;
    private final Integer[] image;
    private final String[] destination;
    private final Integer[] month;
    private final Integer[] day;

    public CustomAgencyspaceAdaptor(Activity context, String[] trip_destination, Integer[] trip_month, Integer[] trip_day, Integer[] trip_image) {
        super(context, R.layout.agencyspace_row, trip_destination);

        this.context = context;
        this.image = trip_image;
        this.destination = trip_destination;
        this.month = trip_month;
        this.day = trip_day;

    }

    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup parent ) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View rowView = inflater.inflate(R.layout.agencyspace_row, null, true);

        //this code gets references to objects in the listview_row.xml file
        ImageView image_view = rowView.findViewById(R.id.aimageViewID);
        TextView destination_view = rowView.findViewById(R.id.adestinationID);
        TextView month_view = rowView.findViewById(R.id.amonthID);

        TextView day_view = rowView.findViewById(R.id.adayID);

        //this code sets the values of the objects to values from the arrays
        destination_view.setText(destination[position]);
        month_view.setText(month[position]);
        day_view.setText(day[position]);
        image_view.setImageResource(image[position]);

        return rowView;

    }
}
