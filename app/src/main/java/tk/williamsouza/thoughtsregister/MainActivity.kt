package tk.williamsouza.thoughtsregister

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tk.williamsouza.thoughtsregister.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.newThoughtActionButton.setOnClickListener {
            val intent = Intent(this, ActivatingEventActivity::class.java)
            startActivity(intent)
        }
    }
}