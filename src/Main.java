//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);


        double monthAverage;
        double weekAverage;
        int weekAmount;
        double discMonth;
        double discWeek;
        double coupon;
        double bill = 0.0;


        // Ask user for coupon amount in decimal format
        System.out.println("Please enter the value of coupon as decimal ( .25 for 25%):");
        coupon = scanner.nextDouble();

        // set coupon value to 10 % if input is <= 0 or > 1
        if (coupon <= 0 || coupon > 1) {
            coupon = 0.10;
            System.out.println("Setting to default 10%.");
        }

        // Ask user how many weeks to calculate
        System.out.println("How many weeks of grocery bills do you want to enter (between 1 and 4)?");
        weekAmount = scanner.nextInt();

        while (weekAmount < 1 || weekAmount > 4) {
            System.out.println("Enter how many weeks (1 to 4):");
            weekAmount = scanner.nextInt();
        }

        // Get user input for grocery bill amounts
        for (int i = 1; i <= weekAmount; i++) {
            System.out.println("Enter the grocery bill for week " + i + ":");
            bill += scanner.nextDouble();
        }

        // Calculate averages for month and week, a month = 4 weeks
        monthAverage = (bill / weekAmount) * 4;
        weekAverage = bill / weekAmount;

        // multiply monthly avg by coupon amount to get discount
        discMonth = monthAverage * coupon;
        discWeek = weekAverage * coupon;

        // Display results to user
        System.out.println("Your monthly total without coupon is: " + monthAverage);
        System.out.println("Your weekly grocery expense average without coupon is: " + weekAverage);
        System.out.println("Your monthly total with a coupon is: " + (monthAverage - discMonth));
        System.out.println("Your weekly grocery expense average with a coupon is: " + (weekAverage - discWeek));
    }

}