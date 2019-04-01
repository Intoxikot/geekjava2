

public class Leader {

    private Worker assist1;
    private Worker assist2;

    private float[] result;

    private boolean done;
    private int halfSize;

    public Leader(float[] input) {
        done = false;

        this.halfSize = input.length / 2;
        this.result = new float[halfSize * 2];

        float[] work1 = new float[halfSize];
        float[] work2 = new float[halfSize];

        System.arraycopy(input, 0, work1, 0, halfSize);
        System.arraycopy(input, 0, work2, 0, halfSize);

        assist1 = new Worker(work1);
        assist2 = new Worker(work2);
    }

    public void run() {
        assist1.run();
        assist2.run();

        float[] work1 = assist1.getResult();
        float[] work2 = assist2.getResult();

        System.arraycopy(work1, 0, result, 0, halfSize);
        System.arraycopy(work2, 0, result, halfSize, halfSize);

        done = true;
    }

    public float[] getResult() {
        return (done) ? result: null;
    }

    public boolean isDone() {
        return done;
    }
}
