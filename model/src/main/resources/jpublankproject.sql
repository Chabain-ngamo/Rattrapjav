-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 04, 2020 at 02:04 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jpublankproject`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `GameId`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GameId` (IN `p_id` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM Game WHERE id = p_id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `levels`
--

DROP TABLE IF EXISTS `Game`;
CREATE TABLE IF NOT EXISTS `Game` (
  `id` int(2) NOT NULL AUTO_INCREMENT,
  `LevelGame` text NOT NULL,
  `nbrDiamonds` int(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `levels`
--

INSERT INTO `Game` (`id`, `LevelGame`, `nbrDiamonds`) VALUES
(1, 'wwwwwwwwwwwwwwwwwwwwwwwww\r\nwdsddsddwdsdddDdwdddpdsdw\r\nwdddddddwddddddpwppdpdddw\r\nwadddddddddddddsdssdddddw\r\nwDddddddwdsddddswdsdpddpw\r\nwdddddddwdsddddswdsdppddw\r\nwwwwwwwwwwwwwwwwwwwwpwwww\r\nwddddssdwddpddddwdddpddsw\r\nwdddddddwddpddddwdddpdddw\r\nwWpppppppppsppppppppppppw\r\nwsddsdddwddddsddwddssdddw\r\nwsddddsdwddsddsdwdddsdssw\r\nwdsddDddwdddsDddwdddddddw\r\nwwwwwwwwwwwwwwwwwwwwwwwww', 4),
(2, 'wwwwwwwwwwwwwwwwwwwwwwwww\r\nwddddssdwddpddddwdddpddsw\r\nwdddddddwddpddddwdddpdddw\r\nwapppppppppsppppppppppppw\r\nwsddsdddwddddsddwddssdddw\r\nwsddddsdwddsddsdwdddsdssw\r\nwdsddDddwdddsDddwdddddddw\r\nwwwwwwwwwwwwwwwwwwppwwwww\r\nwsWpepddwddddsdswdddpdddw\r\nwdddddpdwpddddddwddDpdddw\r\nwppppppppsppppppppppppDpw\r\nwdDdddspwddpddddwddDpsddw\r\nwdsdWddswddsddsdwddddddDw\r\nwwwwwwwwwwwwwwwwwwwwwwwww', 7),
(3, 'wwwwwwwwwwwwwwwwwwwwwwwww\r\nwdddddsddddddwwddddsDdddw\r\nwddwdwdwddwddwdwddwddwwdw\r\nwawdswwwdddddswddddddwwww\r\nwdwdDwdwdwwwdwdwdwwwdwwdw\r\nwddwdwdwDwdwDwwddsdwdwwdw\r\nwdddddddddddddddddddDdddw\r\nwwwwppwwwwwwwwwwwwwppwwww\r\nwdddddddwdddssdwddddpppdw\r\nwddddpppwdDsdddwdddspepsw\r\nwddsdpeppddddddwddDdpppdw\r\nwDsddpppwddsddDwddddddddw\r\nwdddddddwddddWdwddddddddw\r\nwwwwwwwwwwwwwwwwwwwwwwwww', 9),
(4, 'wwwwwwwwwwwwwwwwwwwwwwwww\r\nwdddddsddddwdsddddddddddw\r\nwdddddddwdddddddddwddsddw\r\nwdswdwdddddwdwDwdddddsDdw\r\nwaswwwdwwwdwdwdwdwwwdsddw\r\nwddwDwdwdwdwddwddwdwdddsw\r\nwddppdddddpepdsdsdddddddw\r\nwwwppwwwwwwwwDwpwwddwwwww\r\nwdddsdwdDdddwpwpwdwdddddw\r\nwdspppwddsdswwwwwddwdsddw\r\nwdspepwdddwddddddDddsdddw\r\nwdDpppwdddwdpepddddsdpddw\r\nwsdddDwdWdwdddddddsddwddw\r\nwwwwwwwwwwwwwwwwwwwwwwwww', 8),
(5, 'wwwwwwwwwwwwwwwwwwwwwwwww\r\nwdddddwddwddddddsdddddddw\r\nwddwdwwdddddwwdwdwDwdwwww\r\nwadwdwwdwdwdwdwwdwwwdwwwd\r\nwdddwdwwwdwdwwdwdwdwdwwpw\r\nwddddsddddddddddddddddddw\r\nwdwwddddwwwwwwwwwwwwwssdw\r\nwddDwddwddddddddddddwdddw\r\nwwwwddwddwwwwwwpeppwddwdw\r\nwdsddwDdwWddddddddwddwddw\r\nwdddwdddwwwwwwwwwwddwwdsw\r\nwDdwddswddssssdddddwDwpdw\r\nwdwdddddddddddddddwdddpdw\r\nwwwwwwwwwwwwwwwwwwwwwwwww', 5);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;