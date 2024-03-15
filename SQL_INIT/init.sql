-- création de la base de donnée pour l'api des événements
CREATE DATABASE IF NOT EXISTS db_api_evenement;

USE db_api_evenement;

-- création table Membre
create table if not EXISTS `T_membre_MBR` (
    `MBR_id` int(1) NOT NULL,
    `MBR_nom` varchar(16),
    `MBR_prenom` varchar(16),
    `MBR_dateNaissance` datetime NOT NULL,
    `MBR_mdp` varchar(256) NOT NULL,
    `MBR_email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- création table Évènements
create table if not EXISTS `T_evenement_EVT` (
    `EVT_id` int(1) NOT NULL,
    `EVT_nom` varchar(100) NOT NULL,
    `EVT_duree` int(1) NOT NULL,
    `EVT_max` int(1) NOT NULL,
    `LIEU_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- création table Commentaires
create table if not EXISTS `T_commentaires_COM`(
    `COM_message` varchar(256) NOT NULL,
    `COM_id` int(1) NOT NULL,
    `MBR_id` int(1) NOT NULL,
    `EVT_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- création table Lieu
create table if not EXISTS `T_lieu_LIE` (
    `LIEU_id` int(1) NOT NULL,
    `LIEU_nom` varchar(50) NOT NULL,
    `LIEU_adresse` varchar(100) NOT NULL,
    `LIEU_capacite` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- création table jointure entre Membre et Évènement
-- table Inscription
create table if not exists `TJ_inscription_INS` (
    `MBR_id` int(1) NOT NULL,
    `EVT_id` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-------------------------------------------

-- contraintes sur la table Membre
alter table `T_membre_MBR`
    add primary key (`MBR_id`),
    modify `MBR_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1;

-- contraintes sur la table Évènements
alter table `T_evenement_EVT`
    add primary key (`EVT_id`),
    modify `EVT_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1;

-- contraintes sur la table Lieu
alter table `T_lieu_LIEU`
    add primary key (`LIEU_id`),
    modify `LIEU_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1;

-- référenciations de la clef étrangère LIEU_id dans Évènements
alter table `T_evenement_EVT`
    add constraint `fk_T_evenement_EVT_T_lieu_LIEU` foreign key (`LIEU_id`) references `T_lieu_LIEU` (`LIEU_id`) on delete no action on update no action;

-- containres sur la table Commentaires
alter table `T_commentaires_COM`
    add primary key (`COM_id`),
    modify `COM_id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT = 1;

-- référenciations des clefs étrangères MBR_id et EVT_id dans Commentaires
alter table `T_commentaires_COM`
    add constraint `fk_T_commentaires_COM_T_membre_MBR` foreign key (`MBR_id`) references `T_membre_MBR` (`MBR_id`) on delete no action on update no action,
    add constraint `fk_T_commentaires_COM_T_evenement_EVT` foreign key (`EVT_id`) references `T_evenement_EVT` (`EVT_id`) on delete no action on update no action;

-- contraintes sur la table de jointure Inscription
alter table `T_inscription`
    add primary key (`MBR_id`, `EVT_id`);

-- référenciations des clefs étrangères MBR_id et EVT_id dans Inscription
alter table `T_inscription`
    add constraint `fk_T_inscription_T_membre_MBR` foreign key (`MBR_id`) references `T_membre_MBR` (`MBR_id`) on delete no action on update no action,
    add constraint `fk_T_inscription_T_evenement_EVT` foreign key (`EVT_id`) references `T_evenement_EVT` (`EVT_id`) on delete no action on update no action;
