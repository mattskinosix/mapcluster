package data;
class ContinuosAttribute extends Attribute {
    private double max;
    private double min;
    
    
    
    
    public ContinuosAttribute(String name, int index, double min, double max){
        super(name,index);
        this.max=max;
        this.min=min;
    }
   
    
    public double getScaledValue(double v){
    double v1=(v-min)/(v-max);
    return v1;
    }

    
}
