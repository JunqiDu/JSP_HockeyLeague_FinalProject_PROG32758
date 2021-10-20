CREATE SCHEMA dbhockeyleague;

create table dbhockeyleague.teams(
team_ID int primary key AUTO_INCREMENT,
team_name varchar(40)
);

create table dbhockeyleague.games(
game_ID int primary key AUTO_INCREMENT,
game_win varchar(40),
game_lose varchar(40)
);