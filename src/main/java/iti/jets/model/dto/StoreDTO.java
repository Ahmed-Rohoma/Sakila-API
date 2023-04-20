package iti.jets.model.dto;

import java.util.Date;
import java.util.List;

public class StoreDTO {
    private Integer id;
    private AddressDTO address;
    private StaffDTO manager;
    private List<StaffDTO> staffList;
    private Date lastUpdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public StaffDTO getManager() {
        return manager;
    }

    public void setManager(StaffDTO manager) {
        this.manager = manager;
    }

    public List<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffDTO> staffList) {
        this.staffList = staffList;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}

