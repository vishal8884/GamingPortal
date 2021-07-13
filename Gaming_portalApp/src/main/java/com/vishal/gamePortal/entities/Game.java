package com.vishal.gamePortal.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {
	
	@Id
	private String id;
	private String name;
	private String publisherName;
	private int cost;
	
	
	public Game()
	{
		
	}
	
	
	public Game(String id, String name, String publisherName, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.publisherName = publisherName;
		this.cost = cost;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", publisherName=" + publisherName + ", cost=" + cost + "]";
	}
	
	
	

}
