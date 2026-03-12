// ================== POLYMORPHISM ==================
class UPIPayment extends CSRP implements PaymentService 
{
    public void pay(double amount) 
    {
        System.out.println(ANSI_GREEN+"Payment of Rs : " + amount + " successful using UPI\n"+ANS_RESET);
    }
}
