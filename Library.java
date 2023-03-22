import java.io.ObjectInputFilter.Status;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Library
 */
public class Library {

    private ArrayList<Book> listlivre = new ArrayList<Book>();
    private String nom;
    private String adresse;
    public static ArrayList<Book> listemprunt = new ArrayList<Book>();

    public ArrayList<Book> getListlivre() {
        return this.listlivre;
    }

    public void setListlivre(ArrayList<Book> listlivre) {
        this.listlivre = listlivre;
    }

    public ArrayList<Book> getListemprunt() {
        return this.listemprunt;
    }

    public void setListemprunt(ArrayList<Book> listemprunt) {
        this.listemprunt = listemprunt;
    }

    // constructeur qui prend en parametre une liste de livre 
    public Library(ArrayList<Book> listlivre, String nom, String adresse) {
        this.listlivre = listlivre;
        this.nom = nom;
        this.adresse = adresse;
    }

     // constructeur qui ne prend pas en parametre une liste de livre 
     public Library( String nom, String adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    public ArrayList<Book> getlistlivre() {
        return this.listlivre;
    }

    public void setlistlivre(ArrayList<Book> listlivre) {
        this.listlivre = listlivre;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void ajouterLivre(Book book){
        this.listlivre.add(book);
    }
    // la methode pour supprimer un livre
    public void supprimerLivre(String ISBN){
        
        if(recherche(ISBN)==1){
            for(int i=0;i<listlivre.size();i++){
                    if(ISBN.equals(this.listlivre.get(i).getISBN())){
                        listlivre.remove(i);
                        System.out.println(" suppression  faite \n");
        
                    }
            }
        }else{
            System.out.println("livre non trouve ");
        }

    }
    // la methode pour rechercher 
    public int recherche(String ISBN){
        int test = 0;
        for(int i=0;i<listlivre.size();i++){
            if(ISBN.equals(this.listlivre.get(i).getISBN())){
                test= 1;
            }else{
                test= 0;
            }
            
        }
        if(test==1){
            return 1;
        }else{
            return 0;
        }
    }
    // la methode pour rechercher un livre 
    public void rechercherLivre(String ISBN){
        
        if(recherche(ISBN)==1){
            System.out.println("le livre est existant et sera afficher dans la liste des livres \n");
        }else{
            System.out.println("livre non trouve ");
        }

    }

    // la methode pour afficher tous les livres
    public void afficherBibliotheque(){
        for(int i =0;i<listlivre.size();i++){
            System.out.println(this.listlivre.get(i));
        }
    }

    // la methode getBorrowedBooks

    public ArrayList<Book> getBorrowedBooks( Student student ){
        return student.borrowedBooks;
    }

    // ma methode getOverdue

    // public ArrayList<Book> getOverdueBooks(){
    //     if()
    // }

    // la methode displayAvailableBooks
    public void displayAvailableBooks(){
        int nbr_dispo=0;
        for (int i = 0; i < listlivre.size(); i++) {
            if(listlivre.get(i).status.equals(BookStatus.AVAILABLE)){
            nbr_dispo+=1;                
            }
        }
        System.out.println("le nombre de livre disponible est de "+nbr_dispo );
    }

    // la methode displayBorrowedBooks
    public void displayBorrowedBooks(){
        for (int i = 0; i < listemprunt.size(); i++) {
            
            System.out.println(listemprunt.get(i));
        }
        
    }

    
}