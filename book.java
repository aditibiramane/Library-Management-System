import java.util.Scanner;



class book {

int sNo;
String bookName;
String authorName;
int bookQty;
int bookQtyCopy;
Scanner input = new Scanner(System.in);
book theBooks[] = new book[50]; 
int count;

book(){

    System.out.println("Enter Serial No of Book:");
    this.sNo = input.nextInt();
    input.nextLine();
    System.out.println("Enter Book Name:");
    this.bookName = input.nextLine();
    System.out.println("Enter Author Name:");
    this.authorName = input.nextLine();
    System.out.println("Enter Quantity of Books:");
    this.bookQty = input.nextInt();
    bookQtyCopy = this.bookQty;

}

void addBook(book b){

    for (int i=0; i<count; i++){

        if (this.compareBookObjects(b, this.theBooks[i]) == 0)
            return;

    }

    if (count<50){

        theBooks[count] = b;
        count++;

    }
    else{

        System.out.println("No Space to Add More Books.");

    }

}

void searchBySno(){

    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo;
    System.out.println("Enter Serial No of Book:");
    sNo = input.nextInt();

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
            return;

        }

    }
    if (flag == 0){
        System.out.println("No Book for Serial No " + sNo + " Found.");}

}


void searchByAuthorName(){

    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
    input.nextLine();
    System.out.println("Enter Author Name:");
    String authorName = input.nextLine();
    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
        }

    }
    if (flag == 0)
        System.out.println("No Books of " + authorName + " Found.");

}

void showAllBooks(){

    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);


    }

}


void upgradeBookQty(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
    System.out.println("Enter Serial No of Book");
    int sNo = input.nextInt();
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println("Enter No of Books to be Added:");
            int addingQty = input.nextInt();
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;

        }

    }

}


void dispMenu(){

    System.out.println("----------------------------");
    System.out.println("Enter 0 to Exit Application.");
    System.out.println("Enter 1 to Add new Book.");
    System.out.println("Enter 2 to Upgrade Quantity of a Book.");
    System.out.println("Enter 3 to Search a Book.");
    System.out.println("Enter 4 to Show All Books.");
    System.out.println("Enter 5 to Register Student.");
    System.out.println("Enter 6 to Show All Registered Students.");
    System.out.println("Enter 7 to Check In Book. ");
    System.out.println("--------------------------");

}


int isAvailable(int sNo){

    //returns the index number if available



    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){
            if(theBooks[i].bookQtyCopy > 0){

                System.out.println("Book is Available.");
                return i;

            }
            System.out.println("Book is Unavailable");
            return -1;

        }

    }

    System.out.println("No Book of Serial Number " + " Available in Library.");
    return -1;


}




void checkInBook(){

    System.out.println("Enter the book name you want to withdraw");
     String bookname = input.nextLine();
    input.nextLine();
    System.out.println("Book Successfully Withdraw");
    
    

}

 int compareBookObjects(book b1, book b2){

    if (b1.bookName.equalsIgnoreCase(b2.bookName)){

        System.out.println("Book of this Name Already Exists.");
        return 0;

    }
    if (b1.sNo==b2.sNo){

        System.out.println("Book of this Serial No Already Exists.");
        return 0;
    }
    return 1;
}

String studentName;
String regNum;

book borrowedBooks[] = new book[3];
int booksCount = 0;

void addstudent(){

    System.out.println("Enter Student Name:");
    String studentName = input.nextLine();
    input.nextLine();

    System.out.println("Enter Reg Number:");
    String regNum = input.nextLine();

}

void showAllStudents(){
     
     System.out.println("\t\t\t\tSHOWING ALL STUDENTS\n");
    System.out.println("Student Name\t\tReg Number");
    {

        System.out.println("aditi");
         System.out.println("1234");



   }
}



public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("********************Welcome to the Student Library!********************");
    System.out.println("              Please Select From The Following Options:");
    System.out.println("******************");
    book ob = new book();
    int choice;
    int searchChoice;
   
do{

        ob.dispMenu();
        choice = input.nextInt();

        switch(choice){

            case 1:
                ob.addBook(ob);
                break;

            case 2:
                ob.upgradeBookQty();
                break;

            case 3:
                System.out.println("Enter 1 to Search with Serial No.");
                System.out.println("Enter 2 to Search with Author Name(Full Name).");
                searchChoice = input.nextInt();

                switch(searchChoice){

                    case 1:
                        ob.searchBySno();
                        break;
                    case 2:
                        ob.searchByAuthorName();

                }
                break;

            case 4:
                ob.showAllBooks();
                break;
            case 5:
                ob.addstudent();
                break;
            case 6:
                 ob.showAllStudents();
                 break;

            case 7:
                ob.checkInBook();
                break;
            default:
                System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 7.");

        }

    }
    while (choice!=0);

}



}





