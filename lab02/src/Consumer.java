// biniakou theofanhs icsd13126
public class Consumer extends Thread{
    private CubbyHole c;
    private String name;
    private Product p;
    
    public Consumer(CubbyHole ch,String name){
        c = ch;
        this.name = name;
    }
    
    @Override
    public void run(){
        // arxikopoiw ena counter, afou kathe servitoros antistoixei kai se ena antikeimeno (exw ftiaksei
        // 2 antikeimena Consumer sthn main) 
        
        int counter=0;
        
        // an to thread pou paei na bei se afth thn run einai to thread pou antistoixei sto antikeimeno tou
        // servitorou a, pou servirei mono rofhmata, tha bei se auth thn if, alliws tha bei sthn parakatw else
        if (this.name.equals("a")) {
            // afou exoume 20 paraggelies me rofhmata, o servitoros tha servirei 20 rofhmata
            while (counter < 20){ 
                
                if (c.getFirst().what_category() == 0) { // an einai rofhma
                    // an to prwto proion pou uparxei ston pinaka einai rofhma
                    // tote kalw thn sunarthsh get() sto cubbyhole
                    // kai auksanw to counter +1 dioti o servitoros tha servirei kanonika
                    // alliws den kanw tipota kai o servitoros agnoei to cubbyhole
                    p = c.get();
                    System.out.println("consumer " + this.name + " put: " + p.get_prod_name());
                    counter++;
                    try{
                        sleep((int)(Math.random()*5000));
                    } catch (InterruptedException e){}
                }
            }
        }
        // an dhladh o servitoros einai o b
        else { 
            // afou exoume 20 paraggelies me trofhma, o servitoros tha servirei 20 trofhma
            while (counter < 20){ 
                
                if (c.getFirst().what_category() == 1) { // an einai trofimo
                    p = c.get();
                    System.out.println("consumer " + this.name + " put: " + p.get_prod_name());
                    counter++;
                    try{
                        sleep((int)(Math.random()*5000));
                    } catch (InterruptedException e){}
                }
            }
      
        }
    }
}
