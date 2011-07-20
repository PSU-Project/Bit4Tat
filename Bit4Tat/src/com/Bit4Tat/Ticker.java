package com.Bit4Tat;

public class Ticker {

	private double low;
	private double high;
	private double average;
	private double volume;
	private double last;
	private double buy;
	private double sell;
	
	/**
	 * 
	 */
	public Ticker () {
		
	}
	
	/**
	 * @param low the low to set
	 */
	public void setLow(double low) {
		this.low = low;
	}
	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(double high) {
		this.high = high;
	}
	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}
	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(double volume) {
		this.volume = volume;
	}
	/**
	 * @return the volume
	 */
	public double getVolume() {
		return volume;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(double last) {
		this.last = last;
	}
	/**
	 * @return the last
	 */
	public double getLast() {
		return last;
	}
	/**
	 * @param buy the buy to set
	 */
	public void setBuy(double buy) {
		this.buy = buy;
	}
	/**
	 * @return the buy
	 */
	public double getBuy() {
		return buy;
	}
	/**
	 * @param sell the sell to set
	 */
	public void setSell(double sell) {
		this.sell = sell;
	}
	/**
	 * @return the sell
	 */
	public double getSell() {
		return sell;
	}
}