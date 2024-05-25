package View;

import Controller.Controller;
import Model.SewaAlatGym.ModelSewaAlatGym;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMain extends JFrame {

    Integer baris;
    Controller controller;

    JLabel header = new JLabel("Data Sewa Alat Gym");
    JLabel labelNamaPemilik = new JLabel("Nama Penyewa");
    JLabel labelNamaAlat = new JLabel("Nama Alat");
    JLabel labelNomorTelepon = new JLabel("Nomor Telepon");
    JLabel labelWaktuSewa = new JLabel("Waktu Sewa (Hari)");

    JTextField inputNamaPemilik = new JTextField();
    JTextField inputNamaAlat = new JTextField();
    JTextField inputNomorTelepon = new JTextField();
    JTextField inputWaktuSewa = new JTextField();

    JButton tombolTambah = new JButton("Tambah");
    JButton tombolEdit = new JButton("Ubah");
    JButton tombolClear = new JButton("Clear");
    JButton tombolHapus = new JButton("Hapus");

    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    String namaKolom[] = {"Nama Pemilik", "Nama Alat", "Nomor Telepon", "Waktu Sewa", "Biaya Sewa"};

    public ViewMain() {
        setTitle("Data Sewa Alat Gym");
        setSize(710, 410);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TABLE DATA
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        
        // Set Bounds
        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(250, 15, 300, 30);
        scrollPane.setBounds(20, 60, 460, 280);

        labelNamaPemilik.setBounds(500, 55, 120, 20);
        inputNamaPemilik.setBounds(500, 80, 170, 25);

        labelNamaAlat.setBounds(500, 105, 120, 20);
        inputNamaAlat.setBounds(500, 130, 170, 25);

        labelNomorTelepon.setBounds(500, 155, 120, 20);
        inputNomorTelepon.setBounds(500, 180, 170, 25);

        labelWaktuSewa.setBounds(500, 205, 120, 20);
        inputWaktuSewa.setBounds(500, 230, 170, 25);

        tombolTambah.setBounds(500, 270, 80, 25);
        tombolEdit.setBounds(590, 270, 80, 25);
        tombolClear.setBounds(500, 310, 80, 25);
        tombolHapus.setBounds(590, 310, 80, 25);

        // Add Components
        add(header);
        add(scrollPane);
        add(labelNamaPemilik);
        add(inputNamaPemilik);
        add(labelNamaAlat);
        add(inputNamaAlat);
        add(labelNomorTelepon);
        add(inputNomorTelepon);
        add(labelWaktuSewa);
        add(inputWaktuSewa);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolClear);
        add(tombolHapus);

        // Controller
        controller = new Controller(this);
        controller.readAllData();

        // Table Click Listener
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                baris = table.getSelectedRow();
                if (baris != -1) {
                    inputNamaPemilik.setText(table.getValueAt(baris, 0).toString());
                    inputNamaAlat.setText(table.getValueAt(baris, 1).toString());
                    inputNomorTelepon.setText(table.getValueAt(baris, 2).toString());
                    inputWaktuSewa.setText(table.getValueAt(baris, 3).toString());
                }
            }
        });

        // Button Listeners
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertData();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (baris != null) {
            // Mendapatkan nama pemilik dari baris terpilih
            String nama_pemilik = table.getValueAt(baris, 0).toString();
            // Mengirim nama pemilik dan indeks baris ke controller
            controller.ubahData(nama_pemilik, baris);
        } else {
            JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearInputFields();
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (baris != null) {
            String nama_pemilik = table.getValueAt(baris, 0).toString(); // Ambil nama pemilik dari baris yang dipilih
            controller.hapusData(nama_pemilik);
            clearInputFields();
        } else {
            JOptionPane.showMessageDialog(null, "Data belum dipilih.");
        }
    }
});

        setVisible(true);
    }

    public JTable getTableSewaAlatGym() {
        return table;
    }

    public String getInputNama_pemilik() {
        return inputNamaPemilik.getText();
    }

    public String getInputNama_alat() {
        return inputNamaAlat.getText();
    }

    public String getInputNomor_telepon() {
        return inputNomorTelepon.getText();
    }

    public int getInputWaktu_sewa() {
        try {
            return Integer.parseInt(inputWaktuSewa.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void clearInputFields() {
        inputNamaPemilik.setText("");
        inputNamaAlat.setText("");
        inputNomorTelepon.setText("");
        inputWaktuSewa.setText("");
        baris = null;
    }
}
