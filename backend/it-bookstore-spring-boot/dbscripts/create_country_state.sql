
-- -----------------------------------------------------
-- Table country
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS country
(
    id   serial NOT NULL,
    code varchar(2)   DEFAULT null,
    name varchar(255) DEFAULT null,
    PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table state
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS state
(
    id         serial NOT NULL,
    name       varchar(255) DEFAULT null,
    country_id int    NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country (id)
);

-- Data for table `country`
--

INSERT INTO country (code, name) VALUES
('BR','Brazil'),
('CA','Canada'),
('DE','Germany'),
('IN','India'),
('TR','Turkey'),
('US','United States');

--
-- D ata for table `state`
--

INSERT INTO state (name, country_id) VALUES
('Acre',1),
('Alagoas',1),
('Amapá',1),
('Amazonas',1),
('Bahia',1),
('Ceará',1),
('Distrito Federal',1),
('Espírito Santo',1),
('Goiás',1),
('Maranhão',1),
('Mato Grosso do Sul',1),
('Mato Grosso',1),
('Minas Gerais',1),
('Paraná',1),
('Paraíba',1),
('Pará',1),
('Pernambuco',1),
('Piaui',1),
('Rio de Janeiro',1),
('Rio Grande do Norte',1),
('Rio Grande do Sul',1),
('Rondônia',1),
('Roraima',1),
('Santa Catarina',1),
('Sergipe',1),
('São Paulo',1),
('Tocantins',1),
('Alberta',2),
('British Columbia',2),
('Manitoba',2),
('New Brunswick',2),
('Newfoundland and Labrador',2),
('Northwest Territories',2),
('Nova Scotia',2),
('Nunavut',2),
('Ontario',2),
('Prince Edward Island',2),
('Quebec',2),
('Saskatchewan',2),
('Yukon',2),
('Baden-Württemberg',3),
('Bavaria',3),
('Berlin',3),
('Brandenburg',3),
('Bremen',3),
('Hamburg',3),
('Hesse',3),
('Lower Saxony',3),
('Mecklenburg-Vorpommern',3),
('North Rhine-Westphalia',3),
('Rhineland-Palatinate',3),
('Saarland',3),
('Saxony',3),
('Saxony-Anhalt',3),
('Schleswig-Holstein',3),
('Thuringia',3),
('Andhra Pradesh',4),
('Arunachal Pradesh',4),
('Assam',4),
('Bihar',4),
('Chhattisgarh',4),
('Goa',4),
('Gujarat',4),
('Haryana',4),
('Himachal Pradesh',4),
('Jammu & Kashmir',4),
('Jharkhand',4),
('Karnataka',4),
('Kerala',4),
('Madhya Pradesh',4),
('Maharashtra',4),
('Manipur',4),
('Meghalaya',4),
('Mizoram',4),
('Nagaland',4),
('Odisha',4),
('Punjab',4),
('Rajasthan',4),
('Sikkim',4),
('Tamil Nadu',4),
('Telangana',4),
('Tripura',4),
('Uttar Pradesh',4),
('Uttarakhand',4),
('West Bengal',4),
('Andaman and Nicobar Islands',4),
('Chandigarh',4),
('Dadra and Nagar Haveli',4),
('Daman & Diu',4),
('Lakshadweep',4),
('Puducherry',4),
('The Government of NCT of Delhi',4),
('Alabama',6),
('Alaska',6),
('Arizona',6),
('Arkansas',6),
('California',6),
('Colorado',6),
('Connecticut',6),
('Delaware',6),
('District Of Columbia',6),
('Florida',6),
('Georgia',6),
('Hawaii',6),
('Idaho',6),
('Illinois',6),
('Indiana',6),
('Iowa',6),
('Kansas',6),
('Kentucky',6),
('Louisiana',6),
('Maine',6),
('Maryland',6),
('Massachusetts',6),
('Michigan',6),
('Minnesota',6),
('Mississippi',6),
('Missouri',6),
('Montana',6),
('Nebraska',6),
('Nevada',6),
('New Hampshire',6),
('New Jersey',6),
('New Mexico',6),
('New York',6),
('North Carolina',6),
('North Dakota',6),
('Ohio',6),
('Oklahoma',6),
('Oregon',6),
('Pennsylvania',6),
('Rhode Island',6),
('South Carolina',6),
('South Dakota',6),
('Tennessee',6),
('Texas',6),
('Utah',6),
('Vermont',6),
('Virginia',6),
('Washington',6),
('West Virginia',6),
('Wisconsin',6),
('Wyoming',6),
('Adıyaman',5),
('Afyonkarahisar',5),
('Ağrı',5),
('Aksaray',5),
('Amasya',5),
('Ankara',5),
('Antalya',5),
('Ardahan',5),
('Artvin',5),
('Aydın',5),
('Balıkesir',5),
('Bartın',5),
('Batman',5),
('Bayburt',5),
('Bilecik',5),
('Bingöl',5),
('Bitlis',5),
('Bolu',5),
('Burdur',5),
('Bursa',5),
('Çanakkale',5),
('Çankırı',5),
('Çorum',5),
('Denizli',5),
('Diyarbakır',5),
('Düzce',5),
('Edirne',5),
('Elazığ',5),
('Erzincan',5),
('Erzurum',5),
('Eskişehir',5),
('Gaziantep',5),
('Giresun',5),
('Gümüşhane',5),
('Hakkâri',5),
('Hatay',5),
('Iğdır',5),
('Isparta',5),
('İstanbul',5),
('İzmir',5),
('Kahramanmaraş',5),
('Karabük',5),
('Karaman',5),
('Kars',5),
('Kastamonu',5),
('Kayseri',5),
('Kırıkkale',5),
('Kırklareli',5),
('Kırşehir',5),
('Kilis',5),
('Kocaeli',5),
('Konya',5),
('Kütahya',5),
('Malatya',5),
('Manisa',5),
('Mardin',5),
('Mersin',5),
('Muğla',5),
('Muş',5),
('Nevşehir',5),
('Niğde',5),
('Ordu',5),
('Osmaniye',5),
('Rize',5),
('Sakarya',5),
('Samsun',5),
('Siirt',5),
('Sinop',5),
('Sivas',5),
('Şanlıurfa',5),
('Şırnak',5),
('Tekirdağ',5),
('Tokat',5),
('Trabzon',5),
('Tunceli',5),
('Uşak',5),
('Van',5),
('Yalova',5),
('Yozgat',5),
('Zonguldak',5);


