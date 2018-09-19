CREATE TABLE tb_estilo (
  id_estilo integer PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
  tx_nome   VARCHAR(30) NOT NULL
);

CREATE TABLE tb_cerveja (
  id_cerveja        integer PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
  tx_sku            VARCHAR(50)    NOT NULL,
  tx_nome           VARCHAR(80)    NOT NULL,
  tx_descricao      TEXT           NOT NULL,
  nr_valor          DECIMAL(10, 2) NOT NULL,
  nr_teor_alcoolico DECIMAL(10, 2) NOT NULL,
  nr_comissao       DECIMAL(10, 2) NOT NULL,
  tx_sabor          VARCHAR(50)    NOT NULL,
  tx_origem         VARCHAR(50)    NOT NULL,
  id_estilo         integer        NOT NULL
);




ALTER TABLE tb_cerveja
  ADD CONSTRAINT tb_cerveja_fk_id_estilo FOREIGN KEY (id_estilo) REFERENCES tb_estilo (id_estilo) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO tb_estilo (tx_nome)
VALUES ('Amber Lager');
INSERT INTO tb_estilo (tx_nome)
VALUES ('Dark Lager');
INSERT INTO tb_estilo (tx_nome)
VALUES ('Pale Lager');
INSERT INTO tb_estilo (tx_nome)
VALUES ('Pilsner');
