package org.ashik.demo.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContentResData {
    private int statusCode;
    private String message;
    private int contentCount;
    private List<ContentData> contents;
}
