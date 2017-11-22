package nyc.c4q.whatismyaddress.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.*;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.whatismyaddress.DisplayActivity;
import nyc.c4q.whatismyaddress.R;
import nyc.c4q.whatismyaddress.RecyclerActivity;
import nyc.c4q.whatismyaddress.model.Display;


/**
 * Created by amirahoxendine on 11/21/17.
 */

public class DisplayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private TextView itemTextView;
    private Context context;
    private String text;


    public DisplayViewHolder(View itemView) {
        super(itemView);
        itemTextView = (TextView) itemView.findViewById(R.id.textview_recycler_text);
    }
    public void onBind(Display display) {
        itemTextView.setText(display.getItemViewText());
        context = itemView.getContext();
        text = display.getItemViewText();

    }

    @Override
    public void onClick(View v) {
        Intent displayIntent = new Intent(context, DisplayActivity.class);
        displayIntent.putExtra("item_view_text", text );
    }
}
