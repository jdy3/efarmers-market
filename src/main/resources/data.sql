INSERT INTO produce (
    date,
    expiry,
    price,
    weight,
    description,
    location,
    name,
    picture,
    provenance,
    variety,
    category
) VALUES
('2025-09-08', '2025-09-20', 0.8,   107.00, '', 'Dimo',      'Pineapple', '', 'Yei River Orchard', 'Queen',            'Fruit'),
('2025-09-08', '2025-09-15', 2.0,    80.00,  '', 'Dimo',      'Mango',     '', 'Yei River Orchard', 'Ngowe',            'Fruit'),
('2025-09-08', '2025-09-30', 2.5,    75.00,  '', 'Dimo',      'Guava',     '', 'Yei River Orchard', 'Bassateen Edfina', 'Fruit'),
('2025-09-08', '2025-09-13', 1.5,    10.00,  '', 'Nimule',    'Khoodra',   '', 'Nimule Hills Farm', '',                 'Vegetable'),
('2025-09-08', '2026-10-01', 0.25,   500.00, '', 'Nimule',    'Sorghum',   '', 'Nimule Hills Farm', 'Milo',             'Cereal'),
('2025-09-08', '2026-11-01', 0.25,   500.00, '', 'Nimule',    'Maize',     '', 'Nimule Hills Farm', 'TELA',             'Cereal'),
('2025-09-08', '2025-09-15', 0.90, 9500.00,  '', 'Yei Town',  'Cassava',   '', 'Dimo Creek Farm',   'Hope',             'Vegetable'),
('2025-09-08', '2027-09-01', 5.00, 1100.00,  '', 'Yei Town',  'Rice',      '', 'Dimo Creek Farm',   'Jasmine',          'Cereal');

INSERT INTO livestock (
    age,
    date,
    price,
    quantity,
    weight,
    certification,
    description,
    location,
    name,
    picture,
    provenance,
    breed
) VALUES
(1.0,  '2025-09-08', 2.00,   60,  1.4,  'eOrganic Certification', 'Brooded kroilers', 'Dimo Creek Farm',   'Chicken', '', 'Dimo Creek Farm',   'Rainbow'),
(3.0,  '2025-09-08', 88.00,  40, 18.0,  'eOrganic Certification', '',                 'Nimule Hills Farm', 'Goat',    '', 'Nimule Hills Farm', 'Nubian'),
(6.5,  '2025-09-08', 88.00,  40, 66.0,  'eOrganic Certification', '',                 'Dimo Creek Farm',   'Lamb',    '', 'Nimule Creek Farm', 'Masai Sheep'),
(24.0, '2025-09-08', 360.00, 25, 80.0,  'eOrganic Certification', '',                 'Dimo Creek Farm',   'Sheep',   '', 'Dimo Creek Farm',   'Masai Sheep'),
(18.0, '2025-09-08', 1150.00,500,700.0, 'eOrganic Certification', '',                 'Nimule Hills Farm', 'Cow',     '', 'Nimule Hills Farm', 'Ankole-Watusi');