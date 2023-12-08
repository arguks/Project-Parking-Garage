package com.krisstelargueta.parkinggarage;

public class Car{
  private int car_id;
  private int timeParked; //the max stay is 10080 minutes = 1 week 
  
  public Car(int car_id, int timeParked) throws TimeException{
      if(timeParked > 10080 || timeParked < 30){
          throw new TimeException("You may park between 30 minutes to 10080 minutes. Please try again.");
      }
      this.car_id = car_id;
      this.timeParked = timeParked;
  }
  
  public int getRegistrationNumber() {
        return car_id;
  }
  
  public int getParkingDuration() {
        return car_id;
  }
  
}
