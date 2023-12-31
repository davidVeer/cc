package MainProgram;

import Buildings.Buildings;
import Buildings.Farms;
import Buildings.Fingers;
import Buildings.Grandma;

public class CookieCount {
    int cookieCounter;
    private Fingers finger = new Fingers(15);
    private Grandma grandma = new Grandma(100);
    private Farms farms = new Farms(1100);
    private double productionCache = 0;

    public CookieCount(int cookieCounter) {
        this.cookieCounter = 52;
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


    public String updateProduction()
    {
        this.productionCache += finger.getHowMany() * (0.2 * 0.01666666); //clickers

        if (this.productionCache >= 1) {
            this.cookieCounter += (int) this.productionCache;
            this.productionCache -= (int) this.productionCache;
        }


        return String.valueOf(this.cookieCounter);
    }

    public double getProductionCache() {
        return productionCache;
    }
    public void addProductionCache(){
        this.cookieCounter += this.productionCache;
        this.productionCache = 0;
    }

    public Buildings getFinger() {
        return finger;
    }

    public Buildings getGrandma() {
        return grandma;
    }

    public Buildings getFarms() {
        return farms;
    }
}