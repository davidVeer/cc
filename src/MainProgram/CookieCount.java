package MainProgram;

import Buildings.Farms;
import Buildings.Fingers;
import Buildings.Grandma;

public class CookieCount {
    int cookieCounter;
    Fingers finger = new Fingers(15);
    Grandma grandma = new Grandma(100);
    Farms farms = new Farms(1100);
    private int productionCache = 0;

    public CookieCount(int cookieCounter) {
        this.cookieCounter = cookieCounter;
        finger.setCookieCount(this);
        grandma.setCookieCount(this);
        farms.setCookieCount(this);

    }

    public String add(){
        this.cookieCounter++;
        return String.valueOf(this.cookieCounter);
    }

    public int getCookieCounter() {
        return cookieCounter;
    }

    public void setCookieCounter(int cookieCounter) {
        this.cookieCounter = cookieCounter;
    }


    @Override
    public String toString() {
        return "MainProgram.CookieCount " + this.cookieCounter;
    }


    public void updateProduction()
    {
        this.productionCache += finger.getHowMany() * (0.2 * 0.01666666); //clickers
    }

    public int getProductionCache() {
        return productionCache;
    }
    public void addProductionCache(){
        this.cookieCounter += this.productionCache;
        this.productionCache = 0;
    }


}