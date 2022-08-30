// biniakou theofanhs icsd13126
import java.util.Random;


public class Producer extends Thread{
    private CubbyHole c;
    private String name;
    private Product p;
    
    public Producer(CubbyHole c,String name){
        this.c = c;
        this.name = name;
    }
    
    @Override
    public void run(){
        
        // me thn parakatw if, epilegw pio thread tha bei se poia epanalhpsh
        // an dhladh, bei to thread me to antikeimeno pou antistoixei ston mageira
        // tha bei sthn if, alliws an bei to thread pou antistoixei ston mpoufetzh
        // tha bei sthn else
        if (this.name.equals("cook")) {
            for (int i=0; i<20; i++){
                p = new Product(product_food());
                c.put(p);
                System.out.println("producer " + this.name + " put: " + p.get_prod_name());
            
                try{
                    sleep((int)(Math.random()*5000));
                } catch (InterruptedException e){}
            }
        }
        else {
            for (int i=0; i<20; i++){
                p = new Product(product_drink());
                c.put(p);
                System.out.println("producer " + this.name + " put: " + p.get_prod_name());
            
                try{
                    sleep((int)(Math.random()*5000));
                } catch (InterruptedException e){}
            }
        }
    }
    
    // duo sunarthseis oi opoies dhmiourgoun tuxaia ta analwsima trofima kai rofhmata
    
    String product_food(){
        
        Random rand = new Random();
        // epilegei tuxaia metaksu 2 arithmwn. eite 0 eite 1
        int i = rand.nextInt(2);
        
        if (i == 0)
            return "toast";
        else
            return "spaghetti";
    }
    
    String product_drink(){
        Random rand = new Random();
        int i = rand.nextInt(2);
        
        if (i == 0)
            return "coffe";
        else
            return "juice";
    }
}
