
public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  // Sort the folders lexicographically
        List<String> result = new ArrayList<>();
        
        String prev = "";  // To store the last added folder to compare prefixes
        for (String path : folder) {
            // Only add if not a subfolder of the last added folder
            if (prev.isEmpty() || !path.startsWith(prev + "/")) {
                result.add(path);
                prev = path;
            }
        }
        
        return result;
    }
}
