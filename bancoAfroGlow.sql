CREATE DATABASE bdAfroGlow;
USE bdAfroGlow;

CREATE TABLE planoUsuario(
	 idPlanoUsuario INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     statusPagamento VARCHAR(30) NOT NULL,
     idUsuario INT(11) UNIQUE NOT NULL,
     idPlano INT(11) NOT NULL
);
CREATE TABLE planos(
	 idPlano INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     nomeDoPlano VARCHAR(15) NOT NULL,
     preco DOUBLE NOT NULL,
     duracao INT(2) NOT NULL,
     descricao VARCHAR(255) NOT NULL
);
CREATE TABLE usuarioCabelo(
	 idUsuarioCabelo INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     tipoDeCabelo VARCHAR(20) NOT NULL,
     curvaturaDoCabelo VARCHAR(20) NOT NULL,
     danoDoCabelo VARCHAR(20) NOT NULL,
     transicaoCapilar BOOLEAN NOT NULL,
     idDefinicaoDoCabelo INT(11) NOT NULL,
     idUsuario INT(11) UNIQUE NOT NULL
);
CREATE TABLE definicaoDoCabelo(
	 idDefinicaoDoCabelo INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
     definicao VARCHAR(80) NOT NULL
);
CREATE TABLE pagamento(
	 idPagamento INT(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
     `status` VARCHAR(25) NOT NULL,
     idUsuario INT(11) NOT NULL
);

CREATE TABLE administrador(
	 idAdmin INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     nomeAdmin VARCHAR(60) NOT NULL,
     senha VARCHAR(150) NOT NULL,
     dataDeNascimento DATE NOT NULL,
     email VARCHAR(120) NOT NULL
);

CREATE TABLE usuario(
	 idUsuario INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     idDefinicaoDoCabelo INT(11),
     idTipoDeUsuario INT(11) NOT NULL,
	 nomeCompleto VARCHAR(80) NOT NULL,
     nomeSocial VARCHAR(80) NOT NULL,
     dataDeNascimento DATE NOT NULL,
     genero VARCHAR(25) NOT NULL,
     email VARCHAR(130) NOT NULL,
     senha VARCHAR(160) NOT NULL,
	 telefone INTEGER(11) NOT NULL,
     cpf INT(11) NOT NULL,
     `status` VARCHAR(25)
);
 
CREATE TABLE tipoDeUsuario(
	 idTipoDeUsuario INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     descricao VARCHAR(255) NOT NULL
);

CREATE TABLE crianca(
	 idCrianca INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     idUsuario INT(11) NOT NULL,
     idDefinicaoDoCabelo INT(11) NOT NULL,
     nomeCompleto VARCHAR(80) NOT NULL,
     nomeFantasia VARCHAR(40) NOT NULL,
     dataDeNascimento DATE NOT NULL,
     `status` VARCHAR(25) NOT NULL
);

CREATE TABLE endereco(
	 idEndereco INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     idUsuario INT(11),
     idParceiro INT(11),
     rua VARCHAR(120) NOT NULL,
     numero INT(10) NOT NULL,
     bairro VARCHAR(40) NOT NULL,
     complemento VARCHAR (80) NOT NULL,
     cidade VARCHAR(40) NOT NULL,
     estado VARCHAR(40) NOT NULL,
     cep INT(8) NOT NULL
);

CREATE TABLE pedidosBox (
  idPedidoBox INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  idUsuario INT(11) NOT NULL,
  idBox INT(11) NOT NULL,
  idPagamento INT(11) 
);

CREATE TABLE box (
  idBox INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  tipoDeBox VARCHAR(50) NOT NULL,
  preco DOUBLE NOT NULL,
  qtdDeProdutos INT(2) NOT NULL
);

CREATE TABLE produtos (
  idProduto INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  tipoDeCabelo VARCHAR(100) NOT NULL,
  marca VARCHAR(100) NOT NULL,
  valor DOUBLE NOT NULL,
  idParceiro INT(11) NOT NULL,
  idBox INT(11) NOT NULL,
  idUsuarioCabelo INT(11) NOT NULL
);

CREATE TABLE perfumarias (
  idPerfumaria INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nomePerfumaria VARCHAR(80) NOT NULL,
  razaoSocial VARCHAR(255) NOT NULL,
  telefone INT(20) NOT NULL,
  idEndereco INT(11) NOT NULL,
  idParceiro INT(11) NOT NULL
);

CREATE TABLE parcerias (
  idParceiro INT(11) AUTO_INCREMENT PRIMARY KEY NOT NULL,
  nomeColab VARCHAR(80) NOT NULL,
  idEndereco INT(11) NOT NULL,
  telefone INT(20) NOT NULL,
  cnpj INT(18) NOT NULL,
  `status` INT(12) NOT NULL,
  marcaDoProduto VARCHAR(80) NOT NULL,
  tipoDeParceria VARCHAR(40) NOT NULL,
  validadeDeContrato VARCHAR(40) NOT NULL
);

ALTER TABLE parcerias
ADD FOREIGN KEY (idEndereco) REFERENCES endereco(idEndereco);

ALTER TABLE perfumarias
ADD FOREIGN KEY (idEndereco) REFERENCES endereco(idEndereco),
ADD FOREIGN KEY (idParceiro) REFERENCES parcerias(idParceiro);

ALTER TABLE produtos
ADD FOREIGN KEY (idParceiro) REFERENCES parcerias(idParceiro),
ADD FOREIGN KEY (idBox) REFERENCES box(idBox),
ADD FOREIGN KEY (idUsuarioCabelo) REFERENCES usuarioCabelo(idUsuarioCabelo);
 
ALTER TABLE pedidosBox
ADD FOREIGN KEY (idBox) REFERENCES box(idBox),
ADD FOREIGN KEY (idPagamento) REFERENCES pagamento(idPagamento),
ADD FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario);

ALTER TABLE usuario 
ADD FOREIGN KEY (idDefinicaoDoCabelo) REFERENCES definicaoDoCabelo(idDefinicaoDoCabelo),
ADD FOREIGN KEY (idTipoDeUsuario) references tipodeusuario(idTipoDeUsuario);

ALTER TABLE crianca
ADD FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
ADD FOREIGN KEY (idDefinicaoDoCabelo) REFERENCES definicaoDoCabelo(idDefinicaoDoCabelo);

ALTER TABLE endereco
ADD FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
ADD FOREIGN KEY (idParceiro) REFERENCES parcerias(idParceiro);

ALTER TABLE planoUsuario
ADD FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
ADD FOREIGN KEY (idPlano) REFERENCES planos(idPlano); 

ALTER TABLE usuarioCabelo
ADD FOREIGN KEY (idUsuario) REFERENCES usuario(idUsuario),
ADD FOREIGN KEY (idDefinicaoDoCabelo) REFERENCES definicaoDoCabelo(idDefinicaoDoCabelo);

ALTER TABLE pagamento
ADD FOREIGN KEY (idUsuario) references usuario(idUsuario);