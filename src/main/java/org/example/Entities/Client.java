package org.example.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class Client {

    private Integer clientId;
    private String clientName;
    private ClientType type;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate added;
    private List<Address> addresses;

}
