package Model.SewaAlatGym;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel {
    
    List<ModelSewaAlatGym> daftarSewaAlatGym;

    String kolom[] = {"Nama Pemilik", "Nama Alat", "Nomor Telepon", "Waktu Sewa", "Biaya Sewa"};

    public ModelTable(List<ModelSewaAlatGym> daftarSewaAlatGym) {
        this.daftarSewaAlatGym = daftarSewaAlatGym;
    }

    // Method untuk mengambil jumlah baris dari tabel
    @Override
    public int getRowCount() {
        return daftarSewaAlatGym.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarSewaAlatGym.get(rowIndex).getNama_pemilik();
            case 1:
                return daftarSewaAlatGym.get(rowIndex).getNama_alat();
            case 2:
                return daftarSewaAlatGym.get(rowIndex).getNomor_telepon();
            case 3:
                return daftarSewaAlatGym.get(rowIndex).getWaktu_sewa();
            case 4:
                return daftarSewaAlatGym.get(rowIndex).getTotal_biaya();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
    
}
