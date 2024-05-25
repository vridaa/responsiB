package Model.SewaAlatGym;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements InterfaceDAO {

    @Override
    public void insert(ModelSewaAlatGym sewa_alat_gym) {
        try {
            String query = "INSERT INTO sewa_alat_gym (nama_pemilik, nama_alat, nomor_telepon, waktu_sewa, total_biaya) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = Connector.Connect().prepareStatement(query);

            int total_biaya = calculateBiaya(sewa_alat_gym.getWaktu_sewa());
            sewa_alat_gym.setTotal_biaya(total_biaya);

            statement.setString(1, sewa_alat_gym.getNama_pemilik());
            statement.setString(2, sewa_alat_gym.getNama_alat());
            statement.setString(3, sewa_alat_gym.getNomor_telepon());
            statement.setInt(4, sewa_alat_gym.getWaktu_sewa());
            statement.setInt(5, sewa_alat_gym.getTotal_biaya());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
public void update(ModelSewaAlatGym sewa_alat_gym) {
    try {
        String query = "UPDATE sewa_alat_gym SET nama_alat=?, nomor_telepon=?, waktu_sewa=?, total_biaya=? WHERE nama_pemilik=?;";
        PreparedStatement statement = Connector.Connect().prepareStatement(query);

        int total_biaya = calculateBiaya(sewa_alat_gym.getWaktu_sewa());
        sewa_alat_gym.setTotal_biaya(total_biaya);

        // Memasukkan parameter ke dalam query
        statement.setString(1, sewa_alat_gym.getNama_alat());
        statement.setString(2, sewa_alat_gym.getNomor_telepon());
        statement.setInt(3, sewa_alat_gym.getWaktu_sewa());
        statement.setInt(4, sewa_alat_gym.getTotal_biaya());
        // Parameter terakhir adalah nama_pemilik yang digunakan sebagai kondisi WHERE
        statement.setString(5, sewa_alat_gym.getNama_pemilik());

        // Eksekusi query
        statement.executeUpdate();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Update Failed! (" + e.getLocalizedMessage() + ")");
    }
}

    @Override
    public void delete(String nama_pemilik) {
    try {
        String query = "DELETE FROM sewa_alat_gym WHERE nama_pemilik=?;";
        PreparedStatement statement = Connector.Connect().prepareStatement(query);
        statement.setString(1, nama_pemilik);

        statement.executeUpdate();
        statement.close();
    } catch (SQLException e) {
        System.out.println("Delete Failed: " + e.getLocalizedMessage());
    }
    }

    @Override
    public List<ModelSewaAlatGym> getAll() {
        List<ModelSewaAlatGym> listSewaAlatGym = new ArrayList<>();

        try {
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM sewa_alat_gym;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                ModelSewaAlatGym sewa_alat_gym = new ModelSewaAlatGym();
                sewa_alat_gym.setNama_pemilik(resultSet.getString("nama_pemilik"));
                sewa_alat_gym.setNama_alat(resultSet.getString("nama_alat"));
                sewa_alat_gym.setNomor_telepon(resultSet.getString("nomor_telepon"));
                sewa_alat_gym.setWaktu_sewa(resultSet.getInt("waktu_sewa"));
                sewa_alat_gym.setTotal_biaya(resultSet.getInt("total_biaya"));

                listSewaAlatGym.add(sewa_alat_gym);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listSewaAlatGym;
    }

    private int calculateBiaya(int waktu_sewa) {
        if (waktu_sewa <= 2) {
            return waktu_sewa * 50000;
        } else {
            return (2 * 50000) + ((waktu_sewa - 2) * 25000);
        }
    }
}
