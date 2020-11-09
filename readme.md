# Dziwny projekt md

**Dokumentacja** : https://docs.google.com/document/d/1Ej96htsU3wJZiu_nJ5V7qXtIH7qG0024Oh0gC5AcgG4/edit?usp=sharing
tu bede wypisywac rozne rzeczy zwiazane z projektem takie jak ustawic dockera czy jakies endpointy bo nie bede robic dokumentacji


# Stworzenie instancji db
**Pobierz** dockera
**Pobierz** aktualizacje to **WDL2**
w folderze **/filesToUseWithDocker** jest **docker-compose.yaml** - jak korzystasz z linuxa to git jak nie to pewnie w powershellu tez zadziala: **docker-compose up -d** to stworzy obraz bazy i Ci go odpali
zrobilem tak ze po kazdym starcie klienta dockera kontener powinien wstac sam lecz jak nie wstanie to docker start nazwa kontenera - a nazwe pobierasz z komendy docker ps -a i tam mas nazwe
No i jak chcesz sie zalogowac do bazy to zmapowalem port na 3308 bo nie wiem czy macie jakies juz stojace mysqle wiec w workbenchu czy gdziekolwiek tam bedziecie chcieli 
adres: 127.0.0.1:3308 login roota: user pw roota: password ; adres bazy (jesli potrzebny) /projdb

**SKRYPT DO BAZY** /databaseScripts i w jakims workbenczu czy innym syfie odpalic script1 
