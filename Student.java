import java.util.ArrayList;

/**
 * Student
 */
public class Student extends User{
    public static ArrayList<Student> listetudiant = new ArrayList<Student>();
    ArrayList<Book> borrowedBooks = new ArrayList<Book>();

    public Student(String nom, String prenom, String numero_etudiant) {
        super(nom, prenom, numero_etudiant);
        //TODO Auto-generated constructor stub
        Student.listetudiant.add(this);
    }


    @Override
    public void borrowBook(Book book) {
        // TODO Auto-generated method stub
        this.borrowedBooks.add(book);
    }

    @Override
    public void returnBook(Book book) {
        // TODO Auto-generated method stub
        this.borrowedBooks.remove(book);
    }

    // la methode pour afficher les livres empruntes par l'etudiant
    public void afficherLivreEmprunte(){
        System.out.println("liste des livres empruntés par "+this.getPrenom()+" "+this.getNom());
        for (int i = 0; i < borrowedBooks.size(); i++) {
            System.out.println(this.borrowedBooks.get(i));

        }
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "NOM : "+super.getNom()+" PRENOM : "+super.getPrenom()+" NUMERO : "+super.getNumero_etudiant();
    }

    

    
   

    
}