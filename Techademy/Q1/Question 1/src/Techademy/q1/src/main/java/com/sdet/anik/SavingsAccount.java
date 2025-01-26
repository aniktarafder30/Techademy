package Techademy.q1.src.main.java.com.sdet.anik;

public class SavingsAccount extends Account {
    public SavingsAccount(double principal, double rate, double time) {
        super();
        setPrincipal(principal);
        setTime(time);
        setRate(rate);
    }

    @Override
    public double calculateInterest() {
        return getPrincipal() + (getPrincipal() * getTime() * getRate() / 100);

    }

}





