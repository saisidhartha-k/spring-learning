package com.learning.learningspring.controller.binding;


import lombok.Data;

@Data
public class AddPostForm {
  private String content;
  private int userId;
}