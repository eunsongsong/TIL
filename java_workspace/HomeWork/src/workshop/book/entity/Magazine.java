package workshop.book.entity;

public class Magazine extends Publication{
	private String publishingPeriod;
	
	public Magazine(String title, String publishingDate, int page, int price, String publishingPeriod) {
		super(title, publishingDate, page, price);
		this.publishingPeriod = publishingDate;
	}
	
	public Magazine(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}

	public String getPublishingPeriod() {
		return publishingPeriod;
	}

	public void setPublishingPeriod(String publishingPeriod) {
		this.publishingPeriod = publishingPeriod;
	}
	

}
