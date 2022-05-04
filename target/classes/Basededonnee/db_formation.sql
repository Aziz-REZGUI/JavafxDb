-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 04 mai 2022 à 19:23
-- Version du serveur : 10.4.24-MariaDB
-- Version de PHP : 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_formation`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `code_admin` int(11) NOT NULL,
  `login` varchar(10) NOT NULL,
  `password` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `domaine`
--

CREATE TABLE `domaine` (
  `code_domaine` int(11) NOT NULL,
  `Libelle` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `formateur`
--

CREATE TABLE `formateur` (
  `Code_formateur` int(11) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `Prenom` varchar(10) NOT NULL,
  `Email` varchar(30) NOT NULL,
  `N_tel` int(11) NOT NULL,
  `Code_organisme` int(11) NOT NULL,
  `code_domaine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `formation`
--

CREATE TABLE `formation` (
  `code_formation` int(4) NOT NULL,
  `intitule` varchar(20) NOT NULL,
  `nombre_jour` smallint(6) NOT NULL,
  `annee` int(11) NOT NULL,
  `mois` int(11) NOT NULL,
  `nombre_participant` int(11) NOT NULL,
  `Code_formateur` int(11) NOT NULL,
  `code_domaine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `organisme`
--

CREATE TABLE `organisme` (
  `Code_organisme` int(11) NOT NULL,
  `Libelle` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

CREATE TABLE `participant` (
  `Matricule` int(11) NOT NULL,
  `Nom` varchar(10) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `date_naissance` date NOT NULL,
  `Code_profil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

CREATE TABLE `participation` (
  `Matricule` int(11) NOT NULL,
  `code_formation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

CREATE TABLE `profil` (
  `Code_profil` int(11) NOT NULL,
  `Libelle` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `code_utilisateur` int(11) NOT NULL,
  `full_name` varchar(30) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `role` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`code_utilisateur`, `full_name`, `login`, `password`, `role`) VALUES
(1, 'test', 'adz', 'daed', 'User'),
(2, '', 'aziz', 'aziz', 'admin'),
(3, 'test', 'fdf', 'fdgdb', 'User'),
(4, 'edzdaad', 'azdadz', 'dazd', 'user'),
(5, 'test', 'abir', 'azazd', 'utilisateur '),
(7, 'test', 'aziz', 'akiiizdaxs', 'utilisateur'),
(8, 'test', 'aziz', 'rezgui', 'User');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`code_admin`);

--
-- Index pour la table `domaine`
--
ALTER TABLE `domaine`
  ADD PRIMARY KEY (`code_domaine`);

--
-- Index pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`Code_formateur`),
  ADD KEY `Code_organisme` (`Code_organisme`),
  ADD KEY `code_domaine` (`code_domaine`);

--
-- Index pour la table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`code_formation`),
  ADD KEY `fk_domaine` (`code_domaine`),
  ADD KEY `fk_formateur` (`Code_formateur`);

--
-- Index pour la table `organisme`
--
ALTER TABLE `organisme`
  ADD PRIMARY KEY (`Code_organisme`);

--
-- Index pour la table `participant`
--
ALTER TABLE `participant`
  ADD PRIMARY KEY (`Matricule`),
  ADD KEY `fk_prfl` (`Code_profil`);

--
-- Index pour la table `participation`
--
ALTER TABLE `participation`
  ADD PRIMARY KEY (`Matricule`,`code_formation`),
  ADD KEY `participation_ibfk_1` (`code_formation`);

--
-- Index pour la table `profil`
--
ALTER TABLE `profil`
  ADD PRIMARY KEY (`Code_profil`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`code_utilisateur`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `code_admin` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `domaine`
--
ALTER TABLE `domaine`
  MODIFY `code_domaine` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `code_utilisateur` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `formateur`
--
ALTER TABLE `formateur`
  ADD CONSTRAINT `Code_organisme` FOREIGN KEY (`Code_organisme`) REFERENCES `organisme` (`Code_organisme`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `code_domaine` FOREIGN KEY (`code_domaine`) REFERENCES `domaine` (`code_domaine`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `formation`
--
ALTER TABLE `formation`
  ADD CONSTRAINT `fk_domaine` FOREIGN KEY (`code_domaine`) REFERENCES `domaine` (`code_domaine`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_formateur` FOREIGN KEY (`Code_formateur`) REFERENCES `formateur` (`Code_formateur`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participant`
--
ALTER TABLE `participant`
  ADD CONSTRAINT `fk_prfl` FOREIGN KEY (`Code_profil`) REFERENCES `profil` (`Code_profil`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`code_formation`) REFERENCES `formation` (`code_formation`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`Matricule`) REFERENCES `participant` (`Matricule`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
