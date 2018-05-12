
-- DML

-- Insert de administrador con secuensias
insert into usuario(id,primer_nombre,primer_apellido,segundo_apellido,num_identificacion,tipo_identificacion,rol ) values(nextval('seq_usuario'),'alejandro','kuratomi','nakamura',1113648236,3,1);

-- Insert de administrador sin sencuencias
-- insert into usuario(id,primer_nombre,primer_apellido,segundo_apellido,num_identificacion,tipo_identificacion,rol ) values(1,'alejandro','kuratomi','nakamura',1113648236,3,1);


-- INSERT DE PRODUCTOS 

-- PRINCIPIO
INSERT INTO principio(id, nombre, descripcion, estado, usuario_creacion, fecha_creacion) VALUES
	(nextval('seq_principio'), 'PRINCIPIO_1', 'PRINCIPIO', 'A', 'TAKURATOMI', CURRENT_DATE),
 	(nextval('seq_principio'), 'PRINCIPIO_2', 'PRINCIPIO', 'A', 'TAKURATOMI', CURRENT_DATE),
 	(nextval('seq_principio'), 'PRINCIPIO_3', 'PRINCIPIO', 'A', 'TAKURATOMI', CURRENT_DATE);
-- BEBIBDA
INSERT INTO bebida(id, nombre, descripcion, estado, usuario_creacion, fecha_creacion) VALUES
	(nextval('seq_bebida'), 'BEBIDA_1', 'BEBIDA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_bebida'), 'BEBIDA_2', 'BEBIDA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_bebida'), 'BEBIDA_3', 'BEBIDA', 'A', 'TAKURATOMI', CURRENT_DATE);
-- PROTEINA
INSERT INTO proteina(id, nombre, descripcion, estado, usuario_creacion, fecha_creacion) VALUES
	(nextval('seq_proteina'), 'PROTEINA_1', 'PROTEINA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_proteina'), 'PROTEINA_2', 'PROTEINA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_proteina'), 'PROTEINA_3', 'PROTEINA', 'A', 'TAKURATOMI', CURRENT_DATE);
-- SOPA
INSERT INTO sopa(id, nombre, descripcion, estado, usuario_creacion, fecha_creacion) VALUES
	(nextval('seq_sopa'), 'SOPA_1', 'SOPA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_sopa'), 'SOPA_2', 'SOPA', 'A', 'TAKURATOMI', CURRENT_DATE),
	(nextval('seq_sopa'), 'SOPA_3', 'SOPA', 'A', 'TAKURATOMI', CURRENT_DATE);



















