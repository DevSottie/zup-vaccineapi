create table user(
	user_id bigint not null auto_increment primary key,
    user_nome varchar(60) not null,
    user_email varchar(255) not null,
    user_cpf varchar(14) not null,
    user_birthdate datetime
);