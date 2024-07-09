package org.spring.in.action.spring.in.action.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
public class SignOnRequest implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;

    private String token;


}
