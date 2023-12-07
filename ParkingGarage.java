package com.krisstelargueta.parkinggarage;

public class ParkingGarage {

    private ParkingLot [] levels;

    public ParkingGarage(int floors, int spaces){
        levels = new ParkingLot [floors];

        for(ParkingLot x: levels){
            x = new ParkingLot(spaces);
        }

    }

    
    
}

