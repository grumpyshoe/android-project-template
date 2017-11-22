package de.grumpyshoe.projecttemplate.features.main.view

import android.databinding.DataBindingUtil.setContentView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import de.grumpyshoe.projecttemplate.R
import de.grumpyshoe.projecttemplate.databinding.ActivityMainBinding
import de.grumpyshoe.projecttemplate.features.main.viewmodel.MainViewModel

/**
 * Created by grumpyshoe on 13.11.17.
 *
 * Main Activity, loaded on app start
 *
 */
class MainActivity : AppCompatActivity() {


    /**
     * onCreate
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.viewmodel = MainViewModel()
    }
}
