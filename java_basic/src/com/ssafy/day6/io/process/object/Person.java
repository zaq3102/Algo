package com.ssafy.day6.io.process.object;

import java.io.Serializable;

// Person 을 직렬화 가능하도록 처리하시오.
public class Person implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -455351535326080518L;
	private String id;
    private transient String pass; // 민감한 데이터
    private Address addr; // has a 관계의 다른 객체


    public Person(String id, String pass, String zipCode, String city) {
        this.id = id;
        this.pass = pass;
        this.addr = new Address(zipCode, city);
    }

    @Override
    public String toString() {
        return "[id=" + id + ", pass=" + pass + ", addr=" + addr + "]";
    }

    class Address implements Serializable  {
        private String zipCode;
        private String city;

        public Address(String zipCode, String city) {
            this.zipCode = zipCode;
            this.city = city;
        }

        public String toString() {
            return "Address [zipCode=" + zipCode + ", city=" + city + "]";
        }
    }
}
