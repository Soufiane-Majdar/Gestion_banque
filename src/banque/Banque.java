package banque;

import java.util.List;

public class Banque {
    private static int idBanque=0;
    private String nomAgence,emailAgence;
    private final int  maxCompte=4;


    private final int  maxClient=4;




    private Compte[] compte = new Compte[4];
    public int nbrCompte=0;
    private Client[] client = new Client[4];
    public static int nbrClient=0;

    public Banque(){}

    public Banque(String nomAgence, String emailAgence) {
        idBanque++;
        this.nomAgence = nomAgence;
        this.emailAgence = emailAgence;
    }

    public static void setIdBanque(int idBanque) {
        Banque.idBanque = idBanque;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public void setEmailAgence(String emailAgence) {
        this.emailAgence = emailAgence;
    }

    public void setCompte(Compte[] compte) {
        this.compte = compte;
    }

    public void setClient(Client[] client) {
        this.client = client;
    }

    public static int getIdBanque() {
        return idBanque;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public String getEmailAgence() {
        return emailAgence;
    }

    public int getMaxCompte() {
        return maxCompte;
    }

    public int getMaxClient() {
        return maxClient;
    }

    public Compte[] getCompte() {
        return compte;
    }


    public Client[] getClient() {
        return client;
    }


    /*public  void addCompte(Compte c) {
        this.compte[nbrCompte]=c;
        nbrCompte++;
    }*/

    @Override
    public String toString() {

        String r="=============================================\n";
        r+="<<< Banque >>>\n";
        r+="    Id    : "+idBanque+"\n";
        r+="    Nom   : "+nomAgence+"\n";
        r+="    Email : "+emailAgence+"\n";
        r+="=============================================\n";
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Banque)
            return  false;
        Banque o= (Banque) obj;
        if (this.getIdBanque()==o.getIdBanque())
            return true;
        else return false;
    }
}
