class NetBanking extends CSRP implements PaymentService 
{
    public void pay(double amount) 
    {
        System.out.println(ANSI_GREEN+"Payment of Rs : " + amount + " successful using Netbanking\n"+ANS_RESET);
    }
}
