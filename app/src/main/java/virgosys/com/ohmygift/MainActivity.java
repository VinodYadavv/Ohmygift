package virgosys.com.ohmygift;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    String catagary_url=Const.CATAGGARY_URL;
    String product_url=Const.PRODUCT_URL;


    ArrayList<Catagaries> arraylist = new ArrayList<Catagaries>();
    RecyclerView recyclerView,recyclerView1;

    JSONArray jsonArray;
    String[] rank1;

    RecyclerAdapter adapter;
    ProductAdapter adapter1;

    Toolbar toolbar;



    String[] testing={"R.drawable.ic_menu_camera","R.drawable.ic_menu_camera","R.drawable.ic_menu_camera","R.drawable.ic_menu_camera"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.list2);
        recyclerView1=(RecyclerView)findViewById(R.id.list3);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        new MyAsyncTask(Const.CATAGGARY_URL).execute();

        adapter=new RecyclerAdapter(MainActivity.this,arraylist);
        adapter1=new ProductAdapter(MainActivity.this,arraylist);

        for (int i = 0; i < testing.length; i++) {
            Catagaries wp = new Catagaries(testing[i]);
            arraylist.add(wp);
            recyclerView1.setHasFixedSize(true);
            //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());


        }


        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView1.setLayoutManager(horizontalLayoutManagaer);
        recyclerView1.setAdapter(adapter1);









        //drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement
        if (id == R.id.login) {
            LoginFragment fragment1 = new LoginFragment();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, fragment1);
            fragmentTransaction.commit();
            return true;
        }


        if (id == R.id.search) {

            SearchFragment fragment1 = new SearchFragment();
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, fragment1);
            fragmentTransaction.commit();


            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class MyAsyncTask extends AsyncTask<Void, Integer, Boolean>  {

        String url;

        public MyAsyncTask(String url) {

        }

        @Override
        protected Boolean doInBackground(Void... params) {

            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();


            postParameters.add(new BasicNameValuePair("status",
                    "friends"));


            try {
               String response = SimpleHttpClient
                        .executeHttpPost(
                                "http://oohmygift.com/wp/p-categories.php",postParameters);




                jsonArray = new JSONArray(response);

                rank1 = new String[jsonArray.length()];
                try {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        rank1[i] = jsonArray.getString(i);
                        Catagaries wp = new Catagaries(rank1[i]);
                        arraylist.add(wp);
                    }
                }


                catch(Exception e){

                }



            }catch (Exception e){

            }

            return null;
        }



        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }
        @Override
        protected void onPostExecute(Boolean uploaded) {
            // TODO Auto-generated method stub
            super.onPostExecute(uploaded);


            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(adapter);

            System.out.println("omgevening"+recyclerView);





        }
    }

}





