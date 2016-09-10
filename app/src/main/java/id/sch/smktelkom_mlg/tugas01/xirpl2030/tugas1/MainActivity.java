package id.sch.smktelkom_mlg.tugas01.xirpl2030.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama;
    TextView Hasil;
    TextView Judul;
    RadioButton rbLk;
    RadioButton rbPr;
    Button bDaftar;
    TextView erRb;
    CheckBox cbDesign;
    CheckBox cbCoding;
    CheckBox cbNetworking;
    TextView erCb;
    TextView tvKota;
    Spinner spKota;
    TextView erSp;

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
        cbDesign = (CheckBox) findViewById(R.id.design);
        cbCoding = (CheckBox) findViewById(R.id.coding);
        cbNetworking = (CheckBox) findViewById(R.id.networking);
        erCb = (TextView) findViewById(R.id.checkErr);
        tvKota = (TextView) findViewById(R.id.textView4);
        spKota = (Spinner) findViewById(R.id.asal);
        erSp = (TextView) findViewById(R.id.spinnerErr);

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
                return rbLk.isChecked() || rbPr.isChecked();
            }

            private boolean cbValid() {
                return cbAhli() != "";
            }

            private boolean spValid() {
                String sp = spKota.getSelectedItem().toString();
                if (sp == spKota.getItemAtPosition(0).toString()) {
                    erSp.setText("*Anda belum memilih Kota Asal");
                    return false;
                } else {
                    erSp.setText("");
                    return true;
                }
            }

            private boolean isValid() {
                return textValid() && rbValid() && cbValid() && spValid();
            }

            private java.lang.String rbText() {
                String Gender = null;
                if (rbLk.isChecked()) {
                    Gender = rbLk.getText().toString();
                    erRb.setText("");
                } else if (rbPr.isChecked()) {
                    Gender = rbPr.getText().toString();
                    erRb.setText("");
                } else {
                    erRb.setText("*Anda belum memilih Gender");
                }
                return Gender;
            }

            private java.lang.String cbAhli() {
                String Ahli = "";
                if (cbDesign.isChecked()) {
                    Ahli += " " + cbDesign.getText().toString();
                    erCb.setText("");
                }
                if (cbCoding.isChecked()) {
                    Ahli += " " + cbCoding.getText().toString();
                    erCb.setText("");
                }
                if (cbNetworking.isChecked()) {
                    Ahli += " " + cbNetworking.getText().toString();
                    erCb.setText("");
                }
                if (Ahli == "") {
                    erCb.setText("*Anda harus memiliki keahlian");
                }
                return Ahli;
            }

            private void doProcess() {
                String nama = etNama.getText().toString();
                String gender = rbText();
                String ahli = cbAhli();
                String asal = spKota.getSelectedItem().toString();
                spValid();
                if (isValid()) {
                    Judul.setText("Data Terkirim");
                    erRb.setText("");
                    Hasil.setText("Nama: " + nama + "\nGender: " + gender + "\nKeahlian:" + ahli + "\nKota Asal: " + asal);
                } else {
                    Judul.setText("");
                    Hasil.setText("");
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
