import java.util.*;

// ===================== Main Class ==========================
class CSRP
{
    static Scanner sc = new Scanner(System.in);

    static void normalTicketMenu()
    {
        while(true)
        {
            System.out.println(ANSI_ORANGE+"\n1. Book Platform Ticket"+ANS_RESET);
            System.out.println("2. Book General Ticket");
            System.out.println(ANSI_LIME_GREEN+"3. Back"+ANS_RESET);

            int ch = sc.nextInt();

            if(ch == 1)
            {
                PlatformTicket.book(sc);
            }
            else if(ch == 2)
            {
                GeneralTicket.book(sc);
            }
            else if(ch == 3)
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

    static void updateCredentials(Login user1)
    {
        while(true)
        {
            System.out.println(ANS_YELLOW+"\nWhat do you want to update?"+ANS_RESET);
            System.out.println("1. "+ANSI_ORANGE+"Username\n"+ANS_RESET+"2. "+ANSI_BLUE+"Password\n"+ANS_RESET+"3. "+ANS_RESET+"Email\n"+ANS_RESET+"4. "+ANSI_LIGHT_PINK+"Mobile Number\n"+ANS_RESET+"5. "+ANSI_LIME_GREEN+"Back"+ANS_RESET);
            int k=sc.nextInt();
            System.out.println();
            if(k==1)
            {
                System.out.println(ANSI_SKY_BLUE+"Enter New Username : "+ANS_RESET);
                user1.setUsername(sc.next());
                System.out.println(ANSI_GREEN+"Updated Username : "+ANS_RESET+""+user1.getUsername());
                System.out.println();
            }
            else if(k==2)
            {
                System.out.println(ANSI_SKY_BLUE+"Enter New Password : "+ANS_RESET);
                user1.setPassword(sc.next());
                System.out.println(ANSI_GREEN+"Updated Password : "+ANS_RESET+""+user1.getPassword());
                System.out.println();
            }
            else if(k==3)
            {
                System.out.println(ANSI_SKY_BLUE+"Enter New EmailID : "+ANS_RESET);
                user1.setEmailid(sc.next());
                System.out.println(ANSI_GREEN+"Updated Email ID : "+ANS_RESET+""+user1.getEmailid());
                System.out.println();
            }
            else if(k==4)
            {
                System.out.println(ANSI_SKY_BLUE+"Enter New Mobile No : "+ANS_RESET);
                user1.setMobileno(sc.nextLong());
                System.out.println(ANSI_GREEN+"Updated Mobile Number : "+ANS_RESET+""+user1.getMobileno());
                System.out.println();
            }
            else if(k==5)
            {
                break;
            }
            else
            {
                System.out.println(ANSI_RED+"Invalid Input, Try Again"+ANS_RESET);
                System.out.println();
            }
        }
    }

    public static final String ANS_RESET = "\u001B[0m";
    public static final String ANS_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN  = "\u001B[32m";
    public static final String ANSI_RED    = "\u001B[31m";
    public static final String ANSI_BLUE   = "\u001B[34m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public static final String ANSI_LIME_GREEN = "\u001B[92m";
    public static final String ANSI_SKY_BLUE = "\u001B[38;5;117m";
    public static final String ANSI_LIGHT_PINK = "\u001B[38;5;218m";

    // Simple exit animation - scrolling text only
    static void exitAnimation()
    {
        try {
            System.out.println("  ______________________________________________________  _________________________________________^__");
            System.out.println("||                                                      ||                                       __   \\");
            System.out.println("||    "+ANSI_BLUE+"Welcome to IRTS - "+ANSI_ORANGE+"WISHING YOU"+ANS_RESET+" A "+ANSI_LIME_GREEN+"HAPPY JOURNEY     "+ANS_RESET+"||- - - - - "+ANSI_ORANGE+"V A N D E "+ANS_RESET+" "+ANSI_LIME_GREEN+"B H A R A T"+ANS_RESET+" - - -|  |   \\");
            System.out.println("||                   "+ANSI_ORANGE+"I"+ANS_RESET+""+ANSI_LIGHT_PINK+" N"+ANS_RESET+""+ANS_RESET+" D"+ANS_RESET+" "+ANSI_SKY_BLUE+"I"+ANS_RESET+" "+ANSI_LIME_GREEN+"A"+ANS_RESET+"                          ||                "+ANSI_SKY_BLUE+"C S R P"+ANS_RESET+"               |__|    \\");
            System.out.println("||______________________________________________________||_______________________________________________)");
            System.out.println(" _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _ _ _ _ \n");

            System.out.println(":::::::::-----------=====+++++***##*#%%%%%%%#*++==========---::::::::::::::");
            System.out.println("-::::::::----------=======+++*#*#%%#%%%%%@@@@@%%#*========---::::::::::::::");
            System.out.println("-::::::::----------======+++*###%%%%@@%%%%@@@@@@@@#+=====----::::::::::::::");
            System.out.println("-::::::::----------=======+**#%%@@@@%%@%%%@@@@@@@@%+====-----::::::::::::::");
            System.out.println("-::::::::----------======+*###%@@%@@@%#%@%%@@@@%%%#+===-----:::::::::::::::");
            System.out.println("--:::::::-------=-=======+*%%%%@@%@%#+==+#%%@@@@%@@*==------:::::::::::::::");
            System.out.println("--:::::::-------=========+*#@@%@@%*+=---=++#@@@@@@@%=-------:::::::::::::::");
            System.out.println("-::::::::------=========++***#@#+=--------==*%@@@@#+=-------:::::::::::::::");
            System.out.println("-::::::::-==-===========++*+=+#=::-+*##*=+*****%%+====------:::::::::::::::");
            System.out.println("--:-:::::-==============++*=-=+-:::-=++=:+###*+#*===--------:::::::::::::::");
            System.out.println("---::::::-==============++**=-+--:::--::.-=====#+===--------:::::::::::::::");
            System.out.println("----:::::-==============++**#%*+===+=-========++===---------:::::::::::::::");
            System.out.println("----:::::-===============+***#***++#*+*##%#*+**===----------:::::::::::::::");
            System.out.println("----:::::-===============++**#+##**=-=++++*###===----------::::::::::::::::");
            System.out.println("----:::::-===============++=#%==#%%*==*#*+#%%+==------------:::::::::::::::");
            System.out.println("----::::::==============++=-*+--=#%%%%%%%%%#%=--------------:::::::::::::::");
            System.out.println("-----:::::==================:==-==+*#%%%#*%##*=-------------:::::::::::::::");
            System.out.println("------::::===========--@+@@---====+++****#@%*#%#++=---------:::::::::::::::");
            System.out.println("------::::==========+=@@##+@@-:-=+=+****#%@%#**#**#*===-----:::::::::::::::");
            System.out.println("------::::=======---@@@=+*=-@@*%*=--====+***#%%#%*+*#****-:::::::::::::::::");
            System.out.println("--------::===-===+=@@@*==*#**%@@%%#*+---+***#**+#*=+**=+*+--:::::::::::::::");
            System.out.println("--------::=-:==:+#@@@**+=+*+=+*#**#%#=-=*%*+**++**+=*#**##*=:::::::::::::::");
            System.out.println("--------::=-+#+=*@@@@+##+-+*+=+##+#%#++**%#+*%*+##*=+#**###+=::::::::::::::");
            System.out.println("--------::--++=+%%%%#*##*=+##++*#+=#%##++#*-=*+-=++-=*==*+*#+-:::::::::::::");
            System.out.println("-----------=*=-=####*+=++--=+=-=++-=*++==*+-=**++##+*#**#+%%=*:::::::::::::");
            System.out.println("---------==*%*++#*+##++##*=+##++*#++*#*++%%++*#*++#+=*++%#%#+%=::::::::::::");
            System.out.println("---------=-*#++#%%#%%#*##*==**+==*+=+##==##=-+*+==*+-+*+%#%%*%+::::::::::::");
            System.out.println("---------==#%*=*#%%@%*++**=-+**==*+-=*#=-*#*=+##++##+*##%%%#+%#-:::::::::::");
            System.out.println("--------=++#%#*#%%%%@%**#%++*%#*+*#=+%%*=*%*==**+=+*===+%%**#%#-:::::::::::");
            System.out.println("--------==-**++#%@@@@%#*##+==**===+=-+*+-=+=--+++=+#=++*@%#%%#*-:::::::::::");

            System.out.println();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[])
    {
        Login user1 = null;
        System.out.println("  ______________________________________________________  ________________________________________^__");
        System.out.println("||                                                      ||                                       __   \\");
        System.out.println("||"+ANSI_BLUE+"Welcome to IRTS - "+ANSI_ORANGE+"Indian Railway"+ANS_RESET+" Ticket "+ANSI_LIME_GREEN+"Booking System"+ANS_RESET+"||- - - - - "+ANSI_ORANGE+"V A N D E "+ANS_RESET+" "+ANSI_LIME_GREEN+"B H A R A T"+ANS_RESET+" - - -|  |   \\");
        System.out.println("||                   "+ANSI_ORANGE+"I"+ANS_RESET+""+ANSI_LIGHT_PINK+" N"+ANS_RESET+""+ANS_RESET+" D"+ANS_RESET+" "+ANSI_SKY_BLUE+"I"+ANS_RESET+" "+ANSI_LIME_GREEN+"A"+ANS_RESET+"                          ||                "+ANSI_SKY_BLUE+"C S R P"+ANS_RESET+"               |__|    \\");
        System.out.println("||______________________________________________________||_______________________________________________)");
        System.out.println(" _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _@@ _ _ _ _ _ \n");
        while(true)
        {
            System.out.println("1."+ANSI_ORANGE+" Login\n"+ANS_RESET+"2. SignUp\n3."+ANSI_LIME_GREEN+" Exit"+ANS_RESET);
            int i1=sc.nextInt();
            if(i1 == 1)
            {
                user1 = new Login("csrp","4444","csrp4444@gmail.com",7815824948l);
                break;
            }
            else if(i1 == 2)
            {
                System.out.println("Enter "+ANSI_BLUE+"Username, Password, Email ID "+ANS_RESET+"and"+ANSI_BLUE+" Mobile Number"+ANS_RESET);
                user1 = new Login(sc.next(),sc.next(),sc.next(),sc.nextLong());
                if(user1.getUsername().equals("csrp"))
                {
                    System.out.println(ANSI_RED+"Username already exists"+ANS_RESET);
                    System.out.println();
                    continue;
                }
                System.out.println(ANSI_GREEN+"Singup Successful"+ANS_RESET);
                System.out.println();
                break;
            }
            else if(i1 == 3)
            {
                System.out.println();
                System.out.println(ANSI_ORANGE+"Thank you"+ANS_RESET+" for "+ANSI_LIME_GREEN+"using IRTS"+ANS_RESET);
                exitAnimation();
                System.exit(0);
            }
            else
            {
                System.out.println(ANSI_RED+"Invalid Input, Try Again"+ANS_RESET);
            }
        }
        
        while(true)
        {
            System.out.println(ANSI_BLUE+"Enter "+ANSI_ORANGE+"Username"+ANS_RESET+" and "+ANSI_LIME_GREEN+"Password"+ANS_RESET);
            String name = sc.next();
            String pin = sc.next();
            if((name.equals(user1.getUsername()) && pin.equals(user1.getPassword()) ) || (name.equals("csrp") && pin.equals("4444")))
            {
                System.out.println(ANSI_GREEN+"Login Successful"+ANS_RESET);
                System.out.println();
                break;
            }
            else
            {
                System.out.println(ANSI_RED+"Invalid Credentials, Try Again"+ANS_RESET);
                System.out.println();
            }
        }

        while(true)
        {
            System.out.println(ANS_YELLOW+"Select Option of Your Choice"+ANS_RESET);
            System.out.println("1. "+ANSI_RED+"Book Reservation Ticket\n"+ANS_RESET+"2. "+ANSI_GREEN+"Book General or Platform Ticket\n"+ANS_RESET+"3. "+ANSI_ORANGE+"Booking History\n"+ANS_RESET+"4. "+ANSI_BLUE+"Update Credentials\n"+ANS_RESET+"5. Exit");
            switch(sc.nextInt())
            {
                case 1:
                    ReservationTicket.book(sc);
                    break;

                case 2:
                    normalTicketMenu();
                    break;

                case 3:
                    BookingHistory.showHistory(sc);
                    break;

                case 4:
                    updateCredentials(user1);
                    break;

                case 5:
                    exitAnimation();
                    System.exit(0);

                default:
                    System.out.println(ANSI_RED+"Invalid Input"+ANS_RESET);
                    System.out.println();
            }
        }
    }
}
