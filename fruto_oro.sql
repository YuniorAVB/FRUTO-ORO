-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 06-03-2021 a las 05:58:18
-- Versión del servidor: 10.4.17-MariaDB
-- Versión de PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `fruto_oro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_conductor`
--

CREATE TABLE `app_conductor` (
  `con_id` int(11) NOT NULL,
  `con_nombre` varchar(50) NOT NULL,
  `con_dni` char(8) NOT NULL,
  `con_apellido` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_conductor`
--

INSERT INTO `app_conductor` (`con_id`, `con_nombre`, `con_dni`, `con_apellido`) VALUES
(9, 'YUNIOR', '12345678', 'VERGARA '),
(10, 'YUNIOR2', '23456783', 'VERGARA2'),
(11, 'PEDRO1', '98765123', 'PEADASD');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_empleado`
--

CREATE TABLE `app_empleado` (
  `emp_id` int(11) NOT NULL,
  `emp_dni` char(8) DEFAULT NULL,
  `emp_nombre` varchar(50) DEFAULT NULL,
  `emp_apellido` varchar(100) DEFAULT NULL,
  `emp_edad` int(11) DEFAULT NULL,
  `emp_sexo` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_empleado`
--

INSERT INTO `app_empleado` (`emp_id`, `emp_dni`, `emp_nombre`, `emp_apellido`, `emp_edad`, `emp_sexo`) VALUES
(1, '12345678', 'admin', 'admin', 21, 'M'),
(14, '123456', 'yunior', 'vergara', 11, 'M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_empresa`
--

CREATE TABLE `app_empresa` (
  `epr_id` int(11) NOT NULL,
  `epr_ruc` varchar(50) NOT NULL,
  `epr_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_empresa`
--

INSERT INTO `app_empresa` (`epr_id`, `epr_ruc`, `epr_nombre`) VALUES
(1, 'Leche Gloria', 'Leche Gloria'),
(3, '123ASDASD', 'PUMANI');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_empresa_conductor_detalle`
--

CREATE TABLE `app_empresa_conductor_detalle` (
  `eprcondet_id` int(11) NOT NULL,
  `eprcondet_con_id` int(11) NOT NULL,
  `eprcondet_epr_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_empresa_conductor_detalle`
--

INSERT INTO `app_empresa_conductor_detalle` (`eprcondet_id`, `eprcondet_con_id`, `eprcondet_epr_id`) VALUES
(15, 8, 1),
(16, 1, 1),
(17, 9, 1),
(18, 10, 1),
(19, 11, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_empresa_movilidad_detalle`
--

CREATE TABLE `app_empresa_movilidad_detalle` (
  `eprmovdet_id` int(11) NOT NULL,
  `eprmovdet_epr_id` int(11) NOT NULL,
  `eprmovdet_mov_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_empresa_movilidad_detalle`
--

INSERT INTO `app_empresa_movilidad_detalle` (`eprmovdet_id`, `eprmovdet_epr_id`, `eprmovdet_mov_id`) VALUES
(11, 1, 2),
(12, 1, 5),
(13, 3, 3),
(14, 3, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_modelo_ticket`
--

CREATE TABLE `app_modelo_ticket` (
  `modtic_id` int(11) NOT NULL,
  `modtic_titulo` varchar(100) NOT NULL,
  `modtic_pie_pagina` varchar(100) NOT NULL,
  `modtic_sub_titulo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_modelo_ticket`
--

INSERT INTO `app_modelo_ticket` (`modtic_id`, `modtic_titulo`, `modtic_pie_pagina`, `modtic_sub_titulo`) VALUES
(1, 'FRUTO DE ORO', 'GRACIAS POR SU VISITA', 'Sistema de pesaje automatico');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_movilidad`
--

CREATE TABLE `app_movilidad` (
  `mov_id` int(11) NOT NULL,
  `mov_destino` varchar(50) NOT NULL,
  `mov_procedencia` varchar(50) NOT NULL,
  `mov_placa` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_movilidad`
--

INSERT INTO `app_movilidad` (`mov_id`, `mov_destino`, `mov_procedencia`, `mov_placa`) VALUES
(2, 'PISCO', 'CHINCHA ALTA', 'abc-abc'),
(3, 'PISCO', 'NAZCA', 'hyb342'),
(4, 'asdasd', 'asdasd', 'asdasdas'),
(5, 'PISCO', 'CHINCHA', 'nbgcbva');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_pesaje`
--

CREATE TABLE `app_pesaje` (
  `pes_id` int(11) NOT NULL,
  `pes_mov_id` int(11) DEFAULT NULL,
  `pes_emp_id` int(11) DEFAULT NULL,
  `pes_con_id` int(11) DEFAULT NULL,
  `pes_fecha_ingreso` date DEFAULT NULL,
  `pes_fecha_salida` date DEFAULT NULL,
  `pes_peso_ingreso` decimal(10,3) DEFAULT NULL,
  `pes_peso_salida` decimal(10,3) DEFAULT NULL,
  `pes_hora_ingreso` varchar(20) DEFAULT NULL,
  `pes_hora_salida` varchar(20) DEFAULT NULL,
  `pes_tara` decimal(10,3) DEFAULT NULL,
  `pes_neto` decimal(10,3) DEFAULT NULL,
  `pes_bruto` decimal(10,3) DEFAULT NULL,
  `pes_producto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_pesaje`
--

INSERT INTO `app_pesaje` (`pes_id`, `pes_mov_id`, `pes_emp_id`, `pes_con_id`, `pes_fecha_ingreso`, `pes_fecha_salida`, `pes_peso_ingreso`, `pes_peso_salida`, `pes_hora_ingreso`, `pes_hora_salida`, `pes_tara`, `pes_neto`, `pes_bruto`, `pes_producto`) VALUES
(30, 2, 1, 10, '2021-03-05', NULL, '10000.560', NULL, '23:37:06.974', NULL, '10000.560', NULL, NULL, 'LECHE DE VACA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_pesaje_ticket`
--

CREATE TABLE `app_pesaje_ticket` (
  `tic_id` int(11) NOT NULL,
  `tic_pes_id` int(11) NOT NULL,
  `tic_serie_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_pesaje_ticket`
--

INSERT INTO `app_pesaje_ticket` (`tic_id`, `tic_pes_id`, `tic_serie_numero`) VALUES
(25, 30, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_session`
--

CREATE TABLE `app_session` (
  `ses_id` int(11) NOT NULL,
  `ses_usuario` varchar(50) DEFAULT NULL,
  `ses_contrasenia` varchar(50) DEFAULT NULL,
  `ses_tipo` int(11) DEFAULT NULL,
  `ses_emp_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `app_session`
--

INSERT INTO `app_session` (`ses_id`, `ses_usuario`, `ses_contrasenia`, `ses_tipo`, `ses_emp_id`) VALUES
(1, 'admin', 'qwerty', 0, 1),
(5, 'yunior', 'qwerty', 1, 14);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `app_conductor`
--
ALTER TABLE `app_conductor`
  ADD PRIMARY KEY (`con_id`);

--
-- Indices de la tabla `app_empleado`
--
ALTER TABLE `app_empleado`
  ADD PRIMARY KEY (`emp_id`);

--
-- Indices de la tabla `app_empresa`
--
ALTER TABLE `app_empresa`
  ADD PRIMARY KEY (`epr_id`);

--
-- Indices de la tabla `app_empresa_conductor_detalle`
--
ALTER TABLE `app_empresa_conductor_detalle`
  ADD PRIMARY KEY (`eprcondet_id`);

--
-- Indices de la tabla `app_empresa_movilidad_detalle`
--
ALTER TABLE `app_empresa_movilidad_detalle`
  ADD PRIMARY KEY (`eprmovdet_id`);

--
-- Indices de la tabla `app_modelo_ticket`
--
ALTER TABLE `app_modelo_ticket`
  ADD PRIMARY KEY (`modtic_id`);

--
-- Indices de la tabla `app_movilidad`
--
ALTER TABLE `app_movilidad`
  ADD PRIMARY KEY (`mov_id`);

--
-- Indices de la tabla `app_pesaje`
--
ALTER TABLE `app_pesaje`
  ADD PRIMARY KEY (`pes_id`);

--
-- Indices de la tabla `app_pesaje_ticket`
--
ALTER TABLE `app_pesaje_ticket`
  ADD PRIMARY KEY (`tic_id`);

--
-- Indices de la tabla `app_session`
--
ALTER TABLE `app_session`
  ADD PRIMARY KEY (`ses_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `app_conductor`
--
ALTER TABLE `app_conductor`
  MODIFY `con_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `app_empleado`
--
ALTER TABLE `app_empleado`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `app_empresa`
--
ALTER TABLE `app_empresa`
  MODIFY `epr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `app_empresa_conductor_detalle`
--
ALTER TABLE `app_empresa_conductor_detalle`
  MODIFY `eprcondet_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `app_empresa_movilidad_detalle`
--
ALTER TABLE `app_empresa_movilidad_detalle`
  MODIFY `eprmovdet_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `app_modelo_ticket`
--
ALTER TABLE `app_modelo_ticket`
  MODIFY `modtic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `app_movilidad`
--
ALTER TABLE `app_movilidad`
  MODIFY `mov_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `app_pesaje`
--
ALTER TABLE `app_pesaje`
  MODIFY `pes_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `app_pesaje_ticket`
--
ALTER TABLE `app_pesaje_ticket`
  MODIFY `tic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT de la tabla `app_session`
--
ALTER TABLE `app_session`
  MODIFY `ses_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
