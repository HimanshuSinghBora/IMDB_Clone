package com.example.imdb_clone_app
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: ArrayList<Result>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.w("text","Started")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        ApiCall().getData(this) { Data ->
//            holder.textView.text = Data.title.toString()
//            Log.w("TEXT",Data.title)
//            holder.imageView.setImageURI(Uri.parse(Data.poster_path))
//            Log.w("IMAGES",Data.poster_path)
//        }
    }
    override fun getItemCount():Int{
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.movieImage)
        val textView: TextView = itemView.findViewById(R.id.movieName)
    }
}
