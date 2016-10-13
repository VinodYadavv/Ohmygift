package virgosys.com.ohmygift;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    String response,returnResponse;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);








    }

    public String gettingTheCat() {
        new MyAsyncTask(Const.CATAGGARY_URL).execute();

        return returnResponse;
    }


    private class MyAsyncTask extends android.os.AsyncTask<Void, Integer, Boolean> {

        String url;

        public MyAsyncTask(String url) {
            this.url=url;
        }

        @Override
        protected Boolean doInBackground(Void... params) {

            ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();


            postParameters.add(new BasicNameValuePair("status",
                    "friends"));


            try {
                response = SimpleHttpClient
                        .executeHttpPost(
                                url, postParameters);


                System.out.println("jjjjjj" + response);
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






        }
    }

}





