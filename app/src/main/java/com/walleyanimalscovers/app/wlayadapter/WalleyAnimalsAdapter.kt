package com.walleyanimalscovers.app.wlayadapter

import android.content.pm.PackageManager
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.io.File
import java.io.FileOutputStream
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.view.LayoutInflater
import com.walleyanimalscovers.app.MainActivity
import com.walleyanimalscovers.app.databinding.WalleyItemBinding
import com.walleyanimalscovers.app.wlaydata.WalleyAnimalsData

import java.io.OutputStream
import java.lang.Exception
import java.util.*

class WalleyAnimalsAdapter(val owjweewqs :List<WalleyAnimalsData>, val activity: AppCompatActivity) : RecyclerView.Adapter<WalleyAnimalsAdapter.ProfItemHolder>() {
    class ProfItemHolder(val binding : WalleyItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setProfLaItem(oweweq : WalleyAnimalsData, activity : AppCompatActivity) = with(binding){
            Picasso.get().load(oweweq.aurumImgItem).centerCrop().resize(1280,720)
                .into(jfwfwefwef,object : Callback {
                    override fun onSuccess() {
                        progressBar.visibility = View.INVISIBLE
                    }

                    override fun onError(e: Exception?) {

                    }

                } )

            ndjfsdf.setOnClickListener {
                if(ContextCompat.checkSelfPermission(activity,android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(activity, arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),100)
                } else {
                    val externalStoreState = Environment.getExternalStorageState()
                    if(externalStoreState.equals(Environment.MEDIA_MOUNTED)){
                        try{
                            val lsakdsf = Environment.getExternalStorageDirectory().absolutePath
                            val dsllsd = File(lsakdsf,"${UUID.randomUUID()}.jpg")
                            val bxbxhsd : OutputStream = FileOutputStream(dsllsd)
                            val ospsaksa  = ContextCompat.getDrawable(activity.applicationContext,oweweq.aurumImgItem)
                            val pweewe = (ospsaksa as BitmapDrawable).bitmap
                            pweewe.compress(Bitmap.CompressFormat.JPEG,100,bxbxhsd)
                            bxbxhsd.flush()
                            bxbxhsd.close()

                            val snackBar = Snackbar.make((activity as MainActivity).findViewById(android.R.id.content),"Image is saving...",Snackbar.LENGTH_LONG)
                            snackBar.show()
                        }catch(e : Exception){
                            val snackBar = Snackbar.make((activity as MainActivity).findViewById(android.R.id.content),"Image is saving...",Snackbar.LENGTH_LONG)
                            snackBar.show()
                        }


                    }
                }

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfItemHolder {
        val binding = WalleyItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ProfItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ProfItemHolder, position: Int) {
        holder.setProfLaItem(owjweewqs[position],activity)

    }

    override fun getItemCount() = owjweewqs.size


}