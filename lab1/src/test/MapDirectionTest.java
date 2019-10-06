package test;

import agh.cs.lab2.MapDirection;
import org.junit.Test;


public class MapDirectionTest {
    MapDirection dir1 = MapDirection.NORTH;


    @Test
    public void nextTest(){
        for(int i=0; i<4; i++){
            System.out.println(dir1.next());
            dir1=dir1.next();
        }

    }


}
