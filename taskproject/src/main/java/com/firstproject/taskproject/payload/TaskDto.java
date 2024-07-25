package com.firstproject.taskproject.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
	private long id;
	private String taskname;
	
	public long getId() {
        return id;
    }
	public void setId(long id) {
        this.id = id;
	}
	 public String getName() {
	        return taskname;
	    }

	    public void setName(String taskname) {
	        this.taskname = taskname;
	    }
	
	

}
