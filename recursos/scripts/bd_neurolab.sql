-- MySQL dump 10.16  Distrib 10.1.16-MariaDB, for Linux (x86_64)
 --
 -- Host: localhost    Database: bd_neurolab
 -- ------------------------------------------------------
 -- Server version	10.1.16-MariaDB
 
 
 -- Base de datos: bd_neurolab
 -- Para crearla:
 -- create database bd_neurolab;
 -- use bd_neurolab;
 
 
 --
 -- Table structure for table `tab_administradores`
 --
 DROP
	TABLE
		IF EXISTS `tab_administradores`;

CREATE
	TABLE
		`tab_administradores`(
			`adm_id` varchar(15) NOT NULL COMMENT 'Nombre de usuario que identifica a un administrador',
			`adm_nombre` varchar(30) NOT NULL COMMENT 'Nombre real de un administrador',
			`adm_apellidos` varchar(30) NOT NULL COMMENT 'Apellidos de un administrador',
			`adm_correo` varchar(120) NOT NULL COMMENT 'Correo electronico de un administrador',
			`adm_contrasena` varchar(150) NOT NULL COMMENT 'Contrasena de un administrador',
			PRIMARY KEY(`adm_id`)
		) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena la infomacion de los administradores de solicitudes de prestamo y dispositivos';

--
 -- Table structure for table `tab_investigadores`
 --
 DROP
	TABLE
		IF EXISTS `tab_investigadores`;

CREATE
	TABLE
		`tab_investigadores`(
			`inv_id` varchar(15) NOT NULL COMMENT 'Nombre de usuario que identifica a un investigador',
			`inv_nombre` varchar(30) NOT NULL COMMENT 'Nombre real de un investigador',
			`inv_apellidos` varchar(30) NOT NULL COMMENT 'Apellidos de un investigador',
			`inv_correo` varchar(120) NOT NULL COMMENT 'Correo electronico de un investigador',
			`inv_contrasena` varchar(150) NOT NULL COMMENT 'Contrasena de un investigador',
			PRIMARY KEY(`inv_id`)
		) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena la informacion de los investigadores que hacen solicitudes de prestamo';

--
 -- Table structure for table `tab_tipos_dispositivo`
 --
 DROP
	TABLE
		IF EXISTS `tab_tipos_dispositivo`;

CREATE
	TABLE
		`tab_tipos_dispositivo`(
			`tip_id` varchar(4) NOT NULL COMMENT 'Codigo que identifica un tipo de dispositivo',
			`tip_clase` varchar(20) NOT NULL COMMENT 'Especifica la clase o tipo de dispositivo',
			PRIMARY KEY(`tip_id`)
		) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena los diferentes tipos posibles de dispositivos';

--
 -- Table structure for table `tab_dispositivos`
 --
 DROP
	TABLE
		IF EXISTS `tab_dispositivos`;

CREATE
	TABLE
		`tab_dispositivos`(
			`dis_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero que identifica a un dispositivo',
			`dis_tipo_dispositivo` varchar(4) NOT NULL COMMENT 'Identificacion del tipo de dispositivo',
			`dis_disponible` tinyint(4) NOT NULL COMMENT 'Determina si un dispositivo puede o no ser solicitado',
			`dis_especificaciones` varchar(250) NOT NULL COMMENT 'Informacion sobre el dispositivo',
			`dis_registrado_por` varchar(15) NOT NULL COMMENT 'Identifiacion del administrador que registro el dispositivo en la base de datos',
			`dis_fecha_registro` date NOT NULL COMMENT 'Fecha en la que se registro el dispositivo en la base de datos',
			PRIMARY KEY(`dis_id`),
			KEY `tab_dispositivos_tab_administradores_FK`(`dis_registrado_por`),
			KEY `tab_dispositivos_tab_tipo_dispositivo_FK`(`dis_tipo_dispositivo`),
			CONSTRAINT `tab_dispositivos_tab_administradores_FK` FOREIGN KEY(`dis_registrado_por`) REFERENCES `tab_administradores`(`adm_id`) ON
			DELETE
				CASCADE ON
				UPDATE
					CASCADE,
					CONSTRAINT `tab_dispositivos_tab_tipo_dispositivo_FK` FOREIGN KEY(`dis_tipo_dispositivo`) REFERENCES `tab_tipos_dispositivo`(`tip_id`) ON
					DELETE
						CASCADE ON
						UPDATE
							CASCADE
		) ENGINE = InnoDB AUTO_INCREMENT = 7 DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena los dispositivos del laboratorio';

--
 -- Table structure for table `tab_solicitudes_prestamo`
 --
 DROP
	TABLE
		IF EXISTS `tab_solicitudes_prestamo`;

CREATE
	TABLE
		`tab_solicitudes_prestamo`(
			`sol_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Numero que identifica una solicitud de prestamo',
			`sol_fecha_solicitud` date NOT NULL COMMENT 'Fecha en la que se realizo una solicitud de prestamo',
			`sol_solicitante` varchar(15) NOT NULL COMMENT 'Identificacion del investigador que realizo la solicitud de prestamo',
			`sol_procesada_por` varchar(15) NOT NULL COMMENT 'Identificacion del administrador que proceso la solicitud de prestamo',
			`sol_respuesta` tinyint(4) NOT NULL COMMENT 'Respuesta dada por un administrador a la solicitud de un investigador',
			PRIMARY KEY(`sol_id`),
			KEY `tab_solicitudes_prestamo_tab_administradores_FK`(`sol_procesada_por`),
			KEY `tab_solicitudes_prestamo_tab_investigadores_FK`(`sol_solicitante`),
			CONSTRAINT `tab_solicitudes_prestamo_tab_administradores_FK` FOREIGN KEY(`sol_procesada_por`) REFERENCES `tab_administradores`(`adm_id`) ON
			DELETE
				CASCADE ON
				UPDATE
					CASCADE,
					CONSTRAINT `tab_solicitudes_prestamo_tab_investigadores_FK` FOREIGN KEY(`sol_solicitante`) REFERENCES `tab_investigadores`(`inv_id`) ON
					DELETE
						CASCADE ON
						UPDATE
							CASCADE
		) ENGINE = InnoDB AUTO_INCREMENT = 3 DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena las solicitudes de prestamo realizadas por los investigadores';

--
 -- Table structure for table `tab_detalles_solicitud`
 --
 DROP
	TABLE
		IF EXISTS `tab_detalles_solicitud`;

CREATE
	TABLE
		`tab_detalles_solicitud`(
			`det_solicitud` int(11) NOT NULL COMMENT 'Identificacion de la solicitud que se esta detallando',
			`det_dispositivo_solicitado` int(11) NOT NULL COMMENT 'Identifiacion del dispositivo que se esta solicitando',
			`det_hora_entrega` datetime NOT NULL COMMENT 'Hora de entrega del dispositivo',
			`det_hora_devolucion` datetime NOT NULL COMMENT 'Hora de devolucion del dispositivo',
			`det_horas_solicitadas` int(11) NOT NULL COMMENT 'Horas reservadas de un dispositivo',
			PRIMARY KEY(
				`det_solicitud`,
				`det_dispositivo_solicitado`
			),
			KEY `tab_detalles_solicitud_tab_dispositivos_FK`(`det_dispositivo_solicitado`),
			CONSTRAINT `tab_detalles_solicitud_tab_dispositivos_FK` FOREIGN KEY(`det_dispositivo_solicitado`) REFERENCES `tab_dispositivos`(`dis_id`) ON
			DELETE
				CASCADE ON
				UPDATE
					CASCADE,
					CONSTRAINT `tab_detalles_solicitud_tab_solicitudes_prestamo_FK` FOREIGN KEY(`det_solicitud`) REFERENCES `tab_solicitudes_prestamo`(`sol_id`) ON
					DELETE
						CASCADE ON
						UPDATE
							CASCADE
		) ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT = 'Esta tabla almacena los detalles de una solicitud de prestamo';

INSERT
	INTO
		bd_neurolab.tab_administradores(
			adm_id,
			adm_nombre,
			adm_apellidos,
			adm_correo,
			adm_contrasena
		)
	VALUES(
		'guille',
		'Guillermo',
		'Pineda',
		'guille@pineda.com',
		'b8f002559f4cfc740db2de36535cac6b'
	),
	(
		'juangui',
		'Juan',
		'Restrepo',
		'juan@restrepo.com',
		'3ab503379cbd1d58b58440c33b6baf93'
	);

INSERT
	INTO
		bd_neurolab.tab_investigadores(
			inv_id,
			inv_nombre,
			inv_apellidos,
			inv_correo,
			inv_contrasena
		)
	VALUES(
		'dani01',
		'Daniel',
		'Ocampo',
		'dani1@invest.com',
		'c9eb1d8b152704c9ebeccf8cd8706dad'
	),
	(
		'dani02',
		'Daniela',
		'Arboleda',
		'dani@invest.com',
		'1b4440b1f2dcdb372ea7af4acde546b0'
	);

INSERT
	INTO
		bd_neurolab.tab_tipos_dispositivo(
			tip_id,
			tip_clase
		)
	VALUES(
		'MICR',
		'Microscopio'
	),
	(
		'PORT',
		'Portatil'
	),
	(
		'TABL',
		'Tablet'
	);

INSERT
	INTO
		bd_neurolab.tab_dispositivos(
			dis_id,
			dis_tipo_dispositivo,
			dis_disponible,
			dis_especificaciones,
			dis_registrado_por,
			dis_fecha_registro
		)
	VALUES(
		1,
		'PORT',
		0,
		'Laptop de 12 pulgadas marca Eicer',
		'juangui',
		STR_TO_DATE(
			'2016-09-01',
			'%Y-%m-%d'
		)
	),
	(
		2,
		'PORT',
		0,
		'Laptop de 14 pulgadas marca Tochiba',
		'juangui',
		STR_TO_DATE(
			'2016-09-02',
			'%Y-%m-%d'
		)
	),
	(
		3,
		'MICR',
		1,
		'Microscopio optico',
		'guille',
		STR_TO_DATE(
			'2016-09-03',
			'%Y-%m-%d'
		)
	);

INSERT
	INTO
		bd_neurolab.tab_solicitudes_prestamo(
			sol_id,
			sol_fecha_solicitud,
			sol_solicitante,
			sol_procesada_por,
			sol_respuesta
		)
	VALUES(
		1,
		STR_TO_DATE(
			'2016-09-01',
			'%Y-%m-%d'
		),
		'dani01',
		'guille',
		0
	),
	(
		2,
		STR_TO_DATE(
			'2016-09-01',
			'%Y-%m-%d'
		),
		'dani02',
		'juangui',
		0
	);

INSERT
	INTO
		bd_neurolab.tab_detalles_solicitud(
			det_solicitud,
			det_dispositivo_solicitado,
			det_hora_entrega,
			det_hora_devolucion,
			det_horas_solicitadas
		)
	VALUES(
		1,
		1,
		STR_TO_DATE(
			'2016-09-01 01:01:01',
			'%Y-%m-%d %H:%i:%s'
		),
		STR_TO_DATE(
			'2016-09-01 05:01:01',
			'%Y-%m-%d %H:%i:%s'
		),
		4
	),
	(
		2,
		2,
		STR_TO_DATE(
			'2016-09-01 01:02:02',
			'%Y-%m-%d %H:%i:%s'
		),
		STR_TO_DATE(
			'2016-09-01 02:02:02',
			'%Y-%m-%d %H:%i:%s'
		),
		1
	);
