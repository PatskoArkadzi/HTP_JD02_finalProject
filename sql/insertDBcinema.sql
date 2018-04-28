-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.1.10-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win32
-- HeidiSQL Версия:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп данных таблицы cinema.films: ~7 rows (приблизительно)
DELETE FROM `films`;
/*!40000 ALTER TABLE `films` DISABLE KEYS */;
INSERT INTO `films` (`id`, `filmName`, `genre`, `description`) VALUES
	(1, 'Смешарики. Дежавю', 'Мультфильм', 'Крош решает устроить незабываемый день рождения Копатыча - он обращается в агентство «Дежавю», которое обещает своим клиентам удивительные путешествия во времени. Но из-за несоблюдения условий договора всех смешариков раскидывает во времени, а Крошу придется собирать друзей по разным эпохам в компании своего второго «Я» - повзрослевшего и ворчливого Шорка, появившегося из-за временного парадокса.'),
	(2, 'Танки', 'Военный', '1940 год. Советский Союз живет в ожидании большой войны. Стране нужна современная боевая техника, чтобы дать отпор врагу. Конструктор Михаил'),
	(3, 'Такси 5', 'Комедия', 'Переведенный в полицейский участок города Марселя офицер назначается ответственным за поимку банды итальянских грабителей на мощных автомоби'),
	(4, 'Тренер', 'Спорт', 'Футболист национальной сборной Юрий Столешников в ответственный момент не забивает пенальти. После досадной ошибки Столешников покидает сбор'),
	(5, 'Проект Cinemascope: Неприятности с Гарри', 'Комедия', 'Картина, снятая на фоне живописных осенних пейзажей, поставлена по роману Джека Тревора Стори. События фильма разворачиваются вокруг трупа н'),
	(6, 'Проект Cinemascope: Пурпурная роза Каира', 'Мелодрама', '30-е годы в США. У молодой женщины, работающей официанткой в пивной, имеется муж – безработный бездельник. Она утешается, проводя все вечера'),
	(7, 'Проект Cinemascope: Таксист', 'Триллер', 'Тусклый свет слепых фонарей, скелеты фабричных труб, задыхающихся в собственном дыму. Вавилонские башни небоскребов, все это — ад Нового вре');
/*!40000 ALTER TABLE `films` ENABLE KEYS */;

-- Дамп данных таблицы cinema.filmsessions: ~0 rows (приблизительно)
DELETE FROM `filmsessions`;
/*!40000 ALTER TABLE `filmsessions` DISABLE KEYS */;
/*!40000 ALTER TABLE `filmsessions` ENABLE KEYS */;

-- Дамп данных таблицы cinema.orders: ~0 rows (приблизительно)
DELETE FROM `orders`;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;

-- Дамп данных таблицы cinema.roles: ~2 rows (приблизительно)
DELETE FROM `roles`;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` (`id`, `roleName`) VALUES
	(1, 'admin'),
	(2, 'user');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;

-- Дамп данных таблицы cinema.seats: ~0 rows (приблизительно)
DELETE FROM `seats`;
/*!40000 ALTER TABLE `seats` DISABLE KEYS */;
/*!40000 ALTER TABLE `seats` ENABLE KEYS */;

-- Дамп данных таблицы cinema.tickets: ~0 rows (приблизительно)
DELETE FROM `tickets`;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;

-- Дамп данных таблицы cinema.users: ~3 rows (приблизительно)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `login`, `email`, `password`, `role_id`) VALUES
	(1, 'admin', 'admin@admin.com', 'password', 1),
	(2, 'user1', 'user1@user.com', 'qwerty', 2),
	(3, 'user2', 'user2@user.com', '12345', 2);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
