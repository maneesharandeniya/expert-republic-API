package com.expertrepublic.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExpertExpertAdDto implements Serializable {

    private Long id;

    private String name;

    private String description;

    private String country;

    private String languages;

}
