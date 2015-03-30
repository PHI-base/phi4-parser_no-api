PHIBASE version 4.0 30/03/2015


CONFIGURATION DETAILS
---------------------------------------------
- Any java IDE (ex. ECLIPSE)
- mysql relational db

REQUIRED REFERENCED LIBRARY 
---------------------------------------------
- mysql-connector-java-5.1.21.jar
- poi-3.8-20120326.jar
- poi-ooxml-3.8-20120326.jar
- poi-ooxml-schemas-3.8-20120326.jar
- dom4j-1.6.1.jar
- xmlbeans-2.3.0.jar

STEPS TO RUN THE PROGRAM
---------------------------------------------
- create java project with java IDE and copy the src to that project.
- create database and tables in mysql db as per schema(PHIBASE_DB_SCHEMA and phibase.sql present in folder)
- configure installed db details src/com/molcon/phibase/main/PhibaseExcelParseDB.java
- open phibaseExcelParseConfig.properties (src/resources) and edit for path
	- phibaseInputFilePath (path for input xlsx file containing the data of phibase)
	- phibaseResultFilePath (path for log file)
- Run the Program (main class : src/com/molcon/phibase/main/PhibaseExcelParse.java)



