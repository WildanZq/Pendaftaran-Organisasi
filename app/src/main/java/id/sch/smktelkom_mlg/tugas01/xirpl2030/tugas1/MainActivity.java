package id.sch.smktelkom_mlg.tugas01.xirpl2030.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    TextView Hasil;
    TextView Judul;
    Button bDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.nama);
        bDaftar = (Button) findViewById(R.id.daftar);
        Hasil = (TextView) findViewById(R.id.hasil);
        Judul = (TextView) findViewById(R.id.judul);

        bDaftar.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           String nama = etNama.getText().toString();
                                           Judul.setText("Data Terkirim");
                                           Hasil.setText("Nama: " + nama);
                                       }
                                   }
        );
    }
}
