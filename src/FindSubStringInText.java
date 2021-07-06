import java.util.ArrayList;
import java.util.List;

public class FindSubStringInText {
    public String showSubString(String text, String sub)
    {
        //This list separates and stores the entered text into characters
        List<Character> list = new ArrayList<>();
        //This list stores the indexes of the above mentioned list where the sub string starts inside the text
        List<Integer> resultList = new ArrayList<>();
        //Fill in the list with characters of the entered text
        for(int i = 0; i < text.length(); i++)
        {
            list.add(i, text.charAt(i));
        }
        String auxiliary = "";
        int sizeOfList = list.size();
        //The outer loop goes on the list
        for(int j = 0; j < sizeOfList; j++) {
            //Every time, a string is created from the beginning of the list
            for (int i = 0; i < sub.length(); i++) {
                auxiliary += list.get(i);
            }
            //It is checked whether the created string equals with the sub string.
            //If yes, the beginning index is stored in resultList.
            if (auxiliary.equals(sub)) {
                resultList.add(j);
            }
            //The auxiliary is reset to go back in the loop!
            auxiliary = "";
            //One character from the head of the list is removed
            list.remove(0);
            //Check whether the size of list has gone under the size of the sub string.
            //If yes, the loop must be broken, otherwise an error (boundary index exception) pops up!
            if(list.size() < sub.length())
            {
                break;
            }
        }
        String result = "";
        if(resultList.size() == 0)
        {
            return text;
        }
        else {
            int lastCounter = 0;
            for (int j = 0; j < text.length(); j++) {
                if (j == resultList.get(0)) {
                    for (int k = 0; k < sub.length(); k++) {
                        result += (char) ((int)(text.charAt(j + k)) - 32);
                    }
                    resultList.remove(0);
                    if(resultList.size() == 0)
                    {
                        j += sub.length();
                        lastCounter = j;
                        break;
                    }
                    j += sub.length() - 1;
                }
                else
                {
                    result += text.charAt(j);
                }
            }
            for (int j = lastCounter; j < text.length(); j++)
            {
                result += text.charAt(j);
            }
        }
        return result;
    }
}
