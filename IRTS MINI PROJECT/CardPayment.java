class CardPayment extends CSRP implements PaymentService
{
    public void pay(double amount) 
    {
        System.out.println(ANSI_GREEN+"Payment of Rs : " + amount + " successful using Card\n"+ANS_RESET);
    }
}
