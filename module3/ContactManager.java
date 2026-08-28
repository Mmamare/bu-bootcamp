
import java.util.*;

public class ContactManager {
    public static void main(String[] args) {
        
        Map<String, Contact> contacts = new HashMap<>();

        contacts.put("John Kim", new Contact("John Kim", "617-555-1251"));
        contacts.put("William Ford", new Contact("William Ford", "617-555-1252"));
        contacts.put("Chala Kebede", new Contact("Chala Kebede", "617-555-1253"));
        contacts.put("Mimi Abebe", new Contact("Mimi Abebe", "617-555-1254"));
        contacts.put("Ebero Edo", new Contact("Ebero Edo", "617-555-1255"));

        Contact contact = contacts.get("Chala Kebede");

        if(contact != null){
            System.out.println(contact);
        }else{
            System.out.println("Contact not found");
        }

        ArrayList<Contact> contctsList = new ArrayList<>(contacts.values());


        contctsList.sort((a,b) -> a.getName().compareTo(b.getName()));
        System.out.println("\n=== All Contacts ===\n");
       
            for(Contact contact1: contctsList){
                System.out.println(contact1);
            }
        
        

        
    }
}