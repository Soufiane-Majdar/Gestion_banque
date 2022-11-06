package banque;

import java.time.LocalDate;


public class Compte {
    private  int idCompte;
    private double solde;
    private LocalDate d_cration;
    private String[] journalisation = new String[10];
    public int  j=0;
    private Client client;


    public Compte(){}
    public Compte(int idCompte,double solde, Client client) {
        this.idCompte=idCompte;
        this.solde = solde;
        this.d_cration = LocalDate.now();
        this.client = client;

        journalisation[j] = "Compte id : " + idCompte + " a ete crere le : " + d_cration;
        j++;

    }

    public Compte(int idCompte,double solde) {
        this.idCompte=idCompte;
        this.solde = solde;
        this.d_cration = LocalDate.now();

        journalisation[j] = "Compte id : " + idCompte + " a ete crere le : " + d_cration;
        j++;

    }


    public int getIdCompte() {
        return idCompte;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        if(solde>0)
        {
            journalisation[j] = "Compte id : " + idCompte + ", le solde a ete modifier de : " + this.solde+" a : "+solde;
            j++;
            this.solde = solde;
        }

    }

    public LocalDate getD_cration() {
        return d_cration;
    }

    public void setD_cration(LocalDate d_cration) {
        this.d_cration = d_cration;
    }

    public String[] getJournalisation() {
        return journalisation;
    }

    public void setJournalisation(String[] journalisation) {
        this.journalisation = journalisation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        {
            journalisation[j] = "Compte id : " + idCompte + " est lie au Client : " + client.getIdClient();
            j++;
            this.client = client;
        }

    }

    @Override
    public String toString() {
        String r="<<< Compte >>>\n";
        r+="    Id              : "+idCompte+"\n";
        r+="    solde           : "+solde+"\n";
        r+="    date de cration : "+d_cration+"\n";
        if(client!=null)
            r+="    |->"+client.toString()+"\n";
        r+="=============================================\n";
        return r;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Compte)
            return  false;
        Compte o= (Compte) obj;
        if (this.getIdCompte()==o.getIdCompte())
            return true;
        else return false;
    }
}
