--CATEGORIES
INSERT INTO `andromeda`.`categories` (`category_id`, `deleted`, `name`) SELECT 1, 0, 'Mujer'
WHERE NOT EXISTS (SELECT * FROM `categories` WHERE category_id = 1);
INSERT INTO `andromeda`.`categories` (`category_id`, `deleted`, `name`) SELECT 2, 0, 'Hombre'
WHERE NOT EXISTS (SELECT * FROM `categories` WHERE category_id = 2);
INSERT INTO `andromeda`.`categories` (`category_id`, `deleted`, `name`) SELECT 3, 0, 'Infantil'
WHERE NOT EXISTS (SELECT * FROM `categories` WHERE category_id = 3);
INSERT INTO `andromeda`.`categories` (`category_id`, `deleted`, `name`) SELECT 4, 0, 'Deportivo'
WHERE NOT EXISTS (SELECT * FROM `categories` WHERE category_id = 4);


--PRODUCTS
INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 1, 4, 'Zapatillas Adidas', 16900, 'Adidas Galaxy 5 Hombre Adultos', 'https://http2.mlstatic.com/D_NQ_NP_801371-MLA49850442171_052022-W.webp', 20, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 1);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 2, 2, 'Jogging', 8690, 'Jogging Hombre Sport 154 - Con Cierre - Ghy Polo Club', 'https://http2.mlstatic.com/D_NQ_NP_975859-MLA46489359055_062021-W.webp', 60, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 2);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 3, 2, 'Campera', 10999, 'Parka de abrigo con corderito negra y verde militar', 'https://http2.mlstatic.com/D_NQ_NP_721899-MLA49503487315_032022-W.webp', 24, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 3);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 4, 2, 'Pantalon Pampero', 6499, 'Pantalon Pampero Cargo de Trabajo Reforzado', 'https://http2.mlstatic.com/D_NQ_NP_754706-MLA48174872438_112021-W.webp', 54, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 4);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 5, 1, 'Babucha Jogger', 3599, 'Babucha Jogger Mujer Casual Frisa Pantalón Elástico Friza', 'https://http2.mlstatic.com/D_NQ_NP_851855-MLA46130258721_052021-O.webp', 17, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 5);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 6, 1, 'Pantuflas corderito', 7220, 'Pantuflas De Cuero Lanar Corderito Capellada', 'https://http2.mlstatic.com/D_NQ_NP_912994-MLA46740337158_072021-O.webp', 19, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 6);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 7, 4, 'Short De Running', 1800, 'Short De Running - Unisex - Gdo Running Flow', 'https://http2.mlstatic.com/D_NQ_NP_826572-MLA45272142297_032021-O.webp', 46, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 7);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 8, 1, 'Canguro Peluche', 4590, 'Pack X 2 Canguro Peluche Bifaz De Mujer Oferta Envío Gratis', 'https://http2.mlstatic.com/D_NQ_NP_989964-MLA45256400565_032021-O.webp', 24, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 8);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 9, 4, 'Bolso Grande', 5900, 'Bolso Grande Unisex Deportivo Reforzado Impermeable', 'https://http2.mlstatic.com/D_NQ_NP_945535-MLA46881919606_072021-O.webp', 37, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 9);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 10, 1, 'Cuello Térmico Multifunción', 900, 'Cuello Térmico Multifunción Tapaboca Moto Running Bici Sky', 'https://http2.mlstatic.com/D_NQ_NP_797364-MLA46099601150_052021-O.webp', 99, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 10);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 11, 1, 'Pijama Kigurumi', 6890, 'Pijama Kigurumi Unicornios Animales Mameluco Disfraz', 'https://http2.mlstatic.com/D_NQ_NP_600331-MLA49736535058_042022-O.webp', 32, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 11);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 12, 2, 'Buzo De Frisa', 5400, 'Buzos De Tela Frisa Algodón 100% Primera Calidad.', 'https://http2.mlstatic.com/D_NQ_NP_886526-MLA46565296785_062021-O.webp', 14, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 12);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 13, 3, 'Pijama Kigurumi', 6000, 'Pijama Kigurumi Niños Unicornios Animales Mameluco Disfraz', 'https://http2.mlstatic.com/D_NQ_NP_628121-MLA49694646676_042022-O.webp', 9, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 13);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 14, 1, 'Campera Inflable', 12000, 'Campera Inflable De Mujer Con Polar Y Capucha.', 'https://http2.mlstatic.com/D_NQ_NP_782588-MLA41798847937_052020-O.webp', 19, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 14);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 15, 3, 'Pijamas Stitch', 4300, 'Pijamas Personajes - Vexin Moda Infantil Stitch', 'https://http2.mlstatic.com/D_NQ_NP_837075-MLA43208315484_082020-O.webp', 36, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 15);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 16, 4, 'Mochila Puma', 4700, 'Mochila Puma Deck Mini Messenger Clásica Negra Unisex', 'https://http2.mlstatic.com/D_NQ_NP_846811-MLA49139878940_022022-O.webp', 32, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 16);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 17, 3, 'Pijama León', 6600, 'Pijama Kigurumi Importado 2811 León Infantil De 110 A 140 Cm', 'https://http2.mlstatic.com/D_NQ_NP_985472-MLA46183082050_052021-O.webp', 11, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 17);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 18, 3, 'Medias Largas Infantiles', 1930, 'Pack X 6 Pares Medias Largas Infantiles Elemento Nene Nena', 'https://http2.mlstatic.com/D_NQ_NP_830863-MLA49332904035_032022-O.webp', 12, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 18);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 19, 2, 'Set Sweaters', 10000, 'Sweater Polera Hombre Slim Fit Premium Pack X 4u', 'https://http2.mlstatic.com/D_NQ_NP_630203-MLA49886137753_052022-O.webp', 44, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 19);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 20, 4, 'Gorra Deportiva', 3200, 'Gorra Deportiva Running Oslo Unisex', 'https://http2.mlstatic.com/D_NQ_NP_937200-MLA48883807543_012022-O.webp', 67, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 20);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 21, 1, 'Campera Puffer', 12990, 'Campera Dama Puffer Mujer Metalizada Impermeable Premium', 'https://http2.mlstatic.com/D_NQ_NP_815436-MLA49014444071_022022-O.webp', 54, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 21);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 22, 3, 'Baberos Bandanas', 2650, 'Combo X 6 Baberos Bandanas Impermeables En El Reverso Nene', 'https://http2.mlstatic.com/D_NQ_NP_682690-MLA50252521241_062022-O.webp', 23, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 22);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 23, 2, 'Sweater Pullover', 6500, 'Sweater Hombre Medio Cierre Pullover De Lana Excelente', 'https://http2.mlstatic.com/D_NQ_NP_804658-MLA50255124042_062022-O.webp', 36, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 23);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 24, 3, 'Pantuflas Cars', 1900, 'Pantuflas Chicos Cars Rayo Mc Queen Personajes Infantiles', 'https://http2.mlstatic.com/D_NQ_NP_856444-MLA49279438503_032022-O.webp', 39, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 24);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 25, 4, 'Calza Corta', 6700, 'Calza Corta Deportiva Bolsillos Unisex Fit Trail Running X2', 'https://http2.mlstatic.com/D_NQ_NP_686581-MLA49714321882_042022-O.webp', 76, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 25);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 26, 3, 'Pantuflas De Stitch', 1690, 'Pantuflas De Stitch Peluche Niños Chicos Infantil Invierno', 'https://http2.mlstatic.com/D_NQ_NP_923628-MLA49266866393_032022-O.webp', 88, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 26);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 27, 3, 'Pijama Dinosaurio', 5590, 'Pijama Kigurumi Niños Animales Mameluco Disfraz', 'https://http2.mlstatic.com/D_NQ_NP_650925-MLA45788789615_052021-O.webp', 63, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 27);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 28, 4, 'Guantes Neoprene', 1100, 'Guantes De Neoprene Para Gimnasio Unisex', 'https://http2.mlstatic.com/D_NQ_NP_618609-MLA46364450144_062021-O.webp', 52, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 28);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 29, 2, 'Campera', 6800, 'Campera capucha Hoddie', 'https://http2.mlstatic.com/D_NQ_NP_970892-MLA31077285725_062019-W.webp', 19, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 29);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 30, 2, 'Zapatillas Topper', 11899, 'Topper Gordor II Hombre Adultos', 'https://http2.mlstatic.com/D_NQ_NP_875526-MLA49201325445_022022-W.webp', 30, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 30);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 31, 1, 'Jeans', 6500, 'Jeans Mujer Elastizado Tiro Medio Alto', 'https://http2.mlstatic.com/D_NQ_NP_879978-MLA49630309704_042022-W.webp', 10, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 31);

INSERT INTO `andromeda`.`products` (`product_id`, `category_id`, `name`, `unit_price`,`description`, `image_url`, `stock`, `deleted`)
SELECT 32, 4, 'Remera Deportiva', 6400, 'Remera Deportiva Mujer GDO Fit Running Ciclista', 'https://http2.mlstatic.com/D_NQ_NP_762111-MLA40003691898_122019-W.webp', 17, 0
WHERE NOT EXISTS (SELECT * FROM `products` WHERE product_id = 32);
