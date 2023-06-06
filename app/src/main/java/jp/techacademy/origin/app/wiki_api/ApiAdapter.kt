package jp.techacademy.origin.app.wiki_api

import java.net.URLEncoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import jp.techacademy.origin.app.wiki_api.databinding.ActivityApiViewBinding
import jp.techacademy.origin.app.wiki_api.databinding.RecyclerFavoriteBinding


class ApiAdapter : ListAdapter<SNResponse, ApiItemViewHolder>(ApiItemCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiItemViewHolder {
        val view = ActivityApiViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ApiItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ApiItemViewHolder, position: Int) {
        holder.bind(getItem(position),position)
    }

}



/**
 * リスト内の1行の内容を保持する
 */

class ApiItemViewHolder(private val binding: ActivityApiViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun bind(snResponse: SNResponse,position: Int){
            binding.textTest.text = snResponse.toString()
            Log.d("test","OK")
        }

}

/**
 * データの差分を確認するクラス
 */
internal class ApiItemCallback : DiffUtil.ItemCallback<SNResponse>() {

    override fun areItemsTheSame(oldItem: SNResponse, newItem: SNResponse): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem:SNResponse, newItem: SNResponse): Boolean {
        return oldItem == newItem
    }
}

