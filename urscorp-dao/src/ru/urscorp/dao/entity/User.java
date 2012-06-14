package ru.urscorp.dao.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=512)
	private String hash;

	@Column(nullable=false)
	private Timestamp ts;

	//bi-directional many-to-one association to Ip
	@OneToMany(mappedBy="userBean")
	private Set<Ip> ips;

	//bi-directional many-to-one association to Browser
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="browser")
	private Browser browserBean;

    public User() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Timestamp getTs() {
		return this.ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

	public Set<Ip> getIps() {
		return this.ips;
	}

	public void setIps(Set<Ip> ips) {
		this.ips = ips;
	}
	
	public Browser getBrowserBean() {
		return this.browserBean;
	}

	public void setBrowserBean(Browser browserBean) {
		this.browserBean = browserBean;
	}
	
}