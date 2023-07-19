CREATE TABLE IF NOT EXISTS TICKETS (
  ID INT PRIMARY KEY,
  tkt_CONTENT VARCHAR(255),
  tkt_created_on VARCHAR(10),
  tkt_short_DESC VARCHAR(255),
  tkt_TITLE VARCHAR(255)
);



insert into tickets values ( 1,'test content','14-07-2023','test desc','test title');
insert into tickets values ( 2,'test content 2','14-07-2023','test desc 2','test title 2');
insert into tickets values ( 3,'','17-07-2023','test desc 3','test title 3');
insert into tickets values ( 4,'','17-07-2023','test desc 4','test title 4');