create table almuerzo (
  id               numeric(1000, 0) not null, 
  id_pedido        numeric(1000, 0) not null, 
  id_menuSemana    numeric(10, 0) not null, 
  id_hijo          numeric(10, 0) not null, 
  estado           int4, 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column almuerzo.id is 'identificador unico del registro';
comment on column almuerzo.id_pedido is 'identificador del pedido';
comment on column almuerzo.id_menuSemana is 'identificador unico del menu de la semana';
comment on column almuerzo.id_hijo is 'identificador del hijo';
comment on column almuerzo.estado is 'estado si el almuerzo fue consumido o no por el niño

1 -> pendiente
2 -> consumido';
comment on column almuerzo.usuario_creacion is 'usuario que crea el registro';
comment on column almuerzo.fecha_creacion is 'fecha en que se crea el registro';
comment on column almuerzo.usuario_modifica is 'usuario que modifica el registro';
comment on column almuerzo.fecha_modifica is 'fecha en que se modifica el registro';
create table bebida (
  id               numeric(19, 0) not null, 
  nombre           varchar(200), 
  descripcion      varchar(400), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on table bebida is 'identificador de la bebida';
comment on column bebida.id is 'identificador de la bebida';
comment on column bebida.nombre is 'nombre de la bebida';
comment on column bebida.descripcion is 'descripcion de la bebida';
comment on column bebida.usuario_creacion is 'usuario que crea el registro';
comment on column bebida.fecha_creacion is 'fecha en que se crea el registro';
comment on column bebida.usuario_modifica is 'usuario que modifica el registro';
comment on column bebida.fecha_modifica is 'fecha en que se modifica el registro';
create table hijo (
  id               numeric(10, 0) not null, 
  id_usuario       numeric(10, 0) not null, 
  id_padre         numeric(10, 0), 
  fecha_nacimiento date, 
  curso            varchar(300), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column hijo.id is 'identificador unico del registro';
comment on column hijo.id_usuario is 'identificador de usuario';
comment on column hijo.id_padre is 'Identificador del padre';
comment on column hijo.fecha_nacimiento is 'fecha de nacimiento';
comment on column hijo.curso is 'curso en el que se encuentra el niño';
comment on column hijo.usuario_creacion is 'usuario que crea el registro';
comment on column hijo.fecha_creacion is 'fecha en que se crea el registro';
comment on column hijo.usuario_modifica is 'usuario que modifica el registro';
comment on column hijo.fecha_modifica is 'fecha en que se modifica el registro';
create table menu_semana (
  id               numeric(10, 0) not null, 
  dia              varchar(20), 
  id_principio     numeric(19, 0) not null, 
  id_proteina      numeric(19, 0) not null, 
  id_bebida        int4, 
  id_sopa          numeric(19, 0) not null, 
  estado           varchar(1), 
  fecha_inicio     date, 
  fecha_fin        date, 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column menu_semana.id is 'identificador unico';
comment on column menu_semana.dia is 'dia de la semana';
comment on column menu_semana.id_principio is 'identificador de principio';
comment on column menu_semana.id_proteina is 'identificador de proteina';
comment on column menu_semana.id_bebida is 'identificador de bebida';
comment on column menu_semana.id_sopa is 'identificador de sopa';
comment on column menu_semana.estado is 'estado del menu del dia

A -> activo
I -> inactivo';
comment on column menu_semana.fecha_inicio is 'fecha de disponibilidad del menu';
comment on column menu_semana.fecha_fin is 'fecha de fin de disponibilidad del pedido';
comment on column menu_semana.usuario_creacion is 'usuario que crea el registro';
comment on column menu_semana.fecha_creacion is 'fecha en que se crea el registro';
comment on column menu_semana.usuario_modifica is 'usuario que modifica el registro';
comment on column menu_semana.fecha_modifica is 'fecha en que se modifica el registro';
create table padre (
  id               numeric(10, 0) not null, 
  id_usuario       numeric(10, 0) not null, 
  telefono         varchar(15), 
  direccion        varchar(400), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column padre.id is 'identificador unico';
comment on column padre.id_usuario is 'identificador de usuario';
comment on column padre.telefono is 'numero telefonocio o celular a donde se pueda localizar el padre';
comment on column padre.direccion is 'direccion donde recide';
comment on column padre.usuario_creacion is 'usuario que crea el registro';
comment on column padre.fecha_creacion is 'fecha en que se crea el registro';
comment on column padre.usuario_modifica is 'usuario que modifica el registro';
comment on column padre.fecha_modifica is 'fecha en que se modifica el registro';
create table pago (
  id               numeric(1000, 0) not null, 
  detalle          varchar(300), 
  valor            numeric(17, 0), 
  estado           int4, 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column pago.id is 'identificador del registro';
comment on column pago.detalle is 'detalle del pago';
comment on column pago.valor is 'valor total a pagar';
comment on column pago.estado is 'estado del pago
1 -> generado
2 -> pagado';
comment on column pago.usuario_creacion is 'usuario que crea el registro';
comment on column pago.fecha_creacion is 'fecha en que se crea el registro';
comment on column pago.usuario_modifica is 'usuario que modifica el registro';
comment on column pago.fecha_modifica is 'fecha en que se modifica el registro';
create table parametros (
  id               numeric(10, 0) not null, 
  nombre           varchar(200), 
  valor            varchar(200), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column parametros.id is 'identificador unico';
comment on column parametros.nombre is 'nombre del parametro';
comment on column parametros.valor is 'valor del parametro';
comment on column parametros.usuario_creacion is 'usuario que crea el registro';
comment on column parametros.fecha_creacion is 'fecha en que se crea el registro';
comment on column parametros.usuario_modifica is 'usuario que modifica el registro';
comment on column parametros.fecha_modifica is 'fecha en que se modifica el registro';
create table pedido (
  id               numeric(1000, 0) not null, 
  id_padre         numeric(10, 0) not null, 
  id_almuerzo      numeric(10, 0), 
  fecha_pedido     date, 
  fecha_entrega    date, 
  estado           int4, 
  cant_almuerzos   int4, 
  id_pago          numeric(1000, 0) not null, 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column pedido.id is 'identificador del registro';
comment on column pedido.id_padre is 'identificador del padre';
comment on column pedido.id_almuerzo is 'identificador del almuerzo';
comment on column pedido.fecha_pedido is 'fecha en que se hace el pedido';
comment on column pedido.fecha_entrega is 'fecha en que se entrega el pedido';
comment on column pedido.estado is 'estado en que se encuentra el pedido
1 = pendiente de pago
2 = pagado';
comment on column pedido.cant_almuerzos is 'cantidad de almuerzos pedidos';
comment on column pedido.id_pago is 'identificador del pago';
comment on column pedido.usuario_creacion is 'usuario que crea el registro';
comment on column pedido.fecha_creacion is 'fecha en que se crea el registro';
comment on column pedido.usuario_modifica is 'usuario que modifica el registro';
comment on column pedido.fecha_modifica is 'fecha en que se modifica el registro';
create table principio (
  id               numeric(19, 0) not null, 
  nombre           varchar(200), 
  descripcion      varchar(400), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column principio.id is 'idnetificador de principio';
comment on column principio.nombre is 'nombre del principio';
comment on column principio.descripcion is 'descripcion del principio';
comment on column principio.usuario_creacion is 'usuario que crea el registro';
comment on column principio.fecha_creacion is 'fecha en que se crea el registro';
comment on column principio.usuario_modifica is 'usuario que modifica el registro';
comment on column principio.fecha_modifica is 'fecha en que se modifica el registro';
create table proteina (
  id               numeric(19, 0) not null, 
  nombre           varchar(200), 
  descripcion      varchar(400), 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column proteina.id is 'identificdor de proteina';
comment on column proteina.nombre is 'nombre de la proteina';
comment on column proteina.descripcion is 'pequeña descripcion de la proteina';
comment on column proteina.usuario_creacion is 'usuario que crea el registro';
comment on column proteina.fecha_creacion is 'fecha en que se crea el registro';
comment on column proteina.usuario_modifica is 'usuario que modifica el registro';
comment on column proteina.fecha_modifica is 'fecha en que se modifica el registro';
create table sopa (
  id               numeric(19, 0) not null, 
  nombre           varchar(200), 
  descripcion      bytea, 
  usuario_creacion varchar(100), 
  fecha_creacion   date, 
  usuario_modifica varchar(100), 
  fecha_modifica   date, 
  primary key (id));
comment on column sopa.id is 'identificador unico de sopa';
comment on column sopa.nombre is 'nombre de la sopa';
comment on column sopa.descripcion is 'descripcion de la sopa';
comment on column sopa.usuario_creacion is 'usuario que crea el registro';
comment on column sopa.fecha_creacion is 'fecha en que se crea el registro';
comment on column sopa.usuario_modifica is 'usuario que modifica el registro';
comment on column sopa.fecha_modifica is 'fecha en que se modifica el registro';
create table usuario (
  id                  numeric(10, 0) not null, 
  primer_nombre       varchar(200), 
  segundo_nombre      varchar(200), 
  primer_apellido     varchar(200), 
  segundo_apellido    varchar(200), 
  num_identificacion  numeric(17, 0), 
  tipo_identificacion int4, 
  rol                 int4, 
  usuario_creacion    varchar(100), 
  fecha_creacion      date, 
  usuario_modifica    varchar(100), 
  fecha_modifica      date, 
  primary key (id));
comment on column usuario.id is 'identificador unico del usuario';
comment on column usuario.primer_nombre is 'primer nombre';
comment on column usuario.segundo_nombre is 'segundo nombre';
comment on column usuario.primer_apellido is 'primer apellido';
comment on column usuario.segundo_apellido is 'segundo apellido';
comment on column usuario.num_identificacion is 'numero de identificacion';
comment on column usuario.tipo_identificacion is 'tipo de identificacion
1 = tarjeta de identidad
2 = registro civil
3 = cedula de ciudania';
comment on column usuario.rol is 'rol que tiene el usuario en el sistema
1-> administrador
2-> cliente';
comment on column usuario.usuario_creacion is 'usuario que crea el registro';
comment on column usuario.fecha_creacion is 'fecha en que se crea el registro';
comment on column usuario.usuario_modifica is 'usuario que modifica el registro';
comment on column usuario.fecha_modifica is 'fecha en que se modifica el registro';
alter table hijo add constraint FKhijo129434 foreign key (id_usuario) references usuario (id);
alter table almuerzo add constraint FKalmuerzo524568 foreign key (id_hijo) references hijo (id);
alter table pedido add constraint FKpedido982285 foreign key (id_pago) references pago (id);
alter table almuerzo add constraint FKalmuerzo164663 foreign key (id_menuSemana) references menu_semana (id);
alter table menu_semana add constraint FKmenu_seman915116 foreign key (id_sopa) references bebida (id);
alter table menu_semana add constraint FKmenu_seman507615 foreign key (id_sopa) references sopa (id);
alter table menu_semana add constraint FKmenu_seman591943 foreign key (id_principio) references principio (id);
alter table menu_semana add constraint FKmenu_seman894586 foreign key (id_proteina) references proteina (id);
alter table almuerzo add constraint FKalmuerzo816495 foreign key (id_pedido) references pedido (id);
alter table padre add constraint "es un" foreign key (id_usuario) references usuario (id);
alter table pedido add constraint realiza foreign key (id_padre) references padre (id);
alter table hijo add constraint tiene foreign key (id_padre) references padre (id);


-- DROP
/*
alter table hijo drop constraint FKhijo129434;
alter table almuerzo drop constraint FKalmuerzo524568;
alter table pedido drop constraint FKpedido982285;
alter table almuerzo drop constraint FKalmuerzo164663;
alter table menu_semana drop constraint FKmenu_seman915116;
alter table menu_semana drop constraint FKmenu_seman507615;
alter table menu_semana drop constraint FKmenu_seman591943;
alter table menu_semana drop constraint FKmenu_seman894586;
alter table almuerzo drop constraint FKalmuerzo816495;
alter table padre drop constraint "es un";
alter table pedido drop constraint realiza;
alter table hijo drop constraint tiene;
drop table if exists almuerzo cascade;
drop table if exists bebida cascade;
drop table if exists hijo cascade;
drop table if exists menu_semana cascade;
drop table if exists padre cascade;
drop table if exists pago cascade;
drop table if exists parametros cascade;
drop table if exists pedido cascade;
drop table if exists principio cascade;
drop table if exists proteina cascade;
drop table if exists sopa cascade;
drop table if exists usuario cascade;

*/

