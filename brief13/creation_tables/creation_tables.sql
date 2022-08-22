
/* creation table  Role */
create table Role(
ID_Role BIGSERIAL PRIMARY KEY NOT NULL,
Nom VARCHAR(50) NOT NULL
)


/* creation table  Users */
create table Users(
ID_User BIGSERIAL PRIMARY KEY NOT NULL,
nom VARCHAR(50) NOT NULL,
prenom VARCHAR(50) NOT NULL,
login VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
email VARCHAR(50) NOT NULL,
telephone VARCHAR(50) NOT NULL,
ID_Role bigint,
FOREIGN KEY(ID_Role) REFERENCES Role(ID_Role)
)


/* creation table  Admin */
create table Admin(
etat VARCHAR(50) NOT NULL
) INHERITS (Users);



/* creation table  Responsable */
create table Responsable(
domaine VARCHAR(50) NOT NULL,
type VARCHAR(50) NOT NULL,
etat VARCHAR(50) NOT NULL
)INHERITS (Users);

/* creation table  Participant */
create table Participant(
domain VARCHAR(50) NOT NULL,
structure VARCHAR(50) NOT NULL
) INHERITS (Users);


/* creation table  Exercice */
create table Exercice(
ID_Exe BIGSERIAL PRIMARY KEY NOT NULL,
annee int NOT NULL,
date_debut Date NOT NULL,
date_fin Date NOT NULL,
statut VARCHAR(50) NOT NULL
)


/* creation table  Activite */
create table Activite(
ID_Activ BIGSERIAL PRIMARY KEY NOT NULL,
titre VARCHAR(50) NOT NULL,
descriptif VARCHAR(150) NOT NULL,
type VARCHAR(50) NOT NULL,
date_debut Date NOT NULL,
date_fin Date NOT NULL,
etat VARCHAR(50) NOT NULL,
ID_User bigint,
FOREIGN KEY (ID_User) REFERENCES Users(ID_User),
ID_Exe bigint,
FOREIGN KEY (ID_Exe) REFERENCES Exercice(ID_Exe)
)


/* creation table  Activite_Participant */
create table Activite_Participant(
ID_User bigint,
FOREIGN KEY (ID_User) REFERENCES Users(ID_User),
ID_Activ bigint,
FOREIGN KEY (ID_Activ) REFERENCES Activite(ID_Activ)
)


/* Lire les donnees */
select * from Role
select * from Users
select * from Admin
select * from Responsable
select * from Participant
select * from Exercice
select * from Activite
select * from Activite_Participant