# server.xml 

	<!-- JDBC -->
	<dataSource id="DefaultDataSource" jndiName="jdbc/defaultDataSource">
		<jdbcDriver libraryRef="DerbyLib"/>
		<properties.derby.embedded createDatabase="false" databaseName="C:/databases/java9"/>
	</dataSource>

	<library id="DerbyLib">
		<fileset dir="C:/software/db-derby-10.14.1.0-bin/lib" includes="*.jar"/>
	</library>

# persistence.xml - 
	<?xml version="1.0" encoding="UTF-8"?>
		<persistence xmlns="http://java.sun.com/xml/ns/persistence"
		    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" version="2.0"
    			xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd">
	    <persistence-unit name="javaee8PU">
   		 <jta-data-source>java:comp/DefaultDataSource</jta-data-source>
   		 <class>com.javabullets.java9.entity.Event</class>
   		 <class>com.javabullets.java9.entity.Entrant</class>
   		 <properties>
   			 <!-- allow table definitions/creation on-the-fly jpa-2.0 feature -->
   			 <property name="openjpa.jdbc.SynchronizeMappings" value="buildSchema(ForeignKeys=true)" />
   			 <!-- allow table definitions/creation on-the-fly jpa-2.1 feature -->
   			 <property name="eclipselink.ddl-generation" value="create-tables"/>
   			 <!-- property name="eclipselink.ddl-generation" value="none"/-->
   		 </properties>
    		</persistence-unit>
	</persistence>



-- CREATE TABLES
DROP TABLE APP.ENTRANT;
DROP TABLE APP.EVENT;

CREATE TABLE APP.EVENT
   (
      EVENT_ID INTEGER NOT NULL ,
      NAME VARCHAR(255) NOT NULL,
	  EVENT_DATE TIMESTAMP NOT NULL,
	  LOCATION VARCHAR(255) NOT NULL,
	  COUNTRY VARCHAR(255) NOT NULL
   );

ALTER TABLE APP.EVENT
   ADD CONSTRAINT EVENT_PK Primary Key (EVENT_ID);

CREATE TABLE APP.ENTRANT
   (
      ENTRANT_ID INTEGER NOT NULL ,
      FORENAME VARCHAR(255) NOT NULL,
	  SURNAME VARCHAR(255) NOT NULL,
	  AGE INTEGER NOT NULL ,
	  SEX VARCHAR(10),
	  EVENT_ID INTEGER NOT NULL
   );

ALTER TABLE APP.ENTRANT
   ADD CONSTRAINT ENTRANT_PK Primary Key (ENTRANT_ID);

ALTER TABLE APP.ENTRANT
   ADD CONSTRAINT EVENT_FK Foreign Key (
      EVENT_ID)
   REFERENCES APP.EVENT (EVENT_ID);

-- POPULATE TABLES
--
DELETE FROM APP.ENTRANT;
DELETE FROM APP.EVENT;
--  
INSERT INTO APP.EVENT VALUES (1, 'Edinburgh Marathon', TIMESTAMP('2018-05-04 08:00:00.234'), 'Edinburgh', 'UK');
INSERT INTO APP.EVENT VALUES (2, 'London Marathon', TIMESTAMP('2018-04-04 08:00:00.234'), 'London', 'UK');
INSERT INTO APP.EVENT VALUES (3, 'Tokyo Marathon', TIMESTAMP('2018-02-25 08:00:00.234'), 'Tokyo', 'Japan');
INSERT INTO APP.EVENT VALUES (4, 'Berlin Marathon', TIMESTAMP('2018-09-16 08:00:00.234'), 'Berlin', 'Germany');
INSERT INTO APP.EVENT VALUES (5, 'New York Marathon', TIMESTAMP('2018-11-04 08:00:00.234'), 'New York', 'USA');

INSERT INTO APP.ENTRANT VALUES (1, 'Martin', 'Farrell', 40, 'MALE',1);
INSERT INTO APP.ENTRANT VALUES (2, 'Kaylyn', 'Howlett', 18, 'FEMALE',1);
INSERT INTO APP.ENTRANT VALUES (3, 'Peggie', 'Oldam', 22, 'FEMALE',1);
INSERT INTO APP.ENTRANT VALUES (4, 'Verla', 'Prosser', 35, 'FEMALE',1);
INSERT INTO APP.ENTRANT VALUES (5, 'Desiree', 'Kyte', 56, 'FEMALE', 2);
INSERT INTO APP.ENTRANT VALUES (6, 'Andre', 'Dowthwaite', 40, 'MALE', 2);
INSERT INTO APP.ENTRANT VALUES (7, 'Babs', 'Scholcroft', 19, 'FEMALE', 2);
INSERT INTO APP.ENTRANT VALUES (8, 'Brucie', 'Pointer', 24, 'MALE', 2);
INSERT INTO APP.ENTRANT VALUES (9, 'Randi', 'Cutcliffe', 26, 'FEMALE', 3);
INSERT INTO APP.ENTRANT VALUES (10, 'Bondon', 'Landsman', 78, 'MALE', 3);
INSERT INTO APP.ENTRANT VALUES (11, 'Ivonne', 'Carlet', 45, 'FEMALE', 3);
INSERT INTO APP.ENTRANT VALUES (12, 'Huntlee', 'Howison', 48, 'MALE', 3);
INSERT INTO APP.ENTRANT VALUES (13, 'Auguste', 'Deerness', 51, 'FEMALE', 4);
INSERT INTO APP.ENTRANT VALUES (14, 'Patrice', 'Job', 23, 'MALE', 4);
INSERT INTO APP.ENTRANT VALUES (15, 'Bryce', 'Cregan', 24, 'MALE', 4);
INSERT INTO APP.ENTRANT VALUES (16, 'Kipp', 'Toghill', 19, 'FEMALE', 4);
INSERT INTO APP.ENTRANT VALUES (17, 'Cherish', 'Chippindale', 64, 'FEMALE', 5);
INSERT INTO APP.ENTRANT VALUES (18, 'Dewain', 'Mirfield', 90, 'MALE', 5);
INSERT INTO APP.ENTRANT VALUES (19, 'Filmer', 'Fallon', 21, 'MALE', 5);
INSERT INTO APP.ENTRANT VALUES (20, 'Viole', 'Pettyfer', 29, 'FEMALE', 5);
--
update APP.SEQUENCE set SEQ_COUNT = 50;
