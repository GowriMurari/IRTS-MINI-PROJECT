import java.util.*;

class PlatformTicket extends CSRP
{
    static void book(Scanner sc) 
    {
        int persons;
        while(true)
        {
            System.out.print(ANSI_SKY_BLUE+"Enter Number of Persons (Max 5): "+ANS_RESET);
            persons = sc.nextInt();

            if(persons >= 1 && persons <= 5)
                break;

            System.out.println(ANSI_RED+"Invalid number of persons, Try Again\n"+ANS_RESET);
        }

        double farePerPerson = 10;
        double totalFare = persons * farePerPerson;

        System.out.println(ANSI_BLUE+"Total Fare: Rs : "+ANS_RESET+"" + totalFare+"\n"+ANS_YELLOW+"Do You want to Proceed {Y/N}"+ANS_RESET);
        char ch = sc.next().charAt(0);
        if(ch=='Y' || ch=='y')
        {
            Payment.process(totalFare, sc);
            // Save to booking history
            BookingHistory.savePlatformTicket(persons, totalFare);
            System.out.println();
            while(true)
            {
                System.out.println(ANS_YELLOW+"Display Ticket ?{Y/N}"+ANS_RESET);
                char ch2 = sc.next().charAt(0);
                if(ch2 == 'Y' || ch2 == 'y')
                {
                    TicketDisplay.showPlatformTicket(persons, totalFare, sc);
                    break;
                }
                else if(ch2 == 'N' || ch2 == 'n')
                {
                    System.out.println();
                    break;
                }
                else
                {
                    System.out.println(ANSI_RED+"Invalid Input, Try Again...\n"+ANS_RESET);
                }
            }
        }
        else if(ch=='n' || ch=='N')
        {
            System.out.println();
        }
        else
        {
            System.out.println(ANSI_RED+"Invalid Input\n"+ANS_RESET);
        }
    }
}
