package banque;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Client {
    private int idClient;
    private String nom;
    private String prenom;
    private String email;
    private static String[] journalisation = new String[10];
    private static int j=0;
    public Compte[] compte = new Compte[4];
    public int nbrcompte=0;

   public Client(){}
    public Client(int idClient,String nom, String prenom, String email) {
        this.idClient=idClient;
        this.nom = nom;
        this.prenom = prenom;
        boolean valide=false;
        for(int i=0;i<email.length();i++)
        {
            if (email.charAt(i)=='@')
                valide=true;

        }
        if(valide) this.email = email;

        journalisation[j]="Client id : "+idClient+" a ete add le "+ LocalDate.now();
        j++;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        boolean valide=false;
        for(int i=0;i<email.length();i++)
        {
            if (email.charAt(i)=='@')
                valide=true;

        }
        if(valide)
        this.email = email;
    }

    public static void setJournalisation(String[] journalisation) {
        Client.journalisation = journalisation;
    }

    public void setCompte(Compte[] compte) {
        this.compte = compte;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public static String[] getJournalisation() {
        return journalisation;
    }

    public Compte[] getCompte() {
        return compte;
    }

    @Override
    public String toString() {

        String r="  <<< Client >>>\n";
        r+="        Id     : "+idClient+"\n";
        r+="        Nom    : "+nom+"\n";
        r+="        Prenom : "+prenom+"\n";
        r+="        Email  : "+email+"\n";
        r+="=============================================\n";
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Client)
            return  false;
        Client o= (Client) obj;
        if (this.getIdClient()==o.getIdClient() && this.nom==o.getNom() && this.prenom==o.getPrenom() && this.email==o.getEmail() )
            return true;
        else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
