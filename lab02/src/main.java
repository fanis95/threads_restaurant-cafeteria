// biniakou theofanhs icsd13126
public class main {

    
    public static void main(String[] args) {
        
        CubbyHole c = new CubbyHole();
        
        // dhmiourgia antikeimenou pou antistoixei ston mageira
        Producer p1 = new Producer(c,"cook");
        // dhmeiourgia boufetzh
        Producer p2 = new Producer(c,"buffet");
        // dhmeiourgia tou servitorou a
        Consumer c1 = new Consumer(c,"a");
        // dhmiourgia tou servitorou b
        Consumer c2 = new Consumer(c,"b");
        
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
    
}
