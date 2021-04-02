-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-02-2021 a las 03:21:23
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

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
(1, 'Yunior', '12345678', 'vergara blas'),
(8, 'Pedro', '23456787', 'FLORES');

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
(14, '123456', 'yunior', 'vergara', 11, 'M'),
(15, '12312312', 'maria', 'herandesx', 21, 'F'),
(16, '12345678', 'Lucia', 'Hernandex', 20, 'F');

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
  `movcondet_id` int(11) NOT NULL,
  `movcondet_con_id` int(11) NOT NULL,
  `eprcondet_epr_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_empresa_movilidad_detalle`
--

CREATE TABLE `app_empresa_movilidad_detalle` (
  `eprmovdet_id` int(11) NOT NULL,
  `eprmovdet_epr_id` int(11) NOT NULL,
  `eprmovdet_mov_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 'PISCO', 'CHINCHA ALTA', 'hjb-4d'),
(3, 'PISCO', 'NAZCA', 'hyb342');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_pesaje`
--

CREATE TABLE `app_pesaje` (
  `pes_id` int(11) NOT NULL,
  `pes_mov_id` int(11) NOT NULL,
  `pes_emp_id` int(11) NOT NULL,
  `pes_con_id` int(11) NOT NULL,
  `pes_fecha_ingreso` date NOT NULL,
  `pes_fecha_salida` date NOT NULL,
  `pes_peso_ingreso` double NOT NULL,
  `pes_peso_salida` double NOT NULL,
  `pes_hora_ingreso` varchar(20) NOT NULL,
  `pes_hora_salida` varchar(20) NOT NULL,
  `pes_tara` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `app_pesaje_ticket`
--

CREATE TABLE `app_pesaje_ticket` (
  `tic_id` int(11) NOT NULL,
  `tic_pes_id` int(11) NOT NULL,
  `tic_serie_numero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
  ADD PRIMARY KEY (`movcondet_id`);

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
  MODIFY `con_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `app_empleado`
--
ALTER TABLE `app_empleado`
  MODIFY `emp_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `app_empresa`
--
ALTER TABLE `app_empresa`
  MODIFY `epr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `app_empresa_conductor_detalle`
--
ALTER TABLE `app_empresa_conductor_detalle`
  MODIFY `movcondet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `app_empresa_movilidad_detalle`
--
ALTER TABLE `app_empresa_movilidad_detalle`
  MODIFY `eprmovdet_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `app_modelo_ticket`
--
ALTER TABLE `app_modelo_ticket`
  MODIFY `modtic_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `app_movilidad`
--
ALTER TABLE `app_movilidad`
  MODIFY `mov_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `app_pesaje`
--
ALTER TABLE `app_pesaje`
  MODIFY `pes_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `app_pesaje_ticket`
--
ALTER TABLE `app_pesaje_ticket`
  MODIFY `tic_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `app_session`
--
ALTER TABLE `app_session`
  MODIFY `ses_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
