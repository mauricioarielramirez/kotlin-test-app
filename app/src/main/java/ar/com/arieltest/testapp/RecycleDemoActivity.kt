package ar.com.arieltest.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ar.com.arieltest.testapp.databinding.ActivityRecycleDemoBinding

class RecycleDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleDemoBinding

    private val petItemList = listOf(
        PetItem(
            "1",
            "Dolly",
            "Siberiano",
            "Largo",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "2",
            "Thor",
            "Mestizo",
            "Corto",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "3",
            "Duquesa",
            "Siamés",
            "Mediano",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "4",
            "Moro",
            "Ovejero Alemán",
            "Largo",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "5",
            "Emac",
            "Mestizo",
            "Corto",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "6",
            "Tincho",
            "Mestizo",
            "Corto",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
        PetItem(
            "7",
            "Chicho",
            "Mestizo",
            "Corto",
            "https://happytravel.viajes/wp-content/uploads/2020/04/146-1468479_my-profile-icon-blank-profile-picture-circle-hd.png"
        ),
    )

    // Acá también tenemos el tema del bindeo y otra cosa adicional:
    // Si no asociamos un layout manager al RecycleView, no lo vamos a poder levantar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecycleDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecycle()
    }

    private fun initRecycle() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.petListRecyclerView.layoutManager = layoutManager

        val adapter = PetListAdapter(petItemList)
        binding.petListRecyclerView.adapter = adapter
    }

}