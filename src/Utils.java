import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Jsin on 4/20/2016.
 */
public class Utils {

    private static Scanner reader = new Scanner(System.in);
    private static int validNumber;

    public static int isValidInt(String outPut) {
        boolean isValidNumber = false;

        while (isValidNumber == false) {
            System.out.print(outPut);
            try {
                validNumber = reader.nextInt();
                isValidNumber = true;
            } catch (InputMismatchException e) {
                isValidNumber = false;
                reader.next();
            }
        }
        return validNumber;
    }
}
