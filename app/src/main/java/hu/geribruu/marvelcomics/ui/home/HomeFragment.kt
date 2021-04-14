package hu.geribruu.marvelcomics.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import hu.geribruu.marvelcomics.R
import hu.geribruu.marvelcomics.navigator.AppNavigator
import hu.geribruu.marvelcomics.network.CharacterApi
import hu.geribruu.marvelcomics.network.model.CharacterDataWrapper
import hu.geribruu.marvelcomics.network.model.CharacterNet
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    @Inject lateinit var navigator: AppNavigator
    @Inject lateinit var service: CharacterApi

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

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

        return root
    }
}