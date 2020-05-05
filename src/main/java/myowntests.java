import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myowntests {
    public static void main(String[] args) {
        Book mybook1 = new Book(1);
        Book mybook2 = new Book(2);
        Book mybook3 = new Book(3);
        Book mybook4 = new Book(4);
        Book mybook5 = new Book(5);

        // List<Book> list = new ArrayList<Book>() {
        //     {
        //         add(mybook1);
        //         add(mybook2);
        //         add(mybook3);
        //         add(mybook4);
        //         add(mybook5);

        //     }
        // };
        Book[] books={mybook1,mybook2,mybook3,mybook4,mybook5,mybook3,mybook4,mybook4};
        Basket basket = new Basket(books);

        basket=basket.removeDifferent(2);

        String greeting = "Hello";
        //System.out.println(greeting+basket.howManyDifferent());
        // System.out.println(basket);

    }
}