package com.techknowsurfer.springbootrabbitmqsample.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Message {
    UUID id;
    Date date;
    String msg;
}
