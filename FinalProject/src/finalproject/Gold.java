/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;

/**
 *
 * @author nihar, Niharika Shetty 500754054
 */
public class Gold extends Level{







    @Override
    public Level changelevel(CustomerPageController c) throws IOException {
        if(c.getapp() <10000)
        {
            return new Silver();
        } else if (c.getapp() < 20000 && c.getapp() >= 10000) {
                return new Gold();
                }
                else if(c.getapp() >= 20000)
                {
                return new Platinum();
                
                }
                else {
                return new Gold();
                }
        
    
    }
       @Override
       public String toString() {
           return "Gold";
       }


    
}
