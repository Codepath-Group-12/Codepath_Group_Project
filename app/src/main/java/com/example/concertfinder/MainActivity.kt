package com.example.concertfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONArray
import org.json.JSONObject
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // define variables which will hold concert info

    // these lists hold all info we need for each recycler view
    // [dates], [venues], [ticket URLs], [picture URLs], [cities], [states], [short titles], [average prices]
    private lateinit var concertDateList: MutableList<String>
    private lateinit var concertVenueList: MutableList<String>
    private lateinit var concertTicketURLList: MutableList<String>
    private lateinit var concertPictureURLList: MutableList<String>
    private lateinit var concertCityList: MutableList<String>
    private lateinit var concertStateList: MutableList<String>
    private lateinit var concertShortTitleList: MutableList<String>
    private lateinit var concertAveragePriceList: MutableList<String>

    // this is a list of all of the above lists which can be passed to the recycler view
    private lateinit var concertInfoLists: MutableList<List<String>>

    // recycler view variable
    //private lateinit var rvConcerts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize variables defined above

        concertDateList = mutableListOf()
        concertVenueList = mutableListOf()
        concertTicketURLList = mutableListOf()
        concertPictureURLList = mutableListOf()
        concertCityList = mutableListOf()
        concertStateList = mutableListOf()
        concertShortTitleList = mutableListOf()
        concertAveragePriceList = mutableListOf()

        // connect recycler view to id in xml file
        //rvConcerts = findViewById(R.id.concert_list)

        getConcertData()

        Log.d("Concert Data", "Concert Data obtained")

    }

    private fun getConcertData() {

        val client = AsyncHttpClient()

        // geoip corresponds to zipcode. we should collect zipcode in a variable and pass this to the string below
        // to pull up all concerts in that zipcode.
        // API call is currently set to populate 100 concerts. you can change this by altering
        // per_page number.
        client["https://api.seatgeek.com/2/events?per_page=100&geoip=60639&sort=datetime_local.asc&taxonomies.name=concert&client_id=MzMxMjE4NTl8MTY4MTY5MTMyMi4yMzU5NDc&client_secret=50e2878b072fd825d75103491d8ded459ec8d3f53e63314ac0c731877934762a", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Concert", "response successful$json")

                // 100 because our API call pulled 100 concerts - alter this number if needed
                for (i in 0 until 100) {

                    // add info to the respective lists

                    concertDateList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).get("datetime_utc").toString())
                    concertVenueList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("name").toString())
                    concertTicketURLList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).get("url").toString())
                    concertPictureURLList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONArray("performers").getJSONObject(0).get("image").toString())
                    concertCityList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("city").toString())
                    concertStateList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("state").toString())
                    concertShortTitleList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).get("short_title").toString())
                    concertAveragePriceList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("stats").get("average_price").toString())

                }

                concertInfoLists = mutableListOf(concertShortTitleList, concertDateList, concertCityList, concertStateList, concertVenueList, concertPictureURLList, concertTicketURLList, concertAveragePriceList)


                // adapter code - ConcertAdapter is the name of the adapter class
                // pass the list of lists to that class
/*
                val adapter = ConcertAdapter(concertInfoLists)
                rvConcerts.adapter = adapter
                rvConcerts.layoutManager = LinearLayoutManager(this@MainActivity)
                rvConcerts.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))
                */

            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Concert Error", errorResponse)
            }
        }]
    }
}