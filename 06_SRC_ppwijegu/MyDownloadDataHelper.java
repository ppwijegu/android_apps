package com.example.pivithuru.assignment06;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pivithuru on 8/7/17.
 */

public class MyDownloadDataHelper extends AsyncTask<Void, Integer, List<HashMap<String,?>>> {


    private String dataUrl;
    private final WeakReference<MovieAdapter> myApadter;


    public MyDownloadDataHelper(String url, MovieAdapter adapter){

        this.dataUrl=url;
        System.out.println(url);
        myApadter=new WeakReference<MovieAdapter>(adapter);



    }


    @Override
    protected List<HashMap<String,?>> doInBackground(Void... voids) {
        String results=MyUtility.downloadJSONusingHTTPGetRequest(dataUrl);


        //{"vote_count":2085,"id":315635,"video":false,"vote_average":7.4,"title":"Spider-Man: Homecoming","popularity":94.407524,"poster_path":"\/c24sv2weTHPsmDa7jEMN0m2P3RT.jpg","original_language":"en","original_title":"Spider-Man: Homecoming","genre_ids":[28,12,878],"backdrop_path":"\/vc8bCGjdVp0UbMNLzHnHSLRbBWQ.jpg","adult":false,"overview":"Following the events of Captain America: Civil War, Peter Parker, with the help of his mentor Tony Stark, tries to balance his life as an ordinary high school student in Queens, New York City, with fighting crime as his superhero alter ego Spider-Man as a new threat, the Vulture, emerges.","release_date":"2017-07-05"}

        List<HashMap<String,?>> movieList=new ArrayList<>();

        JSONObject mainObject = null;

        if (results!=null) {
            try {
                mainObject = new JSONObject(results);
                JSONArray resultsObject = mainObject.getJSONArray("results");
                for (int i = 0; i < resultsObject.length(); i++) {


                    JSONObject movie = resultsObject.getJSONObject(i);
                    HashMap movieInfo = new HashMap();
                    movieInfo.put("name", movie.getString("title"));
                    movieInfo.put("image", movie.getString("poster_path"));
                    movieInfo.put("description", movie.getString("overview"));
                    movieInfo.put("id", movie.getString("id"));
                    movieInfo.put("rating", movie.getString("vote_average"));

                    movieList.add(movieInfo);

                    //movieInfo.put("description",)

//                movie.put("image",image);
//                movie.put("name", name);
//                movie.put("description", description);
//                movie.put("year", year);
//                movie.put("length",length);
//                movie.put("rating",rating);
//                movie.put("director",director);
//                movie.put("stars",stars);
//                movie.put("url",url);
//                movie.put("selection",false);


                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }



        return movieList;

    }

    protected void onPostExecute(final List<HashMap<String,?>> results){

        if (myApadter!=null){

           final MovieAdapter mAdapterVal=myApadter.get();
            if(mAdapterVal!=null){
                mAdapterVal.mdata=results;
                mAdapterVal.notifyDataSetChanged();
            }

        }

//        if(fragmentRefrence!=null){
//            final MovieListFragment movieListFrag=fragmentRefrence.get();
//            if(movieListFrag!=null){
//                movieListFrag.mData=results;
//                //mAdapterVal.notifyDataSetChanged();
//            }
//        }




    }
}
