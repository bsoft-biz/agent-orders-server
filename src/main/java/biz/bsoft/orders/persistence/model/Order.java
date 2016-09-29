package biz.bsoft.orders.persistence.model;

import biz.bsoft.orders.web.LocalDateAttributeConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by vbabin on 31.08.2016.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer Id;

    @Convert(converter = LocalDateAttributeConverter.class)
    @JsonFormat(pattern="dd.MM.yyyy")
    private LocalDate shipDate;

    private String client;

    private Integer clientId;

    private String clientPos;

    private Integer clientPosId;

    private String route;

    private Integer routeId;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public LocalDate getShipDate() {
        return shipDate;
    }

    public void setShipDate(LocalDate shipDate) {
        this.shipDate = shipDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientPos() {
        return clientPos;
    }

    public void setClientPos(String clientPos) {
        this.clientPos = clientPos;
    }

    public Integer getClientPosId() {
        return clientPosId;
    }

    public void setClientPosId(Integer clientPosId) {
        this.clientPosId = clientPosId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public void setRouteId(Integer routeId) {
        this.routeId = routeId;
    }
}
