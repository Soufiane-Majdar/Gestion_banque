package banque;

import java.util.Scanner;

public class Service_Banque {
    public static Banque banque=new Banque("Majdar Agence","service@mjagence.ma");


    // ** Service transactionnelle **
    public static boolean verser(double mt,Compte c) {
        for (int i=0;i<banque.nbrCompte;i++) {
            if (banque.getCompte()[i].getIdCompte()==c.getIdCompte()) {
                if (mt > 0) {
                    banque.getCompte()[i].setSolde(c.getSolde() + mt);
                    return true;
                }
            }
        }

        return false;
    }
    public static boolean retirer(double mt,Compte c) {
        for (int i=0;i<banque.nbrCompte;i++) {
            if (banque.getCompte()[i].getIdCompte()==c.getIdCompte()) {
                if (c.getSolde() - mt >= 0) {
                    c.setSolde(c.getSolde() - mt);
                    System.out.println("Retirer avec succès");
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean virement(double mt,Compte src,Compte des) {
        boolean src_exist=false,des_exist=false;
        for (int i=0;i<banque.nbrCompte;i++) {
            if (banque.getCompte()[i].getIdCompte()==src.getIdCompte()) {
                src_exist=true;
            }
            if (banque.getCompte()[i].getIdCompte()==des.getIdCompte()) {
                des_exist=true;
            }
        }
        if (src_exist && des_exist)
        {
            if(src.getSolde()-mt>=0)
            {
                des.setSolde(des.getSolde()+mt);
                src.setSolde(src.getSolde()-mt);
                System.out.println("Virement fait avec succès");
                return true;
            }
        }
        else
        {
            System.out.println("Compte source ou Compte destination n'existent pas!");
        }


        return false;
    }


    // ** Service CRUD **
    public static boolean creeEtAjouterCompte(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Compte au Banque");
        System.out.println("ID     : ");
        int id =clavier.nextInt();
        System.out.println("solde  : ");
        double solde=clavier.nextDouble();
        //System.out.println("client : ");
        //String client=clavier.next();
        Compte c=new Compte(id,solde);

        boolean not_exist=true;
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==c.getIdCompte()) {
               not_exist=false;
            }
        }
        if(not_exist)
        {
            if(banque.nbrCompte<banque.getMaxCompte()) {
                banque.getCompte()[banque.nbrCompte] = c;
                banque.nbrCompte++;
                System.out.println("\nCompte est créé avec succès!");
                System.out.println("=============================================\n");
                //boolean b=verser(233,c);
                return true;
            }
            else
            {
                System.out.println("vous avez atteint le nombre maximum de comptes!");
                System.out.println("=============================================\n");
                return false;
            }
        }
        else
        {
            System.out.println("Compte existe déjà!");
            return false;
        }

    }
    public static boolean creeEtAjouterClient(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Client au Banque");
        System.out.println("ID     : ");
        int id =clavier.nextInt();
        System.out.println("nom    : ");
        String nom=clavier.next();
        System.out.println("prenom : ");
        String prenom=clavier.next();
        System.out.println("email  : ");
        String email=clavier.next();
        Client c=new Client(id,nom,prenom,email);

        boolean not_exist=true;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==c.getIdClient()) {
                not_exist=false;
            }
        }
        if(not_exist)
        {
            if(banque.nbrCompte<banque.getMaxCompte()) {
                banque.getClient()[banque.nbrClient] = c;
                banque.nbrClient++;
                System.out.println("\nClient créé avec succès!");
                System.out.println("=============================================\n");
                return true;
            }
            else
            {
                System.out.println("vous avez atteint le nombre maximum de Client");
                System.out.println("=============================================\n");
                return false;
            }
        }
        else
        {
            System.out.println("Client existe déjà!");
            return false;
        }

    }
    public static Compte chercherCompte(Scanner clavier) {
        Compte c=new Compte();
        System.out.println("\n=============================================");
        System.out.println("chercher Compte");
        System.out.println("ID : ");
        int id =clavier.nextInt();

        boolean not_exist=true;
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==id) {
                c=banque.getCompte()[i];
                //System.out.println(c.toString());
                not_exist=false;
                return c;
            }
        }
        if(not_exist)
            System.out.println("Compte dos not exist!");
        System.out.println("=============================================\n");
        return c;
    }
    public static Client chercherClient(Scanner clavier) {
        Client c=new Client();
        System.out.println("\n=============================================");
        System.out.println("chercher Client");
        System.out.println("ID : ");
        int id =clavier.nextInt();

        boolean not_exist=true;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==id) {
                c=banque.getClient()[i];
                //System.out.println(c.toString());
                not_exist=false;
                return c;
            }
        }
        if(not_exist)
            System.out.println("Client n'existe pas!");
            System.out.println("=============================================\n");
        return c;
    }
    public static boolean lierCompteAuClient(int idClient , int idCompte) {
        System.out.println("\n=============================================");
        System.out.println("lier Compte "+idCompte+" Au Client "+idClient);
        int clt_exist=5,cmp_exist=5;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==idClient) {
                clt_exist=i;
            }
        }
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==idCompte) {
                cmp_exist=i;
            }
        }
        if(clt_exist!=5 && cmp_exist!=5)
        {
            banque.getCompte()[cmp_exist].setClient(banque.getClient()[clt_exist]);
            banque.getClient()[clt_exist].compte[banque.getClient()[clt_exist].nbrcompte]=banque.getCompte()[cmp_exist];
            banque.getClient()[clt_exist].nbrcompte++;
            System.out.println("\n le Compte "+idCompte+" est lie au Client "+idClient);
            System.out.println("=============================================\n");
            return true;
        }
        else
        {
            System.out.println("\n le Compte "+idCompte+" ou le Client "+idClient+" n'existe pas dans la banque.");
            System.out.println("=============================================\n");
            return false;
        }

    }
    // not done
    public static void consulterDetailCompte(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Consulter Detail Compte");
        // get id 
        System.out.println("ID     : ");
        int id =clavier.nextInt();
        // get compte
        Compte c=new Compte();
        boolean not_exist=true;
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==id) {
                c=banque.getCompte()[i];
                //System.out.println(c.toString());
                not_exist=false;
            }
        }
        if(not_exist)
            System.out.println("Compte dos not exist!");
        else
        {
            System.out.println("=============================================");
            System.out.println("Detail Compte");
            // lopp to print journalisation
            for (int i=0;i<c.j;i++) {
                System.out.println(c.getJournalisation()[i].toString());
            }
            System.out.println("=============================================\n");
        }

    }
    // not done
    public static void consulterDetailCliente(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Consulter Detail Cliente");
        // get id 
        System.out.println("ID     : ");
        int id =clavier.nextInt();
        // get compte
        Client c=new Client();
        boolean not_exist=true;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==id) {
                c=banque.getClient()[i];
                //System.out.println(c.toString());
                not_exist=false;
            }
        }
        if(not_exist)
            System.out.println("Client dos not exist!");
        else
        {
            System.out.println("=============================================");
            System.out.println("Detail Client");
            // lopp to print journalisation
            for (int i=0;i<c.j;i++) {
                System.out.println(c.getJournalisation()[i].toString());
            }
            System.out.println("=============================================\n");
        }


    }
    public static boolean modifierClient(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Modifier Client");
        System.out.println("ID     : ");
        int id =clavier.nextInt();


        int position=10;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==id) {
                position=i;
            }
        }
        if(position!=10)
        {
                System.out.println("nom    : ");
                String nom=clavier.next();
                System.out.println("prenom : ");
                String prenom=clavier.next();
                System.out.println("email  : ");
                String email=clavier.next();

                banque.getClient()[position].setNom(nom);
                banque.getClient()[position].setPrenom(prenom);
                banque.getClient()[position].setEmail(email);
                System.out.println("\nClient est modifié avec succès!");
            System.out.println("=============================================\n");
                return true;
        }
        else
        {
            System.out.println("\nClient n'existe pas!");
            System.out.println("=============================================\n");
            return false;
        }

    }
    public static boolean modifierCompte(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Modifier Compte");
        System.out.println("ID     : ");
        int id =clavier.nextInt();


        int position=10;
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==id) {
                position=i;
            }
        }
        if(position!=10)
        {
            System.out.println("solde    : ");
            double solde=clavier.nextDouble();

            banque.getCompte()[position].setSolde(solde);
            System.out.println("\nCompte est modifié avec succès!");
            System.out.println("=============================================\n");
            return true;
        }
        else
        {
            System.out.println("\nCompte n'existe pas!");
            System.out.println("=============================================\n");
            return false;
        }

    }
    public static boolean suprimerCompte(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Suprimer Compte");
        System.out.println("ID     : ");
        int id =clavier.nextInt();


        int position=10;
        for (int i=0;i<banque.nbrCompte;i++) {
            if ( banque.getCompte()[i].getIdCompte()==id) {
                position=i;
            }
        }
        if(position!=10)
        {
            for (int i=position;i<banque.nbrCompte;i++) {
                if(i+1<banque.nbrCompte) {
                    banque.getCompte()[i].setIdCompte(banque.getCompte()[i + 1].getIdCompte());
                    banque.getCompte()[i].setSolde(banque.getCompte()[i + 1].getSolde());
                    banque.getCompte()[i].setClient(banque.getCompte()[i + 1].getClient());
                    banque.getCompte()[i].setD_cration(banque.getCompte()[i + 1].getD_cration());
                    banque.getCompte()[i].setJournalisation(banque.getCompte()[i + 1].getJournalisation());
                }
            }
            banque.nbrCompte--;
            System.out.println("\nCompte est supprimé avec succès!");
            System.out.println("=============================================\n");
            return true;
        }
        else
        {
            System.out.println("\nCompte n'existe pas!");
            System.out.println("=============================================\n");
            return false;
        }

    }
    public static boolean suprimerClient(Scanner clavier) {
        System.out.println("\n=============================================");
        System.out.println("Suprimer Client");
        System.out.println("ID     : ");
        int id =clavier.nextInt();


        int position=10;
        for (int i=0;i<banque.nbrClient;i++) {
            if ( banque.getClient()[i].getIdClient()==id) {
                position=i;
            }
        }
        if(position!=10)
        {
            for (int i=position;i<banque.nbrClient;i++) {
                if(i+1<banque.nbrClient) {
                    banque.getClient()[i].setIdClient(banque.getClient()[i + 1].getIdClient());
                    banque.getClient()[i].setNom(banque.getClient()[i + 1].getNom());
                    banque.getClient()[i].setPrenom(banque.getClient()[i + 1].getPrenom());
                    banque.getClient()[i].setEmail(banque.getClient()[i + 1].getEmail());
                    banque.getClient()[i].setJournalisation(banque.getClient()[i + 1].getJournalisation());
                }
            }
            banque.nbrClient--;
            System.out.println("\nClient est supprimé avec succès!");
            System.out.println("=============================================\n");
            return true;
        }
        else
        {
            System.out.println("\nClient n'existe pas!");
            System.out.println("=============================================\n");
            return false;
        }

    }

    // ** Service ++ **
    public static void consulterInformationsBanque( ){
        System.out.println("\n=============================================");
        System.out.println("Consulter Informations Banque\n");
        System.out.println(banque.toString());
    }

    public static void listerClientsDeLaBanque(Scanner clavier){
        System.out.println("\n=============================================");
        System.out.println("lister Clients De La Banque");
        System.out.println("    1 : trier Clients Par Date");
        System.out.println("    2 : trier Clients Par Solde");
        System.out.println("    3 : trier Clients Par Nom");
        int m = clavier.nextInt();
        if (m==1)
        {
            trierClientsParDate (clavier);
            for (int i=0;i<banque.nbrClient;i++) {
                System.out.println(banque.getClient()[i].toString());
            }
        }
        else if (m==2)
        {
            trierClientsParSolde(clavier);
            for (int i=0;i<banque.nbrClient;i++) {
                System.out.println(banque.getClient()[i].toString());
            }
        }
            
        else if(m==3)
        {
            trierClientsParNom(clavier);
            for (int i=0;i<banque.nbrClient;i++) {
                System.out.println(banque.getClient()[i].toString());
            }
        }
        else
            listerClientsDeLaBanque(clavier);
    }

    public static Client[] trierClientsParDate ( Scanner clavier){
        System.out.println("\n=============================================");
        System.out.println("Trier Clients Par Date");
        System.out.println("    1 : croissant");
        System.out.println("    2 : décroissant");
        int m = clavier.nextInt();
        if (m==1)
        {
            for (int i=0;i<banque.nbrClient;i++) {
                for (int j=i+1;j<banque.nbrClient;j++) {
                    if (banque.getClient()[i].getD_cration().compareTo(banque.getClient()[j].getD_cration())>0) {
                        Client temp=banque.getClient()[i];
                        banque.getClient()[i]=banque.getClient()[j];
                        banque.getClient()[j]=temp;
                    }
                }
            }
        }
        else if (m==2)
        {
            for (int i=0;i<banque.nbrClient;i++) {
                for (int j=i+1;j<banque.nbrClient;j++) {
                    if (banque.getClient()[i].getD_cration().compareTo(banque.getClient()[j].getD_cration())<0) {
                        Client temp=banque.getClient()[i];
                        banque.getClient()[i]=banque.getClient()[j];
                        banque.getClient()[j]=temp;
                    }
                }
            }
        }
        else
            trierClientsParDate(clavier);
        return banque.getClient();
    }
    
    public static Client[] trierClientsParSolde ( Scanner clavier){
        System.out.println("\n=============================================");
        System.out.println("Trier Clients Par Solde");
        System.out.println("    1 : croissant");
        System.out.println("    2 : décroissant");
        int m = clavier.nextInt();
        // getsolde from compte of the client in banque
        if (m==1)
        {
            return banque.getClient();
        }
        else if (m==2)
        {
            return banque.getClient();
        }
        else
            trierClientsParSolde(clavier);

        return banque.getClient();
    }
    public static Client[] trierClientsParNom ( Scanner clavier){

        //nom
        System.out.println("\n=============================================");
        System.out.println("Trier Clients Par Nom");
        System.out.println("    1 : croissant");
        System.out.println("    2 : décroissant");
        int m = clavier.nextInt();
        if (m==1)
        {
            for (int i=0;i<banque.nbrClient;i++) {
                for (int j=i+1;j<banque.nbrClient;j++) {
                    if (banque.getClient()[i].getNom().compareTo(banque.getClient()[j].getNom())>0) {
                        Client temp=banque.getClient()[i];
                        banque.getClient()[i]=banque.getClient()[j];
                        banque.getClient()[j]=temp;
                    }
                }
            }
        }
        else if (m==2)
        {
            for (int i=0;i<banque.nbrClient;i++) {
                for (int j=i+1;j<banque.nbrClient;j++) {
                    if (banque.getClient()[i].getNom().compareTo(banque.getClient()[j].getNom())<0) {
                        Client temp=banque.getClient()[i];
                        banque.getClient()[i]=banque.getClient()[j];
                        banque.getClient()[j]=temp;
                    }
                }
            }
        }
        else
            trierClientsParNom(clavier);

        return banque.getClient();
    }



    public static void afficherMenuServiceBanque() {
        Scanner clavier=new Scanner(System.in);
        System.out.println("\n=============================================");
        System.out.println("Menu Service Banque \n");
        System.out.println("    0  : Quitter\n");
        System.out.println("|-> Service Transactionnelle ::");
        System.out.println("    1  : verser");
        System.out.println("    2  : retirer");
        System.out.println("    3  : virement\n");
        System.out.println("|-> Service CRUD ::");
        System.out.println("    4  : créer Et Ajouter Compte");
        System.out.println("    5  : créer Et Ajouter Client");
        System.out.println("    6  : lier Compte Au Client");
        System.out.println("    7  : chercher Compte");
        System.out.println("    8  : chercher Client");
        System.out.println("    9  : consulter Détail Compte");
        System.out.println("    10  : consulter Détail Client");
        System.out.println("    11 : modifier Compte");
        System.out.println("    12 : modifier Client");
        System.out.println("    13 : supprimer Compte");
        System.out.println("    14 : supprimer Client\n");
        System.out.println("|-> Service ++ ::");
        System.out.println("    15 : consulter Informations Banque");
        System.out.println("    16 : lister Clients De La Banque\n");
        System.out.println("|-> Service Utilitaire ::");
        System.out.println("    17 : afficher Menu Service Banquee");
        System.out.println("    18 : trier Asc");
        System.out.println("    19 : trier Dec\n");

        System.out.println("=============================================");
        System.out.println("Votre choix : ");
        int choix = clavier.nextInt();

        switch (choix) {
            case 0:
                System.out.println("Au revoir!");
                break;
            case 1:
                System.out.println("verser");
                System.out.println("Montant : ");
                double mt =clavier.nextDouble();
                Compte c=chercherCompte(clavier);
                if(c!=null)
                    verser(mt,c);
                else
                    System.out.println("Compte n'existe pas!");
                afficherMenuServiceBanque();
                break;
            case 2:
                System.out.println("retirer");
                System.out.println("Montant : ");
                double mt1 =clavier.nextDouble();
                Compte c1=chercherCompte(clavier);
                if(c1!=null)
                    retirer(mt1,c1);
                else
                    System.out.println("Compte n'existe pas!");
                afficherMenuServiceBanque();
                break;
            case 3:
                System.out.println("virement");
                System.out.println("Montant : ");
                double mt2 =clavier.nextDouble();
                Compte c2=chercherCompte(clavier);
                Compte c3=chercherCompte(clavier);
                if(c2!=null && c3!=null)
                    virement(mt2,c2,c3);
                else
                    System.out.println("Compte n'existe pas!");
                afficherMenuServiceBanque();
                break;
            case 4:
                creeEtAjouterCompte(clavier);
                afficherMenuServiceBanque();
                break;
            case 5:
                creeEtAjouterClient(clavier);
                afficherMenuServiceBanque();
                break;
            case 6:
                // get id of client and compte
                System.out.println("Lier Compte Au Client");
                System.out.println("Id Client : ");
                int idClient =clavier.nextInt();
                System.out.println("Id Compte : ");
                int idCompte =clavier.nextInt();
                lierCompteAuClient(idClient, idCompte);
                afficherMenuServiceBanque();
                break;
            case 7:
                System.out.println(chercherCompte(clavier).toString());
                afficherMenuServiceBanque();
                break;
            case 8:
                System.out.println(chercherClient(clavier).toString());
                afficherMenuServiceBanque();
                break;
            case 9:
                consulterDetailCompte(clavier);
                afficherMenuServiceBanque();
                break;
            case 10:
                consulterDetailCliente(clavier);
                afficherMenuServiceBanque();
                break;
            case 11:
                modifierCompte(clavier);
                afficherMenuServiceBanque();
                break;
            case 12:
                modifierClient(clavier);
                afficherMenuServiceBanque();
                break;
            case 13:
                suprimerCompte(clavier);
                afficherMenuServiceBanque();
                break;
            case 14:
                suprimerClient(clavier);
                afficherMenuServiceBanque();
                break;
            case 15:
                consulterInformationsBanque();
                afficherMenuServiceBanque();
                break;
            case 16:
                listerClientsDeLaBanque(clavier);
                afficherMenuServiceBanque();
                break;
            case 17:
                afficherMenuServiceBanque();
                break;
            case 18:
                //trierAsc(clavier);
                afficherMenuServiceBanque();
                break;
            case 19:
                //trierDec(clavier);
                afficherMenuServiceBanque();
                break;
            default:
                System.out.println("Choix invalide!");
                afficherMenuServiceBanque();
                break; 
        }
    }



    public static void main(String[] args) {
        //Scanner clavier=new Scanner(System.in);
        ///////////=>

        afficherMenuServiceBanque();

        //Compte C1=new Compte(1,3000);


        //Compte C2=new Compte(400000,"Soufiane");

        //banque.addCompte(C1);
        //creeEtAjouterCompte(clavier);
        //creeEtAjouterCompte(clavier);
        //creeEtAjouterClient(clavier);
        //creeEtAjouterClient(clavier);

        //boolean v=verser(200,C1);
        //System.out.println(v);







        //chercherClient(clavier);

        //lierCompteAuClient(1,2);



        // for(int i=0;i<banque.nbrCompte;i++)
        // {
        //     System.out.println(banque.getCompte()[i].toString());;
        // }

        // for(int i=0;i<banque.nbrClient;i++)
        // {
        //     System.out.println(banque.getClient()[i].toString());;
        // }

        //modifierClient(clavier);
        //modifierCompte(clavier);
        //suprimerCompte(clavier);
        //suprimerClient(clavier);
        //System.out.println(chercherCompte(clavier).toString());
        //System.out.println(chercherClient(clavier).toString());
        //consulterInformationsBanque();

        // for(int i=0;i<banque.nbrCompte;i++)
        // {
        //     System.out.println(banque.getCompte()[i].toString());;
        // }

        // for(int i=0;i<banque.nbrClient;i++)
        // {
        //     System.out.println(banque.getClient()[i].toString());;
        // }
    }
}
