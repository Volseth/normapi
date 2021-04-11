package com.assignment.normapi.dto;

import java.util.List;

public class NormalizationDTO {

    public List<String> keywords;
    public List<Integer> hashes;

    public NormalizationDTO(List<String> keywords, List<Integer> hashes){
        this.keywords = keywords;
        this.hashes = hashes;
    }
}
