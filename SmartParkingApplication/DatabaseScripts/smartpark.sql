-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2016 at 03:39 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smartpark`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `adminid` varchar(45) NOT NULL,
  `adminpwd` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `adminid`, `adminpwd`) VALUES
(5, 'akshay', 'akshay'),
(4, 'deepika', 'deepika'),
(3, 'madhu', 'madhu'),
(1, 'minla', 'minla'),
(2, 'tejal', 'tejal');

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE `operator` (
  `opname` varchar(45) NOT NULL,
  `oppwd` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`opname`, `oppwd`) VALUES
('ankita', 'ankita'),
('rujuta', 'rujuta');

-- --------------------------------------------------------

--
-- Table structure for table `parkingarea`
--

CREATE TABLE `parkingarea` (
  `pid` int(11) NOT NULL,
  `pname` varchar(45) NOT NULL,
  `addr` varchar(70) NOT NULL,
  `area` varchar(20) NOT NULL,
  `total_slots` int(11) NOT NULL,
  `available_slots` int(11) NOT NULL,
  `price` decimal(6,2) NOT NULL,
  `fine` decimal(6,2) NOT NULL DEFAULT '0.00',
  `lat` decimal(11,8) NOT NULL,
  `lon` decimal(12,8) NOT NULL,
  `adminid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkingarea`
--

INSERT INTO `parkingarea` (`pid`, `pname`, `addr`, `area`, `total_slots`, `available_slots`, `price`, `fine`, `lat`, `lon`, `adminid`) VALUES
(1, 'Phoenix Marketcity', 'Lal Bahadur Shastri Marg,\r\nKurla West, Mumbai, 400070.', 'Mumbai', 10, 0, '40.00', '20.00', '19.08539065', '72.88924456', 1),
(2, 'R Mall', 'L.B.S. Marg, opposite to Richardson and Cruddas, Mulund West, Mumbai, ', 'Mumbai', 15, 15, '40.00', '20.00', '19.18395927', '72.95134208', 2),
(3, 'Inorbit Mall Vashi', 'Plot No 39/1, Sector 30A, Vashi, Opp Vashi Railway Station, Navi Mumba', 'Navi Mumbai', 20, 20, '60.00', '10.00', '19.06511121', '73.00108194', 3),
(4, 'Raghuleela Mall', 'Vashi Gaon Underpass, Sector 7, Vashi, Navi Mumbai, 400703', 'Navi Mumbai', 25, 25, '50.00', '25.00', '19.06392083', '72.99678504', 4),
(8, 'R City Mall', 'Lal Bahadur Shastri Marg\r\nGhatkopar West, Mumbai, 400086', 'Mumbai', 30, 30, '35.00', '20.00', '19.09954026', '72.91678011', 5);

-- --------------------------------------------------------

--
-- Table structure for table `parkinglots`
--

CREATE TABLE `parkinglots` (
  `pid` int(11) NOT NULL,
  `slot_no` int(11) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'available',
  `sessionid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkinglots`
--

INSERT INTO `parkinglots` (`pid`, `slot_no`, `status`, `sessionid`) VALUES
(1, 1, 'available', 2),
(1, 2, 'available', NULL),
(1, 3, 'available', NULL),
(1, 4, 'available', NULL),
(1, 5, 'available', NULL),
(1, 6, 'available', NULL),
(1, 7, 'available', NULL),
(1, 8, 'available', NULL),
(1, 9, 'available', NULL),
(1, 10, 'available', NULL),
(2, 1, 'available', 4),
(2, 2, 'available', NULL),
(2, 3, 'available', NULL),
(2, 4, 'available', NULL),
(2, 5, 'available', NULL),
(2, 6, 'available', NULL),
(2, 7, 'available', NULL),
(2, 8, 'available', NULL),
(2, 9, 'available', NULL),
(2, 10, 'available', NULL),
(2, 11, 'available', NULL),
(2, 12, 'available', NULL),
(2, 13, 'available', NULL),
(2, 14, 'available', NULL),
(2, 15, 'available', NULL),
(3, 1, 'available', 3),
(3, 2, 'available', NULL),
(3, 3, 'available', NULL),
(3, 4, 'available', NULL),
(3, 5, 'available', NULL),
(3, 6, 'available', NULL),
(3, 7, 'available', NULL),
(3, 8, 'available', NULL),
(3, 9, 'available', NULL),
(3, 10, 'available', NULL),
(3, 11, 'available', NULL),
(3, 12, 'available', NULL),
(3, 13, 'available', NULL),
(3, 14, 'available', NULL),
(3, 15, 'available', NULL),
(3, 16, 'available', NULL),
(3, 17, 'available', NULL),
(3, 18, 'available', NULL),
(3, 19, 'available', NULL),
(3, 20, 'available', NULL),
(4, 1, 'available', 1),
(4, 2, 'available', NULL),
(4, 3, 'available', NULL),
(4, 4, 'available', NULL),
(4, 5, 'available', NULL),
(4, 6, 'available', NULL),
(4, 7, 'available', NULL),
(4, 8, 'available', NULL),
(4, 9, 'available', NULL),
(4, 10, 'available', NULL),
(4, 11, 'available', NULL),
(4, 12, 'available', NULL),
(4, 13, 'available', NULL),
(4, 14, 'available', NULL),
(4, 15, 'available', NULL),
(4, 16, 'available', NULL),
(4, 17, 'available', NULL),
(4, 18, 'available', NULL),
(4, 19, 'available', NULL),
(4, 20, 'available', NULL),
(4, 21, 'available', NULL),
(4, 22, 'available', NULL),
(4, 23, 'available', NULL),
(4, 24, 'available', NULL),
(4, 25, 'available', NULL),
(8, 1, 'available', NULL),
(8, 2, 'available', NULL),
(8, 3, 'available', NULL),
(8, 4, 'available', NULL),
(8, 5, 'available', NULL),
(8, 6, 'available', NULL),
(8, 7, 'available', NULL),
(8, 8, 'available', NULL),
(8, 9, 'available', NULL),
(8, 10, 'available', NULL),
(8, 11, 'available', NULL),
(8, 12, 'available', NULL),
(8, 13, 'available', NULL),
(8, 14, 'available', NULL),
(8, 15, 'available', NULL),
(8, 16, 'available', NULL),
(8, 17, 'available', NULL),
(8, 18, 'available', NULL),
(8, 19, 'available', NULL),
(8, 20, 'available', NULL),
(8, 21, 'available', NULL),
(8, 22, 'available', NULL),
(8, 23, 'available', NULL),
(8, 24, 'available', NULL),
(8, 25, 'available', NULL),
(8, 26, 'available', NULL),
(8, 27, 'available', NULL),
(8, 28, 'available', NULL),
(8, 29, 'available', NULL),
(8, 30, 'available', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `parkingsession`
--

CREATE TABLE `parkingsession` (
  `sessionid` int(11) NOT NULL,
  `userid` varchar(45) NOT NULL,
  `carno` char(10) NOT NULL,
  `duration` time(6) NOT NULL,
  `logged` time(6) NOT NULL,
  `intime` time(6) DEFAULT NULL,
  `outtime` time(6) DEFAULT NULL,
  `billamt` decimal(10,2) NOT NULL DEFAULT '0.00',
  `status` varchar(20) NOT NULL DEFAULT 'reserved',
  `pid` int(11) NOT NULL,
  `slot_no` int(11) NOT NULL,
  `ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `parkingsession`
--

INSERT INTO `parkingsession` (`sessionid`, `userid`, `carno`, `duration`, `logged`, `intime`, `outtime`, `billamt`, `status`, `pid`, `slot_no`, `ts`) VALUES
(1, '4', 'MH05CP0555', '01:10:00.000000', '15:10:30.000000', '15:21:49.000000', '15:35:03.000000', '11.00', 'finished', 4, 1, '2016-04-20 16:31:04'),
(2, '1', 'MH04BQ7186', '01:40:00.000000', '15:45:13.000000', NULL, NULL, '0.00', 'cancelled', 1, 1, '2016-04-20 16:31:04'),
(3, '1', 'MH04BQ7186', '01:00:00.000000', '02:25:21.000000', NULL, NULL, '0.00', 'cancelled', 3, 1, '2016-04-20 16:31:04'),
(4, '1', 'MH04BQ7186', '01:00:00.000000', '16:33:03.000000', NULL, NULL, '0.00', 'cancelled', 2, 1, '2016-04-20 16:33:03');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userid` int(11) NOT NULL,
  `userpwd` varchar(45) NOT NULL,
  `uname` varchar(45) NOT NULL,
  `contactno` varchar(13) NOT NULL,
  `dlicense` char(16) NOT NULL,
  `bonus` int(11) NOT NULL DEFAULT '10'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userid`, `userpwd`, `uname`, `contactno`, `dlicense`, `bonus`) VALUES
(1, 'sneha', 'sneha', '8767767106', 'MH-1220050000188', 10),
(2, 'chalonsh', 'chalonsh', '9920801678', 'MH-1220050000189', 10),
(4, 'tejal', 'Tejal', '9833734780', 'MH-1225504000189', 10),
(7, 'pooja', 'pooja', '7506969809', 'MH-1234567890123', 10);

-- --------------------------------------------------------

--
-- Table structure for table `user_cars`
--

CREATE TABLE `user_cars` (
  `userid` varchar(45) NOT NULL,
  `carno` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_cars`
--

INSERT INTO `user_cars` (`userid`, `carno`) VALUES
('1', 'MH04BQ7186'),
('2', 'MH01RS2354'),
('4', 'MH05CP0555'),
('5', ''),
('6', 'MH05AP7193'),
('7', 'MH05LI8352');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `adminid` (`adminid`,`adminpwd`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`opname`,`oppwd`),
  ADD KEY `opname` (`opname`,`oppwd`);

--
-- Indexes for table `parkingarea`
--
ALTER TABLE `parkingarea`
  ADD PRIMARY KEY (`pid`),
  ADD KEY `pid` (`pid`),
  ADD KEY `pid_2` (`pid`),
  ADD KEY `adminid` (`adminid`);

--
-- Indexes for table `parkinglots`
--
ALTER TABLE `parkinglots`
  ADD PRIMARY KEY (`pid`,`slot_no`),
  ADD KEY `pid` (`pid`,`slot_no`),
  ADD KEY `sessionid` (`sessionid`),
  ADD KEY `slot_no` (`slot_no`);

--
-- Indexes for table `parkingsession`
--
ALTER TABLE `parkingsession`
  ADD PRIMARY KEY (`sessionid`),
  ADD KEY `sessionid` (`sessionid`,`userid`,`carno`,`pid`,`slot_no`),
  ADD KEY `slot_no` (`slot_no`),
  ADD KEY `fk_usercars_carno` (`carno`),
  ADD KEY `fk_user_userid` (`userid`,`carno`),
  ADD KEY `fk_pid` (`pid`,`slot_no`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `userpwd` (`userpwd`,`uname`),
  ADD UNIQUE KEY `userpwd_2` (`userpwd`,`uname`),
  ADD KEY `userid` (`userid`);

--
-- Indexes for table `user_cars`
--
ALTER TABLE `user_cars`
  ADD PRIMARY KEY (`userid`,`carno`),
  ADD KEY `userid` (`userid`,`carno`),
  ADD KEY `carno` (`carno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `parkingarea`
--
ALTER TABLE `parkingarea`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `parkingsession`
--
ALTER TABLE `parkingsession`
  MODIFY `sessionid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `parkingarea`
--
ALTER TABLE `parkingarea`
  ADD CONSTRAINT `fk_admin_id` FOREIGN KEY (`adminid`) REFERENCES `admin` (`id`);

--
-- Constraints for table `parkinglots`
--
ALTER TABLE `parkinglots`
  ADD CONSTRAINT `fk_parkingarea_pid` FOREIGN KEY (`pid`) REFERENCES `parkingarea` (`pid`),
  ADD CONSTRAINT `fk_parkingsession_sessionid` FOREIGN KEY (`sessionid`) REFERENCES `parkingsession` (`sessionid`);

--
-- Constraints for table `parkingsession`
--
ALTER TABLE `parkingsession`
  ADD CONSTRAINT `fk_pid` FOREIGN KEY (`pid`,`slot_no`) REFERENCES `parkinglots` (`pid`, `slot_no`),
  ADD CONSTRAINT `fk_user_userid` FOREIGN KEY (`userid`,`carno`) REFERENCES `user_cars` (`userid`, `carno`);

DELIMITER $$
--
-- Events
--
CREATE DEFINER=`root`@`localhost` EVENT `autoupdate` ON SCHEDULE EVERY 1 MINUTE STARTS '2016-04-16 10:21:37' ON COMPLETION PRESERVE ENABLE DO UPDATE parkingsession
   SET status = 'cancelled' 
 WHERE status='reserved' AND MINUTE(SUBTIME(CURRENT_TIME,parkingsession.logged))>=20$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
