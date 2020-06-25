package k.wakir.covid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import k.wakir.covid.R;
import k.wakir.covid.models.ContinentList;
import k.wakir.covid.models.IndiaList;

public class IndiaListAdapter extends RecyclerView.Adapter<IndiaListAdapter.IndiaHolder> {
    private Context mContext;
    private ArrayList<IndiaList> mIndiaLists;
    private OnStateClickListener mOnStateClickListener;

    public interface OnStateClickListener{
        public void onStateClick(int position);
    }
    public IndiaListAdapter(Context context, ArrayList<IndiaList> indiaLists, OnStateClickListener onStateClickListener){
        mContext = context;
        mIndiaLists = indiaLists;
        mOnStateClickListener = onStateClickListener;
    }
    @NonNull
    @Override
    public IndiaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_india_list_item, parent, false);
        return new IndiaHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IndiaHolder holder, final int position) {
        IndiaList indiaList = mIndiaLists.get(position);
        holder.mStateName.setText(indiaList.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnStateClickListener.onStateClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mIndiaLists.size();
    }

    static class IndiaHolder extends RecyclerView.ViewHolder{
        TextView mStateName;
        public IndiaHolder(@NonNull View itemView) {
            super(itemView);
            mStateName = itemView.findViewById(R.id.state_name);
        }
    }
}
