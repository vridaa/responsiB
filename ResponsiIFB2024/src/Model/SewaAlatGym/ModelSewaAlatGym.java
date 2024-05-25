package Model.SewaAlatGym;

public class ModelSewaAlatGym {
    private Integer waktu_sewa, total_biaya;
    private String nama_pemilik, nama_alat, nomor_telepon;

    public String getNama_pemilik() {
        return nama_pemilik;
    }

    public void setNama_pemilik(String nama_pemilik) {
        this.nama_pemilik = nama_pemilik;
    }
    
    public String getNama_alat() {
        return nama_alat;
    }

    public void setNama_alat(String nama_alat) {
        this.nama_alat = nama_alat;
    }
    
    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }
    
    public Integer getWaktu_sewa() {
        return waktu_sewa;
    }

    public void setWaktu_sewa(Integer waktu_sewa) {
        this.waktu_sewa = waktu_sewa;
    }
    
    public Integer getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Integer total_biaya) {
        this.total_biaya = total_biaya;
    }
    
}
