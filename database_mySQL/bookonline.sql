-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 25, 2019 at 09:47 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookonline`
--

-- --------------------------------------------------------

--
-- Table structure for table `datsach`
--

DROP TABLE IF EXISTS `datsach`;
CREATE TABLE IF NOT EXISTS `datsach` (
  `HoTen` varchar(128) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `Email` varchar(128) NOT NULL,
  `MaSach` varchar(10) NOT NULL,
  `TenSach` varchar(256) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `datsach`
--

INSERT INTO `datsach` (`HoTen`, `SoDienThoai`, `Email`, `MaSach`, `TenSach`, `SoLuong`) VALUES
('Huynh Trung Duc', '0788457554', 'bihuynh777@gmail.com', 'JAV0000003', 'Nhap Mon Lap Trinh', 20),
('Huynh Trung Duc', '0788457554', 'bihuynh777@gmail.com', 'JAV0000004', 'Cau Truc Du Lieu Va Giai Thuat', 30);

-- --------------------------------------------------------

--
-- Table structure for table `sach`
--

DROP TABLE IF EXISTS `sach`;
CREATE TABLE IF NOT EXISTS `sach` (
  `MaSach` varchar(10) NOT NULL,
  `TenSach` varchar(256) NOT NULL,
  `TheLoai` varchar(50) NOT NULL,
  `TacGia` varchar(148) NOT NULL,
  `NhaXuatBan` varchar(500) NOT NULL,
  `NgayXuatBan` date NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaThanh` int(11) NOT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sach`
--

INSERT INTO `sach` (`MaSach`, `TenSach`, `TheLoai`, `TacGia`, `NhaXuatBan`, `NgayXuatBan`, `SoLuong`, `GiaThanh`) VALUES
('JAV0000001', 'Tat Den', 'Van Hoc', 'Ngo Tat To', 'Nha Sach Phuong Nam', '2019-04-01', 20, 20000),
('JAV0000003', 'Nhap Mon Lap Trinh', 'IT', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 60, 22000),
('JAV0000004', 'Cau Truc Du Lieu Va Giai Thuat', 'IT', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 10, 30000),
('JAV0000005', 'Lap Trinh Huong Doi Tuong', 'IT', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 30, 25000),
('JAV0000006', 'Lap Trinh Sql', 'IT', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 50, 20000),
('JAV0000007', 'Khoa Hoc Tu Nhien Va Xa Hoi', 'Khoa Hoc', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 20, 22000),
('JAV0000008', 'Ngu Van', 'Van Hoc', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 30, 29000),
('JAV0000009', 'Toan Dai', 'Toan Hoc', 'Nguyen Van A', 'Nha Sach Phuong Nam', '2019-04-02', 20, 24000),
('JAV0000010', 'Sql Sever', 'IT', 'Nguyen Ngoc Thuy', 'Nha Sach Phuong Nam', '2019-04-10', 20, 30000);

-- --------------------------------------------------------

--
-- Table structure for table `sachdaxoa`
--

DROP TABLE IF EXISTS `sachdaxoa`;
CREATE TABLE IF NOT EXISTS `sachdaxoa` (
  `MaSach` varchar(10) NOT NULL,
  `TenSach` varchar(256) NOT NULL,
  `TheLoai` varchar(50) NOT NULL,
  `TacGia` varchar(148) NOT NULL,
  `NhaXuatBan` varchar(500) NOT NULL,
  `NgayXuatBan` date NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `GiaThanh` int(11) NOT NULL,
  PRIMARY KEY (`MaSach`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sachdaxoa`
--

INSERT INTO `sachdaxoa` (`MaSach`, `TenSach`, `TheLoai`, `TacGia`, `NhaXuatBan`, `NgayXuatBan`, `SoLuong`, `GiaThanh`) VALUES
('JAV0000002', 'He Dieu Hanh', 'Khoa Hoc', 'Nguyen Van B', 'Hong Bang', '2019-04-02', 20, 22000);

-- --------------------------------------------------------

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE IF NOT EXISTS `taikhoan` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(100) NOT NULL,
  `PassWord` varchar(100) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `taikhoan`
--

INSERT INTO `taikhoan` (`ID`, `UserName`, `PassWord`) VALUES
(1, 'huynhtrungduc@gmail.com', 'huynhtrungduc'),
(2, 'ngochihai@gmail.com', 'ngochihai'),
(3, 'ngominhtam@gmail.com', 'ngominhtam'),
(4, 'nguyenminhtrung@gmail.com', 'nguyenminhtrung'),
(5, 'leduykhang@gmail.com', 'leduykhang');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
