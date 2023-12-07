package com.krisstelargueta.parkinggarage;


class parkingSpot {
    private Car parkedCar;
    
    public boolean isEmpty(){
        if(parkedCar == null){
            return true;
        } return false;
    }
    
    public void parkCar (Car car){
        if(isEmpty()){
            parkedCar = car;
        } else {
            System.out.println("This spot is not empty");
        }
    }
    
    public Car remove(){
        Car temp = parkedCar;
        parkedCar = null;
        return temp;
    }
      
}
