CREATE TABLE usuarios (
    id               INTEGER      PRIMARY KEY AUTOINCREMENT,
    nomUsuario       VARCHAR(20)  NOT NULL UNIQUE,
    contraseña       VARCHAR(200) NOT NULL,
);