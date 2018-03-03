USE test;

DROP TABLE IF EXISTS `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `Id`       INT(11)      NOT NULL AUTO_INCREMENT,
  `Name`     VARCHAR(100) NOT NULL,
  `Age`      INT(11)      NOT NULL,
  `Gender`   VARCHAR(10)  NOT NULL,
  `Birthday` DATETIME     NOT NULL,
  PRIMARY KEY (`Id`)
)
  ENGINE = INNODB;