import java.util.LinkedList;
import java.util.Queue;

/**
 * 649. Dota2 Senate
 * @author LiPeng
 * @since 2017/7/3019:51
 */
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                q1.add(i);
            else
                q2.add(i);
        }
        while (!q1.isEmpty() && !q2.isEmpty()) {
            int ri = q1.poll(), di = q2.poll();
            if (ri < di) {
                q1.add(ri + senate.length());
            } else {
                q2.add(di + senate.length());
            }
        }
        return (q1.size() > q2.size()) ? "Radiant" : "Dire";
    }
}
