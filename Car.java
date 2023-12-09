package com.krisstelargueta.parkinggarage;

public class Car{
  private int car_id;
  private int time; //the max stay is 10080 minutes = 1 week 
  
  public Car(int car_id, int time) throws TimeException{
      if(time > 1440 || time < 1){
          throw new TimeException("You may park between 1 minute to 1440 minutes. Please try again.");
      }
      this.car_id = car_id;
      this.time = time;
  }
  
  public int getCarID() {
        return car_id;
  }
  
  public int getTime() {
        return time;
  }
  
}
