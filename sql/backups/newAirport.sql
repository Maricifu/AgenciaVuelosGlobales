USE railway;

-- Borrar todas las tablas
/*
SET FOREIGN_KEY_CHECKS = 0;

-- Obtén todas las tablas en la base de datos seleccionada
SET @tables = NULL;
SELECT GROUP_CONCAT('`', table_name, '`') INTO @tables
FROM information_schema.tables
WHERE table_schema = (SELECT DATABASE());

-- Prepara el comando para eliminar todas las tablas
SET @tables = CONCAT('DROP TABLE IF EXISTS ', @tables);
PREPARE stmt FROM @tables;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;

SET FOREIGN_KEY_CHECKS = 1;
*/
CREATE TABLE `customers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `age` INT,
  `idDocument` INT
);

CREATE TABLE `documentTypes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL
);

CREATE TABLE `employees` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `roleId` INT,
  `hireDate` DATE,
  `airlineId` INT,
  `airportId` VARCHAR(5)
);

CREATE TABLE `roles` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL
);

CREATE TABLE `airlines` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `airports` (
  `id` VARCHAR(5) PRIMARY KEY,
  `name` VARCHAR(50) NOT NULL,
  `cityId` INT
);

CREATE TABLE `cities` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `countryId` INT
);

CREATE TABLE `countries` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `planes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `plates` VARCHAR(30) NOT NULL,
  `capacity` INT NOT NULL,
  `fabricationDate` DATE,
  `statusId` INT,
  `modelId` INT,
  `airlineId` INT
);

CREATE TABLE `models` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `manufacturerId` INT
);

CREATE TABLE `manufacturers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL
);

CREATE TABLE `statuses` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `revisions` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `date` DATE,
  `planeId` INT,
  `description` TEXT,
  `employeeId` INT
);

CREATE TABLE `trips` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `flightNumber` VARCHAR(10) NOT NULL,
  `date` DATE NOT NULL,
  `originAirportId` VARCHAR(5),
  `destinationAirportId` VARCHAR(5),
  `price` DOUBLE NOT NULL,
  `planeId` INT
);

CREATE TABLE `tripBookings` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `tripId` INT,
  `customerId` INT
);

CREATE TABLE `tripCrew` (
  `trip_id` INT,
  `employee_id` INT,
  PRIMARY KEY (`trip_id`, `employee_id`)
);

CREATE TABLE `tripLayovers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `tripId` INT,
  `layoverAirportId` VARCHAR(5),
  `layoverFlightNumber` VARCHAR(10) NOT NULL
);

ALTER TABLE `customers` ADD FOREIGN KEY (`idDocument`) REFERENCES `documentTypes` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`airlineId`) REFERENCES `airlines` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`airportId`) REFERENCES `airports` (`id`);

ALTER TABLE `airports` ADD FOREIGN KEY (`cityId`) REFERENCES `cities` (`id`);

ALTER TABLE `cities` ADD FOREIGN KEY (`countryId`) REFERENCES `countries` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`statusId`) REFERENCES `statuses` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`modelId`) REFERENCES `models` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`airlineId`) REFERENCES `airlines` (`id`);

ALTER TABLE `models` ADD FOREIGN KEY (`manufacturerId`) REFERENCES `manufacturers` (`id`);

ALTER TABLE `revisions` ADD FOREIGN KEY (`planeId`) REFERENCES `planes` (`id`);

ALTER TABLE `revisions` ADD FOREIGN KEY (`employeeId`) REFERENCES `employees` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`originAirportId`) REFERENCES `airports` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`destinationAirportId`) REFERENCES `airports` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`planeId`) REFERENCES `planes` (`id`);

ALTER TABLE `tripBookings` ADD FOREIGN KEY (`tripId`) REFERENCES `trips` (`id`);

ALTER TABLE `tripBookings` ADD FOREIGN KEY (`customerId`) REFERENCES `customers` (`id`);

ALTER TABLE `tripCrew` ADD FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`);

ALTER TABLE `tripCrew` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

ALTER TABLE `tripLayovers` ADD FOREIGN KEY (`tripId`) REFERENCES `trips` (`id`);

ALTER TABLE `tripLayovers` ADD FOREIGN KEY (`layoverAirportId`) REFERENCES `airports` (`id`);
