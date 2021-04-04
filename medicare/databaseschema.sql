create schema medicaredb;

CREATE TABLE `payment` (
  `paymentId` int(11) NOT NULL AUTO_INCREMENT,
  `medicineIdPurchasedList` varchar(200) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `dateOfPurchase` date DEFAULT NULL,
  PRIMARY KEY (`paymentId`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medicine` (
  `medicineId` int(11) NOT NULL AUTO_INCREMENT,
  `medicineName` varchar(200) NOT NULL,
  `medicineDescription` varchar(200) DEFAULT NULL,
  `medicinePrice` double DEFAULT NULL,
  `medicineSeller` varchar(45) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userRole` varchar(200) DEFAULT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`medicineId`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user_tb` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `userEmail` varchar(200) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userRole` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `medicaredb`.`user_tb`
(`username`,
`password`,
`userEmail`,
`userRole`)
VALUES
(
'admin',
'admin@123',
'abc@gmail.com',
'adminRole');


