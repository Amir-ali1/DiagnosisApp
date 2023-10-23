package com.example.diagnosisapp;
import static com.example.diagnosisapp.MainActivity.list2;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class adapterClass extends RecyclerView.Adapter<adapterClass.ExampleViewHolder> implements Filterable {
    private List<symptomsClass> exampleList;
    private List<symptomsClass> exampleListFull;
    static int index=0;

    class ExampleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView1;
        TextView textView2;

        ExampleViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            String data= textView1.getText().toString();
            index=0;
            for (index=0;index<list2.size();index++)
            {
                if (list2.get(index).equals(data))
                {
                    break;
                }
            }
            
            itemView.getContext().startActivity(new Intent(itemView.getContext(), DiseasesActivity.class));
//              Toast.makeText(view.getContext(), list2.get(index), Toast.LENGTH_SHORT).show();
        }
    }

    adapterClass(List<symptomsClass> exampleList) {
        this.exampleList = exampleList;
        exampleListFull = new ArrayList<>(exampleList);
    }


    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.symptoms_layout,
                parent, false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        symptomsClass currentItem = exampleList.get(position);

        holder.imageView.setImageResource(R.drawable.ic_baseline_medical_services_24);
        holder.textView1.setText(currentItem.getText1());

        String data= "";

        for(int i=0;i<130;i++)
        {
            data+=currentItem.getText2().charAt(i);
        }
        data+="...";
      //  holder.textView2.setText(data);
        holder.textView2.setText(data);
    }

    @Override
    public int getItemCount() {
        return exampleList.size();
    }




    //FIlterable Data Portion
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<symptomsClass> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (symptomsClass item : exampleListFull) {
                    if (item.getText1().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            exampleList.clear();
            exampleList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}





