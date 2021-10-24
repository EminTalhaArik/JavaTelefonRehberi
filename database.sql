-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.5.4-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- telefonrehberi için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `telefonrehberi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `telefonrehberi`;

-- tablo yapısı dökülüyor telefonrehberi.person
CREATE TABLE IF NOT EXISTS `person` (
  `id` int(50) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `surname` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `email` varchar(50) CHARACTER SET utf8 DEFAULT '',
  `number` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- telefonrehberi.person: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`id`, `name`, `surname`, `email`, `number`) VALUES
	(1, 'Emin Talha', 'Arık', 'iletisim.emint@gmail.com', '05437728493'),
	(4, 'Berat Can ', 'Arık', 'deneme', '1921313'),
	(5, 'osman', 'Kılış', 'ilkMail', '022');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
