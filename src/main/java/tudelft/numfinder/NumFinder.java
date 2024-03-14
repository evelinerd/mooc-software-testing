package tudelft.numfinder;

public class NumFinder {
    private int smallest = Integer.MAX_VALUE;
    private int largest = Integer.MIN_VALUE;

    public void find(int[] nums) {

        if (nums == null || nums.length == 0) {
            smallest = 0;
            largest = 0;
            System.out.println("The array is empty.");
            return;
        }

        for(int n : nums) {

            if(n < smallest)
                smallest = n;
            if (n > largest)
                largest = n;

        }

        if (smallest == largest) {
            System.out.println("The smallest and largest numbers are the same: " + smallest);
        }
    }

    public int getSmallest () {
        return smallest;
    }

    public int getLargest () {
        return largest;
    }
}
