import java.util.*;

class ReservationTicket extends CSRP
{
    static final int MAX_DAYS_ADVANCE = 30;
    static String journeyDateStr;

    static void book(Scanner sc)
    {
        String from, to;
        int fromIndex, toIndex;

        // -------- FROM STATION ----------
        while(true)
        {
            System.out.println(ANSI_SKY_BLUE+"Available Stations : "+ANS_RESET+"" + Station.stationText);
            System.out.print("Enter From Station : ");
            from = sc.next().toLowerCase();

            fromIndex = Station.getStationIndex(from);
            if(fromIndex != -1)
                break;

            System.out.println("Invalid station. Please re-enter.\n");
        }

        // -------- TO STATION ----------
        while(true)
        {
            System.out.println(ANSI_SKY_BLUE+"Available Stations : "+ANS_RESET+"" + Station.stationText);
            System.out.print("Enter To Station : ");
            to = sc.next().toLowerCase();

            toIndex = Station.getStationIndex(to);
            if(toIndex == -1)
            {
                System.out.println(ANSI_RED+"Invalid station. Please re-enter.\n"+ANS_RESET);
                continue;
            }

            if(fromIndex == toIndex)
            {
                System.out.println(ANSI_ORANGE+"From and To stations cannot be same.\n"+ANS_RESET);
                continue;
            }
            break;
        }

        // -------- JOURNEY DATE ----------
        Calendar journeyDate = null;
        while(true)
        {
            System.out.print(ANSI_SKY_BLUE+"Enter Journey Date"+ANS_RESET+" ("+ANSI_ORANGE+"DD "+ANS_RESET+"MM "+ANSI_LIME_GREEN+"YYYY"+ANS_RESET+") : ");
            int d = sc.nextInt();
            int m = sc.nextInt();
            int y = sc.nextInt();

            journeyDate = Calendar.getInstance();
            journeyDate.setLenient(false);

            try
            {
                journeyDate.set(y, m-1, d);

                Calendar today = Calendar.getInstance();
                Calendar limit = Calendar.getInstance();
                limit.add(Calendar.DAY_OF_MONTH, MAX_DAYS_ADVANCE);

                if(journeyDate.before(today))
                {
                    System.out.println(ANSI_RED+"Journey date cannot be in past.\n"+ANS_RESET);
                    continue;
                }
                if(journeyDate.after(limit))
                {
                    System.out.println(ANSI_RED+"Journey date must be within 30 days.\n"+ANS_RESET);
                    continue;
                }
                journeyDateStr = d + "-" + m + "-" + y;
                break;
            }
            catch(Exception e)
            {
                System.out.println(ANSI_RED+"Invalid date. Please re-enter.\n"+ANS_RESET);
            }
        }

        int day = journeyDate.get(Calendar.DAY_OF_WEEK);

        // -------- CLASS TYPE ----------
        int classChoice;
        while(true)
        {
            System.out.println("Select Class Type :");
            System.out.println("1. "+ANSI_ORANGE+"2S\n"+ANS_RESET+"2. SL\n3. "+ANSI_GREEN+"3AC"+ANS_RESET);
            classChoice = sc.nextInt();

            if(classChoice >= 1 && classChoice <= 3)
                break;

            System.out.println(ANSI_RED+"Invalid class type.\n"+ANS_RESET);
        }

        // -------- DISPLAY TRAINS ----------
        Train.displayAvailableTrains(fromIndex, toIndex, day, classChoice, sc);
    }

    static void bookPassengers(
        int fromIdx,
        int toIdx,
        int classType,
        int trainNo,
        String trainName,
        int t1, 
        int t2,
        Scanner sc
    )
    {
        int count;

        while(true)
        {
            System.out.print(ANSI_BLUE+"Enter Number of Passengers (Max 4) : "+ANS_RESET);
            count = sc.nextInt();
            if(count >= 1 && count <= 4)
                break;
            System.out.println(ANSI_RED+"Invalid number."+ANS_RESET);
        }

        int distance = 0;
        if(fromIdx < toIdx)
            for(int i = fromIdx; i < toIdx; i++) distance += Station.distances[i];
        else
            for(int i = toIdx; i < fromIdx; i++) distance += Station.distances[i];

        double rate = (classType == 1) ? 0.5 : (classType == 2 ? 1.0 : 2.0);

        double totalFare = 0;
        String passengerDetails = "";

        for(int i = 1; i <= count; i++)
        {
            System.out.println(ANSI_SKY_BLUE+"\nPassenger "+ANS_RESET+""+ i);

            System.out.print("Name : ");
            String name = sc.next();

            int age;
            do {
                System.out.print("Age : ");
                age = sc.nextInt();
            } while(age <= 0);

            char gender;
            do {
                System.out.print("Gender "+ANSI_BLUE+"(M/F) : "+ANS_RESET);
                gender = Character.toUpperCase(sc.next().charAt(0));
            } while(gender!='M' && gender!='m' && gender!='F' && gender!='f');

            double fare = distance * rate;
            if(age <= 12 || age >= 60)
                fare *= 0.8;

            String berth;
            while(true)
            {
                System.out.print("Berth Preference "+ANSI_BLUE+"(LB/MB/UB/SL/SU/SKIP) : "+ANS_RESET);
                String pref = sc.next().toUpperCase();
                if(pref.equals("SKIP") || pref.equals("skip"))
                {
                    if(age >= 60 && gender=='M')
                    {
                        berth = "SU";
                        break;
                    } 
                    else if(age <= 12)
                    {
                        berth = "UB";
                        break;
                    } 
                    else if(age >=45 && age<=60 && gender=='F')
                    {
                        berth = "LB";
                        break;
                    }
                    else if(age>=60 && gender=='F')
                    {
                        berth = "SL";
                        break;
                    }
                    else if(classType==1)
                    {
                        berth = "NC";
                        break;
                    }
                    else
                    {
                        berth = "MB";
                        break;
                    } 
                }
                else
                {
                    if(pref.equals("UB") || pref.equals("MB") || pref.equals("LB") || pref.equals("SL") || pref.equals("SU") || pref.equals("WS") && classType==1)
                    {
                        berth = pref;
                        break;
                    }
                    else
                    {
                        System.out.println(ANSI_RED+"Invalid Input, Try Again"+ANS_RESET);
                    }
                    
                }
            }

            passengerDetails +=
                ANSI_BLUE+""+ i + ""+ANS_RESET+". " + name +
                " | Age " + age +
                " | Gender " + gender +
                " | Berth " + berth +"\n";

            totalFare += fare;
        }

        System.out.print(ANS_YELLOW+"\nProceed to Payment?"+ANS_RESET+" (Y/N) : ");
        char ch = sc.next().charAt(0);

        if(ch=='Y' || ch=='y')
        {
            Payment.process(totalFare, sc);
            System.out.println(ANS_YELLOW+"Do You Want to Display Ticket"+ANS_RESET+" {Y/N}");
            char ch4 = sc.next().charAt(0);
            while(true)
            {
                if(!(ch4=='Y' || ch4=='y' || ch4=='N' || ch4=='n'))
                {
                    System.out.println(ANSI_RED+"Invalid Input, Try Again"+ANS_RESET);
                    ch4 = sc.next().charAt(0);
                    continue;
                }
                break;
            }
            // Save to booking history
            BookingHistory.saveReservationTicket(trainNo, trainName, t1, t2, classType, passengerDetails, totalFare);
            
            if(ch4=='Y' || ch4 == 'y')
            {
                TicketDisplay.showReservationTicket(trainNo, trainName, t1, t2, classType, passengerDetails, totalFare, sc);
            }
        }
    }
}
