import java.util.*;

class TicketDisplay extends CSRP
{
    // Scrolling text animation method
    static void scrollingPrint(String text) {
        try {
            for(int i = 0; i < text.length(); i++) {
                System.out.print(text.charAt(i));
                Thread.sleep(30); // 30ms delay per character
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    //================Platform Ticket Display==============
    
    static void showPlatformTicket(int ps, double tFare, Scanner sc)
    {
        scrollingPrint(ANS_YELLOW+"==========Platform Ticket Details==========\n"+ANS_RESET);
        System.out.println();
        scrollingPrint(ANSI_BLUE+"No of Persons : "+ANS_RESET+""+ps);
        System.out.println();
        System.out.println();
        scrollingPrint(ANSI_BLUE+"Total Fare : "+ANS_RESET+""+tFare+"\n");
        System.out.println();
        scrollingPrint(ANSI_LIGHT_PINK+"Please Click any Letter and Enter to Exit..."+ANS_RESET);
        System.out.println();
        char ch3 = sc.next().charAt(0);
    }

    static void askShowGeneralTicket(String from, String to, int dist, double fare, int persons, Scanner sc)
    {
        while(true)
        {
            System.out.println(ANS_YELLOW+"Display Ticket? (Y/N)"+ANS_RESET);
            char ch = sc.next().charAt(0);

            if(ch=='Y' || ch=='y')
            {
                scrollingPrint(ANS_YELLOW+"\n======= GENERAL TICKET ======="+ANS_RESET);
                System.out.println();
                scrollingPrint(ANSI_BLUE+"From          : "+ANS_RESET+"" + from.toUpperCase());
                System.out.println();
                scrollingPrint(ANSI_BLUE+"To            : "+ANS_RESET+"" + to.toUpperCase());
                System.out.println();
                scrollingPrint(ANSI_BLUE+"No of Persons : "+ANS_RESET+"" + persons);
                System.out.println();
                scrollingPrint(ANSI_BLUE+"Distance      : "+ANS_RESET+"" + dist + " km");
                System.out.println();
                scrollingPrint(ANSI_BLUE+"TotalFare     : Rs "+ANS_RESET+"" + fare+"\n");
                System.out.println();
                scrollingPrint(ANSI_LIGHT_PINK+"Please Click any Letter and Enter to Exit..."+ANS_RESET);
                System.out.println();
                char ch3 = sc.next().charAt(0);
                break;
            }
            else if(ch=='N' || ch=='n')
                break;
            else
                System.out.println(ANSI_RED+"Invalid Input"+ANS_RESET);
        }
    }

    static void showReservationTicket(int trainNo, String trainName, int t1, int t2, int classType, String passengerDetails, double totalFare, Scanner sc)
    {
        scrollingPrint(ANS_YELLOW+"\n=========== RESERVATION TICKET ==========="+ANS_RESET);
        System.out.println();
        scrollingPrint(ANSI_BLUE+"Train No      : "+ANS_RESET+"" + trainNo);
        System.out.println();
        scrollingPrint(ANSI_BLUE+"Train Name    : "+ANS_RESET+"" + trainName);
        System.out.println();
        scrollingPrint(ANSI_BLUE+"From Station  : "+ANS_RESET+"" + Station.stations[t1].toUpperCase());
        System.out.println();
        scrollingPrint(ANSI_BLUE+"To Station    : "+ANS_RESET+"" + Station.stations[t2].toUpperCase());
        System.out.println();

        System.out.print(ANSI_BLUE+"Class         : "+ANS_RESET);
        scrollingPrint(classType==1 ? "2S" : classType==2 ? "SL" : "3AC");
        System.out.println();

        scrollingPrint("-----------------------------------------");
        System.out.println();
        System.out.print(passengerDetails);
        scrollingPrint("-----------------------------------------");
        System.out.println();
        scrollingPrint(ANSI_SKY_BLUE+"Total Fare : Rs "+ANS_RESET+"" + totalFare);
        System.out.println();
        scrollingPrint(ANSI_ORANGE+"Status"+ANS_RESET+"     : "+ANSI_LIME_GREEN+"CONFIRMED"+ANS_RESET);
        System.out.println();
        scrollingPrint("=========================================");
        System.out.println();
        scrollingPrint(ANSI_LIGHT_PINK+"Press any key and Enter to Exit..."+ANS_RESET);
        System.out.println();
        sc.next();
        System.out.println();
    }
}
