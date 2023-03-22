/**
 * User
 */
public abstract class User implements LibraryUser{
    private String nom;
    private String prenom;
    private String numero_etudiant;

    public User(String nom, String prenom, String numero_etudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numero_etudiant = numero_etudiant;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumero_etudiant() {
        return this.numero_etudiant;
    }

    public void setNumero_etudiant(String numero_etudiant) {
        this.numero_etudiant = numero_etudiant;
    }

    
    
}