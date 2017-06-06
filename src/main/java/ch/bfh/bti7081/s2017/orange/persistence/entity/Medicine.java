package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 * Representation of a medicin which provides medical information from
 * the supplier.
 */
@Entity
public class Medicine extends Identity {
    private static final long serialVersionUID = 1L;

    public String getProductName() {
        return productName;
    }

    private String productName;
    private String description;
    private byte[] document;
}
