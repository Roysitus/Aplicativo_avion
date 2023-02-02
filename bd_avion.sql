-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-02-2023 a las 06:37:20
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_avion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_administrador` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `intentos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_administrador`, `nombre`, `apellido`, `dni`, `estado`, `contraseña`, `edad`, `intentos`) VALUES
('ADMIN2022-0', 'Utpino', 'Centrino', '76511458', 'HABILITADO', '12345', 28, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asiento`
--

CREATE TABLE `asiento` (
  `nroAsiento` varchar(50) NOT NULL,
  `dimension` varchar(50) NOT NULL,
  `clase` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `asiento`
--

INSERT INTO `asiento` (`nroAsiento`, `dimension`, `clase`) VALUES
('AS2022-0', '60 x 120 x 90', 'Clase Economica'),
('AS2022-1', '60 x 120 x 90', 'Clase Economica'),
('AS2022-2', '120 x 180 x 150', 'Primera Clase'),
('AS2022-3', '120 x 180 x 150', 'Primera Clase'),
('AS2022-4', '120 x 180 x 150', 'Primera Clase'),
('AS2022-5', '90 x 150 x 120', 'Clase Ejecutivo'),
('AS2022-6', '90 x 150 x 120', 'Clase Ejecutivo'),
('AS2022-7', '60 x 120 x 90', 'Clase Economica');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra_boleto`
--

CREATE TABLE `compra_boleto` (
  `id_boleto` varchar(50) NOT NULL,
  `costo` double NOT NULL,
  `idServicios` varchar(50) NOT NULL,
  `idViaje` varchar(100) NOT NULL,
  `idUsuario` varchar(50) NOT NULL,
  `nroAsiento` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `compra_boleto`
--

INSERT INTO `compra_boleto` (`id_boleto`, `costo`, `idServicios`, `idViaje`, `idUsuario`, `nroAsiento`) VALUES
('BL2022-0', 1065, 'SV2022-0', 'VJ2022-0', 'USER2022-0', 'AS2022-0'),
('BL2022-1', 995, 'SV2022-0', 'VJ2022-0', 'USER2022-1', 'AS2022-0'),
('BL2022-2', 780, 'SV2022-7', 'VJ2022-7', 'USER2022-0', 'AS2022-7');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `id_servicios` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `monto_servicio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`id_servicios`, `descripcion`, `monto_servicio`) VALUES
('SV2022-0', 'Maleta de 15 kilogramos', 250),
('SV2022-1', 'Maleta de 25 kilogramos', 420),
('SV2022-2', 'Maleta de 15 kilogramos', 250),
('SV2022-3', 'Maleta de 25 kilogramos', 420),
('SV2022-4', 'Maleta de 25 kilogramos', 420),
('SV2022-5', 'Maleta de 20 kilogramos', 310),
('SV2022-6', 'Maleta de 15 kilogramos', 250),
('SV2022-7', 'Maleta de 20 kilogramos', 310);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `dni` varchar(100) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `contraseña` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `intentos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellido`, `dni`, `estado`, `contraseña`, `edad`, `intentos`) VALUES
('USER2022-0', 'Utp', 'Centro', '76511452', 'HABILITADO', '12345', 21, 2),
('USER2022-1', 'Pepito', 'Pataclaun', '745888963', 'HABILITADO', '123', 18, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `viaje`
--

CREATE TABLE `viaje` (
  `id_viaje` varchar(50) NOT NULL,
  `destino` varchar(50) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  `tiempo` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `viaje`
--

INSERT INTO `viaje` (`id_viaje`, `destino`, `fecha`, `tiempo`) VALUES
('VJ2022-0', 'Lima - Tarapoto', '5 / 5 / 2023', '2h 21min 41s - Aprox'),
('VJ2022-1', 'Arequipa - Lima', '3 / 3 / 2023', '2h 21min 41s - Aprox'),
('VJ2022-2', 'Tarapoto - Lima', '4 / 12 / 2022', '2h 21min 41s - Aprox'),
('VJ2022-3', 'Cuzco - Lima', '5 / 12 / 2022', '2h 21min 41s - Aprox'),
('VJ2022-4', 'Arequipa - Lima', '5 / 12 / 2022', '2h 21min 41s - Aprox'),
('VJ2022-5', 'Cuzco - Lima', '6 / 12 / 2023', '2h 21min 41s - Aprox'),
('VJ2022-6', 'Lima - Piura', '1 / 1 / 2022', '2h 21min 41s - Aprox'),
('VJ2022-7', 'Arequipa - Lima', '7 / 12 / 2022', '2h 21min 41s - Aprox');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `asiento`
--
ALTER TABLE `asiento`
  ADD PRIMARY KEY (`nroAsiento`);

--
-- Indices de la tabla `compra_boleto`
--
ALTER TABLE `compra_boleto`
  ADD PRIMARY KEY (`id_boleto`),
  ADD UNIQUE KEY `idServicios` (`idServicios`,`idViaje`,`idUsuario`,`nroAsiento`),
  ADD KEY `idUsuario` (`idUsuario`),
  ADD KEY `idViaje` (`idViaje`),
  ADD KEY `nroAsiento` (`nroAsiento`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`id_servicios`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- Indices de la tabla `viaje`
--
ALTER TABLE `viaje`
  ADD PRIMARY KEY (`id_viaje`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra_boleto`
--
ALTER TABLE `compra_boleto`
  ADD CONSTRAINT `compra_boleto_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `compra_boleto_ibfk_2` FOREIGN KEY (`idViaje`) REFERENCES `viaje` (`id_viaje`),
  ADD CONSTRAINT `compra_boleto_ibfk_3` FOREIGN KEY (`nroAsiento`) REFERENCES `asiento` (`nroAsiento`),
  ADD CONSTRAINT `compra_boleto_ibfk_4` FOREIGN KEY (`idServicios`) REFERENCES `servicios` (`id_servicios`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
