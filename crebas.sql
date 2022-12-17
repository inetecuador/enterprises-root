/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     16/12/2022 20:39:25                          */
/*==============================================================*/


drop table DEPARTMENTS;

drop table DEPARTMENTS_EMPLOYEES;

drop table EMPLOYEES;

drop table ENTERPRISES;

/*==============================================================*/
/* Table: DEPARTMENTS                                           */
/*==============================================================*/
create table DEPARTMENTS (
   DEPARTMENTS_ID       VARCHAR(36)          not null,
   ENTERPRISES_ID       VARCHAR(36)          null,
   DESCRIPTION          VARCHAR(100)         null,
   NAME                 VARCHAR(100)         null,
   PHONE                VARCHAR(20)          null,
   CREATED_BY           VARCHAR(100)         null,
   CREATED_DATE         TIMESTAMP            null,
   MODIFIED_BY          VARCHAR(100)         null,
   MODIFIED_DATE        TIMESTAMP            null,
   STATUS               VARCHAR(1)           null,
   constraint PK_DEPARTMENTS primary key (DEPARTMENTS_ID)
);

/*==============================================================*/
/* Table: DEPARTMENTS_EMPLOYEES                                 */
/*==============================================================*/
create table DEPARTMENTS_EMPLOYEES (
   DEPARTMENTS_EMPLOYEES_ID VARCHAR(36)          not null,
   DEPARTMENTS_ID       VARCHAR(36)          null,
   EMPLOYEES_ID         VARCHAR(36)          null,
   CREATED_BY           VARCHAR(100)         null,
   CREATED_DATE         TIMESTAMP            null,
   MODIFIED_BY          VARCHAR(100)         null,
   MODIFIED_DATE        TIMESTAMP            null,
   STATUS               VARCHAR(1)           null,
   constraint PK_DEPARTMENTS_EMPLOYEES primary key (DEPARTMENTS_EMPLOYEES_ID)
);

/*==============================================================*/
/* Table: EMPLOYEES                                             */
/*==============================================================*/
create table EMPLOYEES (
   EMPLOYEES_ID         VARCHAR(36)          not null,
   AGE                  INT2                 null,
   EMAIL                VARCHAR(20)          null,
   NAME                 VARCHAR(100)         null,
   POSITION            VARCHAR(100)         null,
   SURNAME              VARCHAR(100)         null,
   CREATED_BY           VARCHAR(100)         null,
   CREATED_DATE         TIMESTAMP            null,
   MODIFIED_BY          VARCHAR(100)         null,
   MODIFIED_DATE        TIMESTAMP            null,
   STATUS               VARCHAR(1)           null,
   constraint PK_EMPLOYEES primary key (EMPLOYEES_ID)
);

/*==============================================================*/
/* Table: ENTERPRISES                                           */
/*==============================================================*/
create table ENTERPRISES (
   ENTERPRISES_ID       VARCHAR(36)          not null,
   ADDRESS              VARCHAR(100)         null,
   NAME                 VARCHAR(100)         null,
   PHONE                VARCHAR(20)          null,
   CREATED_BY           VARCHAR(100)         null,
   CREATED_DATE         TIMESTAMP            null,
   MODIFIED_BY          VARCHAR(100)         null,
   MODIFIED_DATE        TIMESTAMP            null,
   STATUS               VARCHAR(1)           null,
   constraint PK_ENTERPRISES primary key (ENTERPRISES_ID)
);

alter table DEPARTMENTS
   add constraint FK_DEPARTME_REFERENCE_ENTERPRI foreign key (ENTERPRISES_ID)
      references ENTERPRISES (ENTERPRISES_ID)
      on delete restrict on update restrict;

alter table DEPARTMENTS_EMPLOYEES
   add constraint FK_DEPARTME_REFERENCE_DEPARTME foreign key (DEPARTMENTS_ID)
      references DEPARTMENTS (DEPARTMENTS_ID)
      on delete restrict on update restrict;

alter table DEPARTMENTS_EMPLOYEES
   add constraint FK_DEPARTME_REFERENCE_EMPLOYEE foreign key (EMPLOYEES_ID)
      references EMPLOYEES (EMPLOYEES_ID)
      on delete restrict on update restrict;

