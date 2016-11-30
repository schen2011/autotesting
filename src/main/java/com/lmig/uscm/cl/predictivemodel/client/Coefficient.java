package com.lmig.uscm.cl.predictivemodel.client;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

@Component
public class Coefficient {
	
    @Id
    public String id;

    public String name;
    public String path;
    public Date date;

    public Coefficient() {}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

    @Override
    public String toString() {
        return String.format(
                "Coefficient[id=%s, firstName='%s', lastName='%s']",
                id, name, path);
    }
    
}
