import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by William Flageol on 2020-04-30.
 */
public class Basket {
    private int numberBooks;
    private boolean isEmpty = true;
    private Book[] Books;
    private ArrayList<Book> BooksArray;

    public Basket(Book[] books) {
        this.numberBooks = books.length;
        this.isEmpty = books.length == 0;
        this.BooksArray = new ArrayList<>(Arrays.asList(books));
    }

    // returns how many books are equals to the specidied book
    public long howMany(Book searchedbook) {
        int counter = 0;
        for (Book book : Books) {
            if (book.equals(searchedbook)) {
                counter++;
            }
        }
        return counter;
    }

    public long howManyDifferent() {

        List<Book> listWithoutDuplicates = this.BooksArray.stream().distinct().collect(Collectors.toList());

        return listWithoutDuplicates.size();
    }

    public int howManyBooks() {
        return this.numberBooks;
    }

    public boolean isEmpty() {
        return this.isEmpty;

    }

    // removeDifferent retire un nombre de livres différents du panier
    public Basket removeDifferent(int quantity) {
        int removed=0;

        for (int i = 0; i < this.numberBooks && removed<quantity ; i++) {
            for (int j = i+1; j < this.numberBooks && removed<quantity; j++) {

                if (this.BooksArray.get(i).equals(this.BooksArray.get(j))) {
                    this.BooksArray.remove(i);
                    this.BooksArray.remove(j);
                    removed=removed+2;
                    this.numberBooks=numberBooks-2;
                    i=0;j=1;
                    
                }
                
            } 
        }
        Book[] newbooks= new Book[this.BooksArray.size()];
        newbooks = this.BooksArray.toArray(newbooks);



        Basket basket = new Basket(newbooks);

        return basket;
    }
 }
