class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        // 1. Count character frequencies
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // 2. Group characters by their frequency
        Map<Integer, List<Character>> grp = new HashMap<>();
        for (Map.Entry<Character, Integer> ent : freq.entrySet()) {
            int f = ent.getValue();
            grp.putIfAbsent(f, new ArrayList<>());
            grp.get(f).add(ent.getKey());
        }

        // 3. Find the majority frequency group
        int bestFreq = -1;
        List<Character> best = new ArrayList<>();
        for (Map.Entry<Integer, List<Character>> ent : grp.entrySet()) {
            int f = ent.getKey();
            List<Character> chars = ent.getValue();

            // Apply the winning conditions
            if (chars.size() > best.size() || (chars.size() == best.size() && f > bestFreq)) {
                best = chars;
                bestFreq = f;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : best) {
            sb.append(c);
        }
        return sb.toString();
    }
}