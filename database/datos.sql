
DML

-- Insert de administrador
insert into usuario(id,
primer_nombre,
primer_apellido, 
segundo_apellido, 
num_identificacion, 
tipo_identificacion, 
rol ) values(select nextval('usuario_id_seq'),
'alejandro',
'kuratomi',
'nakamura',
1113648236,
3,
1);

