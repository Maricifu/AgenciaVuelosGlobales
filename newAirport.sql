CREATE TABLE `customers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `age` INT,
  `id_document` INT
);

CREATE TABLE `documenttypes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL
);

CREATE TABLE `employees` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(40) NOT NULL,
  `role_id` INT,
  `hire_date` DATE,
  `airline_id` INT,
  `airport_id` INT
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
  `city_id` INT
);

CREATE TABLE `cities` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `country_id` INT
);

CREATE TABLE `countries` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL
);

CREATE TABLE `planes` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `plates` VARCHAR(30) NOT NULL,
  `capacity` INT NOT NULL,
  `fabrication_date` DATE,
  `status_id` INT,
  `model_id` INT,
  `airline_id` INT
);

CREATE TABLE `models` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `manufacturer_id` INT
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
  `plane_id` INT,
  `description` TEXT,
  `employee_id` INT
);

CREATE TABLE `trips` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `flight_number` VARCHAR(10) NOT NULL,
  `date` DATE NOT NULL,
  `origin_airport_id` VARCHAR(5),
  `destination_airport_id` VARCHAR(5),
  `price` DOUBLE NOT NULL,
  `plane_id` INT
);

CREATE TABLE `trip_bookings` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `date` DATE NOT NULL,
  `trip_id` INT,
  `customer_id` INT
);

CREATE TABLE `tripcrew` (
  `trip_id` INT,
  `employee_id` INT,
  PRIMARY KEY (`trip_id`, `employee_id`)
);

CREATE TABLE `trip_layovers` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `trip_id` INT,
  `layover_airport_id` VARCHAR(5),
  `layover_flight_number` VARCHAR(10) NOT NULL
);

ALTER TABLE `customers` ADD FOREIGN KEY (`id_document`) REFERENCES `documenttypes` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`id`);

ALTER TABLE `employees` ADD FOREIGN KEY (`airport_id`) REFERENCES `airports` (`id`);

ALTER TABLE `airports` ADD FOREIGN KEY (`city_id`) REFERENCES `cities` (`id`);

ALTER TABLE `cities` ADD FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`status_id`) REFERENCES `statuses` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`model_id`) REFERENCES `models` (`id`);

ALTER TABLE `planes` ADD FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`id`);

ALTER TABLE `models` ADD FOREIGN KEY (`manufacturer_id`) REFERENCES `manufacturers` (`id`);

ALTER TABLE `revisions` ADD FOREIGN KEY (`plane_id`) REFERENCES `planes` (`id`);

ALTER TABLE `revisions` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`origin_airport_id`) REFERENCES `airports` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`destination_airport_id`) REFERENCES `airports` (`id`);

ALTER TABLE `trips` ADD FOREIGN KEY (`plane_id`) REFERENCES `planes` (`id`);

ALTER TABLE `trip_bookings` ADD FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`);

ALTER TABLE `trip_bookings` ADD FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`);

ALTER TABLE `tripcrew` ADD FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`);

ALTER TABLE `tripcrew` ADD FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

ALTER TABLE `trip_layovers` ADD FOREIGN KEY (`trip_id`) REFERENCES `trips` (`id`);

ALTER TABLE `trip_layovers` ADD FOREIGN KEY (`layover_airport_id`) REFERENCES `airports` (`id`);
