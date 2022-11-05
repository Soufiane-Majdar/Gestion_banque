package banque;

import java.util.Scanner;

public class Service_Banque {
    public static Banque banque=new Banque();

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
                return true;
            }
        }
        else
        {
            System.out.println("Compte source or destinaton not exist!");
        }


        return false;
    }

    public static boolean creeEtAjouterCompte(Scanner claver) {
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Compte au Banque");
        System.out.println("ID     : ");
        int id =claver.nextInt();
        System.out.println("solde  : ");
        double solde=claver.nextDouble();
        //System.out.println("client : ");
        //String client=claver.next();
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
                System.out.println("\nAcount created succesfuly!");
                //boolean b=verser(233,c);
                return true;
            }
            else
            {
                System.out.println("you have reched the max number of comptes!");
                return false;
            }
        }
        else
        {
            System.out.println("Compte alredy exist!");
            return false;
        }

    }

    public static boolean creeEtAjouterClient(Scanner claver) {
        System.out.println("\n=============================================");
        System.out.println("Cree Et Ajouter Client au Banque");
        System.out.println("ID     : ");
        int id =claver.nextInt();
        System.out.println("nom    : ");
        String nom=claver.next();
        System.out.println("prenom : ");
        String prenom=claver.next();
        System.out.println("email  : ");
        String email=claver.next();
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
                System.out.println("\nClient created succesfuly!");
                return true;
            }
            else
            {
                System.out.println("you have reched the max number of Client!");
                return false;
            }
        }
        else
        {
            System.out.println("Client alredy exist!");
            return false;
        }

    }

    public static Compte chercherCompte(Scanner claver) {
        Compte c=new Compte();
        System.out.println("\n=============================================");
        System.out.println("chercher Compte");
        System.out.println("ID : ");
        int id =claver.nextInt();

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
        return c;
    }

    public static Client chercherClient(Scanner claver) {
        Client c=new Client();
        System.out.println("\n=============================================");
        System.out.println("chercher Client");
        System.out.println("ID : ");
        int id =claver.nextInt();

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
            System.out.println("Client dos not exist!");
        return c;
    }

    public static boolean lierCompteAuClient(int idClient , int idCompte) {
        System.out.println("\n=============================================");
        System.out.println("lier Compte "+idCompte+" Au Client"+idClient);
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
            banque.getCompte()[clt_exist].setClient(banque.getClient()[cmp_exist]);
            System.out.println("\n le Compte "+idCompte+" a ete lie au Client"+idClient);
            return true;
        }
        else
        {
            System.out.println("\n le Compte "+idCompte+" ou le Client"+idClient+" n'exist pas dant la banque.");
            return false;
        }

    }


    public static void consulterDetailCompte(Scanner claver) {

    }

    public static void consulterDetailCliente(Scanner claver) {

    }

    public static void main(String[] args) {
        Scanner claver=new Scanner(System.in);
        ///////////=>

        //Compte C1=new Compte(1,3000);


        //Compte C2=new Compte(400000,"Soufiane");

        //banque.addCompte(C1);
        creeEtAjouterCompte(claver);
        //creeEtAjouterCompte(claver);
        //creeEtAjouterCompte(claver);
        creeEtAjouterClient(claver);
        //creeEtAjouterClient(claver);

        //boolean v=verser(200,C1);
        //System.out.println(v);



        for(int i=0;i<banque.nbrCompte;i++)
        {
            System.out.println(banque.getCompte()[i].toString());;
        }

        for(int i=0;i<banque.nbrClient;i++)
        {
            System.out.println(banque.getClient()[i].toString());;
        }



        //chercherClient(claver);

        lierCompteAuClient(1,1);

        System.out.println(chercherCompte(claver).toString());
        System.out.println(chercherClient(claver).toString());


    }
}
