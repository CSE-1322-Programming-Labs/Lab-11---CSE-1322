import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        int t1=0;
        int t2=0;

        try{
            System.out.println("Enter time 1 in 24hr format as follows (HH:MM:SS)");
            t1 = getTime(getUserString());
        }catch (InvalidTimeException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("An unknown error has occurred,please try again.");
            System.out.println(e.getMessage());
        }

        try{
            System.out.println("Enter time 2 in 24hr format as follows (HH:MM:SS)");
            t2= getTime(getUserString());
            System.out.println("Difference in seconds: "+(t2-t1));
        }catch (InvalidTimeException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println("An unknown error has occurred,please try again.");
            System.out.println(e.getMessage());
        }

    }

    public static int getTime(String string) throws InvalidTimeException{
        String[] myArray = string.split(":",3); //This limit makes sure that the arraySize will always be 3 or less.

        int hours=0;
        int minutes=0;
        int seconds=0;

        if(myArray.length != 3) throw new InvalidTimeException("Invalid input, please enter Hours,minutes,seconds in a HH:MM:SS format.");

        try{
            hours = Integer.parseInt(myArray[0]);
            minutes = Integer.parseInt(myArray[1]);
            seconds = Integer.parseInt(myArray[2]);
        }catch (NumberFormatException e){
            System.out.println(e.getMessage()+" is not an integer");
        }catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println(e.getMessage());
        }

        if(hours >24 || hours < 0) throw new InvalidTimeException("Invalid Hour");
        if(minutes > 59 || minutes < 0) throw new InvalidTimeException("Invalid minute");
        if(seconds >59 || seconds < 0) throw  new InvalidTimeException("Invalid second");
        return (hours * 60 * 60) + (minutes * 60) + seconds;

    }

    public static String getUserString(){
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
