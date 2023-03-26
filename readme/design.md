# 워들 게임 설계

- 색갈 표현은 나중에 일단은 숫자로
- 게임 진행자
    - 입력기랑 단어장을 가지고 있는 놈
- 입력기
    - 단어 입력 받기
    - 올바른 단어가 아니면 다시 받기 (validation)
        - 소문자 여부 체크
        - 길이 체크
        - 영단어 여부 체크
- 단어장
    - 오늘의 단어 가져오기
- 오늘의 단어
  - 1급 컬렉션으로 구성
  - compare 및 배열로 색정보 결과 리턴 기능
- 뷰 매니저
  - 단어 입력 결과 보여주는 놈 (output)
  - 0 : 회색, 1 : 노란색, 2: 초록색
---
- Miss Match Checker
  - Make 26 Size boolean Array (26 : small Alphabet count)

```
String words = abcde;  
-> boolean spell[] = new boolean[26];

for(word in words) {
    spell[word - 'a'] = true;
}

for(index of not match with word) {
    spell[inputSpell[index] - 'a'] 
}
```
---
### Word 객체 설계 변경
- Word 객체
  - variables 
    - String : 단어 
  - method
    - validate : 소문자 5글자 검증 
- AnswerWord extends Word 
  - variables
    - boolean[26] : 단어 내 각 알파벳이 존재하는지 여부
  - method
    - Result : compare(Word word) 


