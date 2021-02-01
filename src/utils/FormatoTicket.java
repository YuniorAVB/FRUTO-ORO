
package utils;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

/**
 *
 * @author YAVB
 */
public class FormatoTicket implements Printable{

    public FormatoTicket() {
        
        
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
         if (pageIndex == 0) 
      {
          
         graphics.drawString("Hola mundo", 100,100);
         
         return PAGE_EXISTS;
         
      }
      else
         return NO_SUCH_PAGE;
    }
    
    
    
}
