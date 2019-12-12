package com.example.recyclerviewoptionmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<RecyclerItem> listItems;
    private Context context;

    MyAdapter(List<RecyclerItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {

      RecyclerItem itemList = listItems.get(position);

      holder.title.setText(itemList.getTitle());
      holder.description.setText(itemList.getDescription());

      holder.txtOptionDigit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              PopupMenu popupMenu = new PopupMenu(context, holder.txtOptionDigit);
              popupMenu.inflate(R.menu.option_menu);

              popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                  @Override
                  public boolean onMenuItemClick(MenuItem item) {

                      switch (item.getItemId()){
                          case R.id.mnu_item_save:
                              Toast.makeText(context,"Saved",Toast.LENGTH_LONG).show();
                              break;

                          case R.id.mnu_item_delete:
                              listItems.remove(position);
                              notifyDataSetChanged();
                              Toast.makeText(context,"Deleted",Toast.LENGTH_LONG).show();
                              break;

                          default:
                              break;
                      }
                      return false;
                  }
              });
              popupMenu.show();
          }
      });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,description,txtOptionDigit;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            description = itemView.findViewById(R.id.txtDescription);
            txtOptionDigit = itemView.findViewById(R.id.txtOptionDigit);
        }
    }
}
