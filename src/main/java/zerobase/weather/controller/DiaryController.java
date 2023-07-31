package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@Tag(name="날씨 일기 API", description = "날씨 일기 API 입니다.")
@RestController
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @Operation(summary = "일기 텍스트와 날씨를 이용해 DB에 일기 저장", description = "어떻게 나올까?")
    @PostMapping("/create/diary")
    void createDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text) {
        diaryService.createDiary(date, text);
    }

    @Operation(summary = "선택한 날짜의 모든 일기 데이터를 가져옵니다.")
    @GetMapping("/read/diary")
    List<Diary> readDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return diaryService.readDiary(date);
    }

    @Operation(summary = "선택한 기간중의 모든 일기 데이터를 가져옵니다.")
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @Parameter(
                    name = "조회 첫 기준일",
                    description = "조회할 기간의 첫 날짜\n날짜 형식 : yyyy-MM-dd",
                    example = "2020-01-01") LocalDate startDate,
            @RequestParam
            @Parameter(
                    name = "조회 마지막 기준일",
                    description = "조회할 기간의 마지막 날짜\n날짜 형식 : yyyy-MM-dd",
                    example = "2020-12-31")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

        return diaryService.readDiaries(startDate, endDate);
    }

    @Operation(summary = "선택한 날짜의 일기 데이터를 수정합니다.")
    @PutMapping("/update/diary")
    void updateDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestBody String text) {

        diaryService.updateDiary(date, text);
    }

    @Operation(summary = "선택한 날짜의 일기 데이터를 삭제합니다.")
    @DeleteMapping("/delete/diary")
    void deleteDiary(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        diaryService.deleteDiary(date);
    }
}
