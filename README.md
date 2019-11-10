# Alugai

## Descrição 

Plataforma de aluguel e venda de imóveis.


## Configuração

- Configure o acesso ao Banco de Dados no arquivo **application.properties**:
```
spring.jpa.database=POSTGRESQL
spring.jpa.show-sql=false
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults = false
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL9Dialect


spring.datasource.url=jdbc:postgresql://localhost:5432/banco
spring.datasource.username=postgres
spring.datasource.password=senha
spring.datasource.driverClassName=org.postgresql.Driver
```
- E também no arquivo **resources/META-INF/persistence.xml**
```
<properties>
        <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL9Dialect"/>
        <property name="hibernate.hbm2ddl.auto" value="update"/>
        <property name="javax.persistence.jdbc.driver" value="org.postgresql.Driver"/>
        <property name="javax.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/banco"/>
        <property name="javax.persistence.jdbc.user" value="postgres"/>
        <property name="javax.persistence.jdbc.password" value="senha"/>
</properties>
```
Indicado utilizar a IDE [Spring Tool Suite](https://spring.io/tools3/sts/all).

## Autoria
Programa desenvolvido por Jaine Budke (< jainebudke@hotmail.com >) e Mayra Dantas (< mayradazevedo@gmail.com >), 2019.2
