create table ABISCOURSES
(
    ID    NUMBER(30) not null,
    TITLE VARCHAR2(100)
)
    /

create unique index ABISCOURSES_ID_UINDEX
    on ABISCOURSES (ID)
    /

alter table ABISCOURSES
    add constraint ABISCOURSES_PK
        primary key (ID)
    /

create table ABISPERSONS
(
    PERSONID  NUMBER       not null
        primary key,
    FIRSTNAME VARCHAR2(50) not null,
    LASTNAME  VARCHAR2(50) not null
)
    /

create table SANDWICHORDERS
(
    LOCALDATE DATE,
    COURSE    NUMBER
        references ABISCOURSES,
    ID        NUMBER not null
        constraint SANDWICHORDERS_PK
            primary key
)
    /

create table SANDWICHORDERDETAILS
(
    AMOUNT        NUMBER,
    BREADTYPE     VARCHAR2(100),
    VEGETABLES    VARCHAR2(100),
    "COMMENT"     VARCHAR2(1000),
    PERSON        NUMBER
        constraint PERSON
            references ABISPERSONS,
    SANDWICHORDER NUMBER
        constraint SANDWICHORDER
            references SANDWICHORDERS,
    ID            NUMBER not null
        constraint SANDWICHORDERDETAILS_PK
            primary key
)
    /
