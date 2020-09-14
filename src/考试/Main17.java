package 考试;

import java.util.ArrayList;
import java.util.Scanner;

public class Main17 {

    static String[] splitMsg(String text) {
        int MAX_SIZE = 1024;
        char[] tempArray =new char[MAX_SIZE];
        int lastParagraphEnd=0,lastSentenceEnd=0 , pos=0,lastTextPos=0;
        ArrayList<String> ret =new ArrayList<>();
        char[] textChars = text.toCharArray() ;
        char[] splited ;
        for (int textpos=0;textpos<textChars.length;) {
            char c = textChars[textpos++];
            tempArray[pos] = c ;
            if (c == '\n'){
                lastParagraphEnd = pos ;
            }else if ('.' == c || '!' == c){
                lastSentenceEnd = pos ;
            }
            pos++ ;
            if (pos==MAX_SIZE){
                int splitPos = lastParagraphEnd>0?lastParagraphEnd:lastSentenceEnd;
                splited = new char[splitPos+1];
                System.arraycopy(tempArray,0,splited,0,splitPos+1);

                ret.add(new String(splited));
                lastParagraphEnd=0;
                lastSentenceEnd=0;
                pos=0;
                textpos = lastTextPos+splitPos+1;
                lastTextPos = textpos ;
            }
        }
        if (pos>0) {
            splited = new char[pos - 1];

            System.arraycopy(tempArray, 0, splited, 0, pos - 1);
            ret.add(new String(splited));
        }
        return ret.toArray(new String[]{}) ;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] res;
        StringBuffer sb = new StringBuffer();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() == 0) break;
            sb.append(line + "\n");
        }

        res = splitMsg(sb.toString());
        for (int res_i = 0; res_i < res.length; res_i++) {
            System.out.println(String.format("msg%d:%s", res_i + 1, res[res_i]));
        }
    }
}
