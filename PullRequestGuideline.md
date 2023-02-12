# 스터디를 위한 PR 가이드라인

## ✅ 사전 작업

1. clone을 받지 않았으면 받는다.

```
git clone https://github.com/SSAFY-S0914/Java_Algo_Study1.git
```

2. 작업 브런치를 생성 및 변경한다

```
git branch 이름 (ex inhyeok)
git checkout 방금생선한브런치
```

## ✅ 알고리즘 문제 풀이 진행 후

- 메인 브런치의 최신 내용을 가져온다

```
git checkout main
git pull origin main

git checkout [브런치이름]
git merge main
```

- 스터디때 정한 문제를 작업한 후 /study/week[N] 번째 폴더에 들어가 자신이 코딩한 소스를 넣는다.

![](https://user-images.githubusercontent.com/28949213/218299503-5bd425c0-a700-4273-8fb1-3f874bc819c9.png)

- 파일 이름 형식은 문제소스출처+문제번호\_이름 으로 수업시간때 한 네이밍으로 통일한다.  
  ex 백준 : JUN14350_JoInHyeok  
  ex swexpert : SW1218_JoInHyeok.

- 작업 내용을 커밋 and push 한다.

```
git status // 변경사항 확인
git add .
git commit -m "[n주차]조인혁 백준 14350, 백준 15505 문제풀이"
git push origin 브런치이름
```

### push 진행 후

![image](https://user-images.githubusercontent.com/28949213/218299797-28e6c998-b0f9-4fd4-89d7-87d1c1d8d8c9.png)

- compare & pull request 버튼 혹은

![](https://user-images.githubusercontent.com/28949213/218299700-d94848d8-6c46-456d-ac07-6e8305917cb1.png)
오른쪽의 new Pull Request 버튼을 누른다.

#### 버튼 클릭 후

![image](https://user-images.githubusercontent.com/28949213/218299880-80b4c452-c9b3-4630-82e2-9d100a4e3acf.png)
## ✅ PR 규칙
- PR 제목: `[n주차] 이름 및 문제번호`
- `ex) [2주차] 이동현 BOJ1339, BOJ15505`
- PR 본문: 미정  
- base 브런치 : main
- compare 브런치 : 내 브런치  
  를 확인한다.

이후 아래에 코드 설명 및 접근 방법에 대한 풀이를 적는다.

![image](https://user-images.githubusercontent.com/28949213/218299944-09d72625-777c-4f2e-b26b-c44028d8b1f5.png)
<br />
오른쪽에 Reviewers의 톱니바퀴 버튼을 눌러서 스터디원 전원을 리뷰어에 추가하고 PR을 생성한다.


## ✅ 리뷰 방법
- 상대방이 PR한 코드를 보고 느낀점 & 궁금한 점 & 내가 작성한 코드와 다른 점 등 자유롭게 작성
- 다른 팀원의 코드를 리뷰어 기능을 통해 댓글로 달거나 소스를 드래그해 라인에 코멘트를 남긴다.

## ✅ Merge 조건
- 모든 참가자 리뷰 완료 후
- 머지를 한다.(아마도 squash?)

끝입니다. 다들 파이팅.
