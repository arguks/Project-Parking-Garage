package com.krisstelargueta.parkinggarage;

public class Car{
   //attributes
  private int car_id;
  private int time; 
  
  //constructor class
  public Car(int car_id, int time) throws TimeException{
      //if the time is aboce 1440 or under 1 a TimeException will be thrown
      if(time > 1440 || time < 1){
          throw new TimeException("You may park between 1 minute to 1440 minutes. Please try again.");
      }
      this.car_id = car_id;
      this.time = time;
  }
  
  //getter methods
  public int getCarID() {
        return car_id;
  }
  
  public int getTime() {
        return time;
  }
  
}
