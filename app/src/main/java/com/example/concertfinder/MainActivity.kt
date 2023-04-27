package com.example.concertfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {

    // define variables which will hold concert info

    // these lists hold all info we need for each recycler view
    // [dates], [venues], [ticket URLs], [picture URLs], [cities], [states], [short titles], [average prices]
    //private lateinit var concertDateList: MutableList<String>
    //private lateinit var concertVenueList: MutableList<String>
    //private lateinit var concertTicketURLList: MutableList<String>
    //private lateinit var concertPictureURLList: MutableList<String>
    //private lateinit var concertCityList: MutableList<String>
    //private lateinit var concertStateList: MutableList<String>
    //private lateinit var concertShortTitleList: MutableList<String>
    //private lateinit var concertAveragePriceList: MutableList<String>

    // this is a list of all of the above lists which can be passed to the recycler view


    // recycler view variable
    private lateinit var rvConcerts: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize variables defined above

        //concertDateList = mutableListOf()
        //concertVenueList = mutableListOf()
        //concertTicketURLList = mutableListOf()
        //concertPictureURLList = mutableListOf()
        //concertCityList = mutableListOf()
        //concertStateList = mutableListOf()
        //concertShortTitleList = mutableListOf()
        //concertAveragePriceList = mutableListOf()

        // initialize search variables
        val searchButton = findViewById<Button>(R.id.concertButton)
        val searchText = findViewById<EditText>(R.id.enterzipcode)
        // connect recycler view to id in xml file
        rvConcerts = findViewById(R.id.concertRecyclerView)

        getConcertData()

        Log.d("Concert Data", "Concert Data obtained")

        searchButton.setOnClickListener{
            var input = searchText.text.toString()
            searchConcert(input)
        }
    }

    private fun getConcertData(){

        val client = AsyncHttpClient()

        // geoip corresponds to zipcode. we should collect zipcode in a variable and pass this to the string below
        // to pull up all concerts in that zipcode.
        // API call is currently set to populate 100 concerts. you can change this by altering
        // per_page number.
        client["https://api.seatgeek.com/2/events?per_page=100&geoip=60639&sort=datetime_local.asc&taxonomies.name=concert&client_id=MzMxMjE4NTl8MTY4MTY5MTMyMi4yMzU5NDc&client_secret=50e2878b072fd825d75103491d8ded459ec8d3f53e63314ac0c731877934762a", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("Concert", "response successful$json")
                val concertInfoLists = ArrayList<ConcertData>()
                // 100 because our API call pulled 100 concerts - alter this number if needed
                for (i in 0 until 100) {

                    // add info to the respective lists

                    val concertDate = (json.jsonObject.getJSONArray("events").getJSONObject(i).get("datetime_utc").toString())
                    val concertLocation = (json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("name").toString())
                    //concertTicketURLList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).get("url").toString())
                    val concertImage = (json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONArray("performers").getJSONObject(0).get("image").toString())
                    //concertCityList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("city").toString())
                    //concertStateList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("state").toString())
                    val concertName = (json.jsonObject.getJSONArray("events").getJSONObject(i).get("short_title").toString())
                    //concertAveragePriceList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("stats").get("average_price").toString())

                    concertInfoLists.add(
                        ConcertData(
                            concertName,
                            concertLocation,
                            concertDate,
                            concertImage

                        )
                    )
                }

                //concertInfoLists = mutableListOf(concertShortTitleList, concertDateList, concertVenueList, concertPictureURLList)


                // adapter code - ConcertAdapter is the name of the adapter class
                // pass the list of lists to that class


                rvConcerts.adapter = ConcertAdapter(concertInfoLists)
                rvConcerts.layoutManager = LinearLayoutManager(this@MainActivity)
                rvConcerts.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))


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
    private fun searchConcert(input: String) {
        val client = AsyncHttpClient()


        client["https://api.seatgeek.com/2/events?per_page=100&geoip=$input&sort=datetime_local.asc&taxonomies.name=concert&client_id=MzMxMjE4NTl8MTY4MTY5MTMyMi4yMzU5NDc&client_secret=50e2878b072fd825d75103491d8ded459ec8d3f53e63314ac0c731877934762a", object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Headers, json: JsonHttpResponseHandler.JSON) {
                Log.d("searchConcert", "response successful$json")
                val concertInfoLists = ArrayList<ConcertData>()
                // 100 because our API call pulled 100 concerts - alter this number if needed
                for (i in 0 until 100) {

                    // add info to the respective lists

                    val concertDate = (json.jsonObject.getJSONArray("events").getJSONObject(i).get("datetime_utc").toString())
                    val concertLocation = (json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("name").toString())
                    //concertTicketURLList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).get("url").toString())
                    val concertImage = (json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONArray("performers").getJSONObject(0).get("image").toString())
                    //concertCityList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("city").toString())
                    //concertStateList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("venue").get("state").toString())
                    val concertName = (json.jsonObject.getJSONArray("events").getJSONObject(i).get("short_title").toString())
                    //concertAveragePriceList.add(json.jsonObject.getJSONArray("events").getJSONObject(i).getJSONObject("stats").get("average_price").toString())

                    concertInfoLists.add(
                        ConcertData(
                            concertName,
                            concertLocation,
                            concertDate,
                            concertImage

                        )
                    )
                }

                //concertInfoLists = mutableListOf(concertShortTitleList, concertDateList, concertVenueList, concertPictureURLList)


                // adapter code - ConcertAdapter is the name of the adapter class
                // pass the list of lists to that class


                rvConcerts.adapter = ConcertAdapter(concertInfoLists)
                rvConcerts.layoutManager = LinearLayoutManager(this@MainActivity)
                rvConcerts.addItemDecoration(DividerItemDecoration(this@MainActivity, LinearLayoutManager.VERTICAL))


            }

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                errorResponse: String,
                throwable: Throwable?
            ) {
                Log.d("Concert Search Error", errorResponse)

            }
        }]
    }
}
