import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCreation;

/**
 * JournalTransaction
 */
public class JournalTransaction {

    public static ArrayList<String> listtransaction = new ArrayList<String>();
    LocalDateTime current = LocalDateTime.now();
    public JournalTransaction(Student student, Book book, int type) {
        if(type==1){
            listtransaction.add("l'etudiant "+student.getNom() + " a retouné le livre " + book.getTitle()+" le "+current);
        }else{
            listtransaction.add("l'etudiant "+student.getNom() + " a emprunté le livre " + book.getTitle()+" le "+current);
        }
        
    }

    public static void affichertransaction() {
        for (int i = 0; i < listtransaction.size(); i++) {
            System.out.println(listtransaction.get(i));

        }

    }

}