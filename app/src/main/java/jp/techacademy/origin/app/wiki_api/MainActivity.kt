package jp.techacademy.origin.app.wiki_api

import java.net.URLEncoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import jp.techacademy.origin.app.wiki_api.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            var str: String = URLEncoder.encode(binding.editText.text.toString(),"utf-8")
            //R.id.text_test = URLEncoder.encode(str,"utf-8")
            //Log.d("test", URLEncoder.encode(str,"utf-8"))
            binding.textBlank.text = str
            ApiFragment.start(this,str)
        }
        /*
        binding.button2.setOnClickListener {
            binding.textBlank.text
        }

         */
        //RGAPI-8c91dba2-1ea4-4042-b89e-156bcd687223
    }//https://jp1.api.riotgames.com//lol/summoner/v3/summoners/by-name/多摩川のoner
}//https://jp1.api.riotgames.com/lol/summoner/v4/summoners/by-name/多摩川Oner?api_key=RGAPI-8c91dba2-1ea4-4042-b89e-156bcd687223