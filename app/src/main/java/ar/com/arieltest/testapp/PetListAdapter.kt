package ar.com.arieltest.testapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ar.com.arieltest.testapp.databinding.PetItemBinding
import com.squareup.picasso.Picasso

// Lo primero que hacemos es crear un elemento del modelo (PetItem) como un data class
// para luego crear el layout de cada unos de estos items.
// La clase adapter (PetListAdapter) va a recibir como parámetro un listado de elementos del modelo
// y obligatoriamente va a heredar de RecycleView.Adapter<ClaseHolder>

// La clase Holder es una clase (interna o no) que tendrá la responsabilidad de dibujar el item
// en el layout. En render() hacemos esa lágica

// Al heredar de RecycleView.Adapter nos va a obligar a implementar onCreateViewHolder, onBindViewHolder y getItemCount
// en onBindViewHolder vamos a llamar a render() del Holder que creamos (PetListHolder) con el elemento del arreglo.
// Por cada elemento del la lista del modelo (listPetItem) se llamará a este método

// Acá tenemos también el tema del bindeo, un atributo interno _binding y el posta binding
// llamamos al inflate en _binding pero devolvemos el binding.root

class PetListAdapter (private val listPetItem:List<PetItem>): RecyclerView.Adapter<PetListAdapter.PetListHolder>(){
    private var _binding: PetItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetListHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        _binding = PetItemBinding.inflate(layoutInflater, parent, false)
        return PetListHolder(binding.root)
    }

    override fun onBindViewHolder(holder: PetListHolder, position: Int) {
        holder.render(listPetItem[position])
    }

    override fun getItemCount(): Int = listPetItem.size

    class PetListHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun render(petItem: PetItem) {
            view.findViewById<TextView>(R.id.petName).text = petItem.name
            view.findViewById<TextView>(R.id.petQualifiedName).text = petItem.qualifiedName
            view.findViewById<TextView>(R.id.petHairStyle).text = petItem.hairStyle
            Picasso.get().load(petItem.picture).into(view.findViewById<ImageView>(R.id.petPicture))
        }
    }
}