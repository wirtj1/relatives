
-- Create medicine
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (1, 'Makes you calm', null, 'Antiripper');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (10, 'Makes you headbanging', null, 'Black Sabbathzilin');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (2, 'Stuff', null, 'MDMA');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (3, 'Something', null, 'Antibiotic');

-- Create medication
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (1, '200mg', 2, 'Not so important', 1);
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (2, '50mg', 3, 'Take while eating, not on empty stomach', 2);
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (3, '100mg', 1, 'Can make sleepy, but this is normal and no problem', 3);

-- Create addresses
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (1, 'Münsigen', '', 'CH', '', '9123', 'Linkenweg', '42');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (2, 'Wütenberg', '', 'CH', '', '3145', 'Ärgerhof', '66');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (3, 'Galgenhausen', '', 'CH', 'Postbox 4', '4233', 'Richtergasse', '82');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (4, 'Brückenstürzligen', '', 'CH', 'Postbox', '4233', 'Federspielweg', '5');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (5, 'Irrenkofen', '', 'Niemandsland', 'Postbox', '4233', 'Geometrischen', '312');

-- Create insurances
INSERT INTO PUBLIC.INSURANCE (ID, NAME, POLICENUMBER) VALUES (1, 'Lifecare Suisse', '7001.55.1970');

-- Create Pinnboards
INSERT INTO PUBLIC.PINBOARD (ID) VALUES (1);
INSERT INTO PUBLIC.PINBOARD (ID) VALUES (2);

-- Create patient
INSERT INTO PUBLIC.PATIENT (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, GOALS, OASI, WEEKENDINFORMATION, YEARPLANNING, MOVEMENT_ID, PINBOARD_ID, ADDRESS_ID) VALUES ( 3, '1973-08-22 00:00:00.000000000', 'Jack', 'Ripper', '075 102 23 33', 0, 0, 'Kill less people', '756.1111.1111.01', 'Not allowed', 1, null, 1);
INSERT INTO PUBLIC.PATIENT (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, GOALS, OASI, WEEKENDINFORMATION, YEARPLANNING, MOVEMENT_ID, PINBOARD_ID, ADDRESS_ID) VALUES (10, '1963-08-22 00:00:00.000000000', 'Timon', 'Sleeper', '075 193 38 48', 0, 0, 'Must be more active', '756.1111.2222.02', 'Is phishing', 1, null, 2);

-- Create relative
INSERT INTO PUBLIC.RELATIVE (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ADDRESS_ID) VALUES (8, '1970-01-10 00:00:00.000000000', 'John', 'Smith', '074 883 34 33', 0, 0, 3);
INSERT INTO PUBLIC.RELATIVE (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ADDRESS_ID) VALUES (4, '1960-03-02 00:00:00.000000000', 'Marge', 'Scared', '074 432 48 23', 0, 0, 4);

-- Create professional
INSERT INTO PUBLIC.PROFESSIONAL(ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ONEMERGENCY, ROLE, ADDRESS_ID) VALUES (3, '1980-05-14 00:00:00.000000000','Sue', 'Guiltless', '075 444 25 40', 0, 0, false, 0, 5);

-- Create accounts
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (1, 'myPW', null, 'jacks_sister', 1);
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (2, 'myPW', null, 'jacks_playmate', 4);
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (3, 'myPW', null, 'superprof', 3);

-- Create Pinnboard entry
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (1, '2017-05-20 19:46:47.372000000', 'Our neightbour disappeard!', null, 4);
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (2, '2017-05-21 15:02:32.372000000', 'John was alone yesterday', null, 1);
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (3, '2017-05-21 19:46:47.372000000', 'It seams John is not cured', null, 3);

---- n:m

-- Create pinboard<->pinboardentry
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (1, 1);
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (1, 2);
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (1, 3);

-- Create patient<->insurance
INSERT INTO PUBLIC.PATIENT_INSURANCE (PATIENT_ID, INSURANCES_ID) VALUES (3, 1);

-- Create patient<->medication
INSERT INTO PUBLIC.PATIENT_MEDICATION (PATIENT_ID, MEDICATIONS_ID) VALUES (3, 1);

-- Create patient-relatives-professional
INSERT INTO PUBLIC.PATIENT_RELATIVE (PATIENT_ID, RELATIVES_ID) VALUES (3, 8);
INSERT INTO PUBLIC.PATIENT_PROFESSIONAL(PATIENT_ID, PROFESSIONALS_ID) VALUES (3, 3);

