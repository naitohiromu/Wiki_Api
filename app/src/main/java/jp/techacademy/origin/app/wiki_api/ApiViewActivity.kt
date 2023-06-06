
package jp.techacademy.origin.app.wiki_api
/*
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import android.util.Log
import androidx.appcompat.app.AlertDialog
import jp.techacademy.origin.app.wiki_api.databinding.ActivityApiViewBinding

class ApiViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityApiViewBinding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityApiViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        private const val KEY_URL = "key_url"
        private const val VIEW_PAGER_POSITION_API = 0
        private const val VIEW_PAGER_POSITION_FAVORITE = 1
        fun start(activity: Activity, url:String,id:String,logoImage:String,name:String,address:String) {
            val intent = Intent(activity,ApiViewActivity::class.java)
            intent.putExtra(KEY_URL,url)
            intent.putExtra("id",id)
            intent.putExtra("logoImage",logoImage)
            intent.putExtra("name",name)
            intent.putExtra("address",address)
            activity.startActivity(intent)
            /*
            activity.startActivity(
                Intent(activity, WebViewActivity::class.java).putExtra(
                    KEY_URL,
                    url
                )
            )

            val url = StringBuilder()
                .append(getString(R.string.base_summonerurl)) // https://webservice.recruit.co.jp/hotpepper/gourmet/v1/
                .append(summoner_name)
                .append("?api_key=").append(getString(R.string.api_key)) // Apiを使うためのApiKey
                .toString()
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
            val request = Request.Builder()
                .url(url)
                .build()
             */
        }
    }
}

 */