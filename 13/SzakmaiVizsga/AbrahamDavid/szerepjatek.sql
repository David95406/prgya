-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2025. Ápr 15. 11:55
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `szerepjatek`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `fajok`
--

CREATE TABLE `fajok` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) NOT NULL,
  `leiras` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `fajok`
--

INSERT INTO `fajok` (`id`, `nev`, `leiras`) VALUES
(1, 'Ember', 'Sokoldalú faj'),
(2, 'Elf', 'Gyors és bölcs'),
(3, 'Ork', 'Erős, de lassú'),
(4, 'Törp', 'Kitartó harcos nép');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `karakterek`
--

CREATE TABLE `karakterek` (
  `id` int(11) NOT NULL,
  `nev` varchar(255) DEFAULT NULL,
  `szint` int(11) DEFAULT NULL,
  `ero` int(11) DEFAULT NULL,
  `ugyesseg` int(11) DEFAULT NULL,
  `faj_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `karakterek`
--

INSERT INTO `karakterek` (`id`, `nev`, `szint`, `ero`, `ugyesseg`, `faj_id`) VALUES
(1, 'Arthas', 4, 9, 6, 1),
(2, 'Lindir', 5, 7, 10, 2),
(3, 'Gromm', 3, 10, 4, 3),
(4, 'Borin', 2, 6, 5, 4),
(5, 'Elina', 6, 5, 9, 2),
(9, 'Thorg', 3, 10, 5, 3),
(10, 'Thorg', 3, 10, 5, 3);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `fajok`
--
ALTER TABLE `fajok`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `karakterek`
--
ALTER TABLE `karakterek`
  ADD PRIMARY KEY (`id`),
  ADD KEY `faj_id` (`faj_id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `fajok`
--
ALTER TABLE `fajok`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT a táblához `karakterek`
--
ALTER TABLE `karakterek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `karakterek`
--
ALTER TABLE `karakterek`
  ADD CONSTRAINT `karakterek_ibfk_1` FOREIGN KEY (`faj_id`) REFERENCES `fajok` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
