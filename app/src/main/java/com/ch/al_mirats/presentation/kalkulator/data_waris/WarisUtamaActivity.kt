package com.ch.al_mirats.presentation.kalkulator.data_waris

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.ch.al_mirats.databinding.ActivityWarisUtamaBinding
import com.ch.al_mirats.model.WarisDataEntity
import com.ch.al_mirats.presentation.kalkulator.hasil_pembagian.HasilKalkulatorActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WarisUtamaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWarisUtamaBinding
    private lateinit var warisDataDao: WarisDataDao

    private var jenisKelaminPewaris = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWarisUtamaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonBack: ImageView = binding.btnBack
        val buttonDelete: ImageView = binding.btnDelete
        binding.edIstri.filters = arrayOf(InputFilter.LengthFilter(1))
//        buttonDelete.visibility = View.GONE

        val harta = intent.getLongExtra("harta", 0)
        val hutang = intent.getLongExtra("hutang", 0)
        val wasiat = intent.getLongExtra("wasiat", 0)
        val biayaPerawatanJenazah = intent.getLongExtra("biayaPerawatanJenazah", 0)
        jenisKelaminPewaris = intent.getStringExtra("jenisKelaminPewaris").toString()

        if (jenisKelaminPewaris.equals("Laki-Laki")) {
            binding.clIstri.visibility = View.VISIBLE
            binding.clSuami.visibility = View.GONE
        } else if (jenisKelaminPewaris.equals("Perempuan")) {
            binding.clIstri.visibility = View.GONE
            binding.clSuami.visibility = View.VISIBLE
        }

        btnAddAndRemoveListenerIstri(binding.btnAddIstri, binding.btnRemoveIstri, binding.edIstri)
        btnAddAndRemoveListenerAnak(binding.btnAddLaki, binding.btnRemoveLaki, binding.edLaki)
        btnAddAndRemoveListenerAnak(
            binding.btnAddPerempuan,
            binding.btnRemovePerempuan,
            binding.edPerempuan
        )
        btnAddAndRemoveListenerCucu(
            binding.btnAddCucuLaki,
            binding.btnRemoveCucuLaki,
            binding.edCucuLaki
        )
        btnAddAndRemoveListenerCucu(
            binding.btnAddCucuPerempuan,
            binding.btnRemoveCucuPerempuan,
            binding.edCucuPerempuan
        )
        btnAddAndRemoveListenerSaudaraSeayah(
            binding.btnAddSaudaraSeayah,
            binding.btnRemoveSaudaraSeayahSeibu,
            binding.edSaudaraSeayahSeibu
        )
        btnAddAndRemoveListenerSaudaraSeayah(
            binding.btnAddSaudariSeayah,
            binding.btnRemoveSaudariSeayahSeibu,
            binding.edSaudariSeayahSeibu
        )

        buttonBack.setOnClickListener {
            finish()
        }

        buttonDelete.setOnClickListener {
            val nilaiKosong: Editable = Editable.Factory.getInstance().newEditable("")

            binding.cbAyah.isChecked = false
            binding.cbIbu.isChecked = false
            binding.cbAyahnyaAyah.isChecked = false
            binding.cbIbunyaAyah.isChecked = false
            binding.cbIbunyaIbu.isChecked = false
            binding.cbSuami.isChecked = false

            binding.edIstri.text = nilaiKosong
            binding.edLaki.text = nilaiKosong
            binding.edPerempuan.text = nilaiKosong
            binding.edSaudaraSeayahSeibu.text = nilaiKosong
            binding.edSaudariSeayahSeibu.text = nilaiKosong
            binding.edCucuLaki.text = nilaiKosong
            binding.edCucuPerempuan.text = nilaiKosong
        }

        warisDataDao = AppDatabase.getDatabase(this).warisDataDao()
        checkIfDatabaseNotEmpty()

        binding.btnLanjut.setOnClickListener {
            val ayah = binding.cbAyah.isChecked
            val ibu = binding.cbIbu.isChecked
            val suami = binding.cbSuami.isChecked
            val ayahnya_ayah = binding.cbAyahnyaAyah.isChecked
            val ibunya_ayah = binding.cbIbunyaAyah.isChecked
            val saudara_seayah_seibu =
                binding.edSaudaraSeayahSeibu.text.toString().toIntOrNull() ?: 0
            val saudari_seayah_seibu =
                binding.edSaudariSeayahSeibu.text.toString().toIntOrNull() ?: 0
            val ibunya_ibu = binding.cbIbunyaIbu.isChecked
            val istri = binding.edIstri.text.toString().toIntOrNull() ?: 0
            val anakLaki = binding.edLaki.text.toString().toIntOrNull() ?: 0
            val anakPerempuan = binding.edPerempuan.text.toString().toIntOrNull() ?: 0
            val cucuLaki = binding.edCucuLaki.text.toString().toIntOrNull() ?: 0
            val cucuPerempuan = binding.edCucuPerempuan.text.toString().toIntOrNull() ?: 0
            val updatedWarisData = WarisDataEntity(
                harta = harta,
                hutang = hutang,
                wasiat = wasiat,
                biayaPerawatanJenazah = biayaPerawatanJenazah,
                jenisKelamin = jenisKelaminPewaris,
                ayah = ayah,
                ibu = ibu,
                istri = istri,
                suami = suami,
                ayahnya_ayah = ayahnya_ayah,
                ibunya_ayah = ibunya_ayah,
                saudara_seayah_seibu = saudara_seayah_seibu,
                saudari_seayah_seibu = saudari_seayah_seibu,
                ibunya_ibu = ibunya_ibu,
                anakLaki = anakLaki,
                anakPerempuan = anakPerempuan,
                cucuLaki = cucuLaki,
                cucuPerempuan = cucuPerempuan
            )

            GlobalScope.launch(Dispatchers.IO) {
                warisDataDao.insertOrUpdate(updatedWarisData)
            }

            val intent = Intent(this, HasilKalkulatorActivity::class.java)
            intent.putExtra("harta", harta)
            intent.putExtra("hutang", hutang)
            intent.putExtra("wasiat", wasiat)
            intent.putExtra("biayaPerawatanJenazah", biayaPerawatanJenazah)
            intent.putExtra("jenisKelaminPewaris", jenisKelaminPewaris)
            intent.putExtra("ayah", ayah)
            intent.putExtra("ibu", ibu)
            intent.putExtra("suami", suami)
            intent.putExtra("ayahnya_ayah", ayahnya_ayah)
            intent.putExtra("ibunya_ayah", ibunya_ayah)
            intent.putExtra("saudara_seayah_seibu", saudara_seayah_seibu)
            intent.putExtra("saudari_seayah_seibu", saudari_seayah_seibu)
            intent.putExtra("ibunya_ibu", ibunya_ibu)
            intent.putExtra("istri", istri)
            intent.putExtra("anakLaki", anakLaki)
            intent.putExtra("anakPerempuan", anakPerempuan)
            intent.putExtra("cucuLaki", cucuLaki)
            intent.putExtra("cucuPerempuan", cucuPerempuan)

            startActivity(intent)
        }

    }

    private fun checkIfDatabaseNotEmpty() {
        lifecycleScope.launch {
            val isDatabaseNotEmpty = withContext(Dispatchers.IO) {
                warisDataDao.isDataExist() > 0
            }

            if (isDatabaseNotEmpty) {
                displayWarisData()
            } else {
                Log.d("YourActivity", "Database is empty.")
            }
        }
    }

    private fun displayWarisData() {
        GlobalScope.launch(Dispatchers.IO) {
            val loadedWarisData = warisDataDao.getAllWarisData()
            var ayah = false
            var ibu = false
            var suami = false
            var ayahnyaAyah = false
            var ibunyaAyah = false
            var saudaraSeayahSeibu = ""
            var saudariSeayahSeibu = ""
            var ibunyaIbu = false
            var istri = ""
            var anakLaki = ""
            var anakPerempuan = ""
            var cucuLaki = ""
            var cucuPerempuan = ""

            for (warisData in loadedWarisData) {
                ayah = warisData.ayah
                ibu = warisData.ibu
                suami = warisData.suami
                ayahnyaAyah = warisData.ayahnya_ayah
                ibunyaAyah = warisData.ibunya_ayah
                saudaraSeayahSeibu = warisData.saudara_seayah_seibu.toString()
                saudariSeayahSeibu = warisData.saudari_seayah_seibu.toString()
                ibunyaIbu = warisData.ibunya_ibu
                istri = warisData.istri.toString()
                anakLaki = warisData.anakLaki.toString()
                anakPerempuan = warisData.anakPerempuan.toString()
                cucuLaki = warisData.cucuLaki.toString()
                cucuPerempuan = warisData.cucuPerempuan.toString()
            }
            withContext(Dispatchers.Main) {
                val istriEditable: Editable =
                    Editable.Factory.getInstance().newEditable(if (istri == "0") "" else istri)
                val anakLakiEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (anakLaki == "0") "" else anakLaki)
                val anakPerempuanEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (anakPerempuan == "0") "" else anakPerempuan)
                val cucuLakiEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (cucuLaki == "0") "" else cucuLaki)
                val cucuPerempuanEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (cucuPerempuan == "0") "" else cucuPerempuan)
                val saudaraSeayahEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (saudaraSeayahSeibu == "0") "" else saudaraSeayahSeibu)
                val saudariSeayahEditable: Editable = Editable.Factory.getInstance()
                    .newEditable(if (saudariSeayahSeibu == "0") "" else saudariSeayahSeibu)

                binding.cbAyah.isChecked = ayah
                binding.cbIbu.isChecked = ibu
                if (jenisKelaminPewaris.equals("Laki-Laki")) {
                    binding.edIstri.text = istriEditable
                } else if (jenisKelaminPewaris.equals("Perempuan")) {
                    binding.cbSuami.isChecked = suami
                }
                binding.cbAyahnyaAyah.isChecked = ayahnyaAyah
                binding.cbIbunyaAyah.isChecked = ibunyaAyah
                binding.edSaudaraSeayahSeibu.text = saudaraSeayahEditable
                binding.edSaudariSeayahSeibu.text = saudariSeayahEditable
                binding.cbIbunyaIbu.isChecked = ibunyaIbu
                binding.edLaki.text = anakLakiEditable
                binding.edPerempuan.text = anakPerempuanEditable
                binding.edCucuLaki.text = cucuLakiEditable
                binding.edCucuPerempuan.text = cucuPerempuanEditable
            }
        }
    }

    fun btnAddAndRemoveListenerIstri(add: ImageView, remove: ImageView, editText: EditText) {
        add.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            if (currentValue < 4) {
                val newValue = currentValue + 1
                editText.setText(newValue.toString())
            }
        }

        remove.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            if (currentValue > 0) {
                val newValue = currentValue - 1
                editText.setText(newValue.toString())
            }
        }
    }

    fun btnAddAndRemoveListenerAnak(add: ImageView, remove: ImageView, editText: EditText) {
        add.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            val newValue = currentValue + 1
            editText.setText(newValue.toString())
        }

        remove.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            if (currentValue > 0) {
                val newValue = currentValue - 1
                editText.setText(newValue.toString())
            }
        }
    }

    fun btnAddAndRemoveListenerCucu(add: ImageView, remove: ImageView, editText: EditText) {
        add.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            val newValue = currentValue + 1
            editText.setText(newValue.toString())
        }

        remove.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            if (currentValue > 0) {
                val newValue = currentValue - 1
                editText.setText(newValue.toString())
            }
        }
    }

    fun btnAddAndRemoveListenerSaudaraSeayah(
        add: ImageView,
        remove: ImageView,
        editText: EditText
    ) {
        add.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            val newValue = currentValue + 1
            editText.setText(newValue.toString())
        }

        remove.setOnClickListener {
            val currentValue = editText.text.toString().toIntOrNull() ?: 0
            if (currentValue > 0) {
                val newValue = currentValue - 1
                editText.setText(newValue.toString())
            }
        }
    }
}