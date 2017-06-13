
-- Create medicine
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (10, 'Makes you calm', null, 'Antiripper');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (100, 'Makes you headbanging', null, 'Black Sabbathzilin');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (20, 'Stuff', null, 'MDMA');
INSERT INTO PUBLIC.MEDICINE (ID, DESCRIPTION, DOCUMENT, PRODUCTNAME) VALUES (30, 'Something', null, 'Antibiotic');

-- Create medication
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (10, '200mg', 2, 'Not so important', 10);
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (20, '50mg', 3, 'Take while eating, not on empty stomach', 20);
INSERT INTO PUBLIC.MEDICATION (ID, DOSE, INTERVAL, NOTES, MEDICINE_ID) VALUES (30, '100mg', 1, 'Can make sleepy, but this is normal and no problem', 30);

-- Create addresses
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (10, 'Münsigen', '', 'CH', '', '9123', 'Linkenweg', '42');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (20, 'Wütenberg', '', 'CH', '', '3145', 'Ärgerhof', '66');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (30, 'Galgenhausen', '', 'CH', 'Postbox 4', '4233', 'Richtergasse', '82');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (40, 'Brückenstürzligen', '', 'CH', 'Postbox', '4233', 'Federspielweg', '5');
INSERT INTO PUBLIC.ADDRESS (ID, CITY, COMPANY, COUNTRY, POSTBOX, POSTALCODE, STREETNAME, STREETNUMBER) VALUES (50, 'Irrenkofen', '', 'Niemandsland', 'Postbox', '4233', 'Geometrischen', '312');

-- Create insurances
INSERT INTO PUBLIC.INSURANCE (ID, NAME, POLICENUMBER) VALUES (10, 'Lifecare Suisse', '7001.55.1970');

-- Create Pinnboards
INSERT INTO PUBLIC.PINBOARD (ID) VALUES (10);
INSERT INTO PUBLIC.PINBOARD (ID) VALUES (20);

-- Create patient
INSERT INTO PUBLIC.PATIENT (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, GOALS, OASI, WEEKENDINFORMATION, YEARPLANNING, MOVEMENT_ID, PINBOARD_ID, ADDRESS_ID) VALUES ( 10, '1973-08-22 00:00:00.000000000', 'Jack', 'Ripper', '075 102 23 33', 0, 0, 'Kill less people', '756.1111.1111.01', 'Not allowed', 'myYear', null, 10, 10);
INSERT INTO PUBLIC.PATIENT (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, GOALS, OASI, WEEKENDINFORMATION, YEARPLANNING, MOVEMENT_ID, PINBOARD_ID, ADDRESS_ID) VALUES (100, '1963-08-22 00:00:00.000000000', 'Timon', 'Sleeper', '075 193 38 48', 0, 0, 'Must be more active', '756.1111.2222.02', 'Is phishing', 'myYear', null, 10, 20);

-- Create relative
INSERT INTO PUBLIC.RELATIVE (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ADDRESS_ID) VALUES (80, '1970-01-10 00:00:00.000000000', 'John', 'Smith', '074 883 34 33', 0, 0, 30);
INSERT INTO PUBLIC.RELATIVE (ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ADDRESS_ID) VALUES (40, '1960-03-02 00:00:00.000000000', 'Marge', 'Scared', '074 432 48 23', 0, 0, 40);

-- Create professional
INSERT INTO PUBLIC.PROFESSIONAL(ID, BIRTHDATE, FIRSTNAME, LASTNAME, PHONE, SALUTATION, TITLE, ONEMERGENCY, ROLE, ADDRESS_ID) VALUES (30, '1980-05-14 00:00:00.000000000','Sue', 'Guiltless', '075 444 25 40', 0, 0, false, 0, 50);

-- Create accounts
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (10, 'myPW', null, 'jacks_sister', 10);
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (20, 'myPW', null, 'jacks_playmate', 40);
INSERT INTO PUBLIC.ACCOUNT (ID, PASSWORD, PERMISSION, USERNAME, PERSON_ID) VALUES (30, 'myPW', null, 'superprof', 30);

-- Create Pinnboard entry
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (10, '2017-05-20 19:46:47.372000000', 'Our neightbour disappeard!', null, 40);
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (20, '2017-05-21 15:02:32.372000000', 'John was alone yesterday', null, 10);
INSERT INTO PUBLIC.PINBOARDENTRY (ID, CREATIONDATE, MESSAGE, TYPE, AUTHOR_ID) VALUES (30, '2017-05-21 19:46:47.372000000', 'It seams John is not cured', null, 30);

---- n:m

-- Create pinboard<->pinboardentry
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (10, 10);
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (10, 20);
INSERT INTO PUBLIC.PINBOARD_PINBOARDENTRY (PINBOARD_ID, ENTRIES_ID) VALUES (10, 30);

-- Create patient<->insurance
INSERT INTO PUBLIC.PATIENT_INSURANCE (PATIENT_ID, INSURANCES_ID) VALUES (10, 10);
INSERT INTO PUBLIC.PATIENT_INSURANCE (PATIENT_ID, INSURANCES_ID) VALUES (100, 10);

-- Create patient<->medication
INSERT INTO PUBLIC.PATIENT_MEDICATION (PATIENT_ID, MEDICATIONS_ID) VALUES (10, 10);

-- Create patient-relatives-professional
INSERT INTO PUBLIC.PATIENT_RELATIVE (PATIENT_ID, RELATIVES_ID) VALUES (10, 80);
INSERT INTO PUBLIC.PATIENT_PROFESSIONAL(PATIENT_ID, PROFESSIONALS_ID) VALUES (10, 30);
