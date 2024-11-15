package com.example.imdb_clone_app

import android.util.Log
import retrofit.*

class ApiCall {
    // This function takes a Context and callback function
    // as a parameter, which will be called
    // when the API response is received.
    fun getData(context: Movies, callback: (MoviesData) -> Unit) {

        // Create a Retrofit instance with the base URL and
        // a GsonConverterFactory for parsing the response.
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org/3/").addConverterFactory(
            GsonConverterFactory.create()).build()
        //Log.w("DATA","Done")

        // Create an ApiService instance from the Retrofit instance.
        val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        // Call the getjokes() method of the ApiService
        // to make an API request.
        val call: Call<MoviesData> = service.getData()
        //Log.w("DATA","Done")

        // Use the enqueue() method of the Call object to
        // make an asynchronous API request.
        call.enqueue(object : Callback<MoviesData> {
            // This is an anonymous inner class that implements the Callback interface.
            override fun onResponse(response: Response<MoviesData>, retrofit: Retrofit?) {
                // This method is called when the API response is received successfully.
                Log.w("DATA",response.isSuccess.toString())
                if(response.isSuccess == true){
                    // If the response is successful, parse the
                    // response body to a DataModel object.
                    Log.w("DATA","Done")
                    val Data:MoviesData = response.body() as MoviesData
                    Log.w("DATA","Done")

                    // Call the callback function with the DataModel
                    // object as a parameter.
                    callback(Data)
                }
                else(
                        Log.w("DATA1","Done")
                )
            }

            override fun onFailure(t: Throwable?) {
                Log.w("DATA2","Done")
                // This method is called when the API request fails.
                //Toast.makeText(this, "Request Fail", Toast.LENGTH_SHORT)
            }
        })
    }
}
