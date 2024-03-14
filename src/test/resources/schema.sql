
DROP TABLE IF EXISTS `language`;

CREATE TABLE `language`
(
    `language_id` tinyint NOT NULL AUTO_INCREMENT,
    `name`        char(20)  NOT NULL,
    `last_update` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`language_id`)
);

