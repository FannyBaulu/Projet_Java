-- Jointure et Selection
SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Accessories'
Order by B.Cavalry_ATK DESC LIMIT 1;


SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Body Armor'
Order by B.Cavalry_ATK DESC LIMIT 1;
SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Helmets'
Order by B.Cavalry_ATK DESC LIMIT 1;

SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Footwear'
Order by B.Cavalry_ATK DESC LIMIT 1;

SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Main-Hand'
Order by B.Cavalry_ATK DESC LIMIT 1;

SELECT * FROM bddlords.boost AS B
JOIN bddlords.utilisateur_equipements AS UE
ON UE.idEquipement = B.idequipement
WHERE UE.idUtilisateur = '1'
AND B.type = 'Off-Hand'
Order by B.Cavalry_ATK DESC LIMIT 1;
