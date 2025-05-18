
import java.util.HashMap;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        books b1=new books(2345,"chemistry","xyx","S.CHAND");
        books b2=new books(1147,"PHYSICS","h. c. verma","S.CHAND");
        books b3=new books(1023,"english","PQR","TATA mchill");
        HashMap<Integer,books> bookdata=new HashMap<>();
        HashMap<Integer,Integer> issuedbookdata=new HashMap<>();

        bookdata.put(2345,b1);
        bookdata.put(1147,b2);
        bookdata.put(1023,b3);
        Scanner sc=new Scanner(System.in);
        int buttonpressed=0;
        int user=0;
        while(true){
            System.out.println("WELCOME TO LMS");
            System.out.println("1.BOOK");
            System.out.println("2.USER");
            System.out.println("3.EXIT");
            buttonpressed=sc.nextInt();
            if(buttonpressed==1){
                while(true){
                    System.out.println("WELCOME TO BOOK LMS");
                    System.out.println("1.ADD BOOK");
                    System.out.println("2.ISSUE BOOK ");
                    System.out.println("3.SHOW ALL BOOKS");
                    System.out.println("4.BACK");
                    buttonpressed=sc.nextInt();
                    if(buttonpressed==1){
                        if(user==1 || user==2) {
                            while (true) {
                                System.out.println("WELCOME TO ADD BOOK LMS");
                                System.out.println("ENTER ISBN-");
                                int isbn = sc.nextInt();
                                sc.nextLine();
                                System.out.println("ENTER TITLE");
                                String title = sc.nextLine();
                                System.out.println("ENTER AUTHOR");
                                String author = sc.nextLine();
                                System.out.println("ENTER COMPANY");
                                String company = sc.nextLine();
                                books bx = new books(isbn, title, author, company);
                                if (bookdata.containsKey(isbn)) {
                                    System.out.println("BOOK DATA ALREADY PRESENT");
                                } else {
                                    bookdata.put(isbn, bx);
                                    System.out.println("ADDED SUCCESSFULLY");
                                }
                                while (true) {
                                    System.out.println("1.ADD ANOTHER BOOK");
                                    System.out.println("2.SHOW ALL BOOKS");
                                    System.out.println("3.BACK");
                                    buttonpressed = sc.nextInt();
                                    if (buttonpressed == 1) break;
                                    else if (buttonpressed == 2) {
                                        System.out.println("BOOKS DETAILS ARE AS FOLLOWS-");
                                        for (var e : bookdata.entrySet()) {
                                            System.out.println("ISBN-" + e.getValue().ISBN);
                                            System.out.println("title-" + e.getValue().title);
                                            System.out.println("author-" + e.getValue().author);
                                            System.out.println("company-" + e.getValue().company);
                                            System.out.println("status-" + e.getValue().issuestatus);
                                            System.out.println("issuedby-" + e.getValue().issuedby);
                                            System.out.println();
                                        }
                                        System.out.println();
                                    } else if (buttonpressed == 3) break;
                                    else {
                                        System.out.println("INVALID ENTRY");
                                    }
                                }
                                if (buttonpressed == 3) break;
                            }
                        }else{
                            System.out.println("---USER NOT ALLOWED IN THIS DOMAIN---");
                        }
                    }
                    else if(buttonpressed==2){
                        if(user==1 || user==2) {
                            while (true) {
                                System.out.println("ENTER ISBN-");
                                int enteredisbn = sc.nextInt();
                                sc.nextLine();
                                if (bookdata.containsKey(enteredisbn) && bookdata.get(enteredisbn).issuestatus == true) {
                                    System.out.println("BOOKS IS ALREADY ISSUED TO SOMEONE ELSE");
                                } else if (bookdata.containsKey(enteredisbn) && bookdata.get(enteredisbn).issuestatus == false) {
                                    System.out.println("BOOK IS AVAILABLE TO ISSUE");
                                    System.out.println("PERSON ID-");
                                    int enteredid = sc.nextInt();
                                    sc.nextLine();
                                    issuedbookdata.put(enteredisbn, enteredid);
                                    bookdata.get(enteredisbn).issuestatus = true;
                                    bookdata.get(enteredisbn).issuedby = "user-"+user;
                                    System.out.println("ISSUED SUCCESSFULLY");


                                } else {
                                    System.out.println("----ENTERED BOOK ISBN IS NOT VALID---");
                                    System.out.println();
                                }
                                while (true) {
                                    System.out.println("1.ISSUE ANOTHER BOOK");
                                    System.out.println("2.SHOW ALL ISSUED BOOKS");
                                    System.out.println("3.BACK");
                                    buttonpressed = sc.nextInt();
                                    if (buttonpressed == 1) break;
                                    else if (buttonpressed == 2) {
                                        if (issuedbookdata.isEmpty()) {
                                            System.out.println("NONE OF THE INVENTORY BOOKS ISSUED");
                                            System.out.println();
                                        } else {
                                            for (var e : issuedbookdata.entrySet()) {
                                                System.out.println("ISBN-" + e.getKey());
                                                System.out.println("Issued to-" + e.getValue());
                                                System.out.println();
                                            }
                                            System.out.println();
                                        }
                                    } else if (buttonpressed == 3) break;
                                    else {
                                        System.out.println("INVALID ENTRY");
                                    }
                                }
                                if (buttonpressed == 3) break;
                            }
                        }else{

                                System.out.println("---USER NOT ALLOWED IN THIS DOMAIN---");

                        }

                    }
                    else if(buttonpressed==3){
                        System.out.println("BOOKS DETAILS ARE AS FOLLOWS-");
                        for(var e :bookdata.entrySet()) {

                            System.out.println("ISBN-"+e.getValue().ISBN);
                            System.out.println("title-"+e.getValue().title);
                            System.out.println("author-"+e.getValue().author);
                            System.out.println("company-"+e.getValue().company);
                            System.out.println("status-"+e.getValue().issuestatus);
                            System.out.println("issuedby-" + e.getValue().issuedby);
                            System.out.println();
                        }
                        System.out.println();
                    }
                    else if(buttonpressed==4)break;
                    else{
                        System.out.println("---INVALID ENTRY---");
                    }
                }
            }
            else if(buttonpressed==2){
                System.out.println("1-USER 1");
                System.out.println("2-USER 2");
                buttonpressed=sc.nextInt();
                sc.nextLine();
                if(buttonpressed==1){
                    user=1;
                    System.out.println("USER 1 SELECTED SUCCESSFULLY");
                }
                else if(buttonpressed==2){
                    user=2;
                    System.out.println("USER 2 SELECTED SUCCESSFULLY");
                }
                else{
                    user=0;
                    System.out.println("DEFAULT USER SELECTED");
                }
            }
            else if(buttonpressed==3)break;
            else{
                System.out.println("---INVALID ENTRY---");
                System.out.println();
            }


        }

    }
}