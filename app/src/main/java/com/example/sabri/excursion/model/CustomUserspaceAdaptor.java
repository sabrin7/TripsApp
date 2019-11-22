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

public class CustomUserspaceAdaptor extends ArrayAdapter {
    private final Activity context;
    private final Integer[] image;
    private final String[] destination;
    private final String[] agency;
    private final String[] date;

    public CustomUserspaceAdaptor(Activity context, String[] trip_destination, String[] trip_agency, String[] trip_date, Integer[] trip_image) {
        super(context, R.layout.userspace_row, trip_destination);

        this.context = context;
        this.image = trip_image;
        this.destination = trip_destination;
        this.agency = trip_agency;
        this.date = trip_date;

    }

    @NonNull
    public View getView(int position, View view, @NonNull ViewGroup parent ) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View rowView = inflater.inflate(R.layout.userspace_row, null, true);

        //this code gets references to objects in the listview_row.xml file
        ImageView image_view = rowView.findViewById(R.id.imageViewID);
        TextView destination_view = rowView.findViewById(R.id.destinationID);
        TextView agency_view = rowView.findViewById(R.id.agencyID);
        TextView date_view = rowView.findViewById(R.id.dateID);

        //this code sets the values of the objects to values from the arrays
        destination_view.setText(destination[position]);
        agency_view.setText(agency[position]);
        date_view.setText(date[position]);
        image_view.setImageResource(image[position]);

        return rowView;

    }
}
