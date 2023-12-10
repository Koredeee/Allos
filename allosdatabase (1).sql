
CREATE DATABASE IF NOT EXISTS `allosdatabase`;
USE `allosdatabase`;

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `IngredientId` int(11) NOT NULL AUTO_INCREMENT,
  `IngredientName` varchar(255) NOT NULL,
  PRIMARY KEY (`IngredientId`)
);

DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `ProductId` int(11) NOT NULL AUTO_INCREMENT,
  `ProductName` varchar(255) NOT NULL,
  `ProductImage` varchar(255) NOT NULL,
  `BarcodeImage` varchar(255) NOT NULL,
  PRIMARY KEY (`ProductId`)
);

DROP TABLE IF EXISTS `productdetail`;
CREATE TABLE IF NOT EXISTS `productdetail` (
  `ProductId` int(11) NOT NULL,
  `IngredientId` int(11) NOT NULL,
  KEY `ProductId` (`ProductId`),
  KEY `IngredientId` (`IngredientId`)
);

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(255) NOT NULL,
  `UserPassword` varchar(255) NOT NULL,
  `UserEmail` varchar(255) NOT NULL,
  `UserImage` varchar(255) DEFAULT 'stock.jpg',
  PRIMARY KEY (`UserId`)
);

DROP TABLE IF EXISTS `userallergen`;
CREATE TABLE IF NOT EXISTS `userallergen` (
  `UserId` int(11) NOT NULL,
  `IngredientId` int(11) NOT NULL,
  KEY `UserId` (`UserId`),
  KEY `IngredientId` (`IngredientId`)
);

ALTER TABLE `productdetail`
  ADD CONSTRAINT `productdetail_ibfk_1` FOREIGN KEY (`ProductId`) REFERENCES `product` (`ProductId`) ON DELETE CASCADE,
  ADD CONSTRAINT `productdetail_ibfk_2` FOREIGN KEY (`IngredientId`) REFERENCES `ingredient` (`IngredientId`) ON DELETE CASCADE;

ALTER TABLE `userallergen`
  ADD CONSTRAINT `userallergen_ibfk_1` FOREIGN KEY (`UserId`) REFERENCES `user` (`UserId`) ON DELETE CASCADE,
  ADD CONSTRAINT `userallergen_ibfk_2` FOREIGN KEY (`IngredientId`) REFERENCES `ingredient` (`IngredientId`) ON DELETE CASCADE;
COMMIT;
