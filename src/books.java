public class books {
    int ISBN;
    String title;
    String author;
    String company;

    boolean issuestatus;
    String issuedby;
    books(int ISBN,String title,String author,String company){
        this.ISBN=ISBN;
        this.title=title;
        this.author=author;
        this.company=company;
        this.issuestatus=false;
        this.issuedby="";

    }
}
