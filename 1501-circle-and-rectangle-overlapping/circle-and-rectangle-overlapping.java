class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest point (closestX, closestY) on the rectangle to the circle's center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Distance vector from the circle's center to the closest point
        int dx = xCenter - closestX;
        int dy = yCenter - closestY;

        // Check if the squared Euclidean distance is within radius^2
        return (dx * dx + dy * dy) <= (radius * radius);
    }
}