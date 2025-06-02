INSERT INTO manufacturer (id, name, year_of_establishment, headquarters) VALUES
('b36ac537-abf5-477f-94e1-a6fac825ea0a', 'Ravensburger', '1883-01-01', 'Németország'),
('201f0b77-1f11-4ef9-8a7e-ca60037a73ed', 'Trefl', '1985-01-01', 'Lengyelország'),
('0db96129-2869-41a0-bcd1-9ac278c532c0', 'Schmidt', '1900-01-01', 'Németország'),
('e08ed102-a67c-4afb-aea9-54358add5b87', 'Castorland', '1989-01-01', 'Lengyelország');

INSERT INTO jigsaw (id, title, pieces, price, manufacturer_id) VALUES
('f7279fe0-475c-4b02-8b72-91f4ad9122b1', 'Napsütés a folyó partján', 3000, 5290, 'b36ac537-abf5-477f-94e1-a6fac825ea0a'),
('0296541f-b903-4ee0-8d11-0d6feadf25a9', 'Paradicsom', 1000, 2550, '201f0b77-1f11-4ef9-8a7e-ca60037a73ed'),
('8f033070-9640-4d36-ad30-443d97dde285', 'New York', 2000, 9490, '0db96129-2869-41a0-bcd1-9ac278c532c0'),
('d1fee7bc-0ea2-4c2e-9e35-f5c9b7bc3d07', 'Borterasz', 500, 4290, 'e08ed102-a67c-4afb-aea9-54358add5b87');
