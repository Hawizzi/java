public class SumWorker extends Thread {
    private final int[] numbers;
    private final int start;
    private final int end;
    private long sum;

    public SumWorker(int[] numbers, int start, int end) {
        if (numbers == null || start < 0 || end < start || end > numbers.length) {
            throw new IllegalArgumentException("Invalid array range.");
        }
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long result = 0;
        for (int i = start; i < end; i++) {
            if (Thread.currentThread().isInterrupted()) { return; }
            result += numbers[i];
        }
        sum = result;
    }

    public long getSum() { return sum; }
}
