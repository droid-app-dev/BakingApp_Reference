package com.example.venky.bakeingAppp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.venky.bakeingAppp.Activity.StepListActivity;
import com.example.venky.bakeingAppp.Models.Recipe;
import com.example.venky.bakeingAppp.Others.ProjectConstants;
import com.example.venky.bakeingAppp.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by VENKY on 24/3/2019.
 */

public class MainRecyclerViewAdapter extends
        RecyclerView.Adapter<MainRecyclerViewAdapter.ViewInformation> {
    Context context;
    List<Recipe> list;

    public MainRecyclerViewAdapter(Context context, List<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainRecyclerViewAdapter.ViewInformation onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_recipe_detail,parent,false);

        return new MainRecyclerViewAdapter.ViewInformation(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainRecyclerViewAdapter.ViewInformation holder, int position) {
        holder.recipeNames.setText(list.get(position).getName());

    }

    @Override
    public int getItemCount() {
        if(list!=null){
            return list.size();
        }
        else return 0;

    }

    public class ViewInformation extends RecyclerView.ViewHolder
            implements View.OnClickListener{
        @BindView(R.id.recipe_title)
        TextView recipeNames;
        public ViewInformation(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, StepListActivity.class);
            intent.putExtra(ProjectConstants.RECIPIE_TITLE,list.get(position).getName());
            intent.putExtra(ProjectConstants.INGREDIENTS_LIST_KEY,(Serializable)list.get(position).getIngredients());
            intent.putExtra(ProjectConstants.STEPS_LIST_KEY,(Serializable)list.get(position).getSteps());
            context.startActivity(intent);

        }
    }
}