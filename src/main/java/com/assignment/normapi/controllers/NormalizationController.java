package com.assignment.normapi.controllers;

import com.assignment.normapi.dto.NormalizationDTO;
import com.assignment.normapi.utils.StringNormalizer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

@RestController
public class NormalizationController {
    private final Pattern nonLetterNonDigitRegex = compile("[^a-zA-Z0-9]");

    @PostMapping(value = "api/removeNonLetterNonDigit")
    public ResponseEntity<Object> normalizeKeywords(@RequestBody List<String> keywords){
        if (keywords.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<String> normalizedKeywords = new LinkedList<>();
        List<Integer> hashes = new LinkedList<>();

        for(String keyword: keywords){
            String normalizedKeyword = StringNormalizer.normalizeString(keyword.toLowerCase(), nonLetterNonDigitRegex);

            normalizedKeywords.add(normalizedKeyword);
            hashes.add(normalizedKeyword.hashCode());
        }

        NormalizationDTO dto = new NormalizationDTO(normalizedKeywords, hashes);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
