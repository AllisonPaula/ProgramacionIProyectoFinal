CREATE DATABASE hotel_db;
USE hotel_db;

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario VARCHAR(50) NOT NULL,
    contrasena VARCHAR(50) NOT NULL,
    tipo_usuario ENUM('Administrador', 'Corriente') NOT NULL
);
INSERT INTO usuarios (usuario, contrasena, tipo_usuario)
VALUES
    ('Juan', 'admin123', 'Administrador'),
	('Jose', 'admin1234', 'Administrador'),
    ('Ana', 'userpass1', 'Corriente'),
    ('Elisa', 'userpass', 'Corriente');
    
    CREATE TABLE Huesped (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(50) NOT NULL,
    Apellido VARCHAR(50) NOT NULL,
    Email VARCHAR(100) NOT NULL,
    Telefono VARCHAR(15) NOT NULL
);

CREATE TABLE Reserva (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    HuespedID INT NOT NULL,
    CantidadAdultos INT NOT NULL,
    CantidadNinos INT NOT NULL,
    TipoHabitacion VARCHAR(50) NOT NULL,
    PreferenciasEspeciales VARCHAR(100),
    CheckIn DATE NOT NULL,
    CheckOut DATE NOT NULL,
    FOREIGN KEY (HuespedID) REFERENCES Huesped(ID)
);

CREATE TABLE Pago (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    ReservaID INT NOT NULL,
    NumeroTarjeta VARCHAR(25) NOT NULL,
    MesVencimiento VARCHAR(10) NOT NULL,
    AnioVencimiento VARCHAR(10) NOT NULL,
    FOREIGN KEY (ReservaID) REFERENCES Reserva(ID)
);
