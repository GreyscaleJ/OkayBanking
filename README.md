# OkayBanking
 Hands-on JSF 1.2 + RichFaces 3; SOAP/REST; JDBC.
 
### Два слова о состоянии.
Реализованы SOAP и REST интерфейсы.

Фронтовая часть, в установленное время выполнения задания - не реализована в связи с возникшими проблемами совместимости компонентов.
За изучением теоретической части фронта, оставил себе мало времени на реализацию тестового. =)
### Для запуска требуется:
1. Java 1.6
2. Tomcat 6+
3. PostgreSQL
4. Gradle

### Подготовка окружения:
1. В *дефолтной схеме* Postgre создать таблицы:
  * `create table clients
(
  client_id varchar(99) not null,
  ident_code bigint not null,
  surname varchar(99),
  first_name varchar(99),
  fathers_name varchar(99),
  birth_date timestamp,
  nation varchar(99),
  city varchar(99),
  phone varchar(99),
  client_status varchar(99)
);
create unique index clients_client_id_uindex
  on clients (client_id);
create unique index clients_ident_code_uindex
  on clients (ident_code);
alter table clients
  add constraint clients_pk
    primary key (client_id);`
    
  * `create table accounts
(
  account_id varchar(99) not null
    constraint accounts_pk
      primary key,
  account_num int not null,
  balance int not null,
  currency_id int not null,
  account_status varchar(15) not null,
  client_id int not null
);`

* `create table cards
(
  card_id varchar(99) not null,
  card_num int not null,
  exp_date varchar(5) not null,
  cardholder_name varchar(99),
  card_status varchar(99),
  client_id varchar(99) not null
);
create unique index cards_card_id_uindex
  on cards (card_id);
create unique index cards_card_num_uindex
  on cards (card_num);
alter table cards
  add constraint cards_pk
    primary key (card_id);`
2. В Tomcat прописать JNDI DataSource:
  * `<Resource name="jdbc/okayBankingDataSource"
            auth="Container"
            type="javax.sql.DataSource"
            username="dbusername"
            password="dbpassword"
            driverClassName="org.postgresql.Driver"
            url="адрес_базы"
            maxActive="8"
            maxIdle="4"/>`
### Сборка проекта: 
(находясь в папке проекта)

`gradle build`

### Логирование
{tomcat_home}/logs/okayBanking.log

### УРЛы
  *WSDL link: {host:port}/OkayBanking/soap/cardsSOAPInterface.wsdl*

  *REST link: {host:port}/OkayBanking/rest/getAllCardsByClientId?client_id=00000000-0000-0000-0000-000000000000*
