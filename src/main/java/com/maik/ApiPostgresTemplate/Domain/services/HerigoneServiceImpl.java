package com.maik.ApiPostgresTemplate.Domain.services;

import com.maik.ApiPostgresTemplate.Domain.models.Word;
import com.maik.ApiPostgresTemplate.Domain.repository.HerigoneRepository;
import com.maik.ApiPostgresTemplate.models.dto.HerigoneDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class HerigoneServiceImpl implements HerigoneService {

    @Autowired
    private HerigoneRepository herigoneRepository;

    @Override
    public HerigoneDTO findHerigoneByDate(String date) {
        String dateCleaned = date.replace("/", "").replace("\\", "").replace("-", "");
        String herigoneCode = "";
        List<String> herigoneList = new ArrayList<>();

        int i = 0;
        for(char c : dateCleaned.toCharArray()) {
            String s = getDictionaryMap().get(String.valueOf(dateCleaned.toCharArray()[i]));
            herigoneCode += s;
            herigoneList.add(s);
            i++;
        }
        List<String> words = getWords(herigoneList).stream().map(Word::getWord).collect(Collectors.toList());

        HerigoneDTO herigoneDTO = new HerigoneDTO()
                .herigoneCode(herigoneCode)
                .date(date)
                .words(words);

        return herigoneDTO;
    }

    private List<Word> getWords(List<String> charList) {
        String herigonePattern = charList.stream().collect(Collectors.joining("%")) + "%";

        List<Word> words = herigoneRepository.findHerigoneWords(herigonePattern);

        return words;
    }

    private Map<String, String> getDictionaryMap() {
        return  Map.of(
                "0", "r",
                "1", "t",
                "2", "n",
                "3", "m",
                "4", "c",
                "5", "l",
                "6", "s",
                "7", "f",
                "8", "g",
                "9", "b"
        );
    }


}
