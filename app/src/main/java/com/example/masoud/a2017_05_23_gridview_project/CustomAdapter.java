package com.example.masoud.a2017_05_23_gridview_project;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.masoud.a2017_05_23_gridview_project.Model.CalculationModel;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by masoud on 2017-05-27.
 */

class CustomAdapter extends BaseAdapter
{

    private Context context;
    private ArrayList<CalculationModel> calculationModelArrayList;



    public CustomAdapter(Context context, ArrayList<CalculationModel> calculationModelArrayList) {
        this.context = context;
        this.calculationModelArrayList = calculationModelArrayList;
    }

    @Override
    public int getCount() {
        return calculationModelArrayList.size() * 6;
    }

    @Override
    public Object getItem(int position) {
        return calculationModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setHeight(120);
        textView.setBackgroundColor(Color.argb(100,128,255,191));


        int row = position / 6;
        CalculationModel currentCalculationModel = (CalculationModel) getItem(row);



        if( position % 6 == 0){
            textView.setText(String.valueOf(currentCalculationModel.getOperand1()));
        }else if (position % 6 == 1){
            textView.setText(String.valueOf(currentCalculationModel.getOperator()));
        }else if (position % 6 == 2){
            textView.setText(String.valueOf(currentCalculationModel.getOperand2()));
        }else if (position % 6 == 3){
            textView.setText("=");
        }else if (position % 6 == 4){
            if(currentCalculationModel.isUserAnswered()){
                textView.setText(String.valueOf(currentCalculationModel.getUserAnswer()));
            }else { textView.setText("?");}
        }else {
            ImageView imageView = new ImageView(context);

            if(currentCalculationModel.isUserAnswered() && !currentCalculationModel.isUserAnswerRight()){
                imageView.setImageResource(R.drawable.bad);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(120,120));
            }else {
                imageView.setImageResource(R.drawable.ok);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(120,120));
            }
            return imageView;
        }
        return textView;
    }
}
