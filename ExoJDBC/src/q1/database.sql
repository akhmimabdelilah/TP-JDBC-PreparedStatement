--
-- Structure de la table `DevData`
--

CREATE TABLE `DevData` (
  `Developpeur` VARCHAR(32),
  `Jour` CHAR(11),
  `NbScripts` INTEGER
);

--
-- Déchargement des données de la table `DevData`
--

INSERT INTO `DevData` VALUES('ALAMI', 'Lundi', 1);
INSERT INTO `DevData` VALUES('WAFI', 'Mardi', 2);
INSERT INTO `DevData` VALUES('SLAMI', 'Jeudi', 3);

