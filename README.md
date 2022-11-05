# Gestion_banque

Le but de cette application est de permettre à une agence bancaire, ainsi qu’à ces clients de
gérer leurs différents comptes.

# TD : Gestion de Comptes Bancaire

<br /><br />

## **Modèle de l’application :**

<br />
<hr/>

### Écrire une classe Compte définissant un compte bancaire :

**Attributs :** idCompte , solde , date de création , tableau de journalisation et un propriétaire (Client)

**Accès :** getters, setters

( Solde initiale doit être positif ) ( id doit être auto-généré )

( la journalisation de la création du compte est stocké dès l’initialisation du compte, ainsi que le dépôt du solde initiale si c’est pas 0dh )

**Méthodes :**
<br />public String toString(),<br />
<br />public boolean equals( Object autreCompte)

<br />
<hr/>

### Écrire une classe Client définissant un Client de la banque :

**Attributs :** idClient , nom , prénom , email , tableau de journalisation et un tableau de comptes

**Accès :** getters, setters

( email doit être conforme au format Email ) ( id doit être auto-généré )

**Méthodes :** <br />public String toString(),

<br />public boolean equals( Object autreClient)

<br />
<hr/>

### Écrire une classe Banque lié par relation d’agrégation au deux classes Compte et Client : **Attributs :** idBanque , nomAgence , emailAgence , maxComptes , maxClients et un tableau de comptes , tableau de Clients .

**Accès :** getters, setters

( nombre max de Clients et Comptes doit être fixé dès la création de l’agence bancaire )

( id de la banque doit être auto-généré ) **Méthodes :** <br />public String toString(),

<br />public boolean equals( Object autreBanque)
<br /><br />

## **Services  de  l’application  :**

<br />
<hr/>

### Écrire une classe Service-Banque implémentant les différents services de l’application : Attribut : Banque

**Fonctions du Service :**

#### Service transactionnelle :: ( chaque service finit par une journalisation ) <br />public boolean verser( double montant, Compte c)

<br />public boolean retirer( double montant, Compte c)

<br />public boolean virement( double montant, Compte src, Compte des)

#### Service CRUD :: (création, consultation, modification et suppression)

<br />public boolean créerEtAjouterCompte( Scanner clavier)

<br />public boolean créerEtAjouterNouveauClient( Scanner clavier) <br />public boolean lierCompteAuClient ( int idClient, int idCompte) <br />public Compte chercherlCompte( Scanner clavier)

<br />public Compte chercherlClient( Scanner clavier) <br />public void consulterDétailCompte( Scanner clavier) <br />public void consulterDétailClient( Scanner clavier) <br />public boolean modifierCompte( Scanner clavier) <br />public boolean modifierClient( Scanner clavier) <br />public boolean supprimerCompte( Scanner clavier) <br />public boolean supprimerClient( Scanner clavier)

#### Service ++ ::

<br />public void consulterInformationsBanque( Scanner clavier)

<br />public void listerClientsDeLaBanque( Scanner clavier)

è Ordonné par leur date d’ajout

è Ordonné par leurs soldes de comptes (ordre croissant || décroissant)

è Ordonné alphabétiquement (selon leur nom et prénom)

<br />public Client [] trierClientsParDate ( Scanner clavier) <br />public Client [] trierClientsParSolde ( Scanner clavier) <br />public Client [] trierClientsParNom ( Scanner clavier)

#### Service Utilitaire ::

<br />public void afficherMenuServiceBanque()

<br />public Object [] trierAsc( Object [] objets, Object orderByElement)

<br />public Object [] trierDec( Object [] objets, Object orderByElement)

<br />
<hr/>

## **Test  de   l’application   :**

### Écrire une classe Test-Service-Banque , Créant une banque et la lier au service banque pour tester les différents opérations.
