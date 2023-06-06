package jp.techacademy.origin.app.wiki_api

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat.requireContext
import com.squareup.moshi.Moshi
import jp.techacademy.origin.app.wiki_api.databinding.ActivityApiViewBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.*
import java.io.IOException


class ApiFragment : Fragment(){
    private lateinit var binding: ActivityApiViewBinding
    private val handler = Handler(Looper.getMainLooper())
    private val apiAdapter by lazy { ApiAdapter() }
    private var isLoading = false

    //private var list = mutableListOf<SNResponse>()
    private var list = mutableListOf<SNResponse>()
    //private val apiAdapter by lazy { ApiAdapter() }
    // 一覧画面から登録するときのコールバック（FavoriteFragmentへ通知するメソッド)
    var onClickAddFavorite: ((String,String,String,String) -> Unit)? = null

    // 一覧画面から削除するときのコールバック（ApiFragmentへ通知するメソッド)
    var onClickDeleteFavorite: ((String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityApiViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ここから初期化処理を行う
        // RecyclerViewの初期化
        /*
        binding.recyclerView.apply {
            adapter = apiAdapter
            layoutManager = LinearLayoutManager(requireContext()) // 一列ずつ表示
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            updateData()
        }

         */
        updateData()
        /*
        super.onCreate(savedInstanceState)
        binding = ActivityApiViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
         */
    }

    private fun updateData(){
        val SummonerName = intent.getStringExtra(KEY_URL).toString()
        //binding.webView.loadUrl(url)
        val url = StringBuilder()
            .append(getString(R.string.base_summonerurl)) // https://jp1.api.riotgames.com//lol/summoner/v3/summoners/by-name/
            .append(SummonerName)
            .append("?api_key=").append("RGAPI-982dfbd6-57bc-4fdc-ab67-6d84988e31a9") // 何件目からのデータを取得するか
            .toString()
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
        val request = Request.Builder()
            .url(url)
            .build()
        //Log.d("url",url)
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) { // Error時の処理
                e.printStackTrace()
                handler.post {
                    updateRecyclerView(listOf())
                }
                isLoading = false // 読み込み中フラグを折る
            }

            override fun onResponse(call: Call, response: Response) { // 成功時の処理
                // Jsonを変換するためのAdapterを用意
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(SNResponse::class.java)

                //var list = listOf<SummonerNameResponse>()

                response.body?.string()?.also {
                    val apiResponse = jsonAdapter.fromJson(it)
                    if (apiResponse != null) {
                        list += apiResponse
                    }
                    Log.d("test",list.toString())
                }
                //binding.textTest.text =(list2.toString())
                handler.post {
                    updateRecyclerView(list)
                }
                isLoading = false // 読み込み中フラグを折る

            }
        })
    }
    private fun updateRecyclerView(list: List<SNResponse>) {
        apiAdapter.submitList(list)
        // SwipeRefreshLayoutのくるくるを消す
        //binding.swipeRefreshLayout.isRefreshing = false
    }

    companion object {
        // 1回のAPIで取得する件数
        private const val KEY_URL = "key_url"
        private const val COUNT = 20

        fun start(activity: Activity,url:String) {
            val intent = Intent(activity,ActivityApiViewBinding::class.java)
            intent.putExtra(KEY_URL,url)
            activity.startActivity(intent)


    }
}
