package com.example.ubfuneralhouse;

import java.util.List;

public class Value {
    String value;
    String message;
    List<pengajuan> pengajuan;
    List<letak> letak;

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public List<com.example.ubfuneralhouse.pengajuan> getPengajuan() {
        return pengajuan;
    }

    public List<com.example.ubfuneralhouse.letak> getLetak() { return letak; }
}
