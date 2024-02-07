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


create table sandwichorders(

                               localdate date,
                               course number references abiscourses(id )
)

create table sandwichorder (
                               amount number,
                               breadtype varchar2(20),
                               vegetables boolean,
                               comment varchar2(200),
                               person references ABISPERSONS(personid),
                               sandwichorder references SANDWICHORDERS(id)

)