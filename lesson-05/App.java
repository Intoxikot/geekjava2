
public class App {

    public static final int size = 10000000;

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        long begin = System.currentTimeMillis();
        Worker simpleWorker = new Worker(getArray(size));
        simpleWorker.run();
        long end = System.currentTimeMillis();
        System.out.println("result: " + (end - begin) + " ms (worker)");
    }

    private static void test2() {
        long begin = System.currentTimeMillis();
        Leader teamLeader = new Leader(getArray(size));
        teamLeader.run();
        long end = System.currentTimeMillis();
        System.out.println("result: " + (end - begin) + " ms (leader)");
    }

    private static float[] getArray(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++)
            arr[i] = 1;
        return arr;
    }
}