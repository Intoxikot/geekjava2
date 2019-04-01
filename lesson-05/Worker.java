
public class Worker implements Runnable {

    private float[] input;
    boolean done;

    public Worker(float[] input) {
        this.input = input;
        this.done = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < input.length; i++)
            input[i] = (float)(input[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        done = true;
    }

    public float[] getResult()  {
        return done ? input: null;
    }

    public boolean isDone() {
        return done;
    }
}