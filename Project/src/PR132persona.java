

import java.io.Serializable;

public class PR132persona implements Serializable{
    public String nom, cognomç;
    public int edat;
    public PR132persona(String nom, String cognomç, int edat) {
        this.nom = nom;
        this.cognomç = cognomç;
        this.edat = edat;
    }
    @Override
    public String toString() {
        return "nom=" + nom + ", cognomç=" + cognomç + ", edat=" + edat ;
    }
}
