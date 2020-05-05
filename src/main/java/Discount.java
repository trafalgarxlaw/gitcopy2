/**
 * Created by William Flageol on 2020-04-30.
 */
public class Discount {

    private double discountvalue;
    private int booksQuantity; //the number of different books requierd to apply the discount

    // un Discount nécessite deux attributs : un nombre de livres sur lequel le
    // rabais s'applique, et le rabais lui-même
    public Discount(int BooksQuantity, double Discount) {
        this.discountvalue = Discount;
        this.booksQuantity = BooksQuantity;
    }

    // verify if a discount can be applied to the basket
    public boolean canBeApplied(Basket basket) {
        boolean canBeApplied = false;
        if (basket.howManyDifferent() >= booksQuantity) {
            canBeApplied = true;
        }
        return canBeApplied;
    }

    public double apply(double basePrice) {
        return basePrice * booksQuantity * discountvalue;
    }

    //removes booksQuantity of books from the basket, because we applied the discount to those books and paid them.
    // Only different books should be removed, the ones we applied a discount for.
    public Basket removePaidBooks(Basket basket) {
        return basket.removeDifferent(booksQuantity);

    }
}
