package com.sms.fees.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fees")
public class FeeProperties {

    private Fee semester;
    private Fee hostel;
    private Fee bus;

    public static class Fee {
        private Integer amount;
        public Integer getAmount() { return amount; }
        public void setAmount(Integer amount) { this.amount = amount; }
    }

    public Fee getSemester() { return semester; }
    public void setSemester(Fee semester) { this.semester = semester; }

    public Fee getHostel() { return hostel; }
    public void setHostel(Fee hostel) { this.hostel = hostel; }

    public Fee getBus() { return bus; }
    public void setBus(Fee bus) { this.bus = bus; }
}

