CREATE DATABASE acolhimento
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'en_US.utf8'
       LC_CTYPE = 'en_US.utf8'
       CONNECTION LIMIT = -1;

\c acolhimento

CREATE TABLE public.queixa_clinica (
                id SERIAL NOT NULL,
                descricao VARCHAR(100) NOT NULL,
                CONSTRAINT pk_id_queixa_clinica PRIMARY KEY (id)
);

CREATE TABLE public.renovacao_receita (
                id SERIAL NOT NULL,
                descricao VARCHAR(255) NOT NULL,
                CONSTRAINT pk_id_renovacao_receita PRIMARY KEY (id)
);


CREATE TABLE public.resultad_exame (
                id SERIAL NOT NULL,
                descricao VARCHAR(255) NOT NULL,
                CONSTRAINT pk_id_resultado_exame PRIMARY KEY (id)
);


CREATE TABLE public.motivo (
                id SERIAL NOT NULL,
                descricao VARCHAR(200) NOT NULL,
                CONSTRAINT pk_id_motivo PRIMARY KEY (id)
);

CREATE TABLE public.paciente (
                id SERIAL NOT NULL,
                nome VARCHAR(100) NOT NULL,
                data_nascimento DATE NOT NULL,
                sexo VARCHAR(1) NOT NULL,
                CONSTRAINT pk_id_paciente PRIMARY KEY (id)
);
COMMENT ON COLUMN public.paciente.sexo IS '[M/F] -> Masculino/Feminino';

CREATE TABLE public.grupo_usuario (
                id SERIAL NOT NULL,
                nome VARCHAR(100),
                CONSTRAINT pk_id_grupo_usuario PRIMARY KEY (id)
);

CREATE TABLE public.equipe (
                id_equipe SERIAL,
                nome VARCHAR(100) NOT NULL,
                CONSTRAINT pk_id_equipe PRIMARY KEY (id_equipe)
);

CREATE TABLE public.usuario (
                id SERIAL NOT NULL,
                id_grupo_usuario INTEGER NOT NULL,
                id_equipe INTEGER NOT NULL,
                cpf VARCHAR(11) NOT NULL,
                nome NVARCHAR(200) NOT NULL,
                senha VARCHAR(50) NOT NULL,
                CONSTRAINT pk_id_usuario PRIMARY KEY (id)
);

CREATE TABLE public.visita (
                id SERIAL NOT NULL,
                id_usuario INTEGER NOT NULL,
                id_paciente INTEGER NOT NULL,
                id_motivo INTEGER NOT NULL,
                id_resultado_exame INTEGER NOT NULL,
                outro_resultado_exame VARCHAR(255) NOT NULL,
                id_renovacao_receita INTEGER NOT NULL,
                outra_renovacao_receita VARCHAR(255) NOT NULL,
                id_queixa_clinica INTEGER NOT NULL,
                outra_queixa_clinica VARCHAR(255) NOT NULL,
                data_hora TIMESTAMP NOT NULL,
                observacao VARCHAR(255) NOT NULL,
                id_equipe INTEGER NOT NULL,
                CONSTRAINT pk_id_visita PRIMARY KEY (id)
);

CREATE TABLE public.historico_movimento_unidade (
                id SERIAL NOT NULL,
                id_visita INTEGER NOT NULL,
                id_equipe_anterior INTEGER NOT NULL,
                id_equipe_atual INTEGER NOT NULL,
                data_hora TIMESTAMP NOT NULL,
                CONSTRAINT pk_id_historico_movimento_unidade PRIMARY KEY (id)
);


ALTER TABLE public.visita ADD CONSTRAINT queixa_clinica_visita_fk
FOREIGN KEY (id_queixa_clinica)
REFERENCES public.queixa_clinica (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT renovacao_receita_visita_fk
FOREIGN KEY (id_renovacao_receita)
REFERENCES public.renovacao_receita (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT resultad_exame_visita_fk
FOREIGN KEY (id_resultado_exame)
REFERENCES public.resultad_exame (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT fk_id_motivo
FOREIGN KEY (id_motivo)
REFERENCES public.motivo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT fk_id_paciente
FOREIGN KEY (id_paciente)
REFERENCES public.paciente (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT fk_id_grupo_usuario
FOREIGN KEY (id_grupo_usuario)
REFERENCES public.grupo_usuario (id)
ON DELETE RESTRICT
ON UPDATE RESTRICT
NOT DEFERRABLE;

ALTER TABLE public.usuario ADD CONSTRAINT equipe_usuario_fk
FOREIGN KEY (id_equipe)
REFERENCES public.equipe (id_equipe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.historico_movimento_unidade ADD CONSTRAINT equipe_historico_movimento_unidade_fk
FOREIGN KEY (id_equipe_anterior)
REFERENCES public.equipe (id_equipe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.historico_movimento_unidade ADD CONSTRAINT equipe_historico_movimento_unidade_fk1
FOREIGN KEY (id_equipe_atual)
REFERENCES public.equipe (id_equipe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT equipe_visita_fk
FOREIGN KEY (id_equipe)
REFERENCES public.equipe (id_equipe)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.visita ADD CONSTRAINT fk_id_usuario
FOREIGN KEY (id_usuario)
REFERENCES public.usuario (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.historico_movimento_unidade ADD CONSTRAINT visita_historico_movimento_unidade_fk
FOREIGN KEY (id_visita)
REFERENCES public.visita (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;