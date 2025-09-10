import java.util.*;

class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        int m = languages.length;  // number of users
        // Convert each user's languages into a set for quick lookup
        List<Set<Integer>> userLang = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> set = new HashSet<>();
            for (int lang : languages[i]) set.add(lang);
            userLang.add(set);
        }

        // Step 1: Find problematic friendships
        Set<Integer> problematicUsers = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1;  // convert to 0-index
            int v = f[1] - 1;
            if (!canCommunicate(userLang.get(u), userLang.get(v))) {
                problematicUsers.add(u);
                problematicUsers.add(v);
            }
        }

        if (problematicUsers.isEmpty()) return 0; // everyone can already communicate

        // Step 2: For each language, count how many problematic users already know it
        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int countKnow = 0;
            for (int user : problematicUsers) {
                if (userLang.get(user).contains(lang)) {
                    countKnow++;
                }
            }
            int needTeach = problematicUsers.size() - countKnow;
            minTeach = Math.min(minTeach, needTeach);
        }

        return minTeach;
    }

    private boolean canCommunicate(Set<Integer> a, Set<Integer> b) {
        for (int lang : a) {
            if (b.contains(lang)) return true;
        }
        return false;
    }
}
