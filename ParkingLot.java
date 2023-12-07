package com.krisstelargueta.parkinggarage;


class ParkingLot {
    private parkingSpot[] spots; 
  
    public ParkingLot(int spaces){
        spots = new parkingSpot[spaces];   
    }
    
    //how many spots are available
    public int checkAvailability(){
        int avail =0;
       for (parkingSpot x : spots){
            if(x.isEmpty()){
                avail++;
            }
        } 
       return avail;
    }
    
    public boolean isFull(){
        if(checkAvailability() == spots.length){
            return true;
        }
        return false;
    }
    
}
