-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2024 at 02:34 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `responsi_2024_pbo_if_b`
--

-- --------------------------------------------------------

--
-- Table structure for table `sewa_alat_gym`
--

CREATE TABLE `sewa_alat_gym` (
  `nama_pemilik` varchar(100) NOT NULL,
  `nama_alat` varchar(100) NOT NULL,
  `nomor_telepon` varchar(14) NOT NULL,
  `waktu_sewa` int(11) NOT NULL,
  `total_biaya` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sewa_alat_gym`
--

INSERT INTO `sewa_alat_gym` (`nama_pemilik`, `nama_alat`, `nomor_telepon`, `waktu_sewa`, `total_biaya`) VALUES
('Ahmad Aqil', 'Barbel 5 Kg', '081234567890', 2, 100000),
('Dong Sicheng', 'Alat Cardio', '083426754376', 4, 150000),
('Latif Ivanur', 'Treadmill', '081122334455', 4, 150000),
('Luqman Abimanyu', 'Stationary', '081298765432', 6, 200000),
('Park Jisung', 'Barbel 15 Kg', '083527865344', 6, 200000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `sewa_alat_gym`
--
ALTER TABLE `sewa_alat_gym`
  ADD PRIMARY KEY (`nama_pemilik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
