import java.util.ArrayList;

public class Player {
	private String name; 
	private int chips; 
	private int bet;
	private ArrayList<Card> oneRoundCard;
	public Player( String n, int ch) {
		
		name=n;
		chips=ch;
	}
	public String getName() {
		
		return name;
	}

	public void sayHello() {
		
		System.out.println("Hello, I am " + name + ".");
		System.out.println("I have " + chips + " chips.");
	}

	public int makeBet() {

		if(getCurrentChips()==0)
			 bet=0; 
		 else{ 
		 	bet=1;
		 }
		if(bet<=getCurrentChips())
			return bet;
		else
			return 0;
	}

	public void setOneRoundCard(ArrayList<Card> cards) {
		
		oneRoundCard=cards;
	}

	public boolean hitMe() {
		
		if(getTotalValue()<=16)
			return true;
		else
			return false;
	}



	public int getTotalValue() {

		
		int sum=0;
		boolean u=false;//save 1
	 	for(Card c:oneRoundCard){ 
	 		if(u==false) {
	 			if(c.getRank()==11||c.getRank()==12||c.getRank()==13)
	 			{	 
	 				sum=sum+10;
	 			}else if(c.getRank()==1 && (sum+11)<=21)
	 			{ 	 				
	 				sum=sum+11;
	 				u = true;//1=11,
	 				
	 			}else
	 			{ 
	 				sum=sum+c.getRank();
	 			} 
	 		}else {
	 			if(c.getRank()==11||c.getRank()==12||c.getRank()==13)
	 			{	 
	 				sum=sum+10;
	 			}else
	 			{ 
	 				sum=sum+c.getRank();
	 			} 
	 			if(sum>21 && u) {
	 				sum=sum-10;
	 				u=false;
	 			}
	 		}
	 	}
		return sum; 

	}

	public void increaseChips(int diff) {
		
		chips=chips+diff;
	}

	public int getCurrentChips() {
		
		return chips;
	}

}
