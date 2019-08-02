import org.omg.CORBA.MARSHAL;

import java.util.zip.Adler32;

public class Fraction {
    private int numerator;
    private int denumenator;

    public Fraction(int num, int denume) {
        this.numerator=num;
        this.denumenator=denume;
    }
    public Fraction(int num){
        this.numerator=num;
        this.denumenator=1;
        this.Operation();
    }
    public Fraction(){
        this.numerator=0;
        this.denumenator=1;
    }
    public  void Operation(){
        if(numerator<0 && denumenator<0){
            this.numerator=Math.abs(numerator);
            this.denumenator= Math.abs(denumenator);
        }else if(numerator<0||denumenator<0){
            this.numerator=-(Math.abs(numerator));
            this.denumenator=Math.abs(denumenator);
        }else if(this.denumenator==0){
            throw new IllegalArgumentException("Demoniator can't be Zero!");
        }
    }
    public int GetNumerator(){
        return this.numerator;
    }
    public int GetDenominator(){
        return this.denumenator;
    }
    public String toString(){
        String fractionString;
        if(this.denumenator==this.numerator){
            fractionString=String.valueOf(1);
        }else if(this.denumenator==1){
            fractionString=String.valueOf(this.numerator);
        }else {
            fractionString=this.numerator+"\n"+this.denumenator;
        }
        return fractionString;
    }
    public double toDouble(){
        double numDouble=(double)numerator;
        double denDouble=(double)denumenator;
        double result=numDouble/denDouble;
        return result;
    }
    public Fraction add(Fraction addition){
        int newNum=this.numerator* addition.denumenator+this.denumenator*this.numerator;
        int newDen=this.denumenator*addition.denumenator;
        Fraction newF=new Fraction(newNum,newDen);
        return newF;
    }

    public Fraction subtract(Fraction minus){
        int newNum=this.numerator* minus.denumenator-this.denumenator*this.numerator;
        int newDen=this.denumenator*minus.denumenator;
        Fraction newF=new Fraction(newNum,newDen);
        newF.Operation();
        return newF;
    }
    public Fraction Multiply(Fraction multiply){
        int newNum=this.numerator* multiply.denumenator;
        int newDen=this.denumenator*multiply.denumenator;
        Fraction newF=new Fraction(newNum,newDen);
        newF.Operation();
        return newF;
    }
    public Fraction Divide(Fraction divide){
        int newNum=this.numerator* divide.denumenator;
        int newDen=this.denumenator*divide.denumenator;
        Fraction newF=new Fraction(newNum,newDen);
        return newF;
    }
    public Boolean equals(Fraction equal){
        double a=this.toDouble();
        double b=this.toDouble();
        boolean ifEqual=(a==b);
        return ifEqual;
    }
    public Fraction toLowerTerms(){
        int factor = gcd(this.numerator, this.denumenator);
        int newNum = this.numerator / factor;
        int newDen = this.denumenator / factor;
        Fraction newF = new Fraction(newNum, newDen);
        return newF;
    }
    public int GCD(int num,int dem){
        if(dem==0){
            return num;
        }
        return GCD(dem,num%dem);
    }
}
