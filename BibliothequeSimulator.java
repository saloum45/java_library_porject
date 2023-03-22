import java.util.Scanner;

/**
 * BibliothequeSimulator
 */
public class BibliothequeSimulator {

    public static void main(String[] args) throws BookAlreadyBorrowedException, BookNotBorrowedException{
        try {
            Library biblio = new Library("uahb", "Fann");
            Book langage_c = new Book("langage C ", "sene", "lc1", 64, 12);
            Book langage_java = new Book("java ", "NGOM", "lj1", 12, 6);
            Book programmer = new Book("programmer", "fall", "pg1", 200, 80);
            biblio.ajouterLivre(programmer);
            biblio.ajouterLivre(langage_c);
            biblio.ajouterLivre(langage_java);
            Student salem = new Student("fall", "salem", "f12");
            Student diop = new Student("diop", "salem", "di11");
            Student diarra = new Student("ndiaye", "diarra", "di4");
            langage_c.borrowBook(diarra);
            langage_c.returnBook(diarra);
            salem.borrowBook(programmer);
            int choix1 = 0;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print("1-Ajouter un etudiant");
                System.out.println("\t\t7-Ajouter un livre un livre");
                System.out.print("2-Borrow Book");
                System.out.println("\t\t\t8-Supprimer un livre un livre");
                System.out.print("3-Return Book");
                System.out.println("\t\t\t9-Afficher tous les livres");
                System.out.print("4-Afficher les etudiants");
                System.out.println("\t10-Rechercher un livre");
                System.out.print("5-getBorrowedBooks");
                System.out.println("\t\t11-Display Available  Books");
                System.out.print("6-List des transactions ");
                System.out.println("\t12-Display Borrowed Books");

                do {
                    System.out.print("\tvotre choix : ");
                    choix1 = sc.nextInt();
                } while (choix1 < 1 || choix1 > 12);

                switch (choix1) {
                    case 1:
                        System.out.println("-------------------Ajout d'un etudiant-------------------");
                        System.out.print("saisir le nom : ");
                        String nom = sc.next();
                        System.out.print("saisir le prenom : ");
                        String prenom = sc.next();
                        System.out.print("saisir le numero : ");
                        String numero = sc.next();
                        Student etudiant = new Student(nom, prenom, numero);
                        break;
                    case 2:
                        int petu=-1,pliv=-1;
                        System.out.println("-------------------Borrow Book-------------------");
                        System.out.print("donner l'ISBN du livre a emprunter : ");
                        String test2 = sc.next();
                        System.out.print("saisir le numero de l'etudiant qui veut emprunter le livre : ");
                        String numbook= sc.next();
                        
                        for (int i = 0; i < Student.listetudiant.size(); i++) {

                            if(numbook.equals(Student.listetudiant.get(i).getNumero_etudiant())){
                                petu=i;
                                break;

                            }
                        }

                        for (int i = 0; i < biblio.getListlivre().size(); i++) {
                            if(test2.equals(biblio.getListlivre().get(i).getISBN())){
                                pliv=i;
                                break;
                            }
                        }
                        if(pliv!=-1 || petu !=-1){
                            biblio.getListlivre().get(pliv).borrowBook(Student.listetudiant.get(petu));
                            biblio.getListemprunt().add(biblio.getListlivre().get(pliv));
                            JournalTransaction journal = new JournalTransaction(Student.listetudiant.get(petu),biblio.getListlivre().get(pliv),2 ) ;
                        }else{
                            System.out.println("l'ISBN ou le num_Etudiant est introuvable");
                        }
                        


                        break;
                    case 3:
                        int peture=-1,plivre=-1;
                        System.out.println("-------------------Return Book-------------------");
                        System.out.print("donner l'ISBN du livre a retourner : ");
                        String testreturn = sc.next();
                        System.out.print("saisir le numero de l'etudiant qui veut retourner le livre : ");
                        String numbookreturn= sc.next();
                        
                        for (int i = 0; i < Student.listetudiant.size(); i++) {

                            if(numbookreturn.equals(Student.listetudiant.get(i).getNumero_etudiant())){
                                peture=i;
                                break;

                            }
                        }

                        for (int i = 0; i < biblio.getListlivre().size(); i++) {
                            if(testreturn.equals(biblio.getListlivre().get(i).getISBN())){
                                plivre=i;
                                break;
                            }
                        }
                        if(plivre!=-1 || peture !=-1){
                            biblio.getListlivre().get(plivre).returnBook(Student.listetudiant.get(peture));
                            biblio.getListemprunt().remove(biblio.getListlivre().get(plivre));
                            JournalTransaction journal = new JournalTransaction(Student.listetudiant.get(peture),biblio.getListlivre().get(plivre),1) ;

                        }else{
                            System.out.println("l'ISBN ou le num_Etudiant est introuvable");
                        }
                        break;
                    case 4:
                        System.out.println("-------------------Affichage des etudiants-------------------");
                        for (int i = 0; i < Student.listetudiant.size(); i++) {
                            System.out.println(Student.listetudiant.get(i));
                        }
                        break;
                    case 5:
                        System.out.println("-------------------get Borrowed Books-------------------");
                        System.out.print("saisir le numero de l'etudiant pour voir ses livres empruntés : ");
                        String numgetborrow= sc.next();
                        for (int i = 0; i <Student.listetudiant.size() ; i++) {
                            if(numgetborrow.equals(Student.listetudiant.get(i).getNumero_etudiant())){
                                System.out.println(biblio.getBorrowedBooks(Student.listetudiant.get(i))); 
                                
                                break;

                            }
                        }
                        break;

                    case 6:
                        System.out.println("-------------------List des transactions-------------------");
                        JournalTransaction.affichertransaction();
                        break;

                    case 7:
                        System.out.println("-------------------Ajouter un livre-------------------");
                        System.out.print("saisir le titre du livre : ");
                        String titre = sc.next();
                        System.out.print("saisir l'auteur du livre : ");
                        String auteur = sc.next();
                        System.out.print("saisir l'isbn du livre : ");
                        String isbn = sc.next();
                        System.out.print("saisir le nombre de pages du livre : ");
                        int pages = sc.nextInt();
                        System.out.print("saisir le nombre d'exemplaire du livre : ");
                        int exemplaire = sc.nextInt();
                        biblio.ajouterLivre(new Book(titre, auteur, isbn, pages, exemplaire));
                        break;
                    case 8:
                        System.out.println("-------------------Supprimer un livre-------------------");
                        System.out.print("saisir l'isbn du livre a supprimer : ");
                        String suplivre=sc.next();
                        biblio.supprimerLivre(suplivre);
                        break;

                    case 9:
                        System.out.println("-------------------Afficher tous les livres -------------------");
                        biblio.afficherBibliotheque();
                        break;

                    case 10:
                        System.out.println("-------------------Rechercher un livre-------------------");
                        System.out.print("saisir l'isbn du livre a rechercher : ");
                        String isbnrech=sc.next();
                        biblio.rechercherLivre(isbnrech);
                        break;

                    case 11:
                        System.out.println("-------------------Display Available Books-------------------");
                        biblio.displayAvailableBooks();
                        break;

                    case 12:
                        System.out.println("-------------------Display Borrowed Books-------------------");
                        biblio.displayBorrowedBooks();
                        break;
                    default:
                        break;
                }
                System.out.print("\ttapez 0 pour quitter ou 1 pour rester dans le MENU : ");
                choix1 = sc.nextInt();
            } while (choix1 != 0);
        } catch (BookAlreadyBorrowedException e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        } catch (BookNotBorrowedException e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        }catch (Exception e) {
            // TODO: handle exception
            System.out.print(e.getMessage());
        }
    }
}