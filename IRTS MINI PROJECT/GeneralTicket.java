import java.util.*;

class GeneralTicket extends CSRP
{
    static void book(Scanner sc)
    {
        System.out.println(ANSI_BLUE+"\nAvailable Stations:"+ANS_RESET);
        System.out.println(Station.stationText);

        System.out.print(ANSI_SKY_BLUE+"\nEnter From Station: "+ANS_RESET);
        String from = sc.next().toLowerCase();

        System.out.print(ANSI_SKY_BLUE+"Enter To Station: "+ANS_RESET);
        String to = sc.next().toLowerCase();

        int fromIndex = -1, toIndex = -1;

        for(int i = 0; i < Station.stations.length; i++)
        {
            if(Station.stations[i].equals(from))
                fromIndex = i;
            if(Station.stations[i].equals(to))
                toIndex = i;
        }

        // Invalid or same station
        if(fromIndex == -1 || toIndex == -1 || fromIndex == toIndex)
        {
            System.out.println(ANSI_RED+"Invalid Station Selection\n"+ANS_RESET);
            return;
        }

        int totalDistance = 0;

        // Forward journey
        if(fromIndex < toIndex)
        {
            for(int i = fromIndex; i < toIndex; i++)
                totalDistance += Station.distances[i];
        }
        // Reverse journey
        else
        {
            for(int i = toIndex; i < fromIndex; i++)
                totalDistance += Station.distances[i];
        }

        // -------- NUMBER OF PERSONS ----------
        int persons;
        while(true)
        {
            System.out.print(ANSI_SKY_BLUE+"Enter Number of Persons (Max 6): "+ANS_RESET);
            persons = sc.nextInt();

            if(persons >= 1 && persons <= 6)
                break;

            System.out.println(ANSI_RED+"Invalid number of persons, Try Again\n"+ANS_RESET);
        }

        // -------- FARE CALCULATION ----------
        double farePerPerson = totalDistance * 0.5;
        if(farePerPerson < 30)
            farePerPerson = 30;

        double totalFare = farePerPerson * persons;

        System.out.println(ANSI_BLUE+"\nTotal Distance   : "+ANS_RESET+"" + totalDistance + " km");
        System.out.println(ANSI_BLUE+"No of Persons    : "+ANS_RESET+"" + persons);
        System.out.println(ANSI_BLUE+"Fare per Person : Rs "+ANS_RESET+"" + farePerPerson);
        System.out.println(ANSI_BLUE+"Total Fare      "+ANS_RESET+": Rs " + totalFare);
        System.out.println(ANS_YELLOW+"Proceed to Payment? (Y/N)"+ANS_RESET);

        char ch = sc.next().charAt(0);
        if(ch == 'Y' || ch == 'y')
        {
            Payment.process(totalFare, sc);
            // Save to booking history
            BookingHistory.saveGeneralTicket(from, to, totalDistance, totalFare, persons);
            TicketDisplay.askShowGeneralTicket(from, to, totalDistance, totalFare, persons, sc);
        }
    }
}
