package k.wakir.covid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import k.wakir.covid.R;
import k.wakir.covid.models.CountryList;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryListHolder> {

    private Context mContext;
    private ArrayList<CountryList> mCountryLists;
    private OnCountrySelected mOnCountrySelected;

    public CountryListAdapter(Context context, ArrayList<CountryList> countryLists, OnCountrySelected onCountrySelected){
        mContext = context;
        mCountryLists = countryLists;
        mOnCountrySelected = onCountrySelected;
    }
    public interface OnCountrySelected{
        public void onCountrySelected(int position);
    }
    @NonNull
    @Override
    public CountryListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate( R.layout.layout_contry_list_view, parent, false);
        return new CountryListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListHolder holder, final int position) {
        CountryList countryList = mCountryLists.get(position);
        Picasso.get().load(countryList.getImageUrl()).into(holder.mFlag);
        holder.mCountryName.setText(countryList.getCountryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnCountrySelected.onCountrySelected(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCountryLists.size();
    }

    static class CountryListHolder extends RecyclerView.ViewHolder{
        ImageView mFlag;
        TextView mCountryName;
        public CountryListHolder(@NonNull View itemView) {
            super(itemView);
            mFlag = itemView.findViewById(R.id.flag_image);
            mCountryName = itemView.findViewById(R.id.country_name);
        }
    }
}
