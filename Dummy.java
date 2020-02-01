public class Dummy {
    native long totalVirtuaMemory();
    static boolean loaded = false;
    static
    {
        try {
            System.loadLibrary("forfact");
            loaded = true;
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Dummy obj = new Dummy();

        long i = (loaded ? obj.totalVirtuaMemory() : 0) / (1024*1024);
        System.out.println(" Hello world: " + i);

    }
}

