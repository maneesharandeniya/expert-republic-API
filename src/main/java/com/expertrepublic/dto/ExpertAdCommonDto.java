package com.expertrepublic.dto;

import lombok.Data;

@Data
public class ExpertAdCommonDto {

   private Long id;

   private String title;

   private String description;

   private float cost;

   private ExpertExpertAdDto expert;
}
