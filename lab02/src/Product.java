// biniakou theofanhs icsd13126
public class Product {
    private String prod; // kafes, tost ktlp
    
    public Product(String prod){
        this.prod = prod;
    }
    
    // epistrefw an einai faghto=1 h rofhma=0
    int what_category(){
        if (this.prod.equals("coffe") || this.prod.equals("juice"))
            return 0;
        else 
            return 1;
    }
    
    String get_prod_name(){
        return this.prod;
    }
}
