package beans;

import java.io.Serializable;

public class BuyDetailDataBeans  implements Serializable {
	private int id;
	private int buyId;
	private int itemId;
	private String buyItemName;
	private int buyItemPrice;



	public String getBuyItemName() {
		return buyItemName;
	}
	public void setBuyItemName(String buyItemName) {
		this.buyItemName = buyItemName;
	}
	public int getBuyItemPrice() {
		return buyItemPrice;
	}
	public void setBuyItemPrice(int buyItemPrice) {
		this.buyItemPrice = buyItemPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int buyDetailId) {
		this.id = buyDetailId;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}
