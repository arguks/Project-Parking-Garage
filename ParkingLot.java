package com.krisstelargueta.parkinggarage;


class ParkingLot {
    private Space[] spots;
    private int spaces;
    public ParkingLot(int spaces) {
        spots = new Space[spaces];
        this.spaces = spaces;
        for (int i = 0; i < spaces; i++) {
            spots[i] = new Space();
        }
    }

    
    //how many spots are available
    public int numSpotsAvailable(){
        int avail =0;
       for (Space x : spots){
            if(!x.isEmpty()){
                avail++;
            }
        } 
       return avail;
    }
    
    public boolean isFull(){
        if(numSpotsAvailable() == spots.length){
            return true;
        }
        return false;
    }
    
    public boolean carExists(int carID) {
    for (Space spot : spots) {
        if (!spot.isEmpty() && carID == spot.getParkedCar().getCarID()) {
            return true;
        }
    }
    return false;
}
    
    public Car findCar (int carID){
        for(Space spot: spots){
            if(carID == spot.getParkedCar().getCarID()){
                return spot.getParkedCar();
            }
        }
        return null;
    }
    
    public void parkCarLevel(Car car){
        if(!isFull()){
            int i = 0;
            while(!spots[i].isEmpty()){
                i++;
            }
            spots[i].parkCar(car);
        }
    }
    
    public void retrieveCarLevel(int carID) {
    for (Space spot : spots) {
        if (!spot.isEmpty() && carExists(carID)) {
            spot.retrieveCar();
            System.out.println("Here is your car. Have a Great Day!\nOverview:\nCarID: " + carID);
            return;  // exit the method after finding and retrieving the car
        }
    }
    System.out.println("This car does not exist in our parking garage.");
    }
    
    public Space[] getSpots (){
        return spots;
    }
}
