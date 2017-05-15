package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;

/**
 * @author yvesbeutler
 *         INSERT DESCRIPTION HERE
 */
@Entity
public class Medicine extends Identity {
    private String productName;
    private String description;
    private byte[] document;
}
