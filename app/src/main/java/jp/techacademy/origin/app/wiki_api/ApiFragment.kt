package jp.techacademy.origin.app.wiki_api

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.squareup.picasso.Picasso
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import jp.techacademy.origin.app.wiki_api.databinding.FragmentApiBinding
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
import java.io.InputStream
import java.net.URL


class ApiFragment : AppCompatActivity(){
    private lateinit var binding: FragmentApiBinding
    private val handler = Handler(Looper.getMainLooper())
    private var isLoading = false
    //val picasso_iv = findViewById<ImageView>(R.id.picasso_iv)

    //private var sn_encode : String = ""

    //private var list = mutableListOf<SNResponse>()
    private var list = mutableListOf<SNResponse>()
    // 一覧画面から登録するときのコールバック（FavoriteFragmentへ通知するメソッド)
    var onClickAddFavorite: ((String,String,String,String) -> Unit)? = null

    // 一覧画面から削除するときのコールバック（ApiFragmentへ通知するメソッド)
    var onClickDeleteFavorite: ((String) -> Unit)? = null
/*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApiBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ここから初期化処理を行う
        // RecyclerViewの初期化
        binding.recyclerView.apply {
            adapter = apiAdapter
            layoutManager = LinearLayoutManager(requireContext()) // 一列ずつ表示
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            updateData()
        }
        updateData()
        /*
        super.onCreate(savedInstanceState)
        binding = ActivityApiViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
         */
    }
*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentApiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val SummonerName = intent.getStringExtra(KEY_URL)
        //binding.webView.loadUrl(url)
        val url = StringBuilder()
            .append(getString(R.string.base_summonerurl)) // https://jp1.api.riotgames.com//lol/summoner/v3/summoners/by-name/
            .append(SummonerName)
            .append("?api_key=").append("RGAPI-02fc08cb-4d8b-4d81-8efa-8e096471bef4") // 何件目からのデータを取得するか
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
                isLoading = false // 読み込み中フラグを折る
            }

            override fun onResponse(call: Call, response: Response) { // 成功時の処理
                // Jsonを変換するためのAdapterを用意
                val moshi = Moshi.Builder().build()
                val jsonAdapter = moshi.adapter(SNResponse::class.java)


                //var list = listOf<SummonerNameResponse>()

                response.body?.string()?.also { it ->
                    val apiResponse = jsonAdapter.fromJson(it)
                    //Log.d("http",jsonAdapter.fromJson(it).toString())
                    if (apiResponse != null) {
                        //activity.startActivity(intent)
                        //ApiViewActivity.start(this,apiResponse)
                        handler.post {
                            //binding.textTest.text = apiResponse.name

                            val puuid = apiResponse.puuid
                            //binding.webView.loadUrl(url)
                            val url = StringBuilder()
                                .append("https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/") // https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/
                                .append(puuid)
                                .append("/ids?queue=430&type=normal&start=0&count=100&api_key=").append("RGAPI-02fc08cb-4d8b-4d81-8efa-8e096471bef4") // 何件目からのデータを取得するか
                                .toString()
                            val client = OkHttpClient.Builder()
                                .addInterceptor(HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                })
                                .build()
                            val request = Request.Builder()
                                .url(url)
                                .build()
                            client.newCall(request).enqueue(object : Callback {
                                override fun onFailure(call: Call, e: IOException) { // Error時の処理
                                    e.printStackTrace()
                                    isLoading = false // 読み込み中フラグを折る
                                }

                                override fun onResponse(call: Call, response: Response) { // 成功時の処理
                                    // Jsonを変換するためのAdapterを用意
                                    val moshi = Moshi.Builder().build()
                                    val moshi_array = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

                                    val jsonAdapter = moshi_array.adapter(MatchId::class.java)

                                    response.body?.string()?.also { it ->
                                        val apiResponse = it
                                        //Log.d("http",jsonAdapter.fromJson(it).toString())
                                        if (apiResponse != null) {
                                            //binding.textTest.text = apiResponse.substring(2,15)
                                            //Log.d("test",apiResponse.substring(19,32))

                                            val matchid = apiResponse.substring(2,15)
                                            //binding.webView.loadUrl(url)
                                            val url = StringBuilder()
                                                .append("https://asia.api.riotgames.com/lol/match/v5/matches/") // https://asia.api.riotgames.com/lol/match/v5/matches/by-puuid/
                                                .append(matchid)
                                                .append("?api_key=").append("RGAPI-02fc08cb-4d8b-4d81-8efa-8e096471bef4") // 何件目からのデータを取得するか
                                                .toString()
                                            val client = OkHttpClient.Builder()
                                                .addInterceptor(HttpLoggingInterceptor().apply {
                                                    level = HttpLoggingInterceptor.Level.BODY
                                                })
                                                .build()
                                            val request = Request.Builder()
                                                .url(url)
                                                .build()
                                            client.newCall(request).enqueue(object : Callback {
                                                override fun onFailure(call: Call, e: IOException) { // Error時の処理
                                                    e.printStackTrace()
                                                    isLoading = false // 読み込み中フラグを折る
                                                }

                                                override fun onResponse(call: Call, response: Response) { // 成功時の処理
                                                    // Jsonを変換するためのAdapterを用意
                                                    //val moshi = Moshi.Builder().build()
                                                    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

                                                    val jsonAdapter = moshi.adapter(MatchData::class.java)

                                                    response.body?.string()?.also {
                                                        val apiResponse = jsonAdapter.fromJson(it)
                                                        //Log.d("http",jsonAdapter.fromJson(it).toString())
                                                        if (apiResponse != null) {
                                                            val SummonerId = apiResponse.metadata.participants.indexOf(puuid)
                                                            //Log.d("test",SummonerId.toString())
                                                            //val participantid = SummonerId/78
                                                            handler.post {

                                                                binding.textTest.text =
                                                                    apiResponse.info.participants[SummonerId].championName

                                                                Picasso.get()
                                                                    .load("http://ddragon.leagueoflegends.com/cdn/13.11.1/img/champion/"+apiResponse.info.participants[SummonerId].championName+".png") // ロードしたいイメージのURLを入力
                                                                    .into(binding.picassoIv)

                                                            //Log.d("test",apiResponse.substring(19,32))

                                                            }
                                                        }

                                                    }
                                                }
                                            })
                                        }
                                    }
                                }
                            })
                        }
                        //ApiViewActivity.start(this@ApiFragment,apiResponse)
                        //list += apiResponse
                    }
                    //Log.d("test",apiResponse.toString())

                }
                //binding.textTest.text =(list2.toString())
                /*
                handler.post {
                    updateRecyclerView(list)
                }
                isLoading = false // 読み込み中フラグを折る
                 */
            }
        })
    }


    companion object {
        // 1回のAPIで取得する件数
        private const val KEY_URL = "key_url"
        private const val COUNT = 20
        //private var sn_encode = ""

        fun start(activity: Activity,url:String) {
            //sn_encode = url
            val intent = Intent(activity,ApiFragment::class.java)
            intent.putExtra(KEY_URL,url)
            activity.startActivity(intent)
        }
    }
}
/*
class GetImage(private val image: ImageView) :
    AsyncTask<String, Void, Bitmap>() {
    override fun doInBackground(vararg params: String): Bitmap? {
        val image: Bitmap

        val imageUrl = URL(params[0])
        val imageIs: InputStream = imageUrl.openStream()
        image = BitmapFactory.decodeStream(imageIs)
        return image

    }
    override fun onPostExecute(result: Bitmap) {
        // 取得した画像をImageViewに設定します。
        image.setImageBitmap(result)
    }
}
 */