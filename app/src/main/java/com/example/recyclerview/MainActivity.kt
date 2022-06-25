package com.example.recyclerview

import android.app.Dialog
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerview.adapter.AdapterTeamBola
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("tio",R.drawable.tio, "Penyerang", "173cm","Bekasi","29 Oktober 1997"))
        listPemain.add(Pemain("Jamal",R.drawable.jamal, "Belakang", "193cm","Bangkok","23 Oktober 2002"))
        listPemain.add(Pemain("Rama",R.drawable.rama, "Penyerang", "175cm","Makassar","04 Oktober 1999"))
        listPemain.add(Pemain("Sarah",R.drawable.sarah, "Penyerang", "167cm","Kota Palu"," 08 Oktober 2001"))
        listPemain.add(Pemain("Udin",R.drawable.udin, "Pelatih", "165cm","Batang Kapas"," 02 Februari 1963"))

        binding.list.adapter = AdapterTeamBola(this, listPemain,object : AdapterTeamBola.OnClikListener{
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.textDataDiri)

                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir = this.findViewById<TextView>(R.id.txttempatlahir)
                    val tanggallahir = this.findViewById<TextView>(R.id.txttanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tanggallahir.text = "${item?.tgllahir}"


                    btn.setOnClickListener {
                        this.dismiss()
                    }


                }.show()
            }

        })
    }
}