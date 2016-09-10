package id.sch.smktelkom_mlg.tugas01.xirpl2030.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    TextView Hasil;
    TextView Judul;
    RadioButton rbLk;
    RadioButton rbPr;
    Button bDaftar;
    TextView erRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.nama);
        rbLk = (RadioButton) findViewById(R.id.laki);
        rbPr = (RadioButton) findViewById(R.id.perempuan);
        bDaftar = (Button) findViewById(R.id.daftar);
        Hasil = (TextView) findViewById(R.id.hasil);
        Judul = (TextView) findViewById(R.id.judul);
        erRb = (TextView) findViewById(R.id.radioErr);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            private boolean textValid() {
                String nama = etNama.getText().toString();
                if (nama.isEmpty()) {
                    etNama.setError("Nama belum diisi");
                    return false;
                } else {
                    return true;
                }
            }

            private boolean rbValid() {
                String laki = rbLk.getText().toString();
                String pr = rbPr.getText().toString();
                return !(laki.isEmpty() || pr.isEmpty());
            }

            private boolean Validasi() {
                return textValid() && rbValid();
            }

            private boolean isValid() {
                return Validasi();
            }

            private java.lang.String rbText() {
                String Gender = null;
                if (rbLk.isChecked()) {
                    Gender = rbLk.getText().toString();
                } else if (rbPr.isChecked()) {
                    Gender = rbPr.getText().toString();
                } else {
                    erRb.setText("*Anda belum memilih Gender");
                }
                return Gender;
            }

            private void doProcess() {
                if (isValid()) {
                    String nama = etNama.getText().toString();
                    String gender = rbText();
                    Judul.setText("Data Terkirim");
                    Hasil.setText("Nama: " + nama + "\nGender: " + gender);
                }
            }
                                       @Override
                                       public void onClick(View view) {
                                           doProcess();
                                       }
                                   }
        );
    }
}
