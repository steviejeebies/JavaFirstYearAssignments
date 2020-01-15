import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore {
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args) {
        ArrayList<Book> bookList = new ArrayList<Book>();
        try {
            FileReader fileReader = new FileReader("booklist.txt");// Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            while(!endOfFile){
                String bookLine = bufferedReader.readLine();
                if (bookLine != null) {
                    String[] bookData = bookLine.split(", ");
                    String isbn = bookData[ISBN_INDEX];
                    String title = bookData[TITLE_INDEX];
                    String author = bookData[AUTHOR_INDEX];
                    String publisher = bookData[PUBLISHER_INDEX];
                    int publishYear = Integer.parseInt (bookData[PUBLISHER_YEAR_INDEX]);
                    int quantity = Integer.parseInt (bookData[QUANTITY_INDEX]);
                    double price = Double.parseDouble (bookData[PRICE_INDEX]);
                    Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
                    bookList.add(book);

                } else {
                    endOfFile = true;
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        printBookDetails(bookList);
        purchaseBook(bookList);
    }

    public static void printBookDetails(ArrayList<Book> bookList)
    {
        for(Book currentBook : bookList)
        {
            System.out.println(currentBook);
        }
    }

    public static Book getBook(ArrayList<Book> bookList, String title)
    {

        for(Book currentBook : bookList)
        {
            String currentBookTitle = currentBook.getTitle();

            if((currentBookTitle.equalsIgnoreCase(title)))
                return currentBook;
        }

        return null;
    }

    public static void topUpCard(ChargeCard card, double amount)
    {
        if(amount<0)
        {
            card.topUpFunds(amount);
        }
    }

    public static void purchaseBook(ArrayList<Book> bookList)
    {
        System.out.println("Enter your funds:");
        Scanner userInput = new Scanner(System.in);
        ChargeCard userCard = new ChargeCard();
        boolean finished = false;

        try
        {
            double userFunds = userInput.nextDouble();

            if(userFunds > 0)
            {
                userCard.topUpFunds(userFunds);

                while(!finished)
                {
                    System.out.println("What book would you like?");
                    userInput = new Scanner(System.in);
                    userInput.useDelimiter("\r");

                    String userRequest = userInput.next();
                    Book requestedBook = getBook(bookList, userRequest);

                    if(requestedBook == null)
                    {
                        System.out.println(userRequest + " is not in stock.");
                    }
                    else
                    {
                        if(requestedBook.getQuantity()>0&&(userCard.getFunds()>=requestedBook.getPrice()))
                        {
                            requestedBook.setQuantity(requestedBook.getQuantity()-1);
                            userCard.removeFunds(requestedBook.getPrice());
                            System.out.println("Sale complete. You now have $" + userCard.getFunds() + ".");
                            finished = true;
                        }
                    }
                }
            }
            else
            {

            }
        }
        catch(java.util.InputMismatchException e)
        {
            System.out.println("Invalid input.");
        }
    }
}
