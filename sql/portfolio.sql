-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-01-2023 a las 20:10:49
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `portfolio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `acerca_de`
--

CREATE TABLE `acerca_de` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(500) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `id` int(11) NOT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo` varchar(200) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ubicacion` varchar(200) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion`
--

CREATE TABLE `educacion` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `titulo` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `titulo_de_la_carrera` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  `estado` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL,
  `id_portfolio` int(11) DEFAULT NULL,
  `descripcion` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `fecha_final` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `titulo` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades_blandas`
--

CREATE TABLE `habilidades_blandas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades_duras`
--

CREATE TABLE `habilidades_duras` (
  `id` int(11) NOT NULL,
  `imagen` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `nombre` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `sitioweb` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habilidades_nivel`
--

CREATE TABLE `habilidades_nivel` (
  `id` int(11) NOT NULL,
  `nombre` varchar(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfil`
--

CREATE TABLE `perfil` (
  `id` int(11) NOT NULL,
  `rol` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portfolio`
--

CREATE TABLE `portfolio` (
  `id` int(11) NOT NULL,
  `url_banner` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `url_profile_picture` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `id_detalle` int(11) DEFAULT NULL,
  `id_acerca_de` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portfolio_habilidades_blandas`
--

CREATE TABLE `portfolio_habilidades_blandas` (
  `id` int(11) NOT NULL,
  `id_habilidades_blandas` int(11) DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portfolio_habilidades_duras`
--

CREATE TABLE `portfolio_habilidades_duras` (
  `id` int(11) NOT NULL,
  `id_habilidades_duras` int(11) DEFAULT NULL,
  `id_habilidades_nivel` int(11) DEFAULT NULL,
  `id_portfolio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `imagen` varchar(300) COLLATE utf8mb4_spanish_ci NOT NULL,
  `repositorio` varchar(300) COLLATE utf8mb4_spanish_ci NOT NULL,
  `titulo` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_portfolio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `clave` varchar(60) COLLATE utf8mb4_spanish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_spanish_ci NOT NULL,
  `nombre_de_usuario` varchar(40) COLLATE utf8mb4_spanish_ci NOT NULL,
  `id_portfolio` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_perfil`
--

CREATE TABLE `usuario_perfil` (
  `id_usuario` int(11) NOT NULL,
  `id_perfil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `acerca_de`
--
ALTER TABLE `acerca_de`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5s5b43l002owxq6yyurgmlfr2` (`id_portfolio`);

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK143exn3m119a8wk0sodr1ymg` (`id_portfolio`);

--
-- Indices de la tabla `habilidades_blandas`
--
ALTER TABLE `habilidades_blandas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `habilidades_duras`
--
ALTER TABLE `habilidades_duras`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `habilidades_nivel`
--
ALTER TABLE `habilidades_nivel`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `portfolio`
--
ALTER TABLE `portfolio`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq4wixdb6buocn8sb0srvq7vu1` (`id_detalle`),
  ADD KEY `FKdkl5edacubfbmaov2vdx6cjqs` (`id_acerca_de`);

--
-- Indices de la tabla `portfolio_habilidades_blandas`
--
ALTER TABLE `portfolio_habilidades_blandas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbrn2079ts6uvh2fx43466q56a` (`id_habilidades_blandas`),
  ADD KEY `FKnd8mw815as33bwfmk1vfnf2pv` (`id_portfolio`);

--
-- Indices de la tabla `portfolio_habilidades_duras`
--
ALTER TABLE `portfolio_habilidades_duras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3mbgpbx9omkshnafjx9hsdl28` (`id_habilidades_duras`),
  ADD KEY `FKcu7iraaynpdrfxfuklbf9nkv5` (`id_habilidades_nivel`),
  ADD KEY `FKba3qtv3wxtdggj97dv4b691h9` (`id_portfolio`);

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKoefho8hecoheegj9f1h2b7wj5` (`id_portfolio`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK96sotin2i7dcer0vu6b5uvpkq` (`id_portfolio`);

--
-- Indices de la tabla `usuario_perfil`
--
ALTER TABLE `usuario_perfil`
  ADD PRIMARY KEY (`id_usuario`,`id_perfil`),
  ADD KEY `FK3cxlmf5q4y8mllkos025n9px8` (`id_perfil`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `acerca_de`
--
ALTER TABLE `acerca_de`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habilidades_blandas`
--
ALTER TABLE `habilidades_blandas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habilidades_duras`
--
ALTER TABLE `habilidades_duras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habilidades_nivel`
--
ALTER TABLE `habilidades_nivel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `portfolio`
--
ALTER TABLE `portfolio`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `portfolio_habilidades_blandas`
--
ALTER TABLE `portfolio_habilidades_blandas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `portfolio_habilidades_duras`
--
ALTER TABLE `portfolio_habilidades_duras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD CONSTRAINT `FK5s5b43l002owxq6yyurgmlfr2` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD CONSTRAINT `FK143exn3m119a8wk0sodr1ymg` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `portfolio`
--
ALTER TABLE `portfolio`
  ADD CONSTRAINT `FKdkl5edacubfbmaov2vdx6cjqs` FOREIGN KEY (`id_acerca_de`) REFERENCES `acerca_de` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKq4wixdb6buocn8sb0srvq7vu1` FOREIGN KEY (`id_detalle`) REFERENCES `detalle` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `portfolio_habilidades_blandas`
--
ALTER TABLE `portfolio_habilidades_blandas`
  ADD CONSTRAINT `FKbrn2079ts6uvh2fx43466q56a` FOREIGN KEY (`id_habilidades_blandas`) REFERENCES `habilidades_blandas` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKnd8mw815as33bwfmk1vfnf2pv` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `portfolio_habilidades_duras`
--
ALTER TABLE `portfolio_habilidades_duras`
  ADD CONSTRAINT `FK3mbgpbx9omkshnafjx9hsdl28` FOREIGN KEY (`id_habilidades_duras`) REFERENCES `habilidades_duras` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKba3qtv3wxtdggj97dv4b691h9` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKcu7iraaynpdrfxfuklbf9nkv5` FOREIGN KEY (`id_habilidades_nivel`) REFERENCES `habilidades_nivel` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `FKoefho8hecoheegj9f1h2b7wj5` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK96sotin2i7dcer0vu6b5uvpkq` FOREIGN KEY (`id_portfolio`) REFERENCES `portfolio` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuario_perfil`
--
ALTER TABLE `usuario_perfil`
  ADD CONSTRAINT `FK2qe6tjawyl6ojl32uhbwllldh` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK3cxlmf5q4y8mllkos025n9px8` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
