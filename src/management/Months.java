package management;

import java.util.ArrayList;

public class Months {

    private static ArrayList<String> months;

    public Months() {
        months = new ArrayList<>();
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
    }


    public static ArrayList<String> getMonths() {
        return months;
    }

}
