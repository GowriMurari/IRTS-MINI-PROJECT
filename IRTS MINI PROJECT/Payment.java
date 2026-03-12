import java.util.*;

//================== PAYMENT ==================
class Payment extends CSRP
{
    static void process(double amount, Scanner sc)
    {
        PaymentService payment = null;

        while (true)
        {
            System.out.println(ANS_YELLOW+"\nSelect Payment Method:"+ANS_RESET);
            System.out.println("1. "+ANSI_ORANGE+"UPI"+ANS_RESET);
            System.out.println("2. Card");
            System.out.println("3. "+ANSI_LIME_GREEN+"NetBanking"+ANS_RESET);

            int choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    payment = new UPIPayment();
                    break;
                case 2:
                    payment = new CardPayment();
                    break;
                case 3:
                    payment = new NetBanking();
                    break;
                default:
                    System.out.println(ANSI_RED+"Invalid payment option! Try again\n"+ANS_RESET);
                    continue;
            }

            payment.pay(amount);
            break;
        }
    }
}
