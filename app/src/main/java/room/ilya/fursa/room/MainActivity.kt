package room.ilya.fursa.room

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import room.ilya.fursa.room.databinding.ActivityMainBinding

import room.ilya.fursa.room.db.model.Person
import room.ilya.fursa.room.vm.PersonViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: PersonViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(PersonViewModel::class.java)

        viewModel.save(Person("Ilya", "Ivanov", 23, System.currentTimeMillis()))

        viewModel.getById(1).observe(this, Observer { binding.person = it })
    }
}
