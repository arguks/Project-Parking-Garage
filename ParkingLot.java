package com.krisstelargueta.parkinggarage;


class ParkingLot {
    private static Space[] spots; 
  
    public ParkingLot(int spaces){
        spots = new Space[spaces];   
    }
    
    //how many spots are available
    public int numSpotsAvailable(){
        int avail =0;
       for (Space x : spots){
            if(x.isEmpty()){
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
    
    public void parkCar(Car car){
        if(!isFull()){
            int i = 0;
            while(!spots[i].isEmpty()){
                i++;
            }
            spots[i].parkCar(car);
        }
    }
    
}
