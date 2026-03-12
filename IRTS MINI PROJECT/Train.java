import java.util.*;

class Train
{
    static void displayAvailableTrains(int fromIdx, int toIdx, int day, int classType, Scanner sc)
    {
        int option = 1;
        boolean found = false;
        boolean forward = fromIdx < toIdx;
        int t1=fromIdx, t2=toIdx;
        if(fromIdx > toIdx)
        {
            fromIdx = fromIdx + toIdx -(toIdx = fromIdx);
        }

        int[] trainNos = new int[10];
        String[] trainNames = new String[10];

        System.out.println("\nAvailable Trains :");

        // ========= CHENNAI ↔ SECUNDERABAD =========
        if(fromIdx >= 0 && toIdx <= 6 && fromIdx != toIdx)
        {
            if(classType == 2 || classType == 3)
            {
                trainNos[option] = forward ? 20629 : 20630;
                trainNames[option] = "Sabari Superfast Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }

            if(day != Calendar.FRIDAY && classType == 2)
            {
                trainNos[option] = forward ? 12525 : 12526;
                trainNames[option] = "Amrit Bharat Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }

            if(day != Calendar.WEDNESDAY && classType == 3)
            {
                trainNos[option] = forward ? 20101 : 20102;
                trainNames[option] = "Vande Bharat Sleeper Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }
        }

        // ========= CHENNAI ↔ VIJAYAWADA =========
        if(fromIdx >= 0 && toIdx <= 3 && fromIdx != toIdx)
        {
            if(classType == 1)
            {
                trainNos[option] = forward ? 12711 : 12712;
                trainNames[option] = "Pinakini Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }

            if(day != Calendar.TUESDAY && (classType == 2 || classType == 3))
            {
                trainNos[option] = forward ? 12512 : 12513;
                trainNames[option] = "Chennai Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }
        }

        // ========= VIJAYAWADA ↔ SECUNDERABAD =========
        if(fromIdx >= 3 && toIdx <= 6 && fromIdx != toIdx)
        {
            if(day != Calendar.TUESDAY && (classType == 2 || classType == 3))
            {
                trainNos[option] = forward ? 12727 : 12728;
                trainNames[option] = "Godavari Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }

            if(classType == 1)
            {
                trainNos[option] = forward ? 12713 : 12714;
                trainNames[option] = "Satavahana Express";
                System.out.println(option + ". " + trainNos[option] + " " + trainNames[option]);
                option++; found = true;
            }
        }

        if(!found)
        {
            System.out.println("No trains available for selected date and class.\n");
            return;
        }

        int choice;
        while(true)
        {
            System.out.print("\nEnter Train Choice : ");
            choice = sc.nextInt();
            if(choice >= 1 && choice < option)
                break;
            System.out.println("Invalid choice.");
        }

        ReservationTicket.bookPassengers(
            fromIdx,
            toIdx,
            classType,
            trainNos[choice],
            trainNames[choice],
            t1,
            t2,
            sc
        );
    }
}
