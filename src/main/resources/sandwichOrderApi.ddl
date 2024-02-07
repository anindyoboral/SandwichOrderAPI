-- auto-generated definition
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