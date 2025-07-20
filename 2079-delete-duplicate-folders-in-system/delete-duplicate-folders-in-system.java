// class Solution {
//     public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        
//     }
// }

class Solution {
    // Node class to represent each folder
    static class Node {
        String name;
        Map<String, Node> children = new HashMap<>();
        boolean isDeleted = false;

        Node(String name) {
            this.name = name;
        }
    }

    // Map to store serialization of subtrees
    Map<String, List<Node>> duplicates = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node("");

        // Step 1: Build the folder tree
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node(folder));
                curr = curr.children.get(folder);
            }
        }

        // Step 2: Serialize subtrees to detect duplicates
        serialize(root);

        // Step 3: Mark duplicates for deletion
        for (List<Node> nodeList : duplicates.values()) {
            if (nodeList.size() > 1) {
                for (Node node : nodeList) {
                    node.isDeleted = true;
                }
            }
        }

        // Step 4: Collect remaining paths
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    // Serialize a subtree rooted at the current node
    private String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        List<String> serials = new ArrayList<>();
        for (Node child : node.children.values()) {
            String childSerial = serialize(child);
            serials.add("(" + child.name + childSerial + ")");
        }

        Collections.sort(serials); // Ensure order-independent serialization
        String serial = String.join("", serials);
        duplicates.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    // DFS to gather all non-deleted folder paths
    private void dfs(Node node, List<String> path, List<List<String>> result) {
        for (Node child : node.children.values()) {
            if (child.isDeleted) continue;
            path.add(child.name);
            result.add(new ArrayList<>(path));
            dfs(child, path, result);
            path.remove(path.size() - 1); // backtrack
        }
    }
}

