package com.Bit4Tat;

public class Ticker {

	private float low;
	private float high;
	private float average;
	private float volume;
	private float last;
	private float buy;
	private float sell;
	
	/**
	 * 
	 */
	public Ticker () {
		
	}
	
	/**
	 * @param low the low to set
	 */
	public void setLow(float low) {
		this.low = low;
	}
	/**
	 * @return the low
	 */
	public float getLow() {
		return low;
	}
	/**
	 * @param high the high to set
	 */
	public void setHigh(float high) {
		this.high = high;
	}
	/**
	 * @return the high
	 */
	public float getHigh() {
		return high;
	}
	/**
	 * @param average the average to set
	 */
	public void setAverage(float average) {
		this.average = average;
	}
	/**
	 * @return the average
	 */
	public float getAverage() {
		return average;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(float volume) {
		this.volume = volume;
	}
	/**
	 * @return the volume
	 */
	public float getVolume() {
		return volume;
	}
	/**
	 * @param last the last to set
	 */
	public void setLast(float last) {
		this.last = last;
	}
	/**
	 * @return the last
	 */
	public float getLast() {
		return last;
	}
	/**
	 * @param buy the buy to set
	 */
	public void setBuy(float buy) {
		this.buy = buy;
	}
	/**
	 * @return the buy
	 */
	public float getBuy() {
		return buy;
	}
	/**
	 * @param sell the sell to set
	 */
	public void setSell(float sell) {
		this.sell = sell;
	}
	/**
	 * @return the sell
	 */
	public float getSell() {
		return sell;
	}
}