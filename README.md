Comandos para crear la base de datos
======================================
```SQL
CREATE DATABASE STA;
CREATE USER 'sta' IDENTIFIED BY '123';
GRANT ALL PRIVILEGES ON STA.* TO sta;
```

##Instalar el conector JDBC para MYSQl
```bash
sudo apt-get install libmysql-java
```