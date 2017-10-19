package com.test.sam.commmodule.reslist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.test.sam.commmodule.Models.ModelItem;
import com.test.sam.commmodule.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sam on 7/3/17.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    private List<ModelItem> items;
    private ItemListView itemListView;
    private Context context;

    public ItemListAdapter (List<ModelItem> items, ItemListView view) {
        this.items = items;
        this.itemListView = view;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.d("adapter_createholder", "inflate item");
        this.context = parent.getContext();
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_cell, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d("adapter_bindholder", position+"");
        holder.itemView.setOnClickListener(holder);
        holder.item = items.get(position);
        Log.d("adapter_id", holder.item.getName());
        holder.id.setText(holder.item.getId());
        holder.name.setText(holder.item.getName());
        holder.description.setText(holder.item.getDescrpition());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @Bind(R.id.id)
        TextView id;
        @Bind(R.id.name)
        TextView name;
        @Bind(R.id.description)
        TextView description;
        public ModelItem item;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void onClick(View v) {
            ItemListAdapter.this.itemListView.onItemSelected(item);
        }
    }

}
