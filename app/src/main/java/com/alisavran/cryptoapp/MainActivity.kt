package com.alisavran.cryptoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alisavran.cryptoapp.Adapter.CryptoAdapter
import kotlinx.coroutines.launch
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var cryptoAdapter: CryptoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val apiService = RetrofitInstance.apiService

        lifecycleScope.launch {
            try {
                val response: Response<CryptoResponse> = apiService.getCryptoList(limit = 40)
                if (response.isSuccessful) {
                    val cryptoList = response.body()?.data ?: emptyList()
                    cryptoAdapter = CryptoAdapter(cryptoList)
                    recyclerView.adapter = cryptoAdapter
                } else {
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Network Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


//https://pro-api.coinmarketcap.com   //b5393c10-b1f4-47d3-887d-d655a818140c
// https://api.coinmarketcap.com/v1/cryptocurrency/listings/latest