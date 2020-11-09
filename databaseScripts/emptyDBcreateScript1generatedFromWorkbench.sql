CREATE TABLE `kandydat` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) NOT NULL,
  `nazwisko` varchar(30) NOT NULL,
  `stanowisko` int(8) DEFAULT NULL,
  `nazwa_pliku_cv` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stanowisko` (`stanowisko`),
  CONSTRAINT `kandydat_ibfk_1` FOREIGN KEY (`stanowisko`) REFERENCES `stanowisko` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `kat_projektu` (
  `id_kat` int(8) NOT NULL AUTO_INCREMENT,
  `nazwa_kat_projektu` varchar(30) NOT NULL,
  PRIMARY KEY (`id_kat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pracownik` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `imie` varchar(30) NOT NULL,
  `nazwisko` varchar(30) NOT NULL,
  `typ_konta` int(8) NOT NULL,
  `stanowisko` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `stanowisko` (`stanowisko`),
  CONSTRAINT `pracownik_ibfk_1` FOREIGN KEY (`stanowisko`) REFERENCES `stanowisko` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `pracownik_hr` (
  `id_pracownik` int(8) NOT NULL AUTO_INCREMENT,
  `login` varchar(100) NOT NULL,
  `haslo` varchar(100) NOT NULL,
  PRIMARY KEY (`id_pracownik`),
  CONSTRAINT `pracownik_hr_ibfk_1` FOREIGN KEY (`id_pracownik`) REFERENCES `pracownik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `projekt` (
  `id_projekt` int(8) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) NOT NULL,
  `kategoria_projektu` int(8) NOT NULL,
  PRIMARY KEY (`id_projekt`),
  KEY `kategoria_projektu` (`kategoria_projektu`),
  CONSTRAINT `projekt_ibfk_1` FOREIGN KEY (`kategoria_projektu`) REFERENCES `kat_projektu` (`id_kat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `projekt_pracownik` (
  `id_pracownik` int(8) NOT NULL,
  `id_projekt` int(8) NOT NULL,
  KEY `id_pracownik` (`id_pracownik`),
  KEY `id_projekt` (`id_projekt`),
  CONSTRAINT `projekt_pracownik_ibfk_1` FOREIGN KEY (`id_pracownik`) REFERENCES `pracownik` (`id`),
  CONSTRAINT `projekt_pracownik_ibfk_2` FOREIGN KEY (`id_projekt`) REFERENCES `projekt` (`id_projekt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `stanowisko` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) NOT NULL,
  `dzial` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `szkolenie` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `nazwa` varchar(30) NOT NULL,
  `data_szkolenia` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `rodzaj_szkolenia` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `szkolenie_kat` (
  `id_szk_kat` int(8) NOT NULL AUTO_INCREMENT,
  `nazwa_kat_szk` varchar(30) NOT NULL,
  PRIMARY KEY (`id_szk_kat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `szkolenie_pracownik` (
  `id_pracownik` int(8) NOT NULL,
  `id_szkolenie` int(8) NOT NULL,
  KEY `id_pracownik` (`id_pracownik`),
  KEY `id_szkolenie` (`id_szkolenie`),
  CONSTRAINT `szkolenie_pracownik_ibfk_1` FOREIGN KEY (`id_pracownik`) REFERENCES `pracownik` (`id`),
  CONSTRAINT `szkolenie_pracownik_ibfk_2` FOREIGN KEY (`id_szkolenie`) REFERENCES `szkolenie` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
