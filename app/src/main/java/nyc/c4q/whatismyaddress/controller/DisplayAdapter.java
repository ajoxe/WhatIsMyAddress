package nyc.c4q.whatismyaddress.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.model.Display;
import nyc.c4q.whatismyaddress.view.DisplayViewHolder;

/**
 * Created by amirahoxendine on 11/21/17.
 */

public class DisplayAdapter extends RecyclerView.Adapter<DisplayViewHolder> {
    private List<Display> displayList;

    public DisplayAdapter(List<Display> displayList) {
        this.displayList = displayList;
    }
    @Override
    public DisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_view, parent, false);
        return new DisplayViewHolder(childView);

    }


    @Override
    public void onBindViewHolder(final DisplayViewHolder holder, int position) {
       Display display =displayList.get(position);
        holder.onBind(display);


    }

    @Override
    public int getItemCount() {
        return displayList.size();
    }
}
