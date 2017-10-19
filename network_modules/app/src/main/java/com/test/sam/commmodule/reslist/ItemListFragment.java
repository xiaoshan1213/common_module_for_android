package com.test.sam.commmodule.reslist;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.sam.commmodule.BaseApplication;
import com.test.sam.commmodule.Models.ModelItem;
import com.test.sam.commmodule.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ItemListFragment extends android.support.v4.app.Fragment implements ItemListView{

    @Inject
    ItemListPresenter itemsPresenter;
    private List<ModelItem> items = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    @Bind(R.id.listing_item)
    RecyclerView itemListView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("fragment_create", "create");
        super.onCreate(savedInstanceState);
        ((BaseApplication)getActivity().getApplication()).createListComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.d("fragment_createview", "createview");
        View rootView = inflater.inflate(R.layout.fragment_item_list, container, false);
        ButterKnife.bind(this, rootView);
        initLayoutRefs();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("fragment_viewcreated", "viewcreated");
        super.onViewCreated(view, savedInstanceState);
        itemsPresenter.setView(this);
    }

    private void initLayoutRefs(){

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        Log.d("fragment_initadapter", items.toString());
        ModelItem testModel = new ModelItem();
        testModel.setId("123");
        testModel.setName("sam");
        testModel.setDescrpition("helllo");
        items.add(testModel);
        adapter = new ItemListAdapter(items, this);
        itemListView.setAdapter(adapter);
        itemListView.setLayoutManager(manager);

    }

    @Override
    public void showItems(List<ModelItem> items) {
        Log.d("fragment_showitems", items.toString());
        this.items.clear();
        this.items.addAll(items);
        itemListView.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemSelected(ModelItem item) {
        //link to activity using another interface
    }
}
