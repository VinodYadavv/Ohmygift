package virgosys.com.ohmygift;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vinod on 6/10/16.
 */
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private List<Catagaries> categoriesList;

   Activity activity;
    RecyclerView recyclerView1;



    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.rank);
            //imageView=(ImageView)view.findViewById(R.id.imageView);



        }
    }


    public ProductAdapter(MainActivity mainActivity, List<Catagaries> categoriesList) {
        this.categoriesList = categoriesList;
        this.activity=mainActivity;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product, parent, false);

        return new MyViewHolder(itemView);
    }

	/*@Override
	public ListViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		return null;
	}*/


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Catagaries categories = categoriesList.get(position);
        holder.title.setText(categories.getMenus());





        //Picasso.with(this.activity)
                //.load("http://tineye.com/images/widgets/mona.jpg")
                //.into(holder.imageView);


    }
	/*@Override
	public void onBindViewHolder(ListViewAdapter.MyViewHolder holder, int position) {

	}*/


    @Override
    public int getItemCount() {
        return categoriesList.size();
    }
}
