-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2025. Ápr 14. 10:09
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `karakterek`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `fajok`
--

CREATE TABLE `fajok` (
  `id` tinyint(4) NOT NULL,
  `faj` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `fajok`
--

INSERT INTO `fajok` (`id`, `faj`) VALUES
(8, 'ember'),
(14, 'ork'),
(31, 'elf'),
(42, 'törpe');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `karakterek`
--

CREATE TABLE `karakterek` (
  `id` int(11) NOT NULL,
  `nev` varchar(10) NOT NULL,
  `faj_id` tinyint(4) NOT NULL,
  `leiras` varchar(40) NOT NULL,
  `szint` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `karakterek`
--

INSERT INTO `karakterek` (`id`, `nev`, `faj_id`, `leiras`, `szint`) VALUES
(1, 'Aric', 8, 'Kardmester, tűzvarázs, becsületes', 45),
(2, 'Thokk', 14, 'Nagybárd, vérszomj, páncélörlő', 38),
(3, 'Lirea', 31, 'Íjász, természetvarázs, nyugodt', 52),
(4, 'Durin', 42, 'Kalapács, kovács, makacs', 48),
(5, 'Zara', 8, 'Tűzlabda, jégtű, okos', 60),
(6, 'Gromm', 42, 'Kétkezes fegyver, vad, erős', 42),
(7, 'Sylria', 31, 'Állatirányítás, gyógyítás, bölcs', 55),
(8, 'Borin', 42, 'Pajzs, fejsze, kitartó', 50),
(9, 'Kael', 8, 'Lándzsa, lovagi kódex, idealista', 47),
(10, 'Ragash', 42, 'Két kard, kegyetlen, gyors', 40),
(11, 'Elara', 31, 'Gyógyvarázs, fény, empata', 58),
(12, 'Thrain', 42, 'Csatabárd, taktikus, okos', 53),
(13, 'Marcus', 8, 'Tőr, ravasz, szerencsejátékos', 44),
(14, 'Gorruk', 14, 'Bunkósbot, erőszakos, buta', 41),
(15, 'Nimue', 31, 'Illúziók, álcázás, ravasz', 57),
(16, 'Dvalin', 42, 'Harci csákány, pontos, türelmes', 49),
(17, 'Liam', 8, 'Rövidkard, félelmes, tapasztalatlan', 35),
(18, 'Urzog', 8, 'Hosszú kard, vezető, okos', 43),
(19, 'Faelivrin', 31, 'Idővarázs, látnok, bölcs', 65),
(20, 'Hargin', 42, 'Aranyműves, gazdag, kapzsi', 46);

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
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `fajok`
--
ALTER TABLE `fajok`
  MODIFY `id` tinyint(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT a táblához `karakterek`
--
ALTER TABLE `karakterek`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
