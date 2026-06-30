package J03_Conditionals;
import java.util.Scanner;
/*
* Ques: If cost price and selling price of an
item is input through the keyboard, write a
program to determine whether the seller
has made profit or incurred loss or no profit
no loss. Also determine how much profit he
made or loss he incurred.
* */

public class C05_ProfitOrLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the cost price: ");
        double costPrice = sc.nextDouble();
        System.out.print("Enter the selling price: ");
        double sellingPrice = sc.nextDouble();

        if (costPrice < sellingPrice) {
            double profit = sellingPrice - costPrice;
            System.out.println("The seller made profit of $" + profit);
            System.out.println("Profit Percentage: " + (profit / costPrice) * 100 + "%");
        } else if (costPrice > sellingPrice) {
            double loss = costPrice - sellingPrice;
            System.out.println("The seller faced loss of $" + loss);
            System.out.println("Loss Percentage: " + (loss / sellingPrice) * 100 + "%");
        } else {
            System.out.println("He didn't make any profit nor loss.");
        }

        sc.close();
    }
}
