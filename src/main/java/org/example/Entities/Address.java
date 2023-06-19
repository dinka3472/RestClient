package org.example.Entities;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class Address {

    private Integer id;
    private String ip;
    private String mac;
    private String model;
    private String address;

    public Address(String ip, String mac, String model, String address) {
        this.ip = ip;
        this.mac = mac;
        this.model = model;
        this.address = address;
    }
}
