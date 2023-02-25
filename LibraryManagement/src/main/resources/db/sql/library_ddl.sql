CREATE TABLE if NOT EXISTS`admin` (
  `id` int NOT NULL,
  `adminName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contactNo` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `status` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if NOT EXISTS `book` (
 `id` int NOT NULL,
 `bookName` varchar(45) NOT NULL,
 `author` varchar(45) NOT NULL,
 `edition` varchar(45) NOT NULL,
 `serialNo` varchar(45) NOT NULL,
 `category` varchar(45) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if NOT EXISTS `issue` (
 `id` int NOT NULL,
 `bookId` int NOT NULL,
 `studentId` int NOT NULL,
 `issueDate` bigint NOT NULL,
 `dueDate` bigint NOT NULL,
 `returnDate` bigint DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `bookId_idx` (`bookId`),
 KEY `studentId_idx` (`studentId`),
 CONSTRAINT `bookId` FOREIGN KEY (`bookId`) REFERENCES `book` (`id`),
 CONSTRAINT `studentId` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE if NOT EXISTS `student` (
 `id` int NOT NULL,
 `studentName` varchar(45) NOT NULL,
 `emailId` varchar(45) NOT NULL,
 `password` varchar(45) NOT NULL,
 `year` varchar(45) NOT NULL,
 `department` varchar(45) NOT NULL,
 `status` varchar(50) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;