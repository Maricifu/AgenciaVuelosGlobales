-- Insertar en documentTypes
INSERT INTO documentTypes (name) VALUES 
('Passport'), 
('Driver License'), 
('Identity Card'), 
('Residence Permit'), 
('Student ID'), 
('Work Permit'), 
('Health Card'), 
('Social Security Card'), 
('Birth Certificate'), 
('Voter ID');

-- Insertar en roles
INSERT INTO roles (name) VALUES 
('Pilot'), 
('Copilot'), 
('Flight Attendant'), 
('Ground Staff'), 
('Maintenance Technician'), 
('Air Traffic Controller'), 
('Security Officer'), 
('Customer Service Representative'), 
('Baggage Handler'), 
('Catering Staff');

-- Insertar en airlines
INSERT INTO airlines (name) VALUES 
('Airways International'), 
('Sky High Airlines'), 
('Global Fly'), 
('Sunrise Airlines'), 
('Oceanic Air'), 
('Eagle Aviation'), 
('Jet Speed'), 
('Star Airlines'), 
('Blue Sky Airlines'), 
('Horizon Wings');

-- Insertar en countries
INSERT INTO countries (name) VALUES 
('USA'), 
('Canada'), 
('Mexico'), 
('Brazil'), 
('UK'), 
('Germany'), 
('France'), 
('Japan'), 
('China'), 
('Australia');

-- Insertar en cities
INSERT INTO cities (name, countryId) VALUES 
('New York', 1), 
('Los Angeles', 1), 
('Toronto', 2), 
('Vancouver', 2), 
('Mexico City', 3), 
('Sao Paulo', 4), 
('London', 5), 
('Berlin', 6), 
('Paris', 7), 
('Tokyo', 8);

-- Insertar en airports
INSERT INTO airports (id, name, cityId) VALUES 
('JFK', 'John F. Kennedy International Airport', 1), 
('LAX', 'Los Angeles International Airport', 2), 
('YYZ', 'Toronto Pearson International Airport', 3), 
('YVR', 'Vancouver International Airport', 4), 
('MEX', 'Mexico City International Airport', 5), 
('GRU', 'Sao Paulo-Guarulhos International Airport', 6), 
('LHR', 'London Heathrow Airport', 7), 
('TXL', 'Berlin Tegel Airport', 8), 
('CDG', 'Charles de Gaulle Airport', 9), 
('NRT', 'Narita International Airport', 10);

-- Insertar en manufacturers
INSERT INTO manufacturers (name) VALUES 
('Boeing'), 
('Airbus'), 
('Embraer'), 
('Bombardier'), 
('Lockheed Martin'), 
('Cessna'), 
('Dassault Aviation'), 
('Gulfstream Aerospace'), 
('Mitsubishi Heavy Industries'), 
('Textron Aviation');

-- Insertar en models
INSERT INTO models (name, manufacturerId) VALUES 
('737', 1), 
('A320', 2), 
('E190', 3), 
('CRJ900', 4), 
('L-1011', 5), 
('Citation X', 6), 
('Falcon 900', 7), 
('G650', 8), 
('MRJ90', 9), 
('King Air', 10);

-- Insertar en statuses
INSERT INTO statuses (name) VALUES 
('Operational'), 
('Under Maintenance'), 
('Retired'), 
('In Service'), 
('Grounded'), 
('Stored'), 
('Scrapped'), 
('Leased'), 
('Sold'), 
('Testing');

-- Insertar en customers
INSERT INTO customers (name, age, idDocument) VALUES 
('John Doe', 30, 1), 
('Jane Smith', 28, 2), 
('Mike Johnson', 35, 3), 
('Emily Davis', 22, 4), 
('David Brown', 40, 5), 
('Sarah Wilson', 27, 6), 
('James Taylor', 33, 7), 
('Laura Moore', 29, 8), 
('Robert Anderson', 45, 9), 
('Linda Jackson', 31, 10);

-- Insertar en employees
INSERT INTO employees (name, roleId, hireDate, airlineId, airportId) VALUES 
('Alice Green', 1, '2015-06-15', 1, 'JFK'), 
('Bob White', 2, '2016-08-20', 2, 'LAX'), 
('Charlie Black', 3, '2017-09-10', 3, 'YYZ'), 
('Diana Blue', 4, '2018-12-05', 4, 'YVR'), 
('Ethan Gray', 5, '2019-11-03', 5, 'MEX'), 
('Fiona Red', 6, '2020-01-22', 6, 'GRU'), 
('George Pink', 7, '2021-03-15', 7, 'LHR'), 
('Hannah Yellow', 8, '2021-05-18', 8, 'TXL'), 
('Ian Orange', 9, '2022-07-19', 9, 'CDG'), 
('Jessica Purple', 10, '2022-09-23', 10, 'NRT');

-- Insertar en planes
INSERT INTO planes (plates, capacity, fabricationDate, statusId, modelId, airlineId) VALUES 
('ABC123', 180, '2010-05-12', 1, 1, 1), 
('DEF456', 220, '2011-08-14', 2, 2, 2), 
('GHI789', 150, '2012-11-20', 3, 3, 3), 
('JKL012', 190, '2013-03-22', 4, 4, 4), 
('MNO345', 160, '2014-06-24', 5, 5, 5), 
('PQR678', 140, '2015-09-26', 6, 6, 6), 
('STU901', 170, '2016-12-28', 7, 7, 7), 
('VWX234', 210, '2017-03-30', 8, 8, 8), 
('YZA567', 130, '2018-06-01', 9, 9, 9), 
('BCD890', 200, '2019-09-03', 10, 10, 10);

-- Por si es necesario borrar todos los datos de la tabla planes
/*
DELETE FROM planes;
ALTER TABLE planes AUTO_INCREMENT = 1;
*/
-- Insertar en trips
INSERT INTO trips (flightNumber, date, originAirportId, destinationAirportId, price, planeId) VALUES 
('AA100', '2023-01-01', 'JFK', 'LAX', 350.00, 1), 
('BB200', '2023-02-15', 'YYZ', 'YVR', 400.00, 2), 
('CC300', '2023-03-20', 'MEX', 'GRU', 450.00, 3), 
('DD400', '2023-04-25', 'LHR', 'TXL', 300.00, 4), 
('EE500', '2023-05-30', 'CDG', 'NRT', 600.00, 5), 
('FF600', '2023-06-05', 'JFK', 'MEX', 380.00, 6), 
('GG700', '2023-07-10', 'YYZ', 'LHR', 420.00, 7), 
('HH800', '2023-08-15', 'GRU', 'CDG', 470.00, 8), 
('II900', '2023-09-20', 'NRT', 'JFK', 500.00, 9), 
('JJ1000', '2023-10-25', 'LAX', 'YVR', 320.00, 10);

-- Por si es necesario borrar todos los datos de la tabla trips
/*
DELETE FROM trips ;
ALTER TABLE trips AUTO_INCREMENT = 1;
*/
-- Insertar en tripBookings
INSERT INTO tripBookings (date, tripId, customerId) VALUES 
('2023-01-01', 1, 1), 
('2023-02-15', 2, 2), 
('2023-03-20', 3, 3), 
('2023-04-25', 4, 4), 
('2023-05-30', 5, 5), 
('2023-06-05', 6, 6), 
('2023-07-10', 7, 7), 
('2023-08-15', 8, 8), 
('2023-09-20', 9, 9), 
('2023-10-25', 10, 10);

-- Insertar en tripCrew
INSERT INTO tripCrew (trip_id, employee_id) VALUES 
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(6, 6), 
(7, 7), 
(8, 8), 
(9, 9), 
(10, 10);

-- Insertar en tripLayovers
INSERT INTO tripLayovers (tripId, layoverAirportId, layoverFlightNumber) VALUES 
(1, 'YYZ', 'AA101'), 
(2, 'YVR', 'BB201'), 
(3, 'MEX', 'CC301'), 
(4, 'GRU', 'DD401'), 
(5, 'LHR', 'EE501'), 
(6, 'CDG', 'FF601'), 
(7, 'NRT', 'GG701'), 
(8, 'JFK', 'HH801'), 
(9, 'LAX', 'II901'), 
(10, 'YYZ', 'JJ1001');
