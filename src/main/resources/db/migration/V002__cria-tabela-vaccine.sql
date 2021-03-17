create table vaccine(
	vaccine_id bigint not null auto_increment primary key,
    id_user bigint not null,
    vaccine_name varchar(60) not null,
    vaccine_dataAplicacao datetime,
	foreign key fk_vaccine_user (id_user) references user(user_id)
);