import java.util.*;

class BookingHistory extends CSRP
{
    // Storage for booking history
    static ReservationBooking lastReservationTicket = null;
    static GeneralBooking lastGeneralTicket = null;
    static PlatformBooking lastPlatformTicket = null;

    // Inner class to store Reservation Ticket details
    static class ReservationBooking
    {
        int trainNo;
        String trainName;
        int fromStation;
        int toStation;
        int classType;
        String passengerDetails;
        double totalFare;

        ReservationBooking(int trainNo, String trainName, int fromStation, int toStation, 
                          int classType, String passengerDetails, double totalFare)
        {
            this.trainNo = trainNo;
            this.trainName = trainName;
            this.fromStation = fromStation;
            this.toStation = toStation;
            this.classType = classType;
            this.passengerDetails = passengerDetails;
            this.totalFare = totalFare;
        }
    }

    // Inner class to store General Ticket details
    static class GeneralBooking
    {
        String from;
        String to;
        int distance;
        double totalFare;
        int persons;

        GeneralBooking(String from, String to, int distance, double totalFare, int persons)
        {
            this.from = from;
            this.to = to;
            this.distance = distance;
            this.totalFare = totalFare;
            this.persons = persons;
        }
    }

    // Inner class to store Platform Ticket details
    static class PlatformBooking
    {
        int persons;
        double totalFare;

        PlatformBooking(int persons, double totalFare)
        {
            this.persons = persons;
            this.totalFare = totalFare;
        }
    }

    // Show booking history menu
    static void showHistory(Scanner sc)
    {
        while(true)
        {
            System.out.println(ANS_YELLOW+"\n========== Booking History =========="+ANS_RESET);
            System.out.println("1. "+ANSI_RED+"Show Reservation Ticket"+ANS_RESET);
            System.out.println("2. "+ANSI_GREEN+"Show General Ticket"+ANS_RESET);
            System.out.println("3. "+ANSI_ORANGE+"Show Platform Ticket"+ANS_RESET);
            System.out.println("4. "+ANSI_LIME_GREEN+"Back"+ANS_RESET);

            int choice = sc.nextInt();

            if(choice == 1)
            {
                if(lastReservationTicket != null)
                {
                    TicketDisplay.showReservationTicket(
                        lastReservationTicket.trainNo,
                        lastReservationTicket.trainName,
                        lastReservationTicket.fromStation,
                        lastReservationTicket.toStation,
                        lastReservationTicket.classType,
                        lastReservationTicket.passengerDetails,
                        lastReservationTicket.totalFare,
                        sc
                    );
                }
                else
                {
                    TicketDisplay.scrollingPrint(ANSI_RED+"\nNo results found..."+ANS_RESET);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_LIGHT_PINK+"Please click any letter and enter to exit"+ANS_RESET);
                    System.out.println();
                    sc.next();
                    System.out.println();
                }
            }
            else if(choice == 2)
            {
                if(lastGeneralTicket != null)
                {
                    TicketDisplay.scrollingPrint(ANS_YELLOW+"\n======= GENERAL TICKET ======="+ANS_RESET);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"From          : "+ANS_RESET+"" + lastGeneralTicket.from.toUpperCase());
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"To            : "+ANS_RESET+"" + lastGeneralTicket.to.toUpperCase());
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"No of Persons : "+ANS_RESET+"" + lastGeneralTicket.persons);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"Distance      : "+ANS_RESET+"" + lastGeneralTicket.distance + " km");
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"TotalFare     : Rs "+ANS_RESET+"" + lastGeneralTicket.totalFare+"\n");
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_LIGHT_PINK+"Please click any letter and enter to exit"+ANS_RESET);
                    System.out.println();
                    sc.next();
                    System.out.println();
                }
                else
                {
                    TicketDisplay.scrollingPrint(ANSI_RED+"\nNo results found..."+ANS_RESET);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_LIGHT_PINK+"Please click any letter and enter to exit"+ANS_RESET);
                    System.out.println();
                    sc.next();
                    System.out.println();
                }
            }
            else if(choice == 3)
            {
                if(lastPlatformTicket != null)
                {
                    TicketDisplay.scrollingPrint(ANS_YELLOW+"\n==========Platform Ticket Details=========="+ANS_RESET);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"No of Persons : "+ANS_RESET+""+lastPlatformTicket.persons);
                    System.out.println();
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_BLUE+"Total Fare : "+ANS_RESET+""+lastPlatformTicket.totalFare+"\n");
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_LIGHT_PINK+"Please click any letter and enter to exit"+ANS_RESET);
                    System.out.println();
                    sc.next();
                    System.out.println();
                }
                else
                {
                    TicketDisplay.scrollingPrint(ANSI_RED+"\nNo results found..."+ANS_RESET);
                    System.out.println();
                    TicketDisplay.scrollingPrint(ANSI_LIGHT_PINK+"Please click any letter and enter to exit"+ANS_RESET);
                    System.out.println();
                    sc.next();
                    System.out.println();
                }
            }
            else if(choice == 4)
            {
                System.out.println();
                break;
            }
            else
            {
                System.out.println(ANSI_RED+"Invalid Choice, Try Again"+ANS_RESET);
            }
        }
    }

    // Save reservation ticket to history
    static void saveReservationTicket(int trainNo, String trainName, int fromStation, int toStation,
                                      int classType, String passengerDetails, double totalFare)
    {
        lastReservationTicket = new ReservationBooking(trainNo, trainName, fromStation, toStation,
                                                       classType, passengerDetails, totalFare);
    }

    // Save general ticket to history
    static void saveGeneralTicket(String from, String to, int distance, double totalFare, int persons)
    {
        lastGeneralTicket = new GeneralBooking(from, to, distance, totalFare, persons);
    }

    // Save platform ticket to history
    static void savePlatformTicket(int persons, double totalFare)
    {
        lastPlatformTicket = new PlatformBooking(persons, totalFare);
    }
}
