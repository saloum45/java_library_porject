import java.text.SimpleDateFormat;
import java.util.Date;
class BookAlreadyBorrowedException extends Exception{
    BookAlreadyBorrowedException(String msg){
        super(msg);
    }
}

class BookNotBorrowedException extends Exception{
    BookNotBorrowedException(String msg){
        super(msg);
    }
}

/**
 * Book
 */
public class Book {
    
    BookStatus status=BookStatus.AVAILABLE;

    private String title;
    private String auteur;
    private Date date_publication = new Date();
    // SimpleDateFormat dateFormat =new SimpleDateFormat("jj/mm/aaaa");
    private String ISBN;
    private int nombre_pages;
    private int nombre_exemplaire_disponible;

    public BookStatus getStatus() {
        return this.status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Book(String title, String auteur, String ISBN, int nombre_pages, int nombre_exemplaire_disponible) {
        this.title = title;
        this.auteur = auteur;
        //this.date_publication = date_publication;
        this.ISBN = ISBN;
        this.nombre_pages = nombre_pages;
        this.nombre_exemplaire_disponible = nombre_exemplaire_disponible;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuteur() {
        return this.auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Date getDate_publication() {
        return this.date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getNombre_pages() {
        return this.nombre_pages;
    }

    public void setNombre_pages(int nombre_pages) {
        this.nombre_pages = nombre_pages;
    }

    public int getNombre_exemplaire_disponible() {
        return this.nombre_exemplaire_disponible;
    }

    public void setNombre_exemplaire_disponible(int nombre_exemplaire_disponible) {
        this.nombre_exemplaire_disponible = nombre_exemplaire_disponible;
    }

    // la methode pour afficher les informations d'un livre
    public String toString(){
        return "title : "+this.title+"  auteur : "+this.auteur+"    Date publication : "+this.date_publication+"    ISBN : "+this.ISBN+"    nombre de pages : "+this.nombre_pages+"    nombre d'emplaires disponibles : "+this.nombre_exemplaire_disponible;
    }

    // la methode borrowBook
    public void borrowBook(Student student) throws      BookAlreadyBorrowedException{
        if(this.status.equals(BookStatus.AVAILABLE)){
            this.status=BookStatus.BORROWED;
            student.borrowedBooks.add(this);
            Library.listemprunt.add(this);
            System.out.println("le livre est bien emprunté ");
            
            
        }else{
            throw new BookAlreadyBorrowedException("ce livre a dèja été emprunté");
        }
    }

    // la methode returnBook
    public void returnBook(Student student) throws      BookNotBorrowedException{
        int guide=0;
        for (int index = 0; index < student.borrowedBooks.size(); index++) {
            if(this.ISBN.equals(student.borrowedBooks.get(index).getISBN()) && this.status.equals(BookStatus.BORROWED)){
                
                    guide=1;
                
                
            }else{
                guide=0;
            }
            
        }
        if(guide==1){
            this.status=BookStatus.AVAILABLE;
            student.borrowedBooks.remove(this);
            Library.listemprunt.remove(this);
            System.out.println("le livre est bien retourné ");
        }else{
            throw new BookNotBorrowedException("ce livre n'a pas été emprunté par cet Etudiant");
        }
        
    }

    // public static void main(String[] args) throws BookAlreadyBorrowedException,BookNotBorrowedException {
    //     try {
    //         Book memoire = new Book("memoire fin d'etude", "salem", "liv1", 65, 8);
    //         Book codage = new Book("langage c", "salem", "liv2", 65, 8);
    //         System.out.println(memoire.getStatus());
    //         Student salem=new Student("fall", "salem", "salem");
    //         Student modou=new Student("diop", "modou", "mdp4521");
    //         // memoire.setStatus(BookStatus.BORROWED);
    //         memoire.borrowBook(salem);
    //         System.out.println(memoire.getStatus());
    //         memoire.returnBook(salem);
    //         System.out.println(memoire.getStatus());
    //         // salem.afficherLivreEmprunte();
    //     } catch (BookAlreadyBorrowedException e) {
    //         // TODO: handle exception
    //         System.out.println(e.getMessage());
    //     } catch (BookNotBorrowedException e) {
    //         // TODO: handle exception
    //         System.out.println(e.getMessage());
    //     }
        
    // }
}