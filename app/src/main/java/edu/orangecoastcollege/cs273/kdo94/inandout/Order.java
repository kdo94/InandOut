package edu.orangecoastcollege.cs273.kdo94.inandout;

/**
 * Created by kevin_000 on 9/21/2016.
 */
public class Order {
    private int mCheeseburgers;
    private int mDoubleDoubles;
    private int mFrenchFries;
    private int mLargeDrinks;
    private int mMediumDrinks;
    private int mSmallDrinks;
    private int mShakes;
    public final double PRICE_DOUBLE_DOUBLE = 3.60;
    public final double PRICE_CHEESEBURGER = 2.15;
    public final double PRICE_FRENCH_FRIES = 1.65;
    public final double PRICE_LARGE_DRINK = 1.75;
    public final double PRICE_MEDIUM_DRINK = 1.55;
    public final double PRICE_SMALL_DRINK = 1.45;
    public final double PRICE_SHAKES = 2.20;
    public final double TAX_RATE = 0.08;

    public Order(){
        mCheeseburgers = 0;
        mDoubleDoubles = 0;
        mFrenchFries = 0;
        mLargeDrinks = 0;
        mMediumDrinks = 0;
        mSmallDrinks = 0;

    }

    public Order(int cheeseburgers, int doubleDoubles, int frenchFries, int largeDrinks, int mediumDrinks, int smallDrinks, int shakes) {
        mCheeseburgers = cheeseburgers;
        mDoubleDoubles = doubleDoubles;
        mFrenchFries = frenchFries;
        mLargeDrinks = largeDrinks;
        mMediumDrinks = mediumDrinks;
        mSmallDrinks = smallDrinks;
        mShakes = shakes;
    }

    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    public int getShakes() {
        return mShakes;
    }

    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    public void setSmallDrinks(int smallDrinks) {
        this.mSmallDrinks = smallDrinks;
    }

    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    public void setMediumDrinks(int mediumDrinks) {
        this.mMediumDrinks = mediumDrinks;
    }

    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    public void setLargeDrinks(int largeDrinks) {
        this.mLargeDrinks = largeDrinks;
    }

    public int getFrenchFries() {
        return mFrenchFries;
    }

    public void setFrenchFries(int frenchFries) {
        this.mFrenchFries = frenchFries;
    }

    public int getDoubleDoubles() {
        return mDoubleDoubles;
    }

    public void setDoubleDoubles(int doubleDoubles) {
        this.mDoubleDoubles = doubleDoubles;
    }

    public double calculateSubTotal(){
        return mCheeseburgers * PRICE_CHEESEBURGER +
                mDoubleDoubles * PRICE_DOUBLE_DOUBLE +
                mFrenchFries * PRICE_FRENCH_FRIES +
                mShakes * PRICE_SHAKES +
                mSmallDrinks * PRICE_SMALL_DRINK +
                mMediumDrinks * PRICE_MEDIUM_DRINK +
                mLargeDrinks * PRICE_LARGE_DRINK;
    }

    public double calculateTax(){
        return calculateSubTotal() * TAX_RATE;
    }

    public double calculateTotal(){
        return calculateSubTotal() + calculateTax();
    }

    public int getOrder(){
         return mCheeseburgers + mDoubleDoubles + mFrenchFries +
                 mShakes + mSmallDrinks + mMediumDrinks + mLargeDrinks;
    }
}
