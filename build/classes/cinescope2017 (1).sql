-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 11 Octobre 2017 à 16:15
-- Version du serveur :  10.1.10-MariaDB
-- Version de PHP :  7.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cinescope2017`
--

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `departementDelete` (IN `aiId` INT)  DELETE FROM departement WHERE id_departement = aiId$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `departementInsert` (IN `asCode` CHAR(3), IN `asName` VARCHAR(50))  BEGIN
INSERT INTO departement(code_departement, nom_departement) VALUES (asCode, asName);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `departementSelectAll` ()  BEGIN
SELECT * FROM departement;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `departementSelectOne` (IN `aiId` INT)  BEGIN
SELECT * FROM departement WHERE id_departement = aiId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `departementUpdate` (IN `aiId` INT, IN `asCp` CHAR(3), IN `asName` VARCHAR(50))  BEGIN
UPDATE departement SET code_departement = asCp, nom_departement = asName WHERE id_departement = aiId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `genreDelete` (IN `asId` INT)  BEGIN
DELETE FROM genre WHERE ID_genre = asId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `genreInsert` (IN `asCodeGenre` CHAR(2), IN `asLibelleGenre` VARCHAR(50), IN `asGenreGram` CHAR(1))  BEGIN
INSERT INTO genre(CODE_genre,LIBELLE_genre,genre_GRAMMATICAL) VALUES(asCodeGenre,asLibelleGenre,asGenreGram);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `genreSelectAll` ()  BEGIN
SELECT * FROM genre g;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `genreSelectOne` (IN `asId` INT)  BEGIN
SELECT * FROM genre WHERE ID_genre = asId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `genreUpdate` (IN `aiId` INT, IN `asCodeGenre` CHAR(2), IN `asLibelleGenre` VARCHAR(50), IN `asGenreGram` CHAR(1))  BEGIN
UPDATE genre SET CODE_genre = asCodeGenre, LIBELLE_genre = asLibelleGenre, genre_GRAMMATICAL = asGenreGram WHERE ID_genre = aiId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `media_delete` (`paramID_MEDIA` INT)  BEGIN
	DELETE
	FROM cinescope2017.media
	WHERE ID_media = paramID_MEDIA ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `media_insert` (`paramID_MEDIA` INT, `paramNOM_MEDIA` VARCHAR(254))  BEGIN
	INSERT INTO cinescope2017.media(ID_media,NOM_media)
	VALUES(paramID_MEDIA,paramNOM_MEDIA) ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `media_select_all` ()  BEGIN
	SELECT * 
	FROM cinescope2017.media ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `media_select_one` (`paramID_MEDIA` INT)  BEGIN
	SELECT * 
	FROM cinescope2017.media
	WHERE ID_media = paramID_MEDIA ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `media_update` (`paramID_MEDIA` INT, `paramNOM_MEDIA` VARCHAR(254))  BEGIN
	UPDATE cinescope2017.media
	SET NOM_media = paramNOM_MEDIA
	WHERE ID_media = paramID_MEDIA ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `paysDelete` (IN `asId` INT)  BEGIN
DELETE FROM pays WHERE ID_pays = asId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `paysInsert` (IN `asName` VARCHAR(50), IN `asMale` VARCHAR(50), IN `asFemale` VARCHAR(50), IN `asNeutre` VARCHAR(50))  BEGIN
INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(asName,asMale,asFemale,asNeutre);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `paysSelectAll` ()  BEGIN
SELECT * FROM pays p;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `paysSelectOne` (IN `asId` INT)  BEGIN
SELECT * FROM pays WHERE ID_pays = asId;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `paysUpdate` (IN `asId` INT, IN `asName` VARCHAR(50), IN `asMale` VARCHAR(50), IN `asFemale` VARCHAR(50), IN `asNeutre` VARCHAR(50))  BEGIN
UPDATE pays SET NOM_pays = asName, MASCULIN = asMale, FEMININ = asFemale, NEUTRE = asNeutre WHERE ID_pays = asId;
END$$

--
-- Fonctions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `Insert_Into` (`asNom` VARCHAR(50), `asMasculin` VARCHAR(50), `asFeminin` VARCHAR(50), `asNeutre` VARCHAR(50)) RETURNS INT(11) NO SQL
    DETERMINISTIC
BEGIN
   DECLARE LastID INT;

   SET LastID = -1;
   INSERT INTO pays(NOM_pays, MASCULIN, FEMININ, NEUTRE) VALUES(asNom,asMasculin,asFeminin,asNeutre);
   SELECT LAST_INSERT_ID() INTO LastID FROM DUAL;
   RETURN LastID;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `appreciation`
--

CREATE TABLE `appreciation` (
  `ID_appreciation` int(11) NOT NULL,
  `ETOILE` varchar(5) NOT NULL,
  `LIBELLE_appreciation` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `apprecier`
--

CREATE TABLE `apprecier` (
  `ID_media` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `ID_appreciation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `arrondissement`
--

CREATE TABLE `arrondissement` (
  `ID_arrondissement` int(11) NOT NULL,
  `CODE_arrondissement` varchar(5) NOT NULL,
  `NOM_arrondissement` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `ID_article` int(11) NOT NULL,
  `ID_journaliste` int(11) NOT NULL,
  `ID_film` int(11) DEFAULT NULL,
  `TITRE_article` varchar(50) NOT NULL,
  `TEXTE_article` varchar(50) NOT NULL,
  `PHOTO_article` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `artiste`
--

CREATE TABLE `artiste` (
  `ID_artiste` int(11) NOT NULL,
  `NOM_artiste` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `cinema`
--

CREATE TABLE `cinema` (
  `ID_cinema` int(11) NOT NULL,
  `ID_ville` int(11) DEFAULT NULL,
  `ID_arrondissement` int(11) DEFAULT NULL,
  `CODE_cinema` varchar(10) NOT NULL,
  `NOM_cinema` varchar(50) NOT NULL,
  `ADRESSE_cinema` varchar(100) DEFAULT NULL,
  `TELEPHONE_cinema` varchar(50) DEFAULT NULL,
  `TARIFS_cinema` varchar(100) DEFAULT NULL,
  `DIVERS_cinema` varchar(100) DEFAULT NULL,
  `RESEAU_cinema` varchar(50) DEFAULT NULL,
  `ACCES_HANDICAPES` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `cinemas_paris`
--
CREATE TABLE `cinemas_paris` (
`ID_cinema` int(1)
,`ID_ville` int(1)
,`ID_arrondissement` int(1)
,`CODE_cinema` int(1)
,`NOM_cinema` int(1)
,`ADRESSE_cinema` int(1)
,`TELEPHONE_cinema` int(1)
,`TARIFS_cinema` int(1)
,`DIVERS_cinema` int(1)
,`RESEAU_cinema` int(1)
,`ACCES_HANDICAPES` int(1)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `cinemas_peripherie`
--
CREATE TABLE `cinemas_peripherie` (
`ID_cinema` int(1)
,`ID_ville` int(1)
,`ID_arrondissement` int(1)
,`CODE_cinema` int(1)
,`NOM_cinema` int(1)
,`ADRESSE_cinema` int(1)
,`TELEPHONE_cinema` int(1)
,`TARIFS_cinema` int(1)
,`DIVERS_cinema` int(1)
,`RESEAU_cinema` int(1)
,`ACCES_HANDICAPES` int(1)
);

-- --------------------------------------------------------

--
-- Structure de la table `departement`
--

CREATE TABLE `departement` (
  `ID_departement` int(11) NOT NULL,
  `CODE_departement` char(3) NOT NULL,
  `NOM_departement` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `departement`
--

INSERT INTO `departement` (`ID_departement`, `CODE_departement`, `NOM_departement`) VALUES
(3, '99', 'Neuf'),
(4, '989', 'Neuf-Huit-Neuf'),
(5, '88', 'Huit c''est beaucoup'),
(9, 'TED', 'TEST Département'),
(10, 'VAL', 'VAL DE MARNE'),
(11, 'TRT', 'Troyes Ville'),
(13, 'TSS', 'TEST SOUS SECURITE'),
(14, 'SST', 'SECURITE SOUS TEST'),
(15, 'T1T', 'Test 1 Test'),
(16, 'ESS', 'Essai'),
(17, 'FRR', 'FRANCE');

-- --------------------------------------------------------

--
-- Structure de la table `festival`
--

CREATE TABLE `festival` (
  `ID_festival` int(11) NOT NULL,
  `NOM_festival` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `ID_film` int(11) NOT NULL,
  `ID_genre` int(11) NOT NULL,
  `TITRE_film` varchar(50) NOT NULL,
  `TITRE_ORIGINAL` varchar(50) DEFAULT NULL,
  `TOTAL_ENTREES` decimal(10,0) DEFAULT NULL,
  `DATE_SORTIE` date DEFAULT NULL,
  `ENTREES_SEMAINE` decimal(10,0) DEFAULT NULL,
  `NOMBRE_SEMAINES` decimal(5,0) DEFAULT NULL,
  `ANNEE` decimal(4,0) DEFAULT NULL,
  `DUREE` varchar(10) DEFAULT NULL,
  `CONDENSE` varchar(1000) DEFAULT NULL,
  `COULEURS` varchar(20) DEFAULT NULL,
  `INTERDICTION_film` int(11) DEFAULT NULL,
  `PUBLIC_film` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `films_autres`
--
CREATE TABLE `films_autres` (
`ID_film` int(1)
,`ID_genre` int(1)
,`TITRE_film` int(1)
,`TITRE_ORIGINAL` int(1)
,`TOTAL_ENTREES` int(1)
,`DATE_SORTIE` int(1)
,`ENTREES_SEMAINE` int(1)
,`NOMBRE_SEMAINES` int(1)
,`ANNEE` int(1)
,`DUREE` int(1)
,`CONDENSE` int(1)
,`COULEURS` int(1)
,`INTERDICTION_film` int(1)
,`PUBLIC_film` int(1)
);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `films_nouveaux`
--
CREATE TABLE `films_nouveaux` (
`ID_film` int(1)
,`ID_genre` int(1)
,`TITRE_film` int(1)
,`TITRE_ORIGINAL` int(1)
,`TOTAL_ENTREES` int(1)
,`DATE_SORTIE` int(1)
,`ENTREES_SEMAINE` int(1)
,`NOMBRE_SEMAINES` int(1)
,`ANNEE` int(1)
,`DUREE` int(1)
,`CONDENSE` int(1)
,`COULEURS` int(1)
,`INTERDICTION_film` int(1)
,`PUBLIC_film` int(1)
);

-- --------------------------------------------------------

--
-- Structure de la table `film_festival`
--

CREATE TABLE `film_festival` (
  `ID_film` int(11) NOT NULL,
  `ID_festival` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `film_rubrique`
--

CREATE TABLE `film_rubrique` (
  `id_film` int(11) NOT NULL,
  `id_rubrique` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `genre`
--

CREATE TABLE `genre` (
  `ID_genre` int(11) NOT NULL,
  `CODE_genre` char(2) NOT NULL,
  `LIBELLE_genre` varchar(50) NOT NULL,
  `genre_GRAMMATICAL` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `genre`
--

INSERT INTO `genre` (`ID_genre`, `CODE_genre`, `LIBELLE_genre`, `genre_GRAMMATICAL`) VALUES
(1, 'SF', 'Science Fiction', 'F'),
(3, 'CO', 'Comique', 'M'),
(4, 'CD', 'Comedie-Dramatique', 'F'),
(5, 'CR', 'Comedie-Romantique', 'F');

-- --------------------------------------------------------

--
-- Structure de la table `jouer`
--

CREATE TABLE `jouer` (
  `ID_artiste` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_ACTEUR` decimal(2,0) DEFAULT NULL,
  `VOIX` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `journaliste`
--

CREATE TABLE `journaliste` (
  `ID_journaliste` int(11) NOT NULL,
  `ID_media` int(11) NOT NULL,
  `NOM_journaliste` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE `media` (
  `ID_media` int(11) NOT NULL,
  `NOM_media` varchar(254) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`ID_media`, `NOM_media`) VALUES
(3, 'Canal+'),
(2, 'France info'),
(1, 'France inter'),
(4, 'Pariscope');

-- --------------------------------------------------------

--
-- Structure de la table `pays`
--

CREATE TABLE `pays` (
  `ID_pays` int(11) NOT NULL,
  `NOM_pays` varchar(50) NOT NULL,
  `MASCULIN` varchar(50) NOT NULL,
  `FEMININ` varchar(50) NOT NULL,
  `NEUTRE` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contenu de la table `pays`
--

INSERT INTO `pays` (`ID_pays`, `NOM_pays`, `MASCULIN`, `FEMININ`, `NEUTRE`) VALUES
(86, 'France', 'Français', 'Françaises', 'Franco'),
(87, 'Suisse', 'Suisse', 'Suisse', 'Suisse'),
(89, 'Japon', 'Japonais', 'japonaise', 'Japono'),
(90, 'chine', 'chinois', 'chinoise', 'chino'),
(91, 'Taiwan', 'Taiwanais', 'Taiwanaise', 'Taiwano');

-- --------------------------------------------------------

--
-- Structure de la table `produire`
--

CREATE TABLE `produire` (
  `ID_pays` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_PRODUCTION` decimal(2,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `projeter`
--

CREATE TABLE `projeter` (
  `ID_film` int(11) NOT NULL,
  `ID_salle` int(11) NOT NULL,
  `VERSION_PROJECTION` char(2) DEFAULT NULL,
  `HORAIRES_PROJECTION` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `realiser`
--

CREATE TABLE `realiser` (
  `ID_artiste` int(11) NOT NULL,
  `ID_film` int(11) NOT NULL,
  `RANG_REALISATEUR` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `rubrique`
--

CREATE TABLE `rubrique` (
  `ID_rubrique` int(11) NOT NULL,
  `CODE_rubrique` char(2) NOT NULL,
  `INTITULE_rubrique` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `ID_salle` int(11) NOT NULL,
  `ID_cinema` int(11) NOT NULL,
  `ID_festival` int(11) DEFAULT NULL,
  `NOM_salle` varchar(50) DEFAULT NULL,
  `DESCRIPTION_salle` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `situer_metro`
--

CREATE TABLE `situer_metro` (
  `ID_cinema` int(11) NOT NULL,
  `ID_station_metro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `station_metro`
--

CREATE TABLE `station_metro` (
  `ID_station_metro` int(11) NOT NULL,
  `NOM_station_metro` varchar(254) DEFAULT NULL,
  `lat` double DEFAULT NULL,
  `lng` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `pseudo` varchar(45) NOT NULL,
  `mdp` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ville`
--

CREATE TABLE `ville` (
  `ID_ville` int(11) NOT NULL,
  `ID_departement` int(11) NOT NULL,
  `CP` char(5) NOT NULL,
  `NOM_ville` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la vue `cinemas_paris`
--
DROP TABLE IF EXISTS `cinemas_paris`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cinemas_paris`  AS  select 1 AS `ID_cinema`,1 AS `ID_ville`,1 AS `ID_arrondissement`,1 AS `CODE_cinema`,1 AS `NOM_cinema`,1 AS `ADRESSE_cinema`,1 AS `TELEPHONE_cinema`,1 AS `TARIFS_cinema`,1 AS `DIVERS_cinema`,1 AS `RESEAU_cinema`,1 AS `ACCES_HANDICAPES` ;

-- --------------------------------------------------------

--
-- Structure de la vue `cinemas_peripherie`
--
DROP TABLE IF EXISTS `cinemas_peripherie`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `cinemas_peripherie`  AS  select 1 AS `ID_cinema`,1 AS `ID_ville`,1 AS `ID_arrondissement`,1 AS `CODE_cinema`,1 AS `NOM_cinema`,1 AS `ADRESSE_cinema`,1 AS `TELEPHONE_cinema`,1 AS `TARIFS_cinema`,1 AS `DIVERS_cinema`,1 AS `RESEAU_cinema`,1 AS `ACCES_HANDICAPES` ;

-- --------------------------------------------------------

--
-- Structure de la vue `films_autres`
--
DROP TABLE IF EXISTS `films_autres`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `films_autres`  AS  select 1 AS `ID_film`,1 AS `ID_genre`,1 AS `TITRE_film`,1 AS `TITRE_ORIGINAL`,1 AS `TOTAL_ENTREES`,1 AS `DATE_SORTIE`,1 AS `ENTREES_SEMAINE`,1 AS `NOMBRE_SEMAINES`,1 AS `ANNEE`,1 AS `DUREE`,1 AS `CONDENSE`,1 AS `COULEURS`,1 AS `INTERDICTION_film`,1 AS `PUBLIC_film` ;

-- --------------------------------------------------------

--
-- Structure de la vue `films_nouveaux`
--
DROP TABLE IF EXISTS `films_nouveaux`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `films_nouveaux`  AS  select 1 AS `ID_film`,1 AS `ID_genre`,1 AS `TITRE_film`,1 AS `TITRE_ORIGINAL`,1 AS `TOTAL_ENTREES`,1 AS `DATE_SORTIE`,1 AS `ENTREES_SEMAINE`,1 AS `NOMBRE_SEMAINES`,1 AS `ANNEE`,1 AS `DUREE`,1 AS `CONDENSE`,1 AS `COULEURS`,1 AS `INTERDICTION_film`,1 AS `PUBLIC_film` ;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `appreciation`
--
ALTER TABLE `appreciation`
  ADD PRIMARY KEY (`ID_appreciation`),
  ADD UNIQUE KEY `Index_etoile_unique` (`ETOILE`),
  ADD UNIQUE KEY `Index_appreciation_unique` (`LIBELLE_appreciation`);

--
-- Index pour la table `apprecier`
--
ALTER TABLE `apprecier`
  ADD PRIMARY KEY (`ID_media`,`ID_film`),
  ADD KEY `FK_appreciationapprecier` (`ID_appreciation`),
  ADD KEY `FK_mediaapprecier_film` (`ID_film`);

--
-- Index pour la table `arrondissement`
--
ALTER TABLE `arrondissement`
  ADD PRIMARY KEY (`ID_arrondissement`),
  ADD UNIQUE KEY `Index_code_arrond_unique` (`CODE_arrondissement`),
  ADD UNIQUE KEY `Index_arrond_nom_unique` (`NOM_arrondissement`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ID_article`),
  ADD KEY `FK_filmarticle` (`ID_film`),
  ADD KEY `FK_journalistearticle` (`ID_journaliste`);

--
-- Index pour la table `artiste`
--
ALTER TABLE `artiste`
  ADD PRIMARY KEY (`ID_artiste`);

--
-- Index pour la table `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`ID_cinema`),
  ADD UNIQUE KEY `CODE_cinema` (`CODE_cinema`),
  ADD KEY `FK_cinemaarrondissement` (`ID_arrondissement`),
  ADD KEY `FK_cinemaville` (`ID_ville`);

--
-- Index pour la table `departement`
--
ALTER TABLE `departement`
  ADD PRIMARY KEY (`ID_departement`),
  ADD UNIQUE KEY `Index_code_departement_unique` (`CODE_departement`),
  ADD UNIQUE KEY `Index_nom_departement_unique` (`NOM_departement`);

--
-- Index pour la table `festival`
--
ALTER TABLE `festival`
  ADD PRIMARY KEY (`ID_festival`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`ID_film`),
  ADD KEY `FK_filmgenre` (`ID_genre`);

--
-- Index pour la table `film_festival`
--
ALTER TABLE `film_festival`
  ADD PRIMARY KEY (`ID_film`,`ID_festival`),
  ADD KEY `FK_filmfestival_festival` (`ID_festival`);

--
-- Index pour la table `film_rubrique`
--
ALTER TABLE `film_rubrique`
  ADD PRIMARY KEY (`id_film`,`id_rubrique`),
  ADD KEY `id_rubrique` (`id_rubrique`);

--
-- Index pour la table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`ID_genre`),
  ADD UNIQUE KEY `Index_code_genre_unique` (`CODE_genre`),
  ADD UNIQUE KEY `Index_libelle_genre_unique` (`LIBELLE_genre`);

--
-- Index pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD PRIMARY KEY (`ID_artiste`,`ID_film`),
  ADD KEY `FK_film_ACTEUR` (`ID_film`);

--
-- Index pour la table `journaliste`
--
ALTER TABLE `journaliste`
  ADD PRIMARY KEY (`ID_journaliste`),
  ADD UNIQUE KEY `Index_nom_journaliste_unique` (`NOM_journaliste`),
  ADD KEY `FK_journalistemedia` (`ID_media`);

--
-- Index pour la table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`ID_media`),
  ADD UNIQUE KEY `Index_media_unique` (`NOM_media`);

--
-- Index pour la table `pays`
--
ALTER TABLE `pays`
  ADD PRIMARY KEY (`ID_pays`),
  ADD UNIQUE KEY `Index_pays_unique` (`NOM_pays`),
  ADD UNIQUE KEY `Index_pays_masculin_unique` (`MASCULIN`),
  ADD UNIQUE KEY `Index_pays_feminin_unique` (`FEMININ`),
  ADD UNIQUE KEY `Index_pays_neutre_unique` (`NEUTRE`);

--
-- Index pour la table `produire`
--
ALTER TABLE `produire`
  ADD PRIMARY KEY (`ID_pays`,`ID_film`),
  ADD KEY `FK_produire_film` (`ID_film`);

--
-- Index pour la table `projeter`
--
ALTER TABLE `projeter`
  ADD PRIMARY KEY (`ID_film`,`ID_salle`),
  ADD KEY `FK_projeter_salle` (`ID_salle`);

--
-- Index pour la table `realiser`
--
ALTER TABLE `realiser`
  ADD PRIMARY KEY (`ID_artiste`,`ID_film`),
  ADD KEY `FK_realiser_film` (`ID_film`);

--
-- Index pour la table `rubrique`
--
ALTER TABLE `rubrique`
  ADD PRIMARY KEY (`ID_rubrique`),
  ADD UNIQUE KEY `Index_code_rubrique_unique` (`CODE_rubrique`),
  ADD UNIQUE KEY `Index_intitule_rubrique_unique` (`INTITULE_rubrique`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`ID_salle`),
  ADD KEY `FK_sallecinema` (`ID_cinema`),
  ADD KEY `FK_sallefestival_festival` (`ID_festival`);

--
-- Index pour la table `situer_metro`
--
ALTER TABLE `situer_metro`
  ADD PRIMARY KEY (`ID_cinema`,`ID_station_metro`),
  ADD KEY `FK_SITUERMETRO_metro` (`ID_station_metro`);

--
-- Index pour la table `station_metro`
--
ALTER TABLE `station_metro`
  ADD PRIMARY KEY (`ID_station_metro`),
  ADD UNIQUE KEY `Index_nom_station_unique` (`NOM_station_metro`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`pseudo`);

--
-- Index pour la table `ville`
--
ALTER TABLE `ville`
  ADD PRIMARY KEY (`ID_ville`),
  ADD KEY `FK_villedepartement` (`ID_departement`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `appreciation`
--
ALTER TABLE `appreciation`
  MODIFY `ID_appreciation` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `arrondissement`
--
ALTER TABLE `arrondissement`
  MODIFY `ID_arrondissement` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `ID_article` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `artiste`
--
ALTER TABLE `artiste`
  MODIFY `ID_artiste` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `cinema`
--
ALTER TABLE `cinema`
  MODIFY `ID_cinema` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `departement`
--
ALTER TABLE `departement`
  MODIFY `ID_departement` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT pour la table `festival`
--
ALTER TABLE `festival`
  MODIFY `ID_festival` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `ID_film` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `genre`
--
ALTER TABLE `genre`
  MODIFY `ID_genre` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `journaliste`
--
ALTER TABLE `journaliste`
  MODIFY `ID_journaliste` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
  MODIFY `ID_media` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `pays`
--
ALTER TABLE `pays`
  MODIFY `ID_pays` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;
--
-- AUTO_INCREMENT pour la table `rubrique`
--
ALTER TABLE `rubrique`
  MODIFY `ID_rubrique` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `ID_salle` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `station_metro`
--
ALTER TABLE `station_metro`
  MODIFY `ID_station_metro` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `ville`
--
ALTER TABLE `ville`
  MODIFY `ID_ville` int(11) NOT NULL AUTO_INCREMENT;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `apprecier`
--
ALTER TABLE `apprecier`
  ADD CONSTRAINT `FK_appreciationapprecier` FOREIGN KEY (`ID_appreciation`) REFERENCES `appreciation` (`ID_appreciation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_mediaapprecier_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_mediaapprecier_media` FOREIGN KEY (`ID_media`) REFERENCES `media` (`ID_media`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK_filmarticle` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_journalistearticle` FOREIGN KEY (`ID_journaliste`) REFERENCES `journaliste` (`ID_journaliste`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `cinema`
--
ALTER TABLE `cinema`
  ADD CONSTRAINT `FK_cinemaarrondissement` FOREIGN KEY (`ID_arrondissement`) REFERENCES `arrondissement` (`ID_arrondissement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_cinemaville` FOREIGN KEY (`ID_ville`) REFERENCES `ville` (`ID_ville`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FK_filmgenre` FOREIGN KEY (`ID_genre`) REFERENCES `genre` (`ID_genre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `film_festival`
--
ALTER TABLE `film_festival`
  ADD CONSTRAINT `FK_filmfestival_festival` FOREIGN KEY (`ID_festival`) REFERENCES `festival` (`ID_festival`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_filmfestival_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `film_rubrique`
--
ALTER TABLE `film_rubrique`
  ADD CONSTRAINT `film_rubrique_ibfk_1` FOREIGN KEY (`id_film`) REFERENCES `film` (`ID_film`),
  ADD CONSTRAINT `film_rubrique_ibfk_2` FOREIGN KEY (`id_rubrique`) REFERENCES `rubrique` (`ID_rubrique`);

--
-- Contraintes pour la table `jouer`
--
ALTER TABLE `jouer`
  ADD CONSTRAINT `FK_ACTEUR` FOREIGN KEY (`ID_artiste`) REFERENCES `artiste` (`ID_artiste`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_film_ACTEUR` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `journaliste`
--
ALTER TABLE `journaliste`
  ADD CONSTRAINT `FK_journalistemedia` FOREIGN KEY (`ID_media`) REFERENCES `media` (`ID_media`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `produire`
--
ALTER TABLE `produire`
  ADD CONSTRAINT `FK_produire_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_produire_pays` FOREIGN KEY (`ID_pays`) REFERENCES `pays` (`ID_pays`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `projeter`
--
ALTER TABLE `projeter`
  ADD CONSTRAINT `FK_projeter_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_projeter_salle` FOREIGN KEY (`ID_salle`) REFERENCES `salle` (`ID_salle`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `realiser`
--
ALTER TABLE `realiser`
  ADD CONSTRAINT `FK_realiser_artiste` FOREIGN KEY (`ID_artiste`) REFERENCES `artiste` (`ID_artiste`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_realiser_film` FOREIGN KEY (`ID_film`) REFERENCES `film` (`ID_film`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `FK_sallecinema` FOREIGN KEY (`ID_cinema`) REFERENCES `cinema` (`ID_cinema`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `situer_metro`
--
ALTER TABLE `situer_metro`
  ADD CONSTRAINT `FK_SITUERMETRO_cinema` FOREIGN KEY (`ID_cinema`) REFERENCES `cinema` (`ID_cinema`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_SITUERMETRO_metro` FOREIGN KEY (`ID_station_metro`) REFERENCES `station_metro` (`ID_station_metro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `ville`
--
ALTER TABLE `ville`
  ADD CONSTRAINT `FK_villedepartement` FOREIGN KEY (`ID_departement`) REFERENCES `departement` (`ID_departement`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
