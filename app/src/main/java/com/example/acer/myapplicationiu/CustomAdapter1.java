package com.example.acer.myapplicationiu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class CustomAdapter1 extends BaseAdapter implements Filterable {
        Context ct;
        CustomFilter filter;
        ArrayList<MedikamentetModel> filterList;
        ArrayList<MedikamentetModel> medikamentetModel1;

        public CustomAdapter1(Context ctx, ArrayList<MedikamentetModel> medikamentetModel) {
            this.ct = ctx;
            this.medikamentetModel1 = medikamentetModel;
            this.filterList = medikamentetModel;
        }

        @Override
        public int getCount() {
            return medikamentetModel1.size();
        }

        @Override
        public Object getItem(int position) {
            return medikamentetModel1.get(position);
        }

        @Override
        public long getItemId(int position) {
            return medikamentetModel1.indexOf(getItem(position));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.interaksionet, null);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.IntMedTxt);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.IntMedImg);
            textView.setText(medikamentetModel1.get(position).getName());
            imageView.setImageResource(medikamentetModel1.get(position).getImg());
            return convertView;
        }

        @Override
        public Filter getFilter() {
            if (filter == null) {
                filter = new CustomFilter();
            }
            return filter;
        }

        class CustomFilter extends Filter {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                if (constraint != null && constraint.length() > 0) {
                    constraint = constraint.toString().toUpperCase();
                    ArrayList<MedikamentetModel> filters = new ArrayList<MedikamentetModel>();
                    for (int i = 0; i < filterList.size(); i++) {
                        if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
                            MedikamentetModel m = new MedikamentetModel(filterList.get(i).getName(), filterList.get(i).getImg());
                            filters.add(m);
                        }

                    }
                    results.count = filters.size();
                    results.values = filters;
                } else {
                    results.count = filterList.size();
                    results.values = filterList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                medikamentetModel1 = (ArrayList<MedikamentetModel>) results.values;
                notifyDataSetChanged();
            }
        }
    }

