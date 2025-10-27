class Solution {
    public int numberOfBeams(String[] bank) {
        int prevDevices = 0; // stores the number of devices in previous non-empty row
        int totalBeams = 0;

        for (String row : bank) {
            int currentDevices = 0;

            // Count number of '1's in the current row
            for (char c : row.toCharArray()) {
                if (c == '1') currentDevices++;
            }

            // If this row has devices, multiply with previous and update
            if (currentDevices > 0) {
                totalBeams += prevDevices * currentDevices;
                prevDevices = currentDevices;
            }
        }

        return totalBeams;
    }
}
