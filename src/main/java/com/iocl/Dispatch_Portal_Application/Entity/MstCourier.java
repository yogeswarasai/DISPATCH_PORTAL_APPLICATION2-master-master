package com.iocl.Dispatch_Portal_Application.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name = "mst_courier")
@Data
public class MstCourier {
	@Id
    @Column(name = "courier_code", length = 10)
    private String courierCode;

    @Column(name = "courier_name", length = 40)
    private String courierName;
}
