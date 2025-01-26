package Techademy.q1.src.main.java.com.sdet.anik;

public class CurrentAccount extends Account {
    public CurrentAccount(double principal) {
        super();
        setPrincipal(principal);
    }

    @Override
    public double calculateInterest() {
        return getPrincipal();
    }

}




