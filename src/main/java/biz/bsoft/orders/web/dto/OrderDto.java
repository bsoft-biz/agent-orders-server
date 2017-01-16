package biz.bsoft.orders.web.dto;

public class OrderDto {
    private Integer id;
    private Boolean selected;

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", selected=" + selected +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDto OrderDto = (OrderDto) o;

        if (!id.equals(OrderDto.id)) return false;
        return selected.equals(OrderDto.selected);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + selected.hashCode();
        return result;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
