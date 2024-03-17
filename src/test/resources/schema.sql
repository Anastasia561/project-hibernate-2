DROP TABLE IF EXISTS `actor`;

CREATE TABLE `actor`
(
    `actor_id`    smallint    NOT NULL AUTO_INCREMENT,
    `first_name`  varchar(45) NOT NULL,
    `last_name`   varchar(45) NOT NULL,
    `last_update` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`actor_id`)
);

DROP TABLE IF EXISTS `language`;

CREATE TABLE `language`
(
    `language_id` tinyint   NOT NULL AUTO_INCREMENT,
    `name`        char(20)  NOT NULL,
    `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`language_id`)
);

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category`
(
    `category_id` tinyint     NOT NULL AUTO_INCREMENT,
    `name`        varchar(25) NOT NULL,
    `last_update` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`category_id`)
);

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country`
(
    `country_id`  smallint    NOT NULL AUTO_INCREMENT,
    `country`     varchar(50) NOT NULL,
    `last_update` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`country_id`)
);

DROP TABLE IF EXISTS `city`;

CREATE TABLE `city`
(
    `city_id`     smallint    NOT NULL AUTO_INCREMENT,
    `city`        varchar(50) NOT NULL,
    `country_id`  smallint    NOT NULL,
    `last_update` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`city_id`),
    CONSTRAINT `fk_city_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`) ON DELETE RESTRICT ON UPDATE CASCADE
);
