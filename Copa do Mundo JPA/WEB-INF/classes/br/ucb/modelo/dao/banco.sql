CREATE DATABASE copa;

use copa;

CREATE TABLE selecao (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
 	nome varchar(50) NOT NULL,
	qtdTitulos int unsigned DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE jogador (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
	nome varchar(50) NOT NULL,
	idade int unsigned NOT NULL,
	posicao varchar(10) NOT NULL,
	idSelecao int(10) unsigned NOT NULL,
	PRIMARY KEY (id),
	KEY fk_jogador_selecao (idSelecao),
 	CONSTRAINT fk_jogador_selecao FOREIGN KEY (idSelecao) REFERENCES selecao(id)
);

CREATE TABLE hotel (
	id int(10) unsigned NOT NULL AUTO_INCREMENT,
 	nome varchar(50) NOT NULL,
 	cidade varchar(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE selecaoHotel (
	idSelecao int(10) unsigned NOT NULL,
	idHotel int(10) unsigned NOT NULL,
	PRIMARY KEY (idSelecao, idHotel),
	KEY fk_selecao (idSelecao),
	KEY fk_hotel (idHotel),
 	CONSTRAINT fk_selecao FOREIGN KEY (idSelecao) REFERENCES selecao(id),
 	CONSTRAINT fk_hotel FOREIGN KEY (idHotel) REFERENCES hotel(id)
);








