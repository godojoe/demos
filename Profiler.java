public class Profiler {
    native long totalProcessVirtualMemory();

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

    public void report() {
        try {
            long t = (loaded ? this.totalProcessVirtualMemory() : 0) / (1024*1024);
            System.out.println(" Total: " + t);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {

       new Profiler().report();
        System.out.println(" Here" );


    }
}

