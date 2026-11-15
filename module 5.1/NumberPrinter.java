public class NumberPrinter {
    private long current;
    private final int end;
    private boolean cancelled;

    public NumberPrinter(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start must not be greater than end.");
        }
        current = start;
        this.end = end;
    }

    public synchronized void printNumbers(boolean odd) {
        try {
            while (!cancelled && current <= end) {
                while (!cancelled && current <= end && (current % 2 != 0) != odd) {
                    wait();
                }
                if (cancelled || current > end) {
                    break;
                }
                System.out.println((odd ? "Odd Thread: " : "Even Thread: ") + current);
                current++;
                notifyAll();
            }
        } catch (InterruptedException exception) {
            cancelled = true;
            Thread.currentThread().interrupt();
        } finally {
            notifyAll();
        }
    }
}
