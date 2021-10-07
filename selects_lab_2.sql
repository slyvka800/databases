SELECT distinct name, class FROM Labor_SQL.Ships order by name;

SELECT SUBSTRING(name, (SELECT LOCATE(' ', name)+1), 20) FROM Labor_SQL.Passenger where SUBSTRING(name, (SELECT LOCATE(' ', name)+1), 20) LIKE 'C%';

SELECT l1.model, l1.ram, l1.hd FROM Labor_SQL.Laptop l1 JOIN Labor_SQL.Laptop l2 
ON l1.ram = l2.ram and l1.hd = l2.hd and l1.code != l2.code 
ORDER BY l1.code

SELECT distinct maker FROM Labor_SQL.Product 
WHERE (NOT maker = ANY (SELECT maker from Labor_SQL.Product where type = 'Laptop')) 
and (type = 'PC');

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
        
SELECT *, CONCAT('from ',town_from, ' to ', town_to) AS from_to FROM Labor_SQL.Trip;

SELECT model, price
FROM Labor_SQL.PC
WHERE price > (
	SELECT price FROM Labor_SQL.Laptop
	WHERE price <= ALL(SELECT price FROM Laptop));
    
SELECT model, speed FROM Labor_SQL.PC WHERE speed >= 500;
