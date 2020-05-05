import java.util.Arrays;
import java.util.List;

/**
 * Created by William Flageol on 2020-04-30.
 */
public class Cashier {
    private double price; //the base price
    private Discount[] discounts; // sets of book discounts

    // constructor, takes the base price (8$ in our case) and the associated
    // discounts
    public Cashier(int basePrice, Discount[] discounts) {
        this.price = basePrice;
        this.discounts = discounts;
    }



    //this methode calculates the optimal (lower) combinaison of discounts that can be applied to the basket
    public double compute(Basket basket) {
        // if the basket is empty
        if (basket.isEmpty()) {
            return 0.0;
        }

        // finds the discounts that can be applied in the basket -> {5%,10%,20%,25%}
        Discount[] availables = findAvailableDiscount(basket);

        if (availables.length == 0)
            // if there is no discount to apply, we return the base price * number of books
            return price * basket.howManyBooks();
        else
            return Arrays.stream(availables).map(discount -> compute(basket, discount)) // this function let us replace
                                                                                        // every elements in the discount array with
                                                                                        // the basket price associated to the discount.
                    .min(Double::compare).get();// get the minimum value of the array of prices
    }

    // Applies a specific discount to the basket
    private double compute(Basket basket, Discount discount) {
        double local = discount.apply(price);
        Basket remaining = discount.removePaidBooks(basket);
        return local + compute(remaining);
    }

    //returns an array of discounts by testing if a discount in the array of discounts can be applied in the basket
    private Discount[] findAvailableDiscount(Basket basket) {
        return Arrays.stream(discounts).filter(discount -> discount.canBeApplied(basket)).toArray(Discount[]::new);
    }
}
