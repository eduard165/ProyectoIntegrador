-- Creación de la tabla Direccion
CREATE TABLE Direccion (
    idDireccion INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(255) NOT NULL,
    numero INT NOT NULL,
    codigoPostal VARCHAR(10),
    colonia VARCHAR(100),
    ciudad VARCHAR(100)
);

-- Creación de la tabla Empresa
CREATE TABLE Empresa (
    RFC VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    nombreComercial VARCHAR(255),
    logo VARCHAR(255),
    representanteLegal VARCHAR(255),
    email VARCHAR(100),
    telefono VARCHAR(20),
    paginaWeb VARCHAR(255),
    estatusID INT,
    direccionID INT NOT NULL,
    FOREIGN KEY (estatusID) REFERENCES Estatus(idEstatus),
    FOREIGN KEY (direccionID) REFERENCES Direccion(idDireccion)
);

-- Creación de la tabla Promocion
CREATE TABLE Promocion (
    idPromocion INT PRIMARY KEY AUTO_INCREMENT,
    nombrePromocion VARCHAR(255) NOT NULL,
    descripcion TEXT,
    imagen VARCHAR(255),
    fechaInicio DATE,
    fechaTermino DATE,
    restricciones TEXT,
    tipoPromocionID INT,
    porcentajeDescuento DECIMAL(5, 2),
    codigoPromocion VARCHAR(8) UNIQUE,
    estatusID INT,
    empresaRFC VARCHAR(20) NOT NULL,
    FOREIGN KEY (tipoPromocionID) REFERENCES TipoPromocion(idTipoPromocion),
    FOREIGN KEY (estatusID) REFERENCES Estatus(idEstatus),
    FOREIGN KEY (empresaRFC) REFERENCES Empresa(RFC)
);

-- Creación de la tabla Sucursal
CREATE TABLE Sucursal (
    idSucursal INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    codigoPostal VARCHAR(10),
    telefono VARCHAR(20),
    latitud DECIMAL(10, 8),
    longitud DECIMAL(11, 8),
    nombreEncargado VARCHAR(255),
    empresaRFC VARCHAR(20) NOT NULL,
    direccionID INT NOT NULL,
    FOREIGN KEY (empresaRFC) REFERENCES Empresa(RFC),
    FOREIGN KEY (direccionID) REFERENCES Direccion(idDireccion)
);

-- Creación de la tabla TipoPromocion
CREATE TABLE TipoPromocion (
    idTipoPromocion INT PRIMARY KEY AUTO_INCREMENT,
    nombreTipo VARCHAR(50) NOT NULL
);

INSERT INTO TipoPromocion (nombreTipo) VALUES ('descuento'), ('costo rebajado');

-- Creación de la tabla Estatus
CREATE TABLE Estatus (
    idEstatus INT PRIMARY KEY AUTO_INCREMENT,
    nombreEstatus VARCHAR(50) NOT NULL
);

INSERT INTO Estatus (nombreEstatus) VALUES ('activo'), ('inactivo');

-- Creación de la tabla Sucursal_Promocion
CREATE TABLE Sucursal_Promocion (
    idSucursalPromocion INT PRIMARY KEY AUTO_INCREMENT,
    sucursalID INT,
    promocionID INT,
    FOREIGN KEY (sucursalID) REFERENCES Sucursal(idSucursal),
    FOREIGN KEY (promocionID) REFERENCES Promocion(idPromocion)
);

-- Creación de la tabla Cupon
CREATE TABLE Cupon (
    idCupon INT PRIMARY KEY AUTO_INCREMENT,
    codigoCupon VARCHAR(8) UNIQUE NOT NULL,
    promocionID INT NOT NULL,
    fechaGeneracion DATE,
    estatusID INT,
    FOREIGN KEY (promocionID) REFERENCES Promocion(idPromocion),
    FOREIGN KEY (estatusID) REFERENCES Estatus(idEstatus)
);

-- Creación de la tabla Rol
CREATE TABLE Rol (
    idRol INT PRIMARY KEY AUTO_INCREMENT,
    nombreRol VARCHAR(50) NOT NULL
);

INSERT INTO Rol (nombreRol) VALUES 
    ('Administrador general'), 
    ('Administrador comercial');

-- Creación de la tabla Usuario
CREATE TABLE Usuario (
    idUsuario INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    CURP VARCHAR(18) UNIQUE,
    correoElectronico VARCHAR(100) UNIQUE,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255),
    rolID INT,
    empresaRFC VARCHAR(20) NOT NULL,
    FOREIGN KEY (rolID) REFERENCES Rol(idRol),
    FOREIGN KEY (empresaRFC) REFERENCES Empresa(RFC)
);

-- Creación de la tabla Cliente
CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    apellidoPaterno VARCHAR(100),
    apellidoMaterno VARCHAR(100),
    telefono VARCHAR(20),
    correoElectronico VARCHAR(100) UNIQUE,
    direccionID INT NOT NULL,
    fechaNacimiento DATE,
    password VARCHAR(255),
    FOREIGN KEY (direccionID) REFERENCES Direccion(idDireccion)
);
