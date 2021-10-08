-- 1. БД «Кораблі». Перерахувати назви головних кораблів (із таблиці Ships). Вивести: name, class. Вихідні дані впорядкувати за зростанням за стовпцем name.
SELECT distinct name, class FROM Labor_SQL.Ships order by name;


-- 2. БД «Аеропорт». Вивести прізвища пасажирів (друге слово в стовпці name), що починаються на літеру 'С'.
SELECT SUBSTRING(name, (SELECT LOCATE(' ', name)+1), 20) FROM Labor_SQL.Passenger where SUBSTRING(name, (SELECT LOCATE(' ', name)+1), 20) LIKE 'C%';


-- 3. БД «Комп. фірма». Знайдіть пари моделей ноутбуків, що мають однакові об’єми жорстких дисків та RAM (таблиця Laptop).
-- У резуль- таті кожна пара виводиться лише один раз. Порядок виведення: мо- дель із більшим номером, модель із меншим номером, об’єм диску та RAM.
SELECT l1.model, l1.ram, l1.hd FROM Labor_SQL.Laptop l1 JOIN Labor_SQL.Laptop l2 
ON l1.ram = l2.ram and l1.hd = l2.hd and l1.code != l2.code 
ORDER BY l1.code


-- 4. БД «Комп. фірма». Знайдіть виробників, що випускають ПК, але не ноутбуки (використати ключове слово ANY). Вивести maker.
SELECT distinct maker FROM Labor_SQL.Product 
WHERE (NOT maker = ANY (SELECT maker from Labor_SQL.Product where type = 'Laptop')) 
and (type = 'PC');


-- 5. БД «Комп. фірма». Знайдіть виробників принтерів, що випускають ПК із найменшим об’ємом RAM. Виведіть: maker.
SELECT distinct maker FROM Product 
LEFT JOIN PC 
ON Product.model = PC.model 
where type = 'Printer' 
AND maker = ANY (
	SELECT maker from Product
	JOIN PC
	ON PC.model = Product.model
	where ram <= ALL(
		SELECT ram FROM PC));
 

-- 6. БД «Аеропорт». Вивести дані для таблиці Trip з об’єднаними зна- ченнями двох стовпців: town_from та town_to,
-- з додатковими комента- рями типу: 'from Rostov to Paris'.
SELECT *, CONCAT('from ',town_from, ' to ', town_to) AS from_to FROM Labor_SQL.Trip;


-- 7. БД «Комп. фірма». Знайти моделі та ціни ПК, вартість яких пере- вищує мінімальну вартість ноутбуків. Вивести: model, price.
SELECT model, price
FROM Labor_SQL.PC
WHERE price > (
	SELECT price FROM Labor_SQL.Laptop
	WHERE price <= ALL(SELECT price FROM Laptop));
  

-- 8. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК із міні- мальною швидкістю не менше 500 МГц.
-- Вивести: maker, мінімальна швидкість. (Підказка: використовувати підзапити в якості обчислю- вальних стовпців)
SELECT model, speed FROM Labor_SQL.PC WHERE speed >= 500;


-- 9. БД «Фірма прий. вторсировини». Визначіть лідера за сумою виплат у змаганні між кожною парою пунктів
-- з однаковими номерами із двох різних таблиць – Outcome та Outcome_o – на кожний день, коли здійcнювався
-- прийом вторинної сировини хоча б на одному з них. Вивести: Номер пункту, дата, текст: – 'once a day',
-- якщо сума виплат є більшою у фірми зі звітністю один раз на день; – 'more than once a day', якщо – у фірми
-- зі звітністю декілька разів на день; – 'both', якщо сума виплат є однаковою. (Підказка: для з’єднання таблиць
-- використовувати повне зовнішнє з’єднання, а для перевірки умов оператор CASE; для пунктів що не мають у певні
-- дні видачі грошей – необхідно обробляти NULL- значення за допомогою перевірки умови IS [NOT] NULL)
SELECT point, date,
	CASE
		WHEN not_once > once THEN 'more than once a day'
		WHEN not_once < once THEN 'once a day'
		ELSE 'both'
	END AS status
FROM
(SELECT
	Outcome.point AS point,
	Outcome.date AS date,
	SUM(Outcome.out) AS not_once,
	SUM(Outcome_o.out) AS once
FROM Outcome_o 
LEFT OUTER JOIN Outcome
ON Outcome_o.date=Outcome.date
GROUP BY 1,2) AS data_temp
WHERE point IS NOT NULL; 


-- 10. БД «Комп. фірма». Для кожної моделі продукції з усієї БД виведіть її середню ціну.
-- Вивести: type, model, середня ціна. (Підказка: використовувати оператор UNION)
SELECT distinct data1.type, data1.model, (SELECT AVG(data2.price) FROM 
	(SELECT kek.model, kek.price, p.type FROM (
		SELECT model, price FROM Laptop
		UNION
		SELECT model, price FROM PC
		UNION
		SELECT model, price FROM Printer) AS kek
	JOIN Product p
	ON kek.model = p.model) data2
    WHERE data1.model = data2.model
) as average_price FROM 
(SELECT kek.model, kek.price, p.type FROM (
		SELECT model, price FROM Laptop
		UNION
		SELECT model, price FROM PC
		UNION
		SELECT model, price FROM Printer) AS kek
	JOIN Product p
	ON kek.model = p.model) data1

