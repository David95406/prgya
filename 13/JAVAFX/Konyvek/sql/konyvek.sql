-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: localhost
-- Létrehozás ideje: 2025. Már 18. 23:16
-- Kiszolgáló verziója: 10.4.28-MariaDB
-- PHP verzió: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `konyvek`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `elerheto_konyvek`
--

CREATE TABLE `elerheto_konyvek` (
  `id` int(11) NOT NULL,
  `cim` varchar(100) NOT NULL,
  `szerzo` varchar(50) NOT NULL,
  `kiadas_eve` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'ELÉRHETŐ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `elerheto_konyvek`
--

INSERT INTO `elerheto_konyvek` (`id`, `cim`, `szerzo`, `kiadas_eve`, `status`) VALUES
(4, 'A Gyűrűk Ura', 'J.R.R. Tolkien', 1954, 'ELÉRHETŐ'),
(7, 'A Gyűrűk Ura', 'J.R.R. Tolkien', 1954, 'ELÉRHETŐ'),
(9, 'Dűne', 'Frank Herbert', 1965, 'ELÉRHETŐ'),
(10, 'A nevető ember', 'Victor Hugo', 1869, 'KIADVA'),
(11, 'Moby Dick', 'Herman Melville', 1851, 'KIADVA'),
(12, 'A Nagy Gatsby', 'F. Scott Fitzgerald', 1925, 'ELÉRHETŐ'),
(13, 'Harcolj helyettem', 'Harper Lee', 1960, 'ELÉRHETŐ');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `kiadott_konyvek`
--

CREATE TABLE `kiadott_konyvek` (
  `id` int(11) NOT NULL,
  `konyv_id` int(11) DEFAULT NULL,
  `kolcsonzo_neve` varchar(50) DEFAULT NULL,
  `kiadas_datuma` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `kiadott_konyvek`
--

INSERT INTO `kiadott_konyvek` (`id`, `konyv_id`, `kolcsonzo_neve`, `kiadas_datuma`) VALUES
(13, 10, 'asd', '2025-03-18'),
(19, 11, 'jhgjhg', '2025-03-18');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `elerheto_konyvek`
--
ALTER TABLE `elerheto_konyvek`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `kiadott_konyvek`
--
ALTER TABLE `kiadott_konyvek`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kiadott_konyvek_ibfk_1` (`konyv_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `elerheto_konyvek`
--
ALTER TABLE `elerheto_konyvek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT a táblához `kiadott_konyvek`
--
ALTER TABLE `kiadott_konyvek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `kiadott_konyvek`
--
ALTER TABLE `kiadott_konyvek`
  ADD CONSTRAINT `kiadott_konyvek_ibfk_1` FOREIGN KEY (`konyv_id`) REFERENCES `elerheto_konyvek` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
