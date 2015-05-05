Prácticas de Sistemas Telemáticos Avanzados
======================================
Grado Ing.Tecnología de Telecomunicación en ETSIB

Práctica 6
----------

Comandos MySQL para la creación del usuario, la base de datos y el usuario
privilegiado para ella.
```SQL
CREATE DATABASE STA;
CREATE USER 'sta' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON STA.* TO sta;
```

Instalación en Ubuntu del conector JDBC para MySQL.
```bash
sudo apt-get install libmysql-java
```
