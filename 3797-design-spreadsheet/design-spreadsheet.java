class Spreadsheet {
    private int[][] grid;
    private int rows;

    public Spreadsheet(int rows) {
        this.rows = rows;
        // 26 columns (A-Z)
        grid = new int[rows][26];
    }
    
    // Helper: parse cell reference like "B2"
    private int getCellValue(String cell) {
        if (Character.isDigit(cell.charAt(0))) {
            // It's just a number
            return Integer.parseInt(cell);
        }
        // Otherwise, it's a cell reference
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return grid[row][col];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = 0;
    }
    
    public int getValue(String formula) {
        // Formula always of type "=X+Y"
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");
        String left = parts[0];
        String right = parts[1];
        return getCellValue(left) + getCellValue(right);
    }
}

