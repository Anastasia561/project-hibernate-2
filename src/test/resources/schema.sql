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
