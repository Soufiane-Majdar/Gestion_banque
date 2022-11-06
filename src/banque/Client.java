package banque;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Client {
    private int idClient;
    private String nom;
    private String prenom;
    private String email;
    private LocalDate d_cration;
    private  String[] journalisation = new String[10];
    public  int j=0;
    public Compte[] compte = new Compte[4];
    public int nbrcompte=0;

   public Client(){}
    public Client(int idClient,String nom, String prenom, String email) {
        this.idClient=idClient;
        this.nom = nom;
        this.prenom = prenom;
        boolean valide=false;
        this.d_cration = LocalDate.now();
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

    public void setJournalisation(String[] journalisation) {
        this.journalisation = journalisation;
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

    public LocalDate getD_cration() {
        return d_cration;
    }

    public void setD_cration(LocalDate d_cration) {
        this.d_cration = d_cration;
    }

    public  String[] getJournalisation() {
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
