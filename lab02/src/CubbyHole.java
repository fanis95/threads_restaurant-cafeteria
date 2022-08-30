// biniakou theofanhs icsd13126
public class CubbyHole {
    
    private final int size = 10;
    private Product[] contents = new Product[size]; 
    private Product p;
    
    private int first = -1;
    private int last = -1;
    
    
    
     public synchronized void put(Product p){
        
        // otan o pinakas einai gematos
        while(isFull()){ 
            try {
                wait();
            } catch(InterruptedException e){}
        }

        // an o pinakas einai adeios kai paei na ginei eisagwgh enos proiontos
        if (isEmpty()){
            // kanw kai ta duo 0, giati tha uparxei ena antikeimeno sthn thesh 0 tou pinaka
            // kai epeidh tha uparxei MONO ena antikeimeno, tha einai tautoxrona kai to prwto 
            // alla kai to teleutaio proion tou pinaka
            this.first = this.last = 0; 
        }
        // an omws o pinakas den einai adeios, apla afksanw ton metrhth last +1 (dhladh tha uparksei akoma ena
        // proion ston pinaka)
        else{
            this.last = (this.last + 1) % this.size;
        }
        
        // kai telika prosthetw to proion ston pinaka
        contents[last] = p;
        
        if (p.what_category() == 0) // dhladh einai rofhma
            System.out.println("--ADD-- the buffet adds the product: " + p.get_prod_name() + " in the cubbyhole");
        else
            System.out.println("--ADD-- the cook adds the product: " + p.get_prod_name() + " in the cubbyhole");
        
        
        notifyAll();
    }
     
     
    public synchronized Product get(){
        
        while (isEmpty()){
            try {
                wait();
            } catch(InterruptedException e){}
        }
        
        // to proion p2 antistoixei se mia metavlhth temp
        Product p2;
        
        // an oi duo metrhtes einai isoi, shmainei oti o pinakas periexei MONO ena proion
        if (this.first == this.last){
            p2 = contents[first];
            this.first = this.last = -1;
        }
        // ara o pinakas exei panw apo 1 proion
        else{
            p2 = contents[this.first];
            this.first = (this.first + 1) % this.size;
        }
        
        if (p2.what_category() == 0) // dhladh einai rofhma
            System.out.println("--REMOVE-- waiter a removes the product: " + p2.get_prod_name() + " by the cubbyhole");
        else
            System.out.println("--REMOVE-- waiter b removes the product: " + p2.get_prod_name() + " by the cubbyhole");
        
        
        
        notifyAll();
        
        return p2;
    }
    
   
    
    // elegxos an o pinakas einai adeios
    public boolean isEmpty(){
        
        // an einai kai ta duo -1, o pinakas tha einai adeios
        return this.first == -1 && this.last == -1;
    }
    
    // elegxos an o pinakas einai gematos
    public boolean isFull(){
        
        // elegxw an o pinakas einai gematos
        return (this.last + 1) % this.size == this.first;
    }
    
    // epistrefw to prwto proion pou egine eisagwgh ston pinaka
    // to proion dhladh pou einai na afairethei apo ton pinaka
    public Product getFirst(){
        if (isEmpty())
            // an o pinakas einai adeios kai den ginetai na epistrepsw ena antikeimeno
            // tote emfanizw to sigkekrimeno exception epeidh den ginetai na epistrepsw antikeimeno
            throw new IllegalStateException("\n\ntable is empty!!!\n");
        return contents[this.first];
    }
    
    
}
