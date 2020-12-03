CREATE TABLE stanowisko (
 	id INT(8) AUTO_INCREMENT PRIMARY KEY,
 	nazwa VARCHAR(30) NOT NULL,
 	dzial VARCHAR(30)
 );

 CREATE TABLE szkolenie_kat (
 	id_szk_kat INT(8) AUTO_INCREMENT PRIMARY KEY,
 	nazwa_kat_szk VARCHAR(30) NOT NULL
 );

 CREATE TABLE szkolenie (
 	id INT(8) AUTO_INCREMENT PRIMARY KEY,
 	nazwa VARCHAR(30) NOT NULL,
 	data_szkolenia TIMESTAMP NOT NULL,
 	rodzaj_szkolenia INT(8) NOT NULL,
	FOREIGN KEY (rodzaj_szkolenia) REFERENCES szkolenie_kat(id_szk_kat)
 );

 CREATE TABLE pracownik (
 	id INT(8) AUTO_INCREMENT PRIMARY KEY,
 	imie VARCHAR(30) NOT NULL,
 	nazwisko VARCHAR(30) NOT NULL,
 	typ_konta INT(8) NOT NULL,
 	stanowisko INT(8),
 	FOREIGN KEY (stanowisko) REFERENCES stanowisko(id)
 );

 CREATE TABLE szkolenie_pracownik (
 	id_pracownik INT(8) NOT NULL,
     id_szkolenie INT(8) NOT NULL,
     FOREIGN KEY (id_pracownik) REFERENCES pracownik(id),
     FOREIGN KEY (id_szkolenie) REFERENCES szkolenie(id)
 );

 CREATE TABLE kandydat(
 	id INT(8) AUTO_INCREMENT PRIMARY KEY,
 	imie VARCHAR(30) NOT NULL,
 	nazwisko VARCHAR(30) NOT NULL,
 	stanowisko INT(8),
     nazwa_pliku_cv VARCHAR(300),
 	FOREIGN KEY (stanowisko) REFERENCES stanowisko(id)
 );

 CREATE TABLE kat_projektu(
 	id_kat INT(8) NOT NULL AUTO_INCREMENT PRIMARY KEY,
 	nazwa_kat_projektu VARCHAR(30) NOT NULL
 ); 


 CREATE TABLE projekt(
 	id_projekt INT(8) AUTO_INCREMENT PRIMARY KEY,
 	nazwa VARCHAR(30) NOT NULL,
 	kategoria_projektu INT(8) NOT NULL,
 	FOREIGN KEY (kategoria_projektu) REFERENCES kat_projektu(id_kat)
 );

 CREATE TABLE projekt_pracownik(
 	id_pracownik INT(8) NOT NULL,
 	id_projekt INT(8) NOT NULL,
     FOREIGN KEY (id_pracownik) REFERENCES pracownik(id),
     FOREIGN KEY (id_projekt) REFERENCES projekt(id_projekt)
 );

 CREATE TABLE pracownik_hr(
 	id_pracownik INT(8) AUTO_INCREMENT PRIMARY KEY,
     login VARCHAR(100) NOT NULL,
     haslo VARCHAR(100) NOT NULL,
     FOREIGN KEY (id_pracownik) REFERENCES pracownik(id)
 ); 