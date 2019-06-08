-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-03-2015 a las 02:35:09
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `taller`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `automovil`
--

CREATE TABLE IF NOT EXISTS `automovil` (
  `matricula` varchar(7) NOT NULL,
  `dni_propietario` varchar(9) NOT NULL,
  `cod_concesionario` int(3) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `color` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `automovil`
--

INSERT INTO `automovil` (`matricula`, `dni_propietario`, `cod_concesionario`, `modelo`, `marca`, `color`) VALUES
('111111', '6666667', 88, 'gini', 'lambo', 'ghjghj'),
('1111AAA', '33333333C', 1, 'ibi', 'seatt', 'blanco'),
('1888JMG', '44444444C', 2, 'wqewq', 'wqewqe', 'qwe'),
('188sJMG', '11111111A', 2, 'wqewq', 'wqewqe', 'qwee'),
('2121LLL', '11111111A', 2, 'toyota', 'corola', 'gris'),
('2222BBB', '11111111A', 3, 'esz', 'fiat', 'granate'),
('3333CCC', '22222222B', 4, 'Golf', 'volskwagen', 'azul'),
('4444TXC', '33333333C', 2, 'Laguna ', 'Renault', 'negro'),
('858585', '6666667', 88, 'nini', 'esp', 'rojo'),
('8888JMG', '44444444C', 2, 'wqewq', 'wqewqe', 'qwe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `tlf` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `tlf`) VALUES
('11111111A', 'Maria', 'Salgado', 'Rodrigez', 'geranios 12', 111111111),
('22222222B', 'Fernando', 'Cortez', 'Berankis', 'tulipanes 3', 222222222),
('33333333C', 'Perico', 'Palotes', 'Lotes', 'amapola 2', 333333333),
('44444444C', 'Estefania', 'Sobera', 'Pera', 'calle 9', 214748364),
('6666667', 'rtert', 'ertert', 'ertret', 'ertrete', 65656);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concesionario`
--

CREATE TABLE IF NOT EXISTS `concesionario` (
  `codigo` int(3) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `concesionario`
--

INSERT INTO `concesionario` (`codigo`, `nombre`, `direccion`) VALUES
(1, 'conce1', 'tralala'),
(2, 'kk', 'tralala2'),
(3, 'qwe', 'qweqwe'),
(4, 'zxc', 'qweqee'),
(5, 'erwe', 'ererw'),
(88, 'hfg', 'hhj');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mecanico`
--

CREATE TABLE IF NOT EXISTS `mecanico` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `telefono` int(9) NOT NULL,
  `salario` float NOT NULL,
  `contratacion` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `mecanico`
--

INSERT INTO `mecanico` (`dni`, `nombre`, `apellido1`, `apellido2`, `direccion`, `telefono`, `salario`, `contratacion`) VALUES
('11111113L', 'Helena', 'gracia', 'españa', 'dfdfdsf', 123123123, 2000, '123123123'),
('1111111YG', 'Alejandro', 'Rodrigro', 'Perez', 'cdfvvbhgb', 123123123, 2000, '123123123'),
('22222221B', 'Lucia', 'galvez', 'duran', 'vfbgnh ', 123123123, 2000, 'fijo'),
('303030', 'alfonso', 'idelfonso', 'alonso', 'ferraru', 523148, 8000, '3'),
('88811112A', 'Paco', 'Colmado', 'Dorado', 'calle 1', 12121212, 2000, '12121212');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `repara`
--

CREATE TABLE IF NOT EXISTS `repara` (
  `dni_mecanico` varchar(9) NOT NULL,
  `matricula` varchar(7) NOT NULL,
  `num_horas` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `repara`
--

INSERT INTO `repara` (`dni_mecanico`, `matricula`, `num_horas`, `fecha`) VALUES
('22222221B', '1111AAA', 5, '2015-02-22'),
('88811112A', '3333CCC', 2, '2015-02-18'),
('22222221B', '4444TXC', 45, '2015-02-11'),
('11111113L', '1111AAA', 9, '2015-02-02'),
('1111111YG', '188sJMG', 20, '2015-02-02');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `automovil`
--
ALTER TABLE `automovil`
 ADD PRIMARY KEY (`matricula`), ADD KEY `dni_propietario` (`dni_propietario`), ADD KEY `cod_concesionario` (`cod_concesionario`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `concesionario`
--
ALTER TABLE `concesionario`
 ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `mecanico`
--
ALTER TABLE `mecanico`
 ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `repara`
--
ALTER TABLE `repara`
 ADD KEY `dni_mecanico` (`dni_mecanico`,`matricula`), ADD KEY `matricula` (`matricula`), ADD KEY `dni_mecanico_2` (`dni_mecanico`,`matricula`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `automovil`
--
ALTER TABLE `automovil`
ADD CONSTRAINT `fk_aut_conce` FOREIGN KEY (`cod_concesionario`) REFERENCES `concesionario` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_aut_dni` FOREIGN KEY (`dni_propietario`) REFERENCES `cliente` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `repara`
--
ALTER TABLE `repara`
ADD CONSTRAINT `fk_rep_dni_meca` FOREIGN KEY (`dni_mecanico`) REFERENCES `mecanico` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_rep_matri` FOREIGN KEY (`matricula`) REFERENCES `automovil` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
