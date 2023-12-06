package Buildings;

import MainProgram.CookieCount;

public class Fingers implements Buildings{
    private int price;
    private int howMany;

    private int basePrice;
    private CookieCount cookieCount;
    public Fingers(int price) {
        this.price = price;
        this.howMany = 0;
        this.basePrice = price;
    }
    public String bought(){
        if (cookieCount.getCookieCounter() >= this.price) {
            this.howMany += 1;
            cookieCount.setCookieCounter(cookieCount.getCookieCounter() - this.price);
            this.price = (int) (this.basePrice *Math.pow(1.15, this.howMany));
        }
        return String.valueOf(cookieCount.getCookieCounter());
    }

    @Override
    public String getName() {
        return null;
    }

    public int getPrice() {
        return price;
    }

    public int getHowMany() {
        return howMany;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }
    public void setCookieCount(CookieCount cookieCount){
        this.cookieCount = cookieCount;
    }


}
