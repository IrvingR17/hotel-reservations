CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  firstname VARCHAR(15) NOT NULL,
  lastname VARCHAR(15) NOT NULL,
  username VARCHAR(10) UNIQUE NOT NULL,
  email VARCHAR(25) UNIQUE NOT NULL,
  password VARCHAR(150),
  roles VARCHAR(10)
  -- roleid INT NOT NULL,
  -- active BOOLEAN NOT NULL DEFAULT '1'
);

-- CREATE TABLE role (
--   id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
--   rolename VARCHAR(15) UNIQUE NOT NULL,
--   description VARCHAR(50) NOT NULL
-- );

-- insert  into role (rolename, description)
-- VALUES ('superAdmin', 'Super Admin'),
--        ('admin', 'Administrador'),
--        ('user', 'User');

insert  into users (firstname, lastname, username, email, password, roles)
VALUES ('Irving', 'Rios', 'admin', 'a000000@myhotel.com', '$2a$10$yvYz6NvBTSa6gm0WZt8O/esZgTIsjB0wwYiOeSuRKoO4aky10DNhm', 'ADMIN');