-- Consultas Muestra Forense DAO Impl

INSERT INTO muestras_forenses (codigo_caso, tipo_muestra, fecha_recogida, estado_custodia, fk_centro_id) VALUES (?, ?, ?, ?, ?);

UPDATE muestras_forenses SET codigo_caso=?,  tipo_muestra=?, fecha_recogida=?, estado_custodia=?, fk_centro_id=? WHERE id = ?;

SELECT * FROM muestras_forenses WHERE id = ?;

SELECT * FROM muestras_forenses ORDER BY id;

SELECT * FROM muestras_forenses WHERE fk_id_centro = ? ORDER BY id;

SELECT M.id, M.codigo_caso, M.fecha_recogida, M.estado_custodia, M.fk_centro_id
    I.id, I.adn_positivo, I.nivel_riesgo, I.conclusion FROM muestras_forenses M
    INNER JOIN informes_forenses ON M.id = I.fk_muestra_id WHERE M.id = ?, ORDER BY M.ID;