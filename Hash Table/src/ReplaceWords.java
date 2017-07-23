import java.util.*;

/**
 * 648. Replace Words
 * @author LiPeng
 * @since 2017/7/2321:20
 */
public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        if (dict == null || dict.size() == 0) return sentence;

        Set<String> set = new HashSet<>();
        for (String s : dict) set.add(s);

        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (set.contains(prefix)) break;
            }
            sb.append(" " + prefix);
        }

        return sb.deleteCharAt(0).toString();
    }

    // contest
    public int find(List<String> dict, String word) {
        for (int i = 0; i < dict.size(); i++) {
            if (dict.get(i).length() <= word.length()) {
                int index = word.indexOf(dict.get(i));
                if (index == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
    public String replaceWords2(List<String> dict, String sentence) {
        String[] sen = sentence.split(" ");
        Collections.sort(dict, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < sen.length; i++) {
            int index = find(dict, sen[i]);
            if (index != -1) {
                if (i == 0) {
                    res.append(dict.get(index));
                } else {
                    res.append(" " + dict.get(index));
                }
            } else {
                if (i == 0) {
                    res.append(sen[i]);
                } else {
                    res.append(" " + sen[i]);
                }
            }
        }
        return res.toString();
    }
}
