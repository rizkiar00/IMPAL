-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 20, 2018 at 08:56 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubesraniah`
--

-- --------------------------------------------------------

--
-- Table structure for table `bahan`
--

CREATE TABLE `bahan` (
  `nama_bahan` varchar(20) NOT NULL,
  `stok_bahan` int(5) NOT NULL,
  `keterangan` varchar(20) NOT NULL,
  `stokmin` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bahan`
--

INSERT INTO `bahan` (`nama_bahan`, `stok_bahan`, `keterangan`, `stokmin`) VALUES
('ad', 1, 'aq', 3),
('s', 12, 'a', 3);

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_karyawan` varchar(10) NOT NULL,
  `nama_karyawan` varchar(20) NOT NULL,
  `password_karyawan` varchar(20) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_karyawan`, `nama_karyawan`, `password_karyawan`, `role`) VALUES
('a', 'a', 'a', 'koki'),
('admin', 'namaadmin', 'admin', 'admin'),
('koki', 'namakoki', 'koki', 'koki'),
('sales', 'namasales', 'sales', 'sales');

-- --------------------------------------------------------

--
-- Table structure for table `penjualan`
--

CREATE TABLE `penjualan` (
  `id` int(11) NOT NULL,
  `tgl_penjualan` date NOT NULL,
  `nama_pelanggan` varchar(20) NOT NULL,
  `alamat_pelanggan` varchar(50) NOT NULL,
  `uang` int(11) NOT NULL,
  `status` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penjualan`
--

INSERT INTO `penjualan` (`id`, `tgl_penjualan`, `nama_pelanggan`, `alamat_pelanggan`, `uang`, `status`) VALUES
(5, '2018-12-03', 'Beli Bahan', 'gula,garam,susu coklat', 50000, '1'),
(6, '2018-01-15', 'pasar', 'pasar', 45000, '0'),
(7, '2018-02-15', 'pasar', 'pasar', 56000, '0'),
(8, '2018-03-15', 'pasar', 'pasar', 34000, '0'),
(9, '2018-04-15', 'pasar', 'pasar', 36000, '0'),
(11, '2018-05-15', 'pasar', 'pasar', 51000, '0'),
(12, '2018-06-15', 'pasar', 'pasar', 38000, '0'),
(13, '2018-07-15', 'pasar', 'pasar', 44000, '0'),
(14, '2018-08-15', 'pasar', 'pasar', 32000, '0'),
(15, '2018-09-15', 'pasar', 'pasar', 47000, '0'),
(16, '2018-10-15', 'pasar', 'pasar', 35000, '0'),
(17, '2018-11-15', 'pasar', 'pasar', 61000, '0'),
(18, '2018-12-15', 'pasar', 'pasar', 70000, '0'),
(19, '2019-01-16', 'pasar', 'pasar', 50000, '0');

-- --------------------------------------------------------

--
-- Table structure for table `produk`
--

CREATE TABLE `produk` (
  `nama_produk` varchar(20) NOT NULL,
  `stok_produk` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `produk`
--

INSERT INTO `produk` (`nama_produk`, `stok_produk`) VALUES
('b', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bahan`
--
ALTER TABLE `bahan`
  ADD PRIMARY KEY (`nama_bahan`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_karyawan`);

--
-- Indexes for table `penjualan`
--
ALTER TABLE `penjualan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produk`
--
ALTER TABLE `produk`
  ADD PRIMARY KEY (`nama_produk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `penjualan`
--
ALTER TABLE `penjualan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
