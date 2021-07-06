import java.util.Scanner;

public class FindSubString {
    public static void main(String[] args)
    {
        //Instantiation
        FindSubStringInText fssit = new FindSubStringInText();
        //Prompt the user
        System.out.println("Enter a sentence: ");
        Scanner in = new Scanner(System.in);
        //Take the text
        String input = in.nextLine();
        System.out.println("Enter a substring: ");
        //Take the target substring
        String enteredSub = in.nextLine();
        //Print out the result
        System.out.println(fssit.showSubString(input, enteredSub));
    }
}
