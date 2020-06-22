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


public class ContinentListAdapter extends RecyclerView.Adapter<ContinentListAdapter.ContinentHolder> {

    private Context mContext;
    private ArrayList<ContinentList> mContinentLists;
    private OnContinentClickListener mOnContinentClickListener;

    public interface OnContinentClickListener{
        public void onContinentClick(int position);
    }
    public ContinentListAdapter(Context context, ArrayList<ContinentList> continentLists, OnContinentClickListener continentClickListener){
        mContext = context;
        mOnContinentClickListener = continentClickListener;
        mContinentLists = continentLists;
    }
    @NonNull
    @Override
    public ContinentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_continent_list_item, parent, false);
        return new ContinentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentHolder holder, final int position) {
        ContinentList continentList = mContinentLists.get(position);
        holder.mContinentName.setText(continentList.getContinentName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnContinentClickListener.onContinentClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mContinentLists.size();
    }

    static class ContinentHolder extends RecyclerView.ViewHolder{
        TextView mContinentName;
        public ContinentHolder(@NonNull View itemView) {
            super(itemView);
            mContinentName = itemView.findViewById(R.id.continent_name);
        }
    }
}
