--DROP TABLE IF EXISTS todos;
DROP TABLE todos;

CREATE TABLE todos(
 todo_num NUMBER(10) PRIMARY KEY,
 title VARCHAR2(100) NOT NULL,
 contents VARCHAR2(250) ,
 start_date VARCHAR2(50) ,
 end_date VARCHAR2(50) 	
);

DROP Sequence todo_seq;
CREATE SEQUENCE todo_seq
START WITH 1
INCREMENT BY 1
NOMAXVALUE;