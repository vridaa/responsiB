package Controller;

import Model.SewaAlatGym.*;
import View.ViewMain;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller {

    ViewMain View;
    InterfaceDAO daoSewaAlatGym;
    List<ModelSewaAlatGym> daftarSewaAlatGym;

    public Controller(ViewMain View) {
        this.View = View;
        this.daoSewaAlatGym = new DAO();
    }

    public void readAllData() {
        daftarSewaAlatGym = daoSewaAlatGym.getAll();
        ModelTable table = new ModelTable(daftarSewaAlatGym);
        View.getTableSewaAlatGym().setModel(table);
    }

    public void insertData() {
        try {
            ModelSewaAlatGym sewaalatgymBaru = new ModelSewaAlatGym();

            String nama_pemilik = View.getInputNama_pemilik();
            String nama_alat = View.getInputNama_alat();
            String nomor_telepon = View.getInputNomor_telepon();
            int waktu_sewa = View.getInputWaktu_sewa();

            if ("".equals(nama_pemilik) || "".equals(nama_alat) || "".equals(nomor_telepon) || waktu_sewa <= 0) {
                throw new Exception("Data tidak boleh kosong!");
            }

            sewaalatgymBaru.setNama_pemilik(nama_pemilik);
            sewaalatgymBaru.setNama_alat(nama_alat);
            sewaalatgymBaru.setNomor_telepon(nomor_telepon);
            sewaalatgymBaru.setWaktu_sewa(waktu_sewa);
            sewaalatgymBaru.setTotal_biaya(calculateBiaya(waktu_sewa));

            daoSewaAlatGym.insert(sewaalatgymBaru);

            JOptionPane.showMessageDialog(null, "Data baru berhasil ditambahkan");

            View.dispose();
            new ViewMain();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void ubahData(String nama_pemilik, int rowIndex) {
    try {
        ModelSewaAlatGym sewaalatgymYangMauDiedit = new ModelSewaAlatGym();

        String nama_alat = View.getInputNama_alat();
        String nomor_telepon = View.getInputNomor_telepon();
        int waktu_sewa = View.getInputWaktu_sewa();

        if ("".equals(nama_alat) || "".equals(nomor_telepon) || waktu_sewa <= 0) {
            throw new Exception("Data tidak boleh kosong!");
        }

        // Mendapatkan data asli dari baris yang dipilih
        ModelSewaAlatGym originalData = daftarSewaAlatGym.get(rowIndex);

        // Memastikan nama_pemilik yang diubah sesuai dengan baris yang dipilih
        if (!nama_pemilik.equals(originalData.getNama_pemilik())) {
            throw new Exception("Nama Pemilik tidak boleh diubah!");
        }

        // Menggunakan data asli untuk nama_pemilik
        sewaalatgymYangMauDiedit.setNama_pemilik(originalData.getNama_pemilik());
        sewaalatgymYangMauDiedit.setNama_alat(nama_alat);
        sewaalatgymYangMauDiedit.setNomor_telepon(nomor_telepon);
        sewaalatgymYangMauDiedit.setWaktu_sewa(waktu_sewa);
        sewaalatgymYangMauDiedit.setTotal_biaya(calculateBiaya(waktu_sewa));

        daoSewaAlatGym.update(sewaalatgymYangMauDiedit);

        // Perbarui data pada baris yang dipilih dengan data yang baru
        daftarSewaAlatGym.set(rowIndex, sewaalatgymYangMauDiedit);

        JOptionPane.showMessageDialog(null, "Data berhasil diubah");

        View.dispose();
        new ViewMain();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    }
    }

    public void hapusData(String nama_pemilik) {
        daoSewaAlatGym.delete(nama_pemilik);
        
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        View.dispose();
        new ViewMain();
    }

    private int calculateBiaya(int waktu_sewa) {
        if (waktu_sewa <= 2) {
            return waktu_sewa * 50000;
        } else {
            return (2 * 50000) + ((waktu_sewa - 2) * 25000);
        }
    }
}
