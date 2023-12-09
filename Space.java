package com.krisstelargueta.parkinggarage;


class Space {
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
    
    public void retrieveCar(){
        parkedCar = null;
    }
    
    public Car getParkedCar(){
        return parkedCar;
    }
      
}
