package com.krisstelargueta.parkinggarage;


class ParkingLot {
    
    private Space[] spots;
    
    //constructor method will initialize spots with the length of spaces
    //the for loop will then create Space objects in each index
    public ParkingLot(int spaces) {
        spots = new Space[spaces];
        for (int i = 0; i < spaces; i++) {
            spots[i] = new Space();
        }
    }

    
    //how many spots are available by checking if each space is empty
    public int numSpotsAvailable(){
        int avail =0;
       for (Space x : spots){
            if(x.isEmpty()){
                avail++;
            }
        } 
       return avail;
    }
    
    //will check if the number of spots available is 0
    public boolean isFull(){
        if(numSpotsAvailable() == 0){
            return true;
        }
        return false;
    }
    
    //will check if the car exists in the parking lot by checking every spot in the parking lot
    public boolean carExists(int carID) {
    for (Space spot : spots) {
        if (!spot.isEmpty() && carID == spot.getParkedCar().getCarID()) {
            return true;
        }
    }
    return false;
}
    
    //will return the car if it is found in the parking lot, if it is not found it will return null
    public Car findCar (int carID){
        for(Space spot: spots){
            if(carID == spot.getParkedCar().getCarID()){
                return spot.getParkedCar();
            }
        }
        return null;
    }
    
    //if the parking lot is not full, we will iterate through the spots array until we find an empty spot and then 
    //assign the parkedCar variable in the space object with car using the parkCar method in the space class 
    public void parkCarLevel(Car car){
        if(!isFull()){
            int i = 0;
            while(!spots[i].isEmpty()){
                i++;
            }
            spots[i].parkCar(car);
        }
    }
    
    //in order to let a customer retrieve a car, we need the car id. we will iterate through the spaces in the parking lot and 
    //check if the space is not empty and if the carExists in the parking lot
    //we will use the retrieve car method from spaces to remove the car from the spot
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
    
    //getter method
    public Space[] getSpots (){
        return spots;
    }
}
