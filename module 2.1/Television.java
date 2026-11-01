public class Television {
    private boolean on;
    private int channel = 1;

    public boolean isOn() {
        return on;
    }

    public void pressOnOff() {
        on = !on;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        if (on && channel > 0) {
            this.channel = (channel - 1) % 10 + 1;
        }
    }
}
