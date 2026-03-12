class Station
{
    static String[] stations = { "chennai", "nellore", "ongole", "vijayawada", "khammam", "warangal", "secunderabad" };
    static String stationText = "{Chennai, Nellore, Ongole, Vijayawada, Khammam, Warangal, Secunderabad}";
    static int[] distances = {175, 140, 170, 120, 110, 150};

    static int getStationIndex(String station)
    {
        for(int i = 0; i < stations.length; i++)
        {
            if(stations[i].equals(station))
                return i;
        }
        return -1;
    }
}
