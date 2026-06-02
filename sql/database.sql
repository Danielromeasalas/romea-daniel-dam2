-- TABLA CENTROS FORENSES

drop table if exists CENTROS_FORENSES;
create table CENTROS_FORENSES(
	ID SERIAL,
	NOMBRE VARCHAR(100) not null,
	PAIS VARCHAR(100) not null,
	NIVEL_SEGURIDAD INT not null,
	AUTOR_EXAMEN VARCHAR(50) default 'Daniel_Romea_dam',
	constraint PK_CENTROS_FORENSES primary key (ID)
);

-- TABLA MUESTRAS FORENSES

drop table if exists MUESTRAS_FORENSES;
create table MUESTRAS_FORENSES(
	ID SERIAL,
	CODIGO_CASO INT not null,
	TIPO_MUESTRA VARCHAR(100) not null,
	FECHA_RECOGIDA date not null,
	ESTADO_CUSTODIA VARCHAR(100) not null,
	FK_CENTRO_ID SERIAL not null,
	AUTOR_EXAMEN VARCHAR(50) default 'Daniel_Romea_dam',
	constraint PK_MUESTRAS_FORENSES primary key (ID),
	constraint FK_MUESTRAS_FORENSES_CENTRO_ID foreign key (FK_CENTRO_ID) references CENTROS_FORENSES(ID)
);


-- TABLA INFORMES FORENSES

drop table if exists INFORMES_FORENSES;
create table INFORMES_FORENSES(
	ID SERIAL,
	ADN_POSITIVO INT default 0 not null,
	NIVEL_RIESGO INT not null,
	CONCLUSION VARCHAR(100) not null,
	FK_MUESTRA_ID SERIAL not null,
	AUTOR_EXAMEN VARCHAR(50) default 'Daniel_Romea_dam',
	constraint PK_INFORMES_FORENSES primary key (ID),
	constraint UQ_FK_MUESTRA_ID unique (FK_MUESTRA_ID),
	constraint FK_INFORMES_FORENSES_MUESTRA_ID foreign key (FK_MUESTRA_ID) references MUESTRAS_FORENSES(ID)
);