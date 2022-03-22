package com.pichincha.mvc.domain;

import static lombok.AccessLevel.PRIVATE;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "template")
public class Template implements Serializable {

  @Id
  Long id;

  @Column(name = "template_group")
  String templateGroup;

  @Column(name = "file_name")
  String fileName;

  @Column(name = "index")
  Integer index;

  @Column(name = "file")
  byte[] file;
}