package Stock;
import java.time.LocalDateTime;

public class TradingManager {

	private LocalDateTime openTime;
	private LocalDateTime closeTime;
	private boolean isOpen;
	
	TradingManager()
	{
		isOpen = false;
	}

	// open trading session
	public void openTradingSession()
	{
		if(!isOpen){
	        this.openTime = LocalDateTime.now(); // opening trading session
	        isOpen = true;
            System.out.println("Trading session opened at " + openTime);
		}
		else {
			System.out.println(" Trading session is already opened ");
		}
	}
	
	// close trading session
	public void closeTradingSession()
	{
		if(isOpen){
	        this.closeTime = LocalDateTime.now(); // closing trading session
	        isOpen = false;
            System.out.println("Trading session closed at " + closeTime);
		}
		else {
            System.out.println(" No trading session is currently open ");
		}
	}
	
    // Method to check if trading session is opened
    public boolean isTradingSessionOpen() {
        return isOpen;
    }
	
	
}
