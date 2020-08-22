package 分类刷题.回溯.复原IP地址;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    private ArrayList<String> res;

    private int[] segments = new int[4];

    public List<String> restoreIpAddresses(String s) {

        res = new ArrayList<>();
        dfs(s, 0, 0);
        return res;

    }

    private void dfs(String s, int segId, int segStart) {
        // 如果找到了4段IP地址并且遍历完了字符串，那么就是一种答案
        if (segId == 4) {
            if (segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append('.');
                    }
                }
                res.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到4段IP地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为0，那么这一段IP地址只能为0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int i = segStart; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().restoreIpAddresses("25525511135"));
    }
}
