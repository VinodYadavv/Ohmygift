package virgosys.com.ohmygift;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vinod on 6/10/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Catagaries> categoriesList;

    private List<Catagaries> categoriesList1;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.rank);

        }
    }


    public RecyclerAdapter(MainActivity mainActivity, List<Catagaries> categoriesList) {
        this.categoriesList = categoriesList;
        this.categoriesList1 = categoriesList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cat, parent, false);



        return new MyViewHolder(itemView);
    }

	/*@Override
	public ListViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}*/


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Catagaries categories = categoriesList.get(position);
        holder.title.setText(categories.getMenus());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                notifyDataSetChanged();

            }
        });

    }
	/*@Override
	public void onBindViewHolder(ListViewAdapter.MyViewHolder holder, int position) {

	}*/


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}
