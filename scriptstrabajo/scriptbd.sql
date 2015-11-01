CREATE TABLE sys_menuprin
(
  men_id integer NOT NULL,
  men_nombre character varying(250),
  men_desc text,
  men_est boolean DEFAULT true,
  indversion integer DEFAULT 1,
  men_orden integer,
  CONSTRAINT sys_menuprin_pkey PRIMARY KEY (men_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_menuprin
  OWNER TO auditoria;


  -- Table: sys_modulos

-- DROP TABLE sys_modulos;

CREATE TABLE sys_modulos
(
  proc_id integer NOT NULL,
  proc_nombre character varying(250),
  proc_desc text,
  men_id integer,
  proc_estado boolean,
  indversion integer,
  CONSTRAINT sys_modproc_pkey PRIMARY KEY (proc_id),
  CONSTRAINT fk_sys_modulos_men_id FOREIGN KEY (men_id)
      REFERENCES sys_menuprin (men_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_modulos
  OWNER TO auditoria;


  -- Table: sys_rol

-- DROP TABLE sys_rol;

CREATE TABLE sys_rol
(
  rol_id integer NOT NULL,
  rol_nombre character varying(250),
  rol_desc text,
  rol_estado boolean,
  CONSTRAINT sys_roles_pkey PRIMARY KEY (rol_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_rol
  OWNER TO auditoria;


-- Table: sys_funcionario

-- DROP TABLE sys_funcionario;

CREATE TABLE sys_funcionario
(
  frn_id character varying(50) NOT NULL,
  frn_nombre character varying(250),
  frn_apellido character varying(250),
  frn_usuario character varying(100),
  frn_clave character varying(2000),
  frn_estado boolean,
  indversion integer,
  rol_id integer,
  CONSTRAINT sys_funcionario_pkey PRIMARY KEY (frn_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_funcionario
  OWNER TO auditoria;




-- Table: sys_rolxfrn

-- DROP TABLE sys_rolxfrn;

CREATE TABLE sys_rolxfrn
(
  rlfr_id serial NOT NULL,
  frn_id character varying(50),
  rol_id integer,
  rlfr_estado boolean,
  CONSTRAINT sys_rolxfrn_pkey PRIMARY KEY (rlfr_id),
  CONSTRAINT fk_sys_rolxfrn_frn_id FOREIGN KEY (frn_id)
      REFERENCES sys_funcionario (frn_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_sys_rolxfrn_rol_id FOREIGN KEY (rol_id)
      REFERENCES sys_rol (rol_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_rolxfrn
  OWNER TO auditoria;


-- Table: sys_submodulo

-- DROP TABLE sys_submodulo;

CREATE TABLE sys_submodulo
(
  sub_id integer NOT NULL,
  sub_nombre character varying(250),
  sub_desc text,
  proc_id integer,
  sub_reglanav character varying(150),
  sub_jsfbean character varying(150),
  sub_est boolean DEFAULT true,
  indversion integer DEFAULT 1,
  CONSTRAINT sys_submodulo_pkey PRIMARY KEY (sub_id),
  CONSTRAINT fk_sys_submodulo_proc_id FOREIGN KEY (proc_id)
      REFERENCES sys_modulos (proc_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_submodulo
  OWNER TO auditoria;


-- Table: sys_submodxfrn

-- DROP TABLE sys_submodxfrn;

CREATE TABLE sys_submodxfrn
(
  sbfr_id integer NOT NULL,
  frn_id character varying(50),
  sub_id integer,
  sbfr_estado boolean,
  CONSTRAINT sys_submodfrn_pkey PRIMARY KEY (sbfr_id),
  CONSTRAINT fk_sys_submodxfrn_sub_id FOREIGN KEY (sub_id)
      REFERENCES sys_submodulo (sub_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT sys_submodxfrn_frn_id_fkey FOREIGN KEY (frn_id)
      REFERENCES sys_funcionario (frn_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_submodxfrn
  OWNER TO auditoria;


-- Table: sys_submodxrol

-- DROP TABLE sys_submodxrol;

CREATE TABLE sys_submodxrol
(
  sbrl_id integer NOT NULL,
  sub_id integer,
  rol_id integer,
  sbrl_estado boolean,
  CONSTRAINT sys_submodxrol_pkey PRIMARY KEY (sbrl_id),
  CONSTRAINT fk_sys_submodxrol_rol_id FOREIGN KEY (rol_id)
      REFERENCES sys_rol (rol_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_sys_submodxrol_sub_id FOREIGN KEY (sub_id)
      REFERENCES sys_submodulo (sub_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sys_submodxrol
  OWNER TO auditoria;

 --
create table ref_color(
clr_id integer primary key,
clr_nombre varchar(100),
clr_desc  text,
clr_est boolean default true,
indversion integer default 1
);  

create table ref_talla(
tla_id integer primary key,
tla_nombre varchar(100),
tla_desc text,
tla_est boolean default true,
indversion integer default 1
);

create table ref_estilo(
est_id integer primary key,
est_nombre varchar(100),
est_desc text,
est_est boolean default true,
indversion integer default 1
);

create table ref_material(
mat_id integer primary key,
mat_nombre varchar(100),
mat_desc text,
mat_est boolean default true,
indversion integer default 1
);

create table prd_camiseta(
cam_id bigserial primary key,
clr_id integer,
tla_id integer,
est_id integer,
mat_id integer,
cam_est boolean default true,
indversion integer default 1
);
ALTER TABLE prd_camiseta add cam_precio numeric(16,2);

ALTER TABLE prd_camiseta
  ADD FOREIGN KEY (clr_id) REFERENCES ref_color (clr_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE prd_camiseta
  ADD FOREIGN KEY (est_id) REFERENCES ref_estilo (est_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE prd_camiseta
  ADD FOREIGN KEY (mat_id) REFERENCES ref_material (mat_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE prd_camiseta
  ADD FOREIGN KEY (tla_id) REFERENCES ref_talla (tla_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

create table prd_estampa(
etm_id bigserial primary key,
etm_nombre varchar(100),
etm_desc text,
etm_precio numeric(18,2),
etm_est boolean default true,
indversion integer default 1,
rlfr_id integer

);

ALTER TABLE prd_estampa
  ADD CONSTRAINT prd_estampa_rlfr_id_fkey FOREIGN KEY (rlfr_id)
      REFERENCES sys_rolxfrn (rlfr_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT;

create table prd_imagen(
img_id bigserial primary key,
img_nombre varchar(100),
img_desc text,
img_ruta varchar(800),
img_est boolean default true,
indversion integer default 1
);

create table prd_imgxest(
imxe_id bigserial primary key,
etm_id bigint,
img_id bigint,
imxe_est boolean default true,
indversion integer default 1

);
  
ALTER TABLE prd_imgxest
  ADD FOREIGN KEY (img_id) REFERENCES prd_imagen (img_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE prd_imgxest
  ADD FOREIGN KEY (etm_id) REFERENCES prd_estampa (etm_id) ON UPDATE RESTRICT ON DELETE RESTRICT;





create table vnt_factura(
fac_id bigserial primary key,
fac_fechacre timestamp with time zone,
fac_valorneto numeric(16,2),
fac_impuesto numeric(16,2),
fac_valortotal numeric(16,2),
fac_porcimp numeric(16,2),
fac_prefactura boolean default true,
indversion integer default 1,
rlfr_id integer

);

CONSTRAINT vnt_factura_rlfr_id_fkey FOREIGN KEY (rlfr_id)
      REFERENCES sys_rolxfrn (rlfr_id) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
      
create table vnt_detfactura(
detfac_id bigserial primary key ,
fac_id bigint,
cam_id bigint,
detfac_valor numeric(16,2),
detfac_textadd boolean default false,
detfac_valrtxtadd numeric(16,2),
indversion integer default 1
);

ALTER TABLE vnt_detfactura
  ADD FOREIGN KEY (fac_id) REFERENCES vnt_factura (fac_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

create table vnt_estxvn(
exv_id bigserial,
detfac_id  bigint,
etm_id bigint,
exv_valor numeric(16,2),
exv_est boolean default true,
indversion integer default 1
);


ALTER TABLE vnt_estxvn
  ADD PRIMARY KEY (exv_id);
ALTER TABLE vnt_estxvn
  ADD FOREIGN KEY (etm_id) REFERENCES prd_estampa (etm_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

create table sys_mediopago(
mdp_id integer primary key,
mdp_nombre varchar(100),
mdp_desc text,
mdp_est boolean default true
);

create table sys_detallefnr(
detf_id bigserial primary key,
detf_direccion text,
detf_direccion1 text,
detf_telefono varchar(50),
detf_pais varchar(100),
detf_ciudad varchar(100),
frn_id character varying(50),
mdp_id integer,
detf_mdpnumero bigint,
detf_mdpdigitver integer,
detf_est boolean default true,
indversion integer default 1

)  

ALTER TABLE sys_detallefnr
  ADD FOREIGN KEY (frn_id) REFERENCES sys_funcionario (frn_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE sys_detallefnr
  ADD FOREIGN KEY (mdp_id) REFERENCES sys_mediopago (mdp_id) ON UPDATE RESTRICT ON DELETE RESTRICT;

  

create table vnt_mdpxfact(
mdxf_id bigserial,
fac_id bigint,
detf_id bigint,
mdxf_valor numeric(16,2),
mdxf_est boolean default true,
indversion integer default 1
);


ALTER TABLE vnt_mdpxfact
  ADD PRIMARY KEY (mdxf_id);
ALTER TABLE vnt_mdpxfact
  ADD FOREIGN KEY (detf_id) REFERENCES sys_detallefnr (detf_id) ON UPDATE RESTRICT ON DELETE RESTRICT;
ALTER TABLE vnt_mdpxfact
  ADD FOREIGN KEY (fac_id) REFERENCES vnt_factura (fac_id) ON UPDATE RESTRICT ON DELETE RESTRICT;



