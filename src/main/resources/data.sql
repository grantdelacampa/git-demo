/* ---------------------------------------------------------------------------------------------------------------------------------------------- 
    Configure tables
----------------------------------------------------------------------------------------------------------------------------------------------*/

CREATE TABLE IF NOT EXISTS roles (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS users (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `enabled` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS users_roles (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `user_fk_idx` (`user_id`),
  KEY `role_fk_idx` (`role_id`),
  CONSTRAINT `role_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS asset (
  `asset_id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NULL,
  `name` varchar(20) NOT NULL,
  `installDate` date NULL,
  `price` decimal(6,2) NULL,
  `purchaseDate` date NULL,
  `quantity` int NULL,
  `serialNumber` varchar(30) NULL,
  `sku` varchar(25) NULL, 
  `assetType` ENUM('Digital', 'Physical', 'External'),
  `status` ENUM('Purchased', 'Shipped', 'Installed', 'Registered', 'Obsolete'),
  /*
  `ownerId` varchar(25) NOT NULL,*/

  PRIMARY KEY(`asset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/* ---------------------------------------------------------------------------------------------------------------------------------------------- 
    Configure roles
----------------------------------------------------------------------------------------------------------------------------------------------*/
DELETE FROM roles;

INSERT INTO roles (name) VALUES ('USER');     -- auto numbers to 1
INSERT INTO roles (name) VALUES ('CREATOR');  -- auto numbers to 2
INSERT INTO roles (name) VALUES ('EDITOR');   -- auto numbers to 3
INSERT INTO roles (name) VALUES ('ADMIN');    -- auto numbers to 4

/* ---------------------------------------------------------------------------------------------------------------------------------------------- 
    Configure users
----------------------------------------------------------------------------------------------------------------------------------------------*/
-- Please note the passwords are encoded in BCrypt format (using default 10 rounds) and are the same as the usernames
DELETE FROM users;

INSERT INTO users (username, password, enabled) VALUES ('user', '$2a$10$LmoQpntTQx8EUGZrzaoddu4.2n9AVILShNGNWFGkzhR6mBLhdEPLm', '1');           -- user 1 
INSERT INTO users (username, password, enabled) VALUES ('creator', '$2a$10$R3M4n97Picjqrx/aVVVprelsFzEE9kGBS/Pw0WYAozqPiU1cUHpP6', '1');        -- user 2
INSERT INTO users (username, password, enabled) VALUES ('editor', '$2a$10$87FxFUSgID2kPyVMiqNdcuk31DAtw/G3l3tD6nAP9C0egD1vQ8R9i', '1');         -- user 3
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$0hEik.6j6X865afquVWLoOVF.kuFuZkPHS26kUR/8eY4fA2PI1pEK', '1');          -- user 4

/* ---------------------------------------------------------------------------------------------------------------------------------------------- 
    Configure user roles
----------------------------------------------------------------------------------------------------------------------------------------------*/

DELETE FROM users_roles;

INSERT INTO users_roles (user_id, role_id) VALUES (1,1);
INSERT INTO users_roles (user_id, role_id) VALUES (2,2);
INSERT INTO users_roles (user_id, role_id) VALUES (3,3);
INSERT INTO users_roles (user_id, role_id) VALUES (4,4);