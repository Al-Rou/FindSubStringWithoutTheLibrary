import java.util.ArrayList;
import java.util.List;

public class FindSubStringInText {
    public String showSubString(String text, String sub)
    {
        List<Character> list = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < text.length(); i++)
        {
            list.add(i, text.charAt(i));
        }
        String auxiliary = "";
        int sizeOfList = list.size();
        for(int j = 0; j < sizeOfList; j++) {
            for (int i = 0; i < sub.length(); i++) {
                auxiliary += list.get(i);
            }
            if (auxiliary.equals(sub)) {
                resultList.add(j);
            }
            auxiliary = "";
            list.remove(0);
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
