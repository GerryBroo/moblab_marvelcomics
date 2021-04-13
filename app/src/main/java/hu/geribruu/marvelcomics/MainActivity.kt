package hu.geribruu.marvelcomics

import android.os.Bundle
import android.util.Log
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.network.CharacterApi
import hu.geribruu.marvelcomics.network.NetworkInterceptor
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import hu.geribruu.marvelcomics.network.model.CharacterNet
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_favourite))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY


        val client = OkHttpClient.Builder()
            .addInterceptor(NetworkInterceptor())
            .addInterceptor(interceptor)
            .build()

        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service = retrofit.create(CharacterApi::class.java)

        service.getCharacters(10,0).enqueue(object : Callback<CharacterDataWrapper> {
            override fun onResponse(
                call: Call<CharacterDataWrapper>,
                response: Response<CharacterDataWrapper>
            ) {
                val result : Array<CharacterNet> = response.body()!!.data.results
                for(r in result) {
                    Log.d("RETROFIT", r.name)
                }
            }

            override fun onFailure(call: Call<CharacterDataWrapper>, t: Throwable) {
                Log.d("RETROFIT", "FAIL")
            }
        })





     /*   call.enqueue(object : Callback<CharacterDataWrapper> {
            override fun onRespone(call: Call<CharacterDataWrapper>, response: Response<CharacterDataWrapper>) {
                if (response.isSuccessful) {
                    val d = response.body()
                }
            }

        })*/


    }
}