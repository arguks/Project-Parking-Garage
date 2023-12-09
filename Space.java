package com.krisstelargueta.parkinggarage;


class Space {
    private Car parkedCar;
    
    //We will be using the deafult constructor which will set parkedCar to null
    
    //isEmpty will check if a space is null
    public boolean isEmpty(){
        if(parkedCar == null){
            return true;
        } return false;
    }
    
    //parkCar will assign the paramter car to parkedCar if the space is empty
    public void parkCar (Car car){
        if(isEmpty()){
            parkedCar = car;
        } else {
            System.out.println("This spot is not empty");
        }
    }
    
    //retrieveCar will set the space to null
    public void retrieveCar(){
        parkedCar = null;
    }
    
    //getParked Car will return the Car object in the space
    public Car getParkedCar(){
        return parkedCar;
    }
      
}
